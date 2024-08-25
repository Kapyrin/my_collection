package kapyrin.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OwnArrayListCollectionTest {
    private OwnArrayListCollection collection;

    @BeforeEach
    public void setUp() {
        collection = new OwnArrayListCollection<Integer>();
    }

    @Test
    void testAdd() {
        collection.add(1);
        collection.add(2);
        collection.add(3);

        assertTrue(collection.contains(1));
        assertTrue(collection.contains(2));
        assertTrue(collection.contains(3));
        assertFalse(collection.contains(4));
    }

    @Test
    void testContains() {
        assertFalse(collection.contains(45));

        collection.add(25);
        collection.add(35);
        collection.add(45);
        collection.add(415);


        assertTrue(collection.contains(45));
        assertFalse(collection.contains(60));
    }

    @Test
    void testDefaultSizeIsSixteen() {
        assertEquals(0, collection.size());
    }

    @Test
    void testGet() {
        collection.add(1);
        collection.add(2);

        assertEquals(1, collection.get(0));
        assertEquals(2, collection.get(1));
    }

    @Test
    void testSize() {
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);

        assertEquals(5, collection.size());
    }

    @Test
    void testClear() {
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);

        collection.clear();

        assertEquals(0, collection.size());
        assertFalse(collection.contains(1));
        assertFalse(collection.contains(2));
        assertFalse(collection.contains(3));
        assertFalse(collection.contains(4));
        assertFalse(collection.contains(5));
    }

    @Test
    void testRemoveByIndex() {
        collection.add(10);
        collection.add(20);
        collection.add(30);

        assertTrue(collection.removeByIndex(1));

        assertFalse(collection.contains(20));
        assertEquals(2, collection.size());
        assertTrue(collection.contains(30));
        assertTrue(collection.contains(10));
    }

    @Test
    void testRemoveByElement() {
        collection.add(10);
        collection.add(20);
        collection.add(30);

        assertTrue(collection.contains(30));

        assertTrue(collection.removeByValue(30));

        assertFalse(collection.contains(30));
    }

    @Test
    void testAddAll() {
        collection.addAll(5, 10, 15, 20);
        assertEquals(4, collection.size());

        assertTrue(collection.contains(5));
        assertTrue(collection.contains(10));
        assertTrue(collection.contains(15));
        assertTrue(collection.contains(20));
    }

    @Test
    void testSet() {
        collection.add(10);
        collection.add(20);
        collection.add(30);

        collection.set(0, 15);

        assertEquals(15, collection.get(0));
        assertEquals(20, collection.get(1));
        assertEquals(30, collection.get(2));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            collection.set(4, 15);
        });
    }


    @Test
    void testBubbleSort() {
        collection.add(1);
        collection.add(-2);
        collection.add(3);
        collection.add(-4);
        collection.add(5);

        CustomCollection.bubbleSort(collection);

        assertEquals(-4, collection.get(0));
        assertEquals(-2, collection.get(1));
        assertEquals(1, collection.get(2));
        assertEquals(3, collection.get(3));
        assertEquals(5, collection.get(4));
        assertNotEquals(1, collection.get(0));
        assertNotEquals(5, collection.get(1));
        assertNotEquals(3, collection.get(2));
        assertNotEquals(-4, collection.get(3));
    }

    @Test
    void testConstructorWithAnotherCollectionToParameter() {
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);

        OwnArrayListCollection<Integer> testCollection = new OwnArrayListCollection<>(list);

        assertEquals(3, testCollection.size());
        assertTrue(testCollection.contains(100));
        assertTrue(testCollection.contains(200));
        assertTrue(testCollection.contains(300));
        assertFalse(testCollection.contains(400));
    }
}