package kapyrin;

import kapyrin.collection.OwnCollection;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        OwnCollection<String> collection = new OwnCollection<>();
        collection.add("A");
        collection.add("B");
        collection.add("C");
        System.out.println(collection);

        //JUnit tests there are in test folder;
    }
}