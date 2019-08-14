package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
    private static int filesCount;
    private static int dirsCount;
    private static long totalSize;

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) throws IOException {
        dirsCount++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        if(Files.isRegularFile(path)){
            filesCount++;
            totalSize+=Files.size(path);
        }
        return FileVisitResult.CONTINUE;
    }

    public static void getDirInfo(Path path) throws IOException {
        Solution solution = new Solution();
        Files.walkFileTree(path,solution);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String path = br.readLine();
        if(!Files.isDirectory(Paths.get(path))){
            System.out.println(path + " - не папка");
        }else{
            getDirInfo(Paths.get(path));
            System.out.println("Всего папок - " + (dirsCount-1));
            System.out.println("Всего файлов - " + filesCount);
            System.out.println(" Общий размер - " + totalSize);

        }


    }
}
