package sample;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BubbleSorter extends Sorter{
    private int i;
    private int j;
    private int temp;
    private int temp2;
    private ArrayList<GraphPainter> graph;
    public BubbleSorter(){
        i = 0;
        j = 0;
        temp = 0;
        temp2 = 0;

    }

    public ArrayList<Integer> getSortedList(ArrayList<Integer> list, ArrayList<GraphPainter> graph) {
        temp = 0;

         new Thread(()-> {
             for (int i = 0; i < list.size() - 1; i++) {
                 this.i = i;
                 for (int j = 0; j < list.size() - i - 1; j++) {
                     this.j = j;
                     if (list.get(j) > list.get(j + 1) && this.j < list.size() - 1) {

                         final int temp = list.get(j);
                         temp2 = list.get(j + 1);
                         this.temp = temp;

                         graph.get(this.j).adjustHeight(list.get(this.j + 1));
                         graph.get(this.j).setFill(Paint.valueOf("mediumorchid"));
                         try{
                             Thread.sleep(8);
                         }
                         catch (Exception e){
                             e.printStackTrace();
                         }
                         list.set(this.j, list.get(this.j + 1));
                         list.set(this.j + 1, temp);
                         try{
                             Thread.sleep(8);
                         }
                         catch (Exception e){
                             e.printStackTrace();
                         }
                         graph.get(this.j+1).setFill(Paint.valueOf("orangered"));
                         graph.get(this.j++ + 1).adjustHeight(temp);
                     }

                 }
                 this.i++;


             }
             for(GraphPainter painter: graph){
                 painter.setFill(Paint.valueOf("Black"));
                 try{
                     Thread.sleep(100);
                 }
                 catch(Exception e){
                     e.printStackTrace();
                 }
                 painter.setFill(Paint.valueOf("dodgerblue"));
                 try{
                     Thread.sleep(80);
                 }
                 catch(Exception e){
                     e.printStackTrace();
                 }
             }

         }).start();
         return list;
    }


}
