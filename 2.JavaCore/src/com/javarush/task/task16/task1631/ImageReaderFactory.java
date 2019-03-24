package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes types) {
        ImageReader ireader;
        if (types != null) {
            if (types.equals(ImageTypes.PNG)) {
                ireader = new PngReader();
            } else if (types.equals(ImageTypes.JPG)) {
                ireader = new JpgReader();
            } else if (types.equals(ImageTypes.BMP)) {
                ireader = new BmpReader();
            }
            else {
                throw new IllegalArgumentException("Неизвестный тип картинки");
            }
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return ireader;
    }
}
