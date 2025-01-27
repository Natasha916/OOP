package week4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LibraryServiceTest {

    @Test
    public void testAddAndSearchBook() {
        LibraryService libraryService = new LibraryService(); 
        libraryService.addBook("1984");
        assertTrue(libraryService.searchBook("1984"), "The book '1984' should be found.");
    }

    @Test
    public void testSearchBookNotFound() {
        LibraryService libraryService = new LibraryService();
        assertFalse(libraryService.searchBook("Moby Dick"), "The book 'Moby Dick' should not be found.");
    }

    @Test
    public void testAddMultipleBooksAndSearch() {
        LibraryService libraryService = new LibraryService(); 
        libraryService.addBook("The Great Gatsby");
        libraryService.addBook("To Kill a Mockingbird");
        assertTrue(libraryService.searchBook("The Great Gatsby"), "The book 'The Great Gatsby' should be found.");
        assertTrue(libraryService.searchBook("To Kill a Mockingbird"), "The book 'To Kill a Mockingbird' should be found.");
    }
}
