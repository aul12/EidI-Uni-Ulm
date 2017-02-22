package me.aul12;


public class SelectionSort extends Sort {
    SelectionSort(int[] arr) {
        super(arr);
    }

    @Override
    public int[] sort() {
        for(int c=0; c<super.arr.length; c++){
            for(int d=c; d<super.arr.length; d++){
                if(super.arr[d] < super.arr[c]){
                    int t = super.arr[d];
                    super.arr[d] = super.arr[c];
                    super.arr[c] = t;
                }
            }
        }
        return super.arr;
    }
}
