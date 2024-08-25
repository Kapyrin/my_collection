package kapyrin.collection;

import java.util.Collection;

public interface CustomCollection<T> {

    void add(T element);

    boolean contains(T element);

    T get(int index);

    int size();

    void clear();

    boolean removeByIndex(int index);

    boolean removeByValue(T element);

    void addAll(T... elements);

    void addAll(Collection<? extends T> elements);
    void set(int index, T element);


    static <T extends Comparable<? super T>> void bubbleSort(CustomCollection<T> collection) {
        boolean swapped;
        int n = collection.size();
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (collection.get(i).compareTo(collection.get(i + 1)) > 0) {
                    T temp = collection.get(i);
                    collection.set(i, collection.get(i + 1));
                    collection.set(i + 1, temp);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }



}