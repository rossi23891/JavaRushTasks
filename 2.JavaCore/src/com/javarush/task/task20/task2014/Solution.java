package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File test = new File("D:\\Восстановлено\\java\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014");
        Solution savedObject = new Solution(4);
        Solution loadedObject = new Solution(2);
        FileOutputStream fos = new FileOutputStream(test);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(savedObject);
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream(test);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution sol = (Solution)ois.readObject();
        ois.close();
        fis.close();

        System.out.println(new Solution(4));
        if(savedObject.string==loadedObject.string){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution() {
    }

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
