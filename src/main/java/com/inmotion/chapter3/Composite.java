package com.inmotion.chapter3;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.function.UnaryOperator;

/**
 * 合成
 */
public class Composite {

    public <T>UnaryOperator<T> compose(UnaryOperator<T> opt1, UnaryOperator<T> opt2) {
        return t -> opt2.apply(opt1.apply(t));
    }

    public Image transform(Image in, UnaryOperator<Color> f) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y)));
            }
        }
        return out;
    }

    public Image sampleMethod(Image image){
        return transform(image, compose(Color::brighter, Color::grayscale));
    }

}
