package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    private static final BorderPane borderPane = new BorderPane();
    private static FlowPane fp2 = new FlowPane();
    private static final FlowPane flowpane = new FlowPane();
    private static ArrayList<Integer> list ;
    private static ArrayList<GraphPainter> bars = new ArrayList<>();
    private Button merge = new Button("Merge Sort");
    private Button bubble = new Button("Bubble Sort");
    private Button selection = new Button("Insertion Sort");
    private Button quick = new Button("Quick Sort");
    private Button reset = new Button("Reset Sequence");



    @Override
    public void start(Stage primaryStage) throws Exception{
        setup();
        bubble.setOnAction(this::bubbleSolver);
        reset.setOnAction(this::resetSequence);
        selection.setOnAction(this::selectionSolver);
        quick.setOnAction(this::quickSort);
        merge.setOnAction(this::mergeSolver);
        flowpane.setHgap(10);
        fp2.setHgap(1.5);

        flowpane.getChildren().addAll(merge,bubble,selection,quick,reset);
        fp2.setPadding(new Insets(20,20,0,20));
        flowpane.setPadding(new Insets(10,10,0,10));
        borderPane.setCenter(fp2);
        borderPane.setTop(flowpane);
        borderPane.setStyle("-fx-background-color: black; ");




        primaryStage.setTitle("Sorting Visualizer");
        primaryStage.setScene(new Scene(borderPane,1400,700 ));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    private static void setup(){

        list = Sorter.generateSequence(55,500);
        for(int i = 0; i < list.size(); i++){
            GraphPainter bar = new GraphPainter(list.get(i));
            fp2.getChildren().add(bar);
            bars.add(bar);
        }
    }
    public void bubbleSolver(ActionEvent e){
        selection.setDisable(true);
        merge.setDisable(true);
        quick.setDisable(true);
        Sorter sorter = new BubbleSorter();
        sorter.getSortedList(list, bars);

    }
    public void selectionSolver(ActionEvent e){
        bubble.setDisable(true);
        merge.setDisable(true);
        quick.setDisable(true);
        Sorter sorter = new SelectionSorter();
        sorter.getSortedList(list, bars);

    }
    public void mergeSolver(ActionEvent e){
        bubble.setDisable(true);
        selection.setDisable(true);
        quick.setDisable(true);
        MergeSorter sorter = new MergeSorter();
        sorter.getSorted(list,bars);
    }
    public void resetSequence(ActionEvent event){
        bubble.setDisable(false);
        selection.setDisable(false);
        merge.setDisable(false);
        quick.setDisable(false);
        fp2.getChildren().clear();
        bars.clear();
        setup();
    }
    public void quickSort(ActionEvent event){
        bubble.setDisable(true);
        selection.setDisable(true);
        merge.setDisable(true);
        Sorter sorter = new QuickSorter();
        sorter.getSortedList(list,bars);

    }
    public static ArrayList<GraphPainter> modify(){
        return bars;
    }
}
