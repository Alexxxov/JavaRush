package com.javarush.test.level08.lesson08.task04;


import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallon", new Date("JUNE 1 1980"));
        map.put("Stallo", new Date("JANUARY 6 1980"));
        map.put("Stal", new Date("JUNE 1 1980"));
        map.put("S", new Date("JUNE 1 1980"));
        map.put("St", new Date("JUNE 1 1980"));
        map.put("Sta", new Date("FEBRUARY 5 1980"));
        map.put("Stall", new Date("JUNE 1 1980"));
        map.put("S1", new Date("JUNE 6 1980"));
        map.put("St1e", new Date("SEPTEMBER 1 1980"));
        map.put("Stallo3ne", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while(iterator.hasNext())
        {
            Map.Entry<String,Date> pair = iterator.next();
            int month = pair.getValue().getMonth();
            if (5 <= month && month <= 7)
                iterator.remove();
        }



    }

    public static void main(String[] args)
    {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);


    }
}
