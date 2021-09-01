package sample;

import com.sun.scenario.effect.impl.prism.ps.PPSBlend_ADDPeer;
import javafx.application.Platform;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class QuickSorter extends Sorter{
    private ArrayList<Integer> arr ;
    private ArrayList<GraphPainter> graphs ;
    private int i = 0;
    private int j = 0;

    public QuickSorter(){

    }

    @Override
    public ArrayList<Integer> getSortedList(ArrayList<Integer> unsortedList, ArrayList<GraphPainter> graph) {
        this.arr = unsortedList;
        this.graphs = graph;
        quickSort(arr,0,arr.size()-1);
        return arr;
    }
     public void swap(ArrayList<Integer> arr, int i, int j)
    {







    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    public int partition(ArrayList<Integer> arr, int low, int high)
    {


           // pivot
           int pivot = arr.get(high);

           // Index of smaller element and
           // indicates the right position
           // of pivot found so far


           this.i = low - 1;
           for (int j = low; j <= high - 1; j++) {

               this.j = j;
               if (arr.get(this.j) < pivot) {

                   this.i++;
                   int temp = arr.get(i);
                   graphs.get(i).adjustHeight(arr.get(this.j));
                   graphs.get(i).setFill(Paint.valueOf("mediumorchid"));

                   arr.set(i, arr.get(this.j));
                   arr.set(this.j, temp);
                   graphs.get(this.j).adjustHeight(temp);
                   graphs.get(j).setFill(Paint.valueOf("violet"));


               }
               this.j++;
           }
           final int in = i;
           int temp = arr.get(in + 1);
           graphs.get(in + 1).adjustHeight(arr.get(high));
           arr.set(in + 1, arr.get(high));
           arr.set(high, temp);
           graphs.get(high).adjustHeight(temp);




        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    public void quickSort(ArrayList<Integer> arr, int low, int high)
    {
        if (low < high)
        {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
