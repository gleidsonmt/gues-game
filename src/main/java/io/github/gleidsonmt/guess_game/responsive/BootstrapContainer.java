package io.github.gleidsonmt.guess_game.responsive;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  18/06/2025
 */
public class BootstrapContainer extends Container {

    public BootstrapContainer() {
        setSizer(new Sizer<>(this, Bootstrap.values()) {
            @Override
            public void change(Bootstrap abreak) {
                breaker.doAction(abreak);
            }
        });
        sizer.setLog(true);
    }
}
