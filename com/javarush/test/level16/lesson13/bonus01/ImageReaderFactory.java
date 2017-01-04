package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;


/**
 * Created by Admin on 05.10.2016.
 */
public class ImageReaderFactory
{
    private static ImageReader reader;

    public static ImageReader getReader(ImageTypes imageTypes)
    {
        if (imageTypes == ImageTypes.JPG)
        {
            reader = new JpgReader();
        } else if (imageTypes == ImageTypes.BMP)
        {
            reader = new BmpReader();
        } else if (imageTypes == ImageTypes.PNG)
        {
            reader = new PngReader();
        } else
        {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return reader;
    }
}
