package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<String> words = new ArrayList<>();
        while ((line = bf.readLine()) != null) {
            String[] w2 = line.split(" ");
            words.addAll(Arrays.asList(w2));
        }
        bf.close();
        br.close();
        StringBuilder sb;
        for (String word : words) {
            sb = new StringBuilder(word);
            String rev = sb.reverse().toString();
            if (word.equals(rev)) {
                if (Collections.frequency(words, word) == 1) {
                }else{
                    Pair p1 = new Pair(word,word);
                    if(!result.contains(p1)){
                        result.add(p1);
                    }
                }
            } else {
                if (words.contains(rev)) {
                    Pair p = new Pair(rev, word);
                    if (!result.contains(p)) {
                        result.add(new Pair(word, rev));
                    }
                }
            }

        }
        for (Pair pair : result) {
            System.out.println(pair.first + " " + pair.second);
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

}
