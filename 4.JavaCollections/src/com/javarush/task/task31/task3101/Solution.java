package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        File directory = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File outputFile = new File(resultFileAbsolutePath.getParent() + "/" + "allFilesContent.txt");
        if (FileUtils.isExist(outputFile)) {
            FileUtils.deleteFile(outputFile);
        }
        FileUtils.renameFile(resultFileAbsolutePath, outputFile);
        List<File> smallFiles = new ArrayList<>();
        Queue<File> Q = new LinkedList<>();
        Q.add(directory);
        while (!Q.isEmpty()){
            File currDir = Q.poll();
            for (File file : Objects.requireNonNull(currDir.listFiles())) {
                if (file.isDirectory())
                    Q.add(file);
                else if (file.length() <= 50)
                    smallFiles.add(file);
            }
        }
        smallFiles.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFile))) {
            for (File smallFile : smallFiles) {
                BufferedReader fileReader = new BufferedReader(new FileReader(smallFile));
                while (fileReader.ready()) {
                    fileWriter.write(fileReader.readLine());
                }
                fileWriter.write("\n");
                fileReader.close();
            }
        }
    }
}
