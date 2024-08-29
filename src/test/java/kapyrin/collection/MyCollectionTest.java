package kapyrin.collection;


import java.util.Collection;

 interface MyCollectionTest<T> {
    void setUp();

    CustomCollection<T> createCollectionFromExisting(Collection<T> existingCollection);

    void testAdd();

    void testContains();

    void testDefaultSizeIsZero();

    void testGet();

    void testSize();

    void testClear();

    void testRemoveByIndex();

    void testRemoveByElement();

    void testAddAll();

    void testSet();

    void testBubbleSort();

    void testConstructorWithAnotherCollectionToParameter();
}