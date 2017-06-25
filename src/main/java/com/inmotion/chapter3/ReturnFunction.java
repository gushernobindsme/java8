package com.inmotion.chapter3;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.function.UnaryOperator;

/**
 * 関数を返す
 */
public class ReturnFunction {

    public UnaryOperator<Color> brighten(double factor) {
        return c -> c.deriveColor(0, 1, factor, 1);
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
        return transform(image, brighten(1.2));
    }

}
