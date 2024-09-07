package HomeWork3;

public class Pair <T, K>{
    private T key;
    private K value;

    public Pair(T key, K second) {
        this.key = key;
        this.value = second;
    }

    public T getFirst() {
        return key;
    }

    public K getSecond() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + key + ":" + value + ")";
    }
    
}
