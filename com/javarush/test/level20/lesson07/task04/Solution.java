package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable {
    public static void main(String[] args)
    {
        System.out.println(new Solution(4));
        System.out.println(new Solution(11));
    }

//        try
//        {
//            Solution savedObject = new Solution(11);
//
//            File file = new File("D:\\1.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//            oos.writeObject(savedObject);
//            oos.close();
//
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//            Solution loadedObject = (Solution) ois.readObject();
//            ois.close();
//
//            System.out.println(loadedObject.string.equals(savedObject.string));
//
//
//        }
//        catch (FileNotFoundException e)
//        {
//            e.getMessage();
//        }
//        catch (ClassNotFoundException e)
//        {
//            e.getMessage();
//        }
//        catch (IOException e)
//        {
//            e.getMessage();
//        }
//    }

//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException
//    {
//        out.writeInt(this.temperature);
//        out.writeObject(this.string);
//        out.writeObject(this.currentDate);
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
//    {
//        temperature = in.readInt();
//        string = (String) in.readObject();
//        currentDate = (Date) in.readObject();
//    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(){}

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
