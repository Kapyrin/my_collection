package kapyrin;

import kapyrin.collection.OwnArrayListCollection;


public class Main {
    public static void main(String[] args) {
        OwnArrayListCollection<String> collection = new OwnArrayListCollection<>();
        collection.add("A");
        collection.add("B");
        collection.add("C");
        System.out.println(collection);

        //JUnit tests there are in test folder;
    }
}