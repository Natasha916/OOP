package week1;

public class  Book {
    String title;
    String author;
    int year;
    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nYear: " + year;
    }

    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);

        System.out.println(book1);
        System.out.println();  
        System.out.println(book2);
    }
}