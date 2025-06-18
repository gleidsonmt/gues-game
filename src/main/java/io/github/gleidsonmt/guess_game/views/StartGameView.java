package io.github.gleidsonmt.guess_game.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  12/06/2025
 */
public class StartGameView extends VBox {

    public StartGameView() {
        Button playButton = new Button("Play");
        playButton.getStyleClass().add("play-button");
        BorderPane.setAlignment(playButton, Pos.CENTER);
        BorderPane.setMargin(playButton, new Insets(20));

        getChildren().setAll(playButton);
        setAlignment(Pos.CENTER);

        playButton.setOnAction(_ -> {
            GameView gameView = new GameView();
            this.getScene().setRoot(gameView);
        });
    }

}
