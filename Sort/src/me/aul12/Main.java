package me.aul12;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int arr[] = {3, 4, -2, 6, 7, -4};
        Sort s = new MergeSort(arr);
        arr = s.sort();

        System.out.println(Arrays.toString(arr));
    }
}
