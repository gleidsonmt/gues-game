module io.github.gleidsonmt.guess_game {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;
    requires java.sql;


    opens io.github.gleidsonmt.guess_game to javafx.fxml;
    exports io.github.gleidsonmt.guess_game;
    exports io.github.gleidsonmt.guess_game.views.components;
    opens io.github.gleidsonmt.guess_game.views.components to javafx.fxml;
    exports io.github.gleidsonmt.guess_game.utils;
    opens io.github.gleidsonmt.guess_game.utils to javafx.fxml;
    exports io.github.gleidsonmt.guess_game.views;
    opens io.github.gleidsonmt.guess_game.views to javafx.fxml;
}