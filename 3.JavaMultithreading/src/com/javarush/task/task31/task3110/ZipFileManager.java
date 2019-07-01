package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;//архивируем файл с адресом zipFile

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception{ //source - это путь к чему-то, что мы будем архивировать
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            String archivedFileAddress = source.getFileName().toString();
            ZipEntry zipEntry = new ZipEntry(archivedFileAddress);
            zipOutputStream.putNextEntry(zipEntry);
            try (InputStream inputStream = Files.newInputStream(source)) {
                while (inputStream.available() > 0) {
                    int data = inputStream.read();
                    zipOutputStream.write(data);
                }
            }
            zipOutputStream.closeEntry();
        }
    }
}
