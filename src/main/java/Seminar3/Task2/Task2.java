package Seminar3.Task2;

import java.util.Arrays;

public class Task2<T> {
    private Object [] array;
    private int size;
    public Task2(int lenght){
        this.array = new Object[lenght];
    }
    public void addToArray(T el){
        if (size>=array.length){
            array = Arrays.copyOf(array,array.length*2);
        }
        array[size++] = el;
    }
    public void deleteToArray( T el){
        for(int i =0;i<size;i++){
            if(array[i].equals(el)){
                for (int j = i; j < size-1; j++) {
                    array[j] =array[j+1];

                }
                break;
            }
        }
    }

}
