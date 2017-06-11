package com.inmotion.chapter1;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * コンストラクタ参照実装サンプル。
 */
public class ConstructorReference {

    public List<Button> before(List<String> labels){
        List<Button> buttons = new ArrayList<>();
        for(String label : labels){
            buttons.add(new Button(label));
        }
        return buttons;
    }

    public List<Button> after(List<String> labels){
        return labels.stream().map(Button::new).collect(Collectors.toList());
    }

    public Button[] afterToArray(List<String> labels){
        return labels.stream().map(Button::new).toArray(Button[]::new);
    }

}
