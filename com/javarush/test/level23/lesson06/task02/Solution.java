package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public static final class Constants
    {
        public static final String NOT_ACCESSIBLE = "Server is not accessible for now.";
        public static final String NOT_AUTH = "User is not authorized.";
        public static final String IS_BANNNED = "User is banned.";
        public static final String IS_DENIED = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception
    {
        public ServerNotAccessibleException() {
            super(Constants.NOT_ACCESSIBLE);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.NOT_ACCESSIBLE, cause);
        }
    }

    public class UnauthorizedUserException extends Exception
    {
        public UnauthorizedUserException() {
            super(Constants.NOT_AUTH);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.NOT_AUTH, cause);
        }
    }

    public class BannedUserException extends Exception
    {
        public BannedUserException() {
            super(Constants.IS_BANNNED);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.IS_BANNNED, cause);
        }
    }

    public class RestrictionException extends Exception
    {
        public RestrictionException() {
            super(Constants.IS_DENIED);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.IS_DENIED, cause);
        }
    }
}
