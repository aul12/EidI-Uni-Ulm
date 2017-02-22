package me.aul12;


public class BubbleSort extends Sort {
    BubbleSort(int[] arr) {
        super(arr);
    }

    @Override
    public int[] sort() {
        for(int c=super.arr.length; c>0; c--){
            for(int d=0; d<c-1; d++){
                if(super.arr[d] > super.arr[d+1]){
                    int t = super.arr[d];
                    super.arr[d] = super.arr[d+1];
                    super.arr[d+1] = t;
                }
            }
        }
        return super.arr;
    }
}
