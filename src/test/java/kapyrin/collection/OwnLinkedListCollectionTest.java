package kapyrin.collection;

import org.junit.jupiter.api.BeforeEach;

import java.util.Collection;


class OwnLinkedListCollectionTest extends AbstractIntegerMyCollectionTest {

    @Override
    @BeforeEach
    public void setUp() {
        collection = new OwnLinkedListCollection<Integer>();
    }

    @Override
    protected CustomCollection<Integer> createCollectionFromExisting(Collection<Integer> existingCollection) {
        return new OwnLinkedListCollection<>(existingCollection);
    }
}