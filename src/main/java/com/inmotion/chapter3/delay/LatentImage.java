package com.inmotion.chapter3.delay;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * {@link Image}を遅延処理するためのクラス。
 */
public class LatentImage {

    private Image in;
    private List<UnaryOperator<Color>> pendingOperations;

    public LatentImage(Image in, List<UnaryOperator<Color>> pendingOperations) {
        this.in = in;
        this.pendingOperations = pendingOperations;
    }

    public static LatentImage from(Image in) {
        return new LatentImage(in, new ArrayList<UnaryOperator<Color>>());
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (UnaryOperator<Color> f : pendingOperations) {
                    out.getPixelWriter().setColor(x, y, c);
                }
            }
        }
        return out;
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(f);
        return this;
    }

}
