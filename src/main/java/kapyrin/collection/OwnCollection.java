package kapyrin.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

public class OwnCollection<T> {
    private T[] partsOfCollection;
    private int size;
    private static final int INITIAL_CAPACITY = 16;

    public OwnCollection() {
        this.partsOfCollection = (T[]) new Comparable[INITIAL_CAPACITY];
        size = 0;
    }

    public OwnCollection(int size) {
        this.partsOfCollection = (T[]) new Comparable[size];
        this.size = 0;
    }


    public OwnCollection(Collection<? extends T> collection) {
        this.partsOfCollection = (T[]) new Comparable[collection.size()];
        this.size = 0;
        addAll(collection);
    }

    public void add(T element) {
        increaseCapacity();
        partsOfCollection[size++] = element;
    }

    public boolean contains(T element) {
        return IntStream.range(0, size)
                .anyMatch(i -> element.equals(partsOfCollection[i]));
    }


    public T get(int index) {
        checkValidIndex(index);
        return partsOfCollection[index];
    }

    public int size() {
        return size;
    }

    public void clear() {
        this.partsOfCollection = (T[]) new Comparable[INITIAL_CAPACITY];
        this.size = 0;
    }

    public boolean removeByIndex(int index) {
        if (checkValidIndex(index)) {
            int movedIndex = size - index - 1;

            if (movedIndex > 0) {
                System.arraycopy(partsOfCollection, index + 1, partsOfCollection, index, movedIndex);
            }
            partsOfCollection[--size] = null;
            return true;
        }
        return false;
    }

    public boolean removeByValue(T element) {
        int[] removeIndexes = returnIndex(element);

        if (removeIndexes.length == 0) return false;

        for (int i = removeIndexes.length - 1; i >= 0; i--) {
            removeByIndex(removeIndexes[i]);
        }

        return true;

    }

    public void addAll(T... elements) {
        for (T element : elements) {
            add(element);
        }
    }

    private int[] returnIndex(T element) {
        int[] indexes = IntStream.range(0, size)
                .filter(index -> partsOfCollection[index].equals(element))
                .toArray();

        if (indexes.length == 0) {
            throw new IndexOutOfBoundsException("No such element");
        }
        return indexes;
    }


    public static <T extends Comparable<? super T>> void bubbleSort(OwnCollection<T> collection) {
        boolean swapped;
        for (int i = 0; i < collection.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < collection.size() - i - 1; j++) {
                if (collection.get(j).compareTo(collection.get(j + 1)) > 0) {
                    T temp = collection.get(j);
                    collection.partsOfCollection[j] = collection.get(j + 1);
                    collection.partsOfCollection[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    private void increaseCapacity() {
        if (size >= partsOfCollection.length * 0.8) {
            int newSize = partsOfCollection.length * 2;
            partsOfCollection = Arrays.copyOf(partsOfCollection, newSize);
        }
    }

    public void addAll(Collection<? extends T> elements) {
        increaseCapacity();
        for (T element : elements) {
            add(element);
        }
    }

    private boolean checkValidIndex(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(partsOfCollection[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}