package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen{
    @Override
    public int getCountOfEggsPerMonth() {
        int numberOfEggs = 100;
        return numberOfEggs;
    }

    @Override
    public String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }

}
