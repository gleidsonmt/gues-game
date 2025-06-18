package io.github.gleidsonmt.guess_game;

import io.github.gleidsonmt.guess_game.utils.Assets;
import io.github.gleidsonmt.guess_game.views.StartGameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  11/06/2025
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {


        StartGameView startGameView = new StartGameView();
        Scene scene = new Scene(startGameView, 1336, 600);
        scene.getStylesheets().addAll(Assets.getCss("main.css"), Assets.getCss("immersive_scroll.css"));
        stage.setScene(scene);
        stage.show();


    }
}