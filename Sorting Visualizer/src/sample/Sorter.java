package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class Sorter {
    public abstract ArrayList<Integer> getSortedList(ArrayList<Integer> unsortedList, ArrayList<GraphPainter> graph);
    public static void main(String[] args) {
        Sorter sorter = new QuickSorter();
        System.out.println(sorter.getSortedList(generateSequence(10,50), new ArrayList<GraphPainter>()));

    }
    public static ArrayList<Integer> generateSequence(int size, int limit){
        Random random = new Random();
        ArrayList<Integer> sequence= new ArrayList<>();
        for(int i = 0; i< size; i++){
            sequence.add(random.nextInt(limit+1));
        }
        System.out.println(sequence);
        return sequence;
    }

}
