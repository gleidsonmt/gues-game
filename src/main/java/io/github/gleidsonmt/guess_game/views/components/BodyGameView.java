package io.github.gleidsonmt.guess_game.views.components;

import io.github.gleidsonmt.guess_game.responsive.Bootstrap;
import io.github.gleidsonmt.guess_game.responsive.Container;
import io.github.gleidsonmt.guess_game.utils.Assets;
import io.github.gleidsonmt.guess_game.views.StartGameView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  11/06/2025
 */
public class BodyGameView extends BorderPane {

    private ScrollPane wrapper;
    private Container<Bootstrap> container = new Container(Bootstrap.values());
    private GridPane grid;

    int cols = 0;
    int rows = 0;
    int points = 0;
    private final ObservableList<CardView> selects = FXCollections.observableArrayList();

    public BodyGameView(ObservableList<String> images) {
        init();

        images.forEach(el -> {
            String name = el.substring(0, el.lastIndexOf("."));
            CardView cardView = new CardView(name, Assets.getImage(el));
            grid.add(cardView, cols++, rows);
            cardView.setMouseTransparent(true);

            cardView.setOnMouseClicked(e -> {
                cardView.getTimeline().setOnFinished(_ -> {
                    selects.add(cardView);

                    if (selects.size() == 2) {
                        // verifica se os dois estao certos
                        if (verify(selects.get(0), selects.get(1))) {
                            selects.forEach(CardView::applySetStatus);
                            points++;
                            if (points == 10) {
                                wonGame();
                            }
                        } else {
                            selects.forEach(CardView::close);
                        }
                        selects.clear();
                    }
                });
                cardView.open();
            });

            if (cols == 5) {
                rows++;
                cols = 0;
            }
        });


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                grid.getChildren().stream()
                        .filter(el -> el instanceof CardView)
                        .map(el -> (CardView) el)
                        .forEach(el -> {
                            el.setMouseTransparent(false);
                            el.close();
                        });
            }
        };
        new Timer().schedule(timerTask, 1000);

//        container.addPoint(_ -> updateGrid(1), Break.MOBILE);
//        container.addPoint(_ -> updateGrid(2), Break.SM);
//        container.addPoint(_ -> updateGrid(3), Break.MD, Break.LG);
//        container.addPoint(_ -> updateGrid(5), Break.XL, Break.XL);
//        container.addPoint(_ -> updateGrid(10), Break.WIDE);

        container.log();
//        container.addPoint(_ -> updateGrid(1), Bootstrap.SMALL);
//        container.addPoint(_ -> updateGrid(2), Break.SM);
//        container.addPoint(_ -> updateGrid(3), Break.MD, Break.LG);
//        container.addPoint(_ -> updateGrid(5), Break.XL, Break.XL);
//        container.addPoint(_ -> updateGrid(10), Break.WIDE);
    }

    private void wonGame() {
        this.getScene().setRoot(new StartGameView());
    }

    private boolean verify(CardView one, CardView two) {
        return one.getCardName().equals(two.getCardName());
    }

    private void updateGrid(int cols) {
        this.cols = 0;
        this.rows = 0;
        grid.getChildren().forEach(el -> {
            GridPane.setColumnIndex(el, ++this.cols);
            GridPane.setRowIndex(el, this.rows);

            if (this.cols == cols) {
                this.rows++;
                this.cols = 0;
            }
        });

    }

    private Stream<CardView> getCards() {
        return grid.getChildren().stream()
                .filter(cd -> (cd instanceof CardView))
                .map(cd -> (CardView) cd);
    }

    private void init() {
        this.wrapper = new ScrollPane();
        this.wrapper.getStyleClass().add("wrapper");

        this.wrapper.setContent(container);
        this.grid = new GridPane();
        this.container.getChildren().setAll(grid);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(30);
        setCenter(wrapper);
    }
}
