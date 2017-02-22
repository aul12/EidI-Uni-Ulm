package me.aul12;

public class InsertionSort extends Sort {
    InsertionSort(int[] arr) {
        super(arr);
    }

    @Override
    public int[] sort() {
        for(int c=0; c<super.arr.length; c++){
            for(int d=c; d>0; d--){
                if(super.arr[d] < super.arr[d-1]){
                    int t = super.arr[d];
                    super.arr[d] = super.arr[d-1];
                    super.arr[d-1] = t;
                }
            }
        }
        return super.arr;
    }
}
