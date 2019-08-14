package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String>filePaths = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.add(new File(root));
        while (!queue.isEmpty()){
            File currentDir = queue.poll();
            for (File file : Objects.requireNonNull(currentDir.listFiles())) {
                if(file.isDirectory()){
                    ((LinkedList<File>) queue).add(file);
                }else{
                    String absolutePath = file.getAbsolutePath();
                    filePaths.add(absolutePath);
                }
            }
        }
        return filePaths;
    }

    public static void main(String[] args) {
        
    }
}
