package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String zip = args[1];
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zip))) {
            Map<String, ByteArrayOutputStream> tempMap = new TreeMap<>();
            ZipEntry entry = zipInputStream.getNextEntry();
            while (entry != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                copyData(zipInputStream,baos);
                tempMap.put(entry.getName(), baos);
                baos.close();
                zipInputStream.closeEntry();
                entry = zipInputStream.getNextEntry();
            }
            try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zip))) {

                zipOutputStream.putNextEntry(new ZipEntry("new/" + Paths.get(args[0]).getFileName()));
                Files.copy(Paths.get(args[0]),zipOutputStream);
                for (Map.Entry<String,ByteArrayOutputStream> pairs : tempMap.entrySet()
                ) {
                    zipOutputStream.putNextEntry(new ZipEntry(pairs.getKey()));
                    zipOutputStream.write(pairs.getValue().toByteArray());

                    zipOutputStream.closeEntry();
                }
            }
        }
    }

    private static void copyData(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }
}
