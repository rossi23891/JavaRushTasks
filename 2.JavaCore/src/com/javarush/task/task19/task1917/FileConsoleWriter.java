package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter{
    private FileWriter fileWriter;
    String fileName;
    boolean append;
    File file;
    FileDescriptor fd;

    public FileConsoleWriter(String fileName, FileWriter fileWriter) throws IOException {
        this.fileName = fileName;
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(String fileName, boolean append, FileWriter fileWriter) throws IOException {
        this.fileName = fileName;
        this.append = append;
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(File file, FileWriter fileWriter) throws IOException {
        this.file = file;
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(File file, boolean append, FileWriter fileWriter) throws IOException {
        this.file = file;
        this.append = append;
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(FileDescriptor fd, FileWriter fileWriter) {
        this.fd = fd;
        this.fileWriter = fileWriter;
    }


    public static void main(String[] args) {

    }


    public void write(char[] cbuf, int off, int len) throws IOException {

    }


    public void flush() throws IOException {

    }


    public void close() throws IOException {

    }
}
