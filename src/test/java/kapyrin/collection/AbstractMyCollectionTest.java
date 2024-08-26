package kapyrin.collection;


abstract class AbstractMyCollectionTest<T> {
    protected CustomCollection<T> collection;

    abstract void setUp();  // Абстрактный метод для инициализации коллекции

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