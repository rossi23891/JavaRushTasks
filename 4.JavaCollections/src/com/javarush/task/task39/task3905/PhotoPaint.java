package com.javarush.task.task39.task3905;

import java.awt.*;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {

        if (desiredColor == null ||
                image == null ||
                image.length <= y ||
                image[y].length <= x ||
                image[y][x] == null ||
                image[y][x] == desiredColor)
            return false;

        Color current = image[y][x];

        Deque<Point> points = new LinkedBlockingDeque<>();
        points.add(new Point(x, y));

        while (!points.isEmpty()) {
            Point point = points.poll();

            if (paintPixel(image, point.x, point.y+1, desiredColor, current))
                points.add(new Point(point.x, point.y+1));

            if (paintPixel(image, point.x+1, point.y, desiredColor, current))
                points.add(new Point(point.x+1, point.y));

            if (paintPixel(image, point.x, point.y-1, desiredColor, current))
                points.add(new Point(point.x, point.y-1));

            if (paintPixel(image, point.x-1, point.y, desiredColor, current))
                points.add(new Point(point.x-1, point.y));

            if (paintPixel(image, point.x, point.y, desiredColor, current)){
                return true;
            }

        }

        return true;
    }

    private boolean paintPixel(Color[][] image, int x, int y, Color desiredColor, Color oldColor) {
        if (y >= 0 && y < image.length && x >= 0 && x < image[y].length && image[y][x] == oldColor) {
            image[y][x] = desiredColor;
            return true;
        }
        return false;
    }
}
