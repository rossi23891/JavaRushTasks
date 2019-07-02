package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;

public class Archiver {
    public static void main(String[] args){
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        } while (operation != (Operation.EXIT));
    }

    public static Operation askOperation() throws IOException {
        Operation operation = null;
        ConsoleHelper.writeMessage("Выберите операцию:\n" +
                "0 - упаковать файлы в архив\n" +
                "1 - добавить файл в архив\n" +
                "2 - удалить файл из архива\n" +
                "3 - распаковать архив\n" +
                "4 - просмотреть содержимое архива\n" +
                "5 - выход");

        int userOperation = ConsoleHelper.readInt();
        if (userOperation == Operation.CREATE.ordinal()) {
            operation = Operation.CREATE;
        } else if (userOperation == Operation.ADD.ordinal()) {
            operation = Operation.ADD;
        } else if (userOperation == Operation.REMOVE.ordinal()) {
            operation = Operation.REMOVE;
        } else if (userOperation == Operation.EXTRACT.ordinal()) {
            operation = Operation.EXTRACT;
        } else if (userOperation == Operation.CONTENT.ordinal()) {
            operation = Operation.CONTENT;
        } else if (userOperation == Operation.EXIT.ordinal()) {
            operation = Operation.EXIT;
        }
        return operation;
    }
}
