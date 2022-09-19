package ee.bcs.java.tasks;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateArray(5)));
        System.out.println(Arrays.toString(decreasingArray(-2)));
        System.out.println(Arrays.toString(yl3(5)));
        System.out.println(Arrays.toString(sampleArray()));
        // TODO siia saab kirjutada koodi testimiseks
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n) {
        int[] array = new int[n];
        int i = 0;
        while(i < array.length) {
            array[i] = i+1;
            i++;
        }
        return array;
    }

    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n) {

        if(n >= 0) {
            int[] array = new int[n+1];
            for(int i =0; i < array.length; i++){
                array[i] = n -i;
            }
            return array;
        }
        else {
            int[] array = new int[-n+1];
            for(int i =0; i < array.length; i++){
                array[i] = n +i;
            }

            return array;



        }

    }

    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n) {
        int[] array = new int[n];
        int i = 0;
        while (i < array.length) {
            array[i] = 3;
            i++;
        }
        return array;
    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() {
        int[] a = new int[5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;
        return a;
    }
}
