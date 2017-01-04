package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Admin on 30.12.2016.
 */
public class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.verifiedCards", Locale.getDefault());
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.login_en", Locale.getDefault());

    @Override
    public void execute() throws InterruptOperationException {

        ConsoleHelper.writeMessage(res.getString("before"));
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String inptCard = ConsoleHelper.readString();
            String inptPIN = ConsoleHelper.readString();
            if (validCreditCards.containsKey(inptCard))
            {
                if (validCreditCards.getString(inptCard).equals(inptPIN))
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), inptCard));
                else
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), inptCard));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
                }
            }
            else
            {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), inptCard));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }

            break;
        }

    }
}
