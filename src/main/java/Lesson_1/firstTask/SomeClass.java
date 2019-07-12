package Lesson_1.firstTask;

import java.util.ArrayList;

public class SomeClass<T extends Object> {
    private T[] array;

    public SomeClass(T[] array) {
        this.array = array;
    }

    public void swapItems (T[] array, int firstIndex, int secondIndex) {
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public ArrayList getArrayList(T[] array) {
        ArrayList<T> arrayList = new ArrayList<T>();
        for (int i = 0; i <array.length ; i++) {
            arrayList.add(i, array[i]);
        }
        return arrayList;
    }
}
