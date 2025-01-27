package week4;

import java.util.ArrayList;

public class LibraryService {
    private ArrayList<String> books = new ArrayList<>();

    public void addBook(String title) {
        books.add(title);
    }

    public boolean searchBook(String title) {
        return books.contains(title);
    }
}
