package io.github.gleidsonmt.guess_game.responsive;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  18/06/2025
 */
public enum Bootstrap implements Size {

    EXTRA_SMALL(0),
    SMALL(576),
    MEDIUM(768),
    LARGE(992),
    EXTRA_LARGE(1200),
    EXTRA_EXTRA_LARGE(1400);

    private final double size;

    Bootstrap(double size) {
        this.size = size;
    }

    @Override
    public double getMax() {
        return this.size;
    }
}
