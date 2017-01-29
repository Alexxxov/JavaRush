package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

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
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> updatedVacancies)
    {
        //TODO
        return "";
    }

    private void updateFile(String file) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(file);
        writer.close();
    }
}
