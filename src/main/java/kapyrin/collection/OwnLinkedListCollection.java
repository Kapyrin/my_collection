package kapyrin.collection;

import java.util.Collection;

public class OwnLinkedListCollection<T> implements CustomCollection<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public boolean contains(T element) {
        Node<T> current = head;
        while (current != null) {
            if (element == null ? current.data == null : current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public T get(int index) {
        checkValidIndex(index);
        return getNode(index).data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean removeByIndex(int index) {
        checkValidIndex(index);
        Node<T> nodeToRemove = getNode(index);

        if (nodeToRemove.prev != null) {
            nodeToRemove.prev.next = nodeToRemove.next;
        } else {
            head = nodeToRemove.next;
        }

        if (nodeToRemove.next != null) {
            nodeToRemove.next.prev = nodeToRemove.prev;
        } else {
            tail = nodeToRemove.prev;
        }

        size--;
        return true;
    }

    @Override
    public boolean removeByValue(T element) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (element == null ? current.data == null : current.data.equals(element)) {
                return removeByIndex(index);
            }
            current = current.next;
            index++;
        }
        return false;
    }

    @Override
    public void addAll(T... elements) {
        for (T element : elements) {
            add(element);
        }
    }

    @Override
    public void addAll(Collection<? extends T> elements) {
        for (T element : elements) {
            add(element);
        }
    }

    @Override
    public void set(int index, T element) {
        checkValidIndex(index);
        getNode(index).data = element;
    }

    private Node<T> getNode(int index) {
        Node<T> current;

        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    private void checkValidIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        return sb.toString();
    }
}
