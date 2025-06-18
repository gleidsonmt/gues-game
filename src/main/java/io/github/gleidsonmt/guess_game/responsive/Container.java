package io.github.gleidsonmt.guess_game.responsive;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;

import java.util.Arrays;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  19/03/2025
 */
public class Container<T extends Size> extends StackPane {

    protected Breaker<T> breaker;
    protected Sizer<T> sizer;

    public Container() {
        this.breaker = new Breaker<>();
        this.sizer = new Sizer<T>(this, (T[]) Break.values()) {
            @Override
            public void change(T size) {
                breaker.doAction(size);
            }
        };
    }

    public Container(T[] values) {
        this.breaker = new Breaker<>();
        this.sizer = new Sizer<T>(this, values) {
            @Override
            public void change(T size) {
                breaker.doAction(size);
            }
        };
    }

    public void setSizer(Sizer<T> sizer) {
        this.sizer.clear(this);
        this.sizer = sizer;
    }

    public void setBreaker(Breaker breaker) {
        this.breaker = breaker;
    }

    /**
     * See the values and the width relation.
     * [ < number] - Size
     */
    public void log() {
        this.sizer.setLog(true);
    }

    /**
     * Add a point to make an action when the scene size is equal this break point.
     *
     * @param event  The event to occur.
     * @param breaks The breaks/size to event occurs.
     */
    public void addPoint(EventHandler<ActionEvent> event, T... breaks) {
        breaker.getPoints().add(new BreakPoint(event, breaks));
    }

    /**
     * Add a multiple points to make an action when the scene size is equal this break point.
     *
     * @param points The Breakpoints.
     */
    public void addPoints(BreakPoint... points) {
        breaker.getPoints().addAll(Arrays.stream(points).toList());
    }

}
