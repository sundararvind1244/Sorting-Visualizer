package sample;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Objects;

public class GraphPainter extends Rectangle {
    private int height;

    private static final int SIZE_SCALE = 0;
    private static final double WIDTH = 20;
    public GraphPainter(int number){

        setHeight(number-SIZE_SCALE);
        height = (int) getHeight();
        setWidth(WIDTH);
        setFill(Paint.valueOf("blueviolet"));
        setStrokeWidth(2);
        setStroke(Paint.valueOf("black"));

    }
    public void adjustHeight(int number){
        height = number;
        PauseTransition pt = new PauseTransition(Duration.seconds(0));
        pt.setOnFinished((actionEvent -> {
        int newHeight = number+SIZE_SCALE;
        //pt.play();
        setHeight(newHeight);

    }));
pt.play();

    }
    public void repaint(GraphPainter graph,int number){
        //graph.setHeight();
    }

    @Override
    public String toString() {
        return ""+height;
    }
}
