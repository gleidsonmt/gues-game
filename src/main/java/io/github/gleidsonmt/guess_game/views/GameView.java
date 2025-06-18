package io.github.gleidsonmt.guess_game.views;

import io.github.gleidsonmt.guess_game.views.components.BodyGameView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.List;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  11/06/2025
 */
public class GameView extends StackPane {

    private BodyGameView bodyGameView;

    private ObservableList<String> all;
    private List<String> originals;

    public GameView() {
        originals =
                FXCollections.observableArrayList(
                        ("hippo.png penguin.png octopus.png cow.png bat.png " +
                         "panda.png monkey.png dog.png tiger.png turtle.png")
                                .split(" "));

        test();;
        init();
    }

    private void start() {
        shuffle();
        this.getChildren().setAll(bodyGameView);
    }

    private void test() {
        all = FXCollections.observableArrayList();
        all.addAll( originals);
        all.addAll( originals);
    }

    private void shuffle() {
        all = FXCollections.observableArrayList();
        Collections.shuffle(originals);
        all.addAll( originals);
        Collections.shuffle(originals);
        all.addAll(originals);
    }

    private void init() {
        this.bodyGameView = new BodyGameView(all);
        this.getChildren().setAll(this.bodyGameView);
    }


}
