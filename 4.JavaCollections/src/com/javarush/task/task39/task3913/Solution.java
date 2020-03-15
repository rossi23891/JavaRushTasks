package com.javarush.task.task39.task3913;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args){
        LogParser logParser = new LogParser(Paths.get("/home/maria/IdeaProjects/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs"));
        //System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        //System.out.println(logParser.getNumberOfUserEvents("Vasya Pupkin",null,null));
        //System.out.println(logParser.getAllUsers());
        //System.out.println(logParser.getNumberOfUsers(null,null));
        //System.out.println(logParser.getSolvedTaskUsers(null,null,18));
        //System.out.println(logParser.getDatesForUserAndEvent("Amigo",Event.LOGIN,null, null));
        //System.out.println(logParser.getNumberOfSuccessfulAttemptToSolveTask(1,null, null));
        //System.out.println(logParser.execute("get ip for user = \"Vasya Pupkin\""));
        //System.out.println(logParser.execute("get user for event = \"DONE_TASK\""));
        System.out.println(logParser.execute("get ip"));
    }
}