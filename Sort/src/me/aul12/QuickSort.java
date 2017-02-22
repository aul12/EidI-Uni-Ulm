package me.aul12;

public class QuickSort extends Sort {
    QuickSort(int[] arr) {
        super(arr);
    }

    private int[] append(int a[], int b){
        int res[] = new int[a.length+1];
        System.arraycopy(a, 0, res, 0, a.length);
        res[a.length] = b;
        return res;
    }

    private int[] concat(int a[], int b[]){
        int res[] = new int[a.length + b.length];

        System.arraycopy(a, 0, res, 0, a.length);
        System.arraycopy(b, 0, res, 0 + a.length, b.length);

        return res;
    }

    @Override
    public int[] sort() {
        return sort(super.arr);
    }

    private int[] sort(int arr[]){
        if(arr.length <= 1){
            return arr;
        }else{
            int pivot = arr[arr.length/2];

            int low[] = new int[0];
            int high[] = new int[0];

            for (int anArr : arr) {
                if (anArr < pivot) {
                    low = append(low, anArr);
                } else if(anArr > pivot){
                    high = append(high, anArr);
                }
            }

            low = sort(low);
            high = sort(high);

            low = append(low, pivot);

            return concat(low, high);
        }
    }
}
