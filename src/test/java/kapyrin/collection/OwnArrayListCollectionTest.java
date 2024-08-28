package kapyrin.collection;

import org.junit.jupiter.api.BeforeEach;

import java.util.Collection;

class OwnArrayListCollectionTest extends AbstractIntegerMyCollectionTest {

    @Override
    @BeforeEach
    public void setUp() {
        collection = new OwnArrayListCollection<>();
    }

    @Override
    protected CustomCollection<Integer> createCollectionFromExisting(Collection<Integer> existingCollection) {
        return new OwnArrayListCollection<>(existingCollection);
    }
}