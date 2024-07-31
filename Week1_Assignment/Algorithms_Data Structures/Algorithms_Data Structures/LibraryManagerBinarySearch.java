public class LibraryManager { 
 
    // Method to perform binary search 
    public Book binarySearchByTitle(List<Book> books, String title) { 
        int low = 0; 
        int high = books.size() - 1; 
 
        while (low <= high) { 
            int mid = low + (high - low) / 2; 
            Book midBook = books.get(mid); 
 
            int comparison = midBook.getTitle().compareToIgnoreCase(title); 
            if (comparison == 0) { 
                return midBook; 
            } else if (comparison < 0) { 
                low = mid + 1; 
            } else { 
                high = mid - 1; 
            } 
        } 
        return null; // Book not found 
    } 
}