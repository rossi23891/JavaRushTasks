package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    Path path;

    public FileBucket(){
        try {
            path = Files.createTempFile("tmp",null);
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public long getFileSize(){
        try {
            return Files.size(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        return 0L;
    }

    public void putEntry(Entry entry){
        try(ObjectOutputStream ois = new ObjectOutputStream(Files.newOutputStream(path))) {
            ois.writeObject(entry);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry(){
        Entry entry = null;
        if (getFileSize() <= 0) {
            return null;
        }
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            entry = (Entry) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }
        return entry;
    }

    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
