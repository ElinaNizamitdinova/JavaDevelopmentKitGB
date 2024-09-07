package HomeWork3;

public class Task2 {
    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5};
        Integer[] array2 = {1, 2, 3, 4, 5};
        System.out.println(compareArrays(array1, array2));

    }
    public static <T> boolean compareArrays(T[] arrA, T[] arrB) {
        if (arrA.length != arrB.length) {
            return false;
        }
        for (int i = 0; i < arrA.length; i++) {
            if (!arrA[i].getClass().equals(arrB[i].getClass())) {
                return false;
            }
        }

        return true;
    }
}
