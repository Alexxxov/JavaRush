package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Admin on 28.01.2017.
 */
public class FXView implements View {

    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replaceAll("[\\.\\s]+","/") + "/vacancies.html";

    @Override
    public <T> List<T> update(List<T> vacancies)
    {
        return vacancies;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public <T> List<T> userInputQuery(String query)
    {
        return controller.userQuery(query.trim());
    }

//    private String getUpdatedFileContent(List<Vacancy> updatedVacancies)
//    {
//        String fileContent;
//        try
//        {
//            Document doc = getDocument();
//            Element tableLineOriginal  = doc.getElementsByClass("template").first();
//            Element pattern = tableLineOriginal.clone();
//            pattern.removeAttr("style");
//            pattern.removeClass("template");
//
//            doc.getElementsByAttributeValue("class", "vacancy").remove();
//
//            //заполняем наш vacancies.html данными уже полученными с сайта
//            for (Vacancy vacancy: updatedVacancies)
//            {
//                Element tableLine  = pattern.clone();
//
//                tableLine.getElementsByClass("city").first().text(vacancy.getCity());
//                tableLine.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
//                tableLine.getElementsByClass("salary").first().text(vacancy.getSalary());
//
//                Element link = tableLine.getElementsByTag("a").first();
//                link.text(vacancy.getTitle());
//                link.attr("href", vacancy.getUrl());
//                //каждый раз происходит запись вакансии в html-виде перед шаблоном
//                tableLineOriginal.before(tableLine.outerHtml());
//            }
//            fileContent = doc.html();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//            fileContent = "Some exception occured";
//        }
//
//        return fileContent;
//    }
//
//    private void updateFile(String file) throws IOException
//    {
//        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
//        writer.write(file);
//        writer.close();
//    }
//
//    protected Document getDocument() throws IOException
//    {
//        return Jsoup.parse(new File(filePath),"UTF-8");
//    }
}
