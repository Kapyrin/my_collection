package kapyrin.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class AbstractMyCollectionTest<T> {
    protected CustomCollection<T> collection;

    @BeforeEach
    public abstract void setUp();

    
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