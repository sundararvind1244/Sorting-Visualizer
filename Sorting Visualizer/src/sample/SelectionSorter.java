package sample;

import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class SelectionSorter extends Sorter{
    public SelectionSorter(){

    }

    public ArrayList<Integer> getSortedList(ArrayList<Integer> list, ArrayList<GraphPainter> graph){
        ArrayList<Integer> sortedList = new ArrayList<>();
        new Thread(()-> {
            while (list.size() != 0) {
                int minIndex = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) < list.get(minIndex)) {

                        minIndex = i;

                    }



                    //graph.get(i).adjustHeight(list.get(minIndex));


                }
                sortedList.add(list.remove(minIndex));
            }
            int index = 0;
            for(GraphPainter painter: graph){
                painter.adjustHeight(sortedList.get(index));
                index++;
                try{
                    Thread.sleep(100);
                    }
                    catch (InterruptedException e){
                    e.printStackTrace();
                    }

            }
            for(GraphPainter painter: graph){
                painter.setFill(Paint.valueOf("red"));
                try{
                    Thread.sleep(100);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                painter.setFill(Paint.valueOf("dodgerblue"));
                try{
                    Thread.sleep(10);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }

        }).start();
        return sortedList;
    }


}
