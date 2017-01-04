package com.javarush.test.level17.lesson04.task04;

/* Синхронизированный президент
И снова Singleton паттерн - синхронизация в статическом блоке
Внутри класса OurPresident в статическом блоке создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте president.
*/

public class Solution {
    public static class OurPresident {

        private static OurPresident president = null;

        static
        {
            getOurPresident();
        }

        private OurPresident() {
        }

        public synchronized static OurPresident getOurPresident()
        {
            if (president == null)
                president = new OurPresident();
                return president;
        }
    }
}
