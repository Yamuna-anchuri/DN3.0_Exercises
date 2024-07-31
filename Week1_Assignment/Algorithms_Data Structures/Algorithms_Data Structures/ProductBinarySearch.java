import java.util.Arrays; 
 
public class SearchUtil { 
 
    // Binary Search 
    public static Product binarySearch(Product[] products, String searchTerm) { 
        int left = 0; 
        int right = products.length - 1; 
         
        while (left <= right) { 
            int mid = left + (right - left) / 2; 
            int cmp = products[mid].getProductName().compareToIgnoreCase(searchTerm); 
             
            if (cmp == 0) { 
                return products[mid]; // Product found 
            } else if (cmp < 0) { 
                left = mid + 1; // Search in the right half 
            } else { 
                right = mid - 1; // Search in the left half 
            } 
        } 
        return null; // Product not found 
    } 
 
    // Utility method to sort the array before binary search 
    public static void sortProductsByName(Product[] products) { 
        Arrays.sort(products, (a, b) -> 
a.getProductName().compareToIgnoreCase(b.getProductName())); 
    } 
} 