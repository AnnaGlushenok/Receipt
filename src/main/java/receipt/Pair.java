package receipt;

public class Pair<T1, T2> {
    private final T1 first;
    private final T2 second;

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public Pair(T1 firstValue, T2 secondValue) {
        this.first = firstValue;
        this.second = secondValue;
    }
}
