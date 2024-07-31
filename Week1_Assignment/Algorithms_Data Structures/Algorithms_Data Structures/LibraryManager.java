import java.util.List; 
 
public class LibraryManager { 
 
    // Method to perform linear search 
    public Book linearSearchByTitle(List<Book> books, String title) { 
        for (Book book : books) { 
            if (book.getTitle().equalsIgnoreCase(title)) { 
                return book; 
            } 
        } 
        return null; // Book not found 
    } 
}