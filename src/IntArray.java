import java.util.Arrays;
import java.util.Random;

public class IntArray {
    private final Random r = new Random();
    private final int[] arr;  // поле класса IntArray
    // final в этом случае означает, что адрес arr более не поменяется,
    // но элементы можно менять сколько и как угодно
    // final оптимизирует работу программы

    public IntArray() {     // конструктор класса без параметра - для инициализации класса
        arr = new int[r.nextInt(5, 11)];
    }
    public IntArray(int size) {    // конструктор класса с параметром
        arr = new int[size];
    }
    public IntArray(int[] arr) {    // конструктор класса с параметром
        this.arr = arr.clone();
    }

    public void randomFill() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(-100, 101);
        }
    }

    public IntArray clone() {
        int[] arrClone = new int[arr.length];
        return new IntArray(arrClone);
    }

    public String toString() {
        return Arrays.toString(arr);
    }

    public int[] toArray() {
        int[] array = new int[arr.length];
        System.arraycopy(arr, 0, array, 0, arr.length);
        return array;
    }

    public boolean isSorted() {
        for (int i = 0; i < (arr.length - 1); i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private int partition(int[] arr, int min, int max) {
        int pivotIndex = (min + max) / 2;
        int pivot = arr[pivotIndex];
        int i = min - 1, j = max + 1;
        while (true) {
            while (arr[++i] < pivot);
            while (arr[--j] > pivot);
            if (i >= j) return pivotIndex;
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            if (i == pivotIndex) pivotIndex = j++;
            else if (j == pivotIndex) pivotIndex = i--;
        }
    }
    private void quickSort(int[] arr, int min, int max) {
        int p = partition(arr, min, max);
        if (min < (p - 1)) quickSort(arr, min, p - 1);
        if (max > (p + 1)) quickSort(arr, p + 1, max);
    }
    public void quickSort() {   // перегруженная функция
        quickSort(arr, 0, arr.length - 1);
    }

    public void bubbleSort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
        }
    }

    public void sortMin() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
