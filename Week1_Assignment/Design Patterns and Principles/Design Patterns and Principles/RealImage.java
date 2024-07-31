public class RealImage implements Image { 
    private String imageUrl; 
 
    public RealImage(String imageUrl) { 
        this.imageUrl = imageUrl; 
        loadImageFromServer(); 
    } 
 
    private void loadImageFromServer() { 
        System.out.println("Loading image from " + imageUrl); 
        // Simulate a delay for loading image 
        try { 
            Thread.sleep(2000); // Simulates the delay in loading from a remote server 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
    } 
 
    @Override 
    public void display() { 
        System.out.println("Displaying image from " + imageUrl); 
    } 
}