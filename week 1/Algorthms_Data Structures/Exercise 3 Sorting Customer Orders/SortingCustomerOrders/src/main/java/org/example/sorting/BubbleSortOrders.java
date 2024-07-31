package org.example.sorting;

import org.example.Order;

public class BubbleSortOrders implements SortOrders{
    @Override
    public void sortOrdersByTotalPrice(Order[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i].getTotalPrice()>arr[j].getTotalPrice()){
                    new BubbleSortOrders().swap(arr,i,j);
                }
            }
        }
    }

    private void swap(Order arr[], int i,int j){
        Order temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }
}
