/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgos;

import java.util.Random;

/**
 *
 * @author mtsguest
 */
public class SortingAlgos {
    

    Random myNums =new Random();
    public static int[] myOriginalUnsortedArray1 = new int[20000];
    public static int[] myCopyUnsortedArray2 = new int[20000];
    public static long bubbleSortDuration, quickSortDuration, selectionSortDuration, insertionSortDuration, mergeSortDuration;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SortingAlgos thisTask =new SortingAlgos();
        
        thisTask.generateRanNums();
        
        thisTask.copyRanNums();
        thisTask.quickSort();  //Extra Credit!
        
        thisTask.copyRanNums();
        //thisTask.mergeSort();  //Extra Credit!
        
        thisTask.copyRanNums();
        thisTask.selectionSort();
        
        thisTask.copyRanNums();
        thisTask.insertionSort(myCopyUnsortedArray2);
        
        thisTask.copyRanNums();
        thisTask.bubbleSort();
        
        thisTask.compareSortTimes();
    }
    
    
    public void generateRanNums(){
        for (int i=0; i<myOriginalUnsortedArray1.length;i++ ){
            myOriginalUnsortedArray1 [i]=myNums.nextInt(5000)+1;
        }
        
    }
    public void copyRanNums(){
        myCopyUnsortedArray2 = myOriginalUnsortedArray1.clone();
    }
    public void quickSort(){
        
    }
    public void bubbleSort(){
        long startTime =System.nanoTime();
        for (int i = (myCopyUnsortedArray2.length -1);i>=0; i--){
            for (int j=1;j<=i;j++){
                if (myCopyUnsortedArray2[j-1]>myCopyUnsortedArray2[j]){
                    int temp = myCopyUnsortedArray2[j-1];
                    myCopyUnsortedArray2[j-1]=myCopyUnsortedArray2[j];
                    myCopyUnsortedArray2[j]=temp;
                }
            }
        }
        long endTime = System.nanoTime();
         bubbleSortDuration = endTime-startTime;
        
    }
    
    public void insertionSort(int a[]){
        long start = System.nanoTime();
        for (int i = 1; i < a.length; i++)
      {
         int next = a[i];
         // Move all larger elements up
         int j = i;

         while (j > 0 && a[j - 1] > next)
         {
            a[j] = a[j - 1];
            j--;
         }
         // Insert the element
         a[j] = next;
      }
        long end =System.nanoTime();
        insertionSortDuration =end-start;
      
    }
    public void selectionSort(){
        long start = System.nanoTime();
        for (int i =0; i< (myCopyUnsortedArray2.length-1);i++){
            int minPosition = minimumPosition(myCopyUnsortedArray2,i);
            swap(myCopyUnsortedArray2,minPosition,i);
            
        }
        long end = System.nanoTime();
        selectionSortDuration = end -start;
        
    }
    public int minimumPosition(int[] a, int from){
        int minPos =from;
        for(int i=from+1;i<a.length;i++){
            if (a[i]<a[minPos]){
                minPos =i;
            }
        }
        return minPos;
    }
    public void swap(int[]a, int i, int j){
        int temp =a[i];
        a[i]=a[j];
        a[j]=temp;
    
    }
    public void compareSortTimes(){
        System.out.println(insertionSortDuration);
        System.out.println(bubbleSortDuration);
        System.out.println(selectionSortDuration);
        if (bubbleSortDuration < selectionSortDuration && bubbleSortDuration < insertionSortDuration) {
            System.out.println("Bubble sort is the fastest algorithm");
        } else if (selectionSortDuration < bubbleSortDuration && selectionSortDuration < insertionSortDuration) {
            System.out.println("Selection sort is the fastest algorithm");
        } else {
            System.out.println("Insertion sort is the fastest algorithm");
        }
    }
}
