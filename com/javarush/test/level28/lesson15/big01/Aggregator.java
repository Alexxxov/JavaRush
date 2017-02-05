package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

/**
 * Created by Admin on 24.01.2017.
 */
public class Aggregator {
    public static void main(String[] args)
    {
        Provider hhProvider = new Provider(new HHStrategy());
        Provider moiKrugProvider = new Provider(new MoikrugStrategy());

        HtmlView htmlView = new HtmlView();
        Model model = new Model(htmlView, hhProvider, moiKrugProvider);

        Controller controller = new Controller(model);
        htmlView.setController(controller);
        htmlView.userCitySelectEmulationMethod();

    }
}
