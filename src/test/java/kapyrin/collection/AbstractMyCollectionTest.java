package kapyrin.collection;


import java.util.Collection;

abstract class AbstractMyCollectionTest<T> {
    protected CustomCollection<T> collection;

    abstract void setUp();

    abstract CustomCollection<T> createCollectionFromExisting(Collection<T> existingCollection);

    abstract void testAdd();

    abstract void testContains();

    abstract void testDefaultSizeIsZero();

    abstract void testGet();

    abstract void testSize();

    abstract void testClear();

    abstract void testRemoveByIndex();

    abstract void testRemoveByElement();

    abstract void testAddAll();

    abstract void testSet();

    abstract void testBubbleSort();

    abstract void testConstructorWithAnotherCollectionToParameter();
}