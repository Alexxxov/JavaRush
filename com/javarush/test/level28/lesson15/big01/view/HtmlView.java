package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

/**
 * Created by Admin on 28.01.2017.
 */
public class HtmlView implements View {

    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replaceAll("[\\.\\s]+","/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies)
    {
        try
        {
            updateFile(getUpdatedFileContent(vacancies));
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod()
    {
        //выбираем нужный нам город (TODO - запрос)
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> updatedVacancies)
    {
        String fileContent;
        try
        {
            Document doc = getDocument();
            Element tableLineOriginal  = doc.getElementsByClass("template").first();
            Element pattern = tableLineOriginal.clone();
            pattern.removeAttr("style");
            pattern.removeClass("template");

            doc.getElementsByAttributeValue("class", "vacancy").remove();

            //заполняем наш vacancies.html данными уже полученными с сайта
            for (Vacancy vacancy: updatedVacancies)
            {
                Element tableLine  = pattern.clone();

                tableLine.getElementsByClass("city").first().text(vacancy.getCity());
                tableLine.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                tableLine.getElementsByClass("salary").first().text(vacancy.getSalary());

                Element link = tableLine.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());
                //каждый раз происходит запись вакансии в html-виде перед шаблоном
                tableLineOriginal.before(tableLine.outerHtml());
            }
            fileContent = doc.html();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            fileContent = "Some exception occured";
        }

        return fileContent;
    }

    private void updateFile(String file) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(file);
        writer.close();
    }

    protected Document getDocument() throws IOException
    {
        return Jsoup.parse(new File(filePath),"UTF-8");
    }
}
//
//<!DOCTYPE html>
//<html lang="ru">
//<head>
//<meta charset="utf-8">
//<title>Вакансии</title>
//</head>
//<body>
//<table>
//<tr>
//<th>Title</th>
//<th>City</th>
//<th>Company Name</th>
//<th>Salary</th>
//</tr>
//<tr class="vacancy">
//<td class="title"><a href="http://javarush.ru">Junior Java Developer</a></td>
//<td class="city">Entire World</td>
//<td class="companyName">JavaRush</td>
//<td class="salary">1mmm</td>
//</tr>
//<tr class="vacancy">
//<td class="title"><a href="http://javarush.ru">Junior Java Developer 2</a></td>
//<td class="city">Entire World</td>
//<td class="companyName">JavaRush</td>
//<td class="salary">1к</td>
//</tr>
//
//<tr class="vacancy template" style="display: none">
//<td class="title"><a href="url"></a></td>
//<td class="city"></td>
//<td class="companyName"></td>
//<td class="salary"></td>
//</tr>
//</table>
//</body>
//</html>
