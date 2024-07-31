package org.example.sorting;

import org.example.Order;

public class QuickSortOrders implements SortOrders{



    @Override
    public void sortOrdersByTotalPrice(Order[] arr){
        quickSort(arr,0,arr.length-1);
    }

    private void quickSort(Order[] arr,int low,int high){
        QuickSortOrders obj = new QuickSortOrders();

        if(low<high){
            int partitionIndex = obj.partition(arr,low,high);

            quickSort(arr,low,partitionIndex);
            quickSort(arr,partitionIndex+1,high);
        }
    }

    private int partition(Order[] arr,int low,int high){
        QuickSortOrders obj = new QuickSortOrders();

        double pivot = arr[low].getTotalPrice();
        int i= low+1;
        int j= high;


        do{
            while(arr[i].getTotalPrice()<= pivot){
                i++;
            }
            while(arr[j].getTotalPrice()> pivot){
                j--;
            }

            if(i<j)
            {
                obj.swap(arr,i,j);
            }
        }while (i<j);

        obj.swap(arr,low,j);

        return j;

    }

    public void swap(Order[] arr, int i, int j){
        Order temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }
}
