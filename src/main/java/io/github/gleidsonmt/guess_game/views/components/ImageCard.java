package io.github.gleidsonmt.guess_game.views.components;

import io.github.gleidsonmt.guess_game.utils.Assets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  12/06/2025
 */
public class ImageCard extends Region {

    private double width;
    private double height;
    private Image avatar;

    public ImageCard(Image avatar, double width, double height) {
        this.avatar = avatar;
        this.width = width;
        this.height = height;
        setAvatar(avatar);
    }

    public void setAvatar(Image image) {
        setBackground(createBackground(image));
    }

    public Background createBackground(Image image) {
        return  new Background(
                new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER, new BackgroundSize(width, height, true, true, true, false)));
    }

    public Background createBackground(String image) {
        return  new Background(
                new BackgroundImage(Assets.getImage(image, width, height), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER, new BackgroundSize(width, height, true, true, true, false)));
    }
}
