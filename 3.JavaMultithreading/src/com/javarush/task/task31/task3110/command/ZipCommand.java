package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command{
    public ZipFileManager getZipFileManager() throws Exception{
        ConsoleHelper.writeMessage("Введите путь файла архива");
        String pathToArchive = ConsoleHelper.readString();
        //путь файла, где будет создаваться архив
        Path archivePath = Paths.get(pathToArchive);
        return new ZipFileManager(archivePath);
    }
}
