package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getMessage(Enum type) {
        if (type != null) {
            String message = type.toString().replace("_", " ").toLowerCase();
            message = message.substring(0, 1).toUpperCase() + message.substring(1);
            if (type instanceof ApplicationExceptionMessage) {
                return new Exception(message);
            } else if (type instanceof DatabaseExceptionMessage) {
                return new RuntimeException(message);
            } else if (type instanceof UserExceptionMessage) {
                return new Error(message);
            }
        }
        return new IllegalArgumentException();
    }
}
