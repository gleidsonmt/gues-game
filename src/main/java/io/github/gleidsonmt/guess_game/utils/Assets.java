package io.github.gleidsonmt.guess_game.utils;

import io.github.gleidsonmt.guess_game.App;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  11/06/2025
 */
public class Assets {

    public static Image getImage(String name) {
        return new Image(Objects.requireNonNull(App.class.getResource("img/" + name)).toExternalForm());
    }

    public static String getCss(String name) {
        return Objects.requireNonNull(App.class.getResource("css/" + name)).toExternalForm();
    }

}
