package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
*/

import static com.javarush.task.task39.task3905.Color.BLUE;
import static com.javarush.task.task39.task3905.Color.ORANGE;

public class Solution {
    public static void main(String[] args) {
        Color[][] image = new Color[][] {
                {BLUE}
        };

        new PhotoPaint().paintFill(image, 0, 0, ORANGE);

        System.out.println(image[0][0].name());
    }
}
