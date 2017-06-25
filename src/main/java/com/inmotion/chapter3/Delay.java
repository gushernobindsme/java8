package com.inmotion.chapter3;

import com.inmotion.chapter3.delay.LatentImage;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * 遅延
 */
public class Delay {

    public Image sampleMethod(Image image){
        return LatentImage.from(image)
                .transform(Color::brighter)
                .transform(Color::grayscale)
                .toImage();
    }

}
