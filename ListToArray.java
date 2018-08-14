package lesson1.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListToArray {
    public static void main(String[] args) {

        Integer[] a = {1,2,3,4,5,6};
        String[] b = {"abc", "ghfjk", "gjgnhn", "d2", "ey"};
        ArrayList<Integer> l2 = arrayToList(a);
        ArrayList<String> l1 = arrayToList(b);
        System.out.println(l1);
        System.out.println(l2);

//меняем местами: выводим на консоль список элементов массива
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
//запускаем метод
        swapPlaces(b, 1, 4);
        swapPlaces(a, 0, 2);
//проверка
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static <T> ArrayList<T> arrayToList (T[] arr){
        ArrayList<T> l = new ArrayList<T>();

            for (int i = 0; i < arr.length; i++) {
                l.add(arr[i]);
            }

        return l;
    }

    static <T> T[] swapPlaces(T[] arr, int from, int to){
        Object obj = arr[to];
        arr[to] = arr[from];
        arr[from] = (T) obj;

        return arr;
    }

}
