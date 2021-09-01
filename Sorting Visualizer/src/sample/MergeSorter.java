package sample;

import javafx.application.Platform;
import javafx.scene.paint.Paint;

import javax.sound.midi.Receiver;
import java.sql.SQLSyntaxErrorException;
import java.util.*;

public class MergeSorter extends Sorter {
    private ArrayList<GraphPainter> unsorted = new ArrayList<>();
   private ArrayList<GraphPainter> mergedList = new ArrayList<>();
    private HashMap<Integer, Integer> mapping = new HashMap<>();
    public MergeSorter(){

    }
    public ArrayList<Integer> getSortedList(ArrayList<Integer> list,ArrayList<GraphPainter> graph){
        return list;
    }
    public ArrayList<Integer> getSorted(ArrayList<Integer> list,ArrayList<GraphPainter> graph){
        unsorted = graph;

        for(Integer i : list){
            mapping.put(i,list.indexOf(i));
        }
        return mergeSort(list);
    }
    private ArrayList<Integer> merge(ArrayList<Integer> l1, ArrayList<Integer> l2){
        //ArrayList<GraphPainter> mergedList = new ArrayList<>();
        ArrayList<Integer> mergedList2 = new ArrayList<>();
        int i = 0;
        int j = 0;
        int previousFilledIndex = 0;

        while(i<l1.size() && j<l2.size()){
            if(l1.get(i)<= l2.get(j)){
                //mergedList.set(l1.indexOf(painter1),painter1);
               // System.out.println(painter1);
                mergedList2.add(l1.get(i));
                i++;
            }
            else{
                //mergedList.set(l2.indexOf(painter2),painter2);
                //int index1 = mapping.get(l1.get(i));
                //GraphPainter painter = unsorted.get(index1);
                //int index2 = mapping.get(l2.get(j));

                //System.out.println("Index1 ="+ index1+" Index2 = "+index2);
                //System.out.println("Graphe:"+unsorted.get(index1));
               // System.out.println("Graphe:"+unsorted.get(index2));
                //unsorted.get(index1).adjustHeight(l2.get(j));
                //unsorted.get(index2).adjustHeight(l1.get(i));
                //System.out.println("Number:"+unsorted.get(index1));

            //mapping.put(l1.get(i),index2);
            //mapping.put(l2.get(j),index1);
            //unsorted.set(index1, unsorted.get(index2));
           // unsorted.set(index2,painter);
                mergedList2.add(l2.get(j));
                //previousFilledIndex = index1;
                //System.out.println(painter2);
                j++;
            }
        }
        while(i<l1.size()){
           // int currIndex = previousFilledIndex+1;
            //unsorted.get(currIndex).adjustHeight(l1.get(i));
           // mergedList.set(l1.indexOf(painter),painter);
            mergedList2.add(l1.get(i));
            i++;
        }
        while(j<l2.size()){
           // int currIndex = previousFilledIndex+1;
            //unsorted.get(currIndex).adjustHeight(l2.get(j));
            mergedList2.add(l2.get(j));
            //mergedList.set(l2.indexOf(painter),painter);
            j++;
        }
        try {
            new Thread(() -> {
                int minIndex = 0;
                int maxIndex = 0;
                ArrayList<Integer> indices = new ArrayList<>();
                for (Integer x : mergedList2) {
                    indices.add(mapping.get(x));
                }
                Collections.sort(indices);
                minIndex = indices.get(0);
                maxIndex = indices.get(indices.size() - 1);

                int z = 0;
                for (int k = minIndex; k < minIndex + mergedList2.size(); k++) {

                    int finalK = k;
                    int finalZ = z;
                    Platform.runLater(() -> {
                        unsorted.get(finalK).adjustHeight(mergedList2.get(finalZ));


                        unsorted.get(finalK).setFill(Paint.valueOf("mediumorchid"));



                    });
                    try {
                        Thread.sleep(150);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    z++;
                }
            }).start();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //System.out.println("Mergd"+mergedList2);

        return mergedList2;
    }
    private ArrayList<Integer> mergeSort(ArrayList<Integer> graph){


        if(graph.size()>1){
            //ArrayList<Integer> l1 = new ArrayList<>();
            //ArrayList<Integer> l2= new ArrayList<>();

            ArrayList<Integer> g1 = new ArrayList<>();
            ArrayList<Integer> g2 = new ArrayList<>();
            int lowerBound = 0;
            int ub2 = graph.size();

            for(int i = 0; i<((graph.size()+1)/2);i++){
                //l1.add(list.get(i));
                g1.add(graph.get(i));
            }
            for(int i = ((graph.size()-1)/2)+1; i< graph.size();i++){
                //l2.add(list.get(i));
                g2.add(graph.get(i));
            }


            graph =  merge(mergeSort(g1),mergeSort(g2));
            //HashMap<Integer,Integer> map = new HashMap<>();
            //Iterator<GraphPainter> it = graph.iterator();
            //while(it.hasNext()){
                //GraphPainter painter = it.next();
                //map.put(graph.indexOf(painter),(int)painter.getHeight());
            //}






            return graph;
        }
        return graph;


    }


}
