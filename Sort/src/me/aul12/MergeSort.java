package me.aul12;

public class MergeSort extends Sort {
    MergeSort(int[] arr) {
        super(arr);
    }

    @Override
    public int[] sort() {
        return this.sort(super.arr);
    }

    private int[] merge(int[] a, int[] b){
        int aHead=0, bHead=0;
        int res[] = new int[a.length + b.length];
        for(int c=0; c<res.length; c++){
            if(bHead >= b.length){
                res[c] = a[aHead++];
            }else if(aHead >= a.length){
                res[c] = b[bHead++];
            }else if(a[aHead] > b[bHead]){
                res[c] = b[bHead++];
            }else{
                res[c] = a[aHead++];
            }
        }
        return res;
    }

    private int[] sort(int arr[]){
        if(arr.length <= 1){
            return arr;
        }else{
            int m = arr.length/2;
            int low[] = new int[m];
            int high[] = new int[arr.length - m];
            for(int c=0; c<arr.length; c++){
                if(c < m)
                    low[c] = arr[c];
                else
                    high[c-m] = arr[c];
            }
            low = sort(low);
            high = sort(high);

            return merge(low, high);
        }
    }
}
