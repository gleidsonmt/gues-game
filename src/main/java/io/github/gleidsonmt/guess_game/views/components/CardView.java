package io.github.gleidsonmt.guess_game.views.components;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  11/06/2025
 */
public class CardView extends StackPane {

    private Timeline timeline = new Timeline();
    private boolean opened = true;
    private Image avatar;
    private String cardName;

    private double cardWidth = 100;
    private double cardHeight = 150;

    private boolean cardOpened = true;

    private ImageCard imageCard;

    public CardView(String cardName, Image image) {
        this.avatar = image;
        this.cardName = cardName;
        this.imageCard = new ImageCard(image);
        this.setUserData(cardName);

        this.getStyleClass().add("card");

        this.setMinSize(cardWidth, cardHeight);
//        this.setMaxSize(200, 300);
        getChildren().add(imageCard);

        this.setRotationAxis(new Point3D(0,20,0));

        this.addEventFilter(MouseEvent.MOUSE_RELEASED, (_) -> {
//           swap();
        });
    }

    public void swap() {
        if (cardOpened) close();
        else open();

    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void open() {
        if (isOpened()) return;
        timeline.getKeyFrames().setAll(
                new KeyFrame(Duration.ZERO, new KeyValue(this.rotateProperty(), 180)),
                new KeyFrame(Duration.ZERO, new KeyValue(this.imageCard.backgroundProperty(), this.imageCard.createBackground("img_200.png"))),
                new KeyFrame(Duration.millis(300), new KeyValue(this.rotateProperty(), 0)),
                new KeyFrame(Duration.millis(150), new KeyValue(this.imageCard.backgroundProperty(), this.imageCard.createBackground(avatar)))
        );
//        timeline.setOnFinished(_ -> cardOpened = true);
        cardOpened = true;
        timeline.play();
        this.setOpened(!this.isOpened());
    }

    public void close() {
        if (!isOpened()) return;
        timeline.getKeyFrames().setAll(
                new KeyFrame(Duration.ZERO, new KeyValue(this.rotateProperty(), 0)),
                new KeyFrame(Duration.ZERO, new KeyValue(this.imageCard.backgroundProperty(), this.imageCard.createBackground(avatar))),
                new KeyFrame(Duration.millis(300), new KeyValue(this.rotateProperty(),180)),
                new KeyFrame(Duration.millis(150), new KeyValue(this.imageCard.backgroundProperty(), this.imageCard.createBackground("img_200.png")))
        );
//        timeline.setOnFinished(_ -> cardOpened = false);
        cardOpened = false;
        timeline.play();
        this.setOpened(!this.isOpened());
    }


    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public String getCardName() {
        return cardName;
    }

    public void applySetStatus() {
        this.setStyle("-fx-background-color: derive(#50c800, 50%); -fx-border-color: white;");
        System.out.println("cardName = " + cardName.charAt(0));
        Text title = new Text(cardName.toUpperCase().charAt(0) + cardName.substring(1));
        title.setStyle("-fx-fill: white;");
        StackPane.setAlignment(title, Pos.BOTTOM_CENTER);
        getChildren().add(title);

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Card{");
        sb.append("\n\tcardName='").append(cardName).append('\'');
        sb.append("\n\topened=").append(opened);
        sb.append("\n}");
        return sb.toString();
    }
}
