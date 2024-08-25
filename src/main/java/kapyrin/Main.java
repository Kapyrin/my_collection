package kapyrin;

import kapyrin.collection.OwnArrayListCollection;
import kapyrin.collection.OwnLinkedListCollection;


public class Main {
    public static void main(String[] args) {
        OwnArrayListCollection<String> stringCollection = new OwnArrayListCollection<>();
        stringCollection.add("A");
        stringCollection.add("B");
        stringCollection.add("C");

        System.out.println(stringCollection);

        OwnLinkedListCollection<Double> doubleCollection = new OwnLinkedListCollection<>();
        doubleCollection.add(1.0);
        doubleCollection.add(2.0);
        doubleCollection.add(3.0);

        System.out.println(doubleCollection);

        //JUnit tests there are in test folder;
    }
}