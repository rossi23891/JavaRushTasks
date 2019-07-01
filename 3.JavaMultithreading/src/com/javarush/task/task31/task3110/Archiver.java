package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, enter archive directory");
        String archivePath = reader.readLine();// ввод полного пути архива,где будем хранить данные

        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(archivePath));
        System.out.println("Please, enter directory to file to be archived");
        String filePath = reader.readLine(); //ввод пути к файлу, кот архивируем
        zipFileManager.createZip(Paths.get(filePath));

    }
}
