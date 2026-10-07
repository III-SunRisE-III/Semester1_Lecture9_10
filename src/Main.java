public class Main {
    public static void main(String[] args) {
        IntArray arr1 = new IntArray();
        arr1.randomFill();
        IntArray arr2 = arr1.clone();
//        System.out.println(arr1.str() + " " + arr2.str());
        arr1.quickSort();
//        System.out.println(arr1.str() + " " + arr2.str());
    }
}
