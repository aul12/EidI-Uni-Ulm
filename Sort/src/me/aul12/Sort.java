package me.aul12;


public abstract class Sort {
    int arr[];


    Sort(int[] arr) {
        this.arr = arr;
    }

    abstract public int[] sort();
}
