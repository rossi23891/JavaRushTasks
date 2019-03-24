package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.UKRAINE);
        hen.getCountOfEggsPerMonth();
        //Hen hen2 = HenFactory.getHen(Country.UKRAINE);
        //System.out.println(hen.getDescription());
        //System.out.println(hen2.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            if (country.equals("Russia")){
                hen = new RussianHen();
            }
            else if(country.equals("Ukraine")){
                hen = new UkrainianHen();
            }else if(country.equals("Belarus")){
                hen = new BelarusianHen();
            }else if(country.equals("Moldova")){
                hen = new MoldovanHen();
            }
            return hen;
        }
    }


}
