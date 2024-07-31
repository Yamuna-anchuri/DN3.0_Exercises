public class TestProxyPattern { 
    public static void main(String[] args) { 
        Image image1 = new ProxyImage("http://example.com/image1.jpg"); 
        Image image2 = new ProxyImage("http://example.com/image2.jpg"); 
 
        // Display images 
        System.out.println("First call to display image1:"); 
        image1.display();  // Loads the image from the server and then displays it 
        System.out.println("Second call to display image1:"); 
        image1.display();  // Displays the image from cache 
 
        System.out.println("First call to display image2:"); 
        image2.display();  // Loads the image from the server and then displays it 
        System.out.println("Second call to display image2:"); 
        image2.display();  // Displays the image from cache 
    } 
} 
