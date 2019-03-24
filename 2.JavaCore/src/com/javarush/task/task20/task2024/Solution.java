package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public Solution() {
    }

    public void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.writeInt(node);
        outputStream.writeObject(edges);
        outputStream.close();

    }
    public void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int node = objectInputStream.readInt();
        Object edges = (List)objectInputStream.readObject();
    }

    public static void main(String[] args) {

    }
}
