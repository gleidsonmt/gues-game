package io.github.gleidsonmt.guess_game.responsive;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  26/09/2024
 */
public enum Break implements Size {

    MOBILE(0),
    SM(640),
    MD(768),
    LG(1024),
    XL(1280),
    XXL(1536),
    WIDE(2560),
    ;

    private double size;

    Break(double size) {
        this.size = size;
    }

    public double getMax() {
        return size;
    }
}
