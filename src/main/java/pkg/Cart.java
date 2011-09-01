package pkg;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class Cart {

    private ArrayList<String> contents = new ArrayList<String>();

    public void addTo(String item) {
        contents.add(item);
    }

//    // TODO
//    public void removeFrom(String item) {
//    }

    public int size() {
        return contents.size();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "contents=" + asList(contents) +
                '}';
    }
}
