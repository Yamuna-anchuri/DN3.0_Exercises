public class TestBuilderPattern { 
    public static void main(String[] args) { 
        // Create a Computer object using the Builder pattern 
        Computer computer1 = new Computer.Builder("Intel i7", "16GB", "1TB") 
                .setGraphicsCardEnabled(true) 
                .setBluetoothEnabled(true) 
                .build(); 
 
        // Create another Computer object with different configuration 
        Computer computer2 = new Computer.Builder("AMD Ryzen 5", "8GB", "512GB") 
                .setGraphicsCardEnabled(false) 
                .setBluetoothEnabled(true) 
                .build(); 
 
        // Display the configurations 
        System.out.println("Computer 1: "); 
        System.out.println("CPU: " + computer1.getCPU()); 
        System.out.println("RAM: " + computer1.getRAM()); 
        System.out.println("Storage: " + computer1.getStorage()); 
        System.out.println("Graphics Card Enabled: " + computer1.isGraphicsCardEnabled()); 
        System.out.println("Bluetooth Enabled: " + computer1.isBluetoothEnabled()); 
 
        System.out.println("\nComputer 2: "); 
        System.out.println("CPU: " + computer2.getCPU()); 
        System.out.println("RAM: " + computer2.getRAM()); 
        System.out.println("Storage: " + computer2.getStorage()); 
        System.out.println("Graphics Card Enabled: " + computer2.isGraphicsCardEnabled()); 
        System.out.println("Bluetooth Enabled: " + computer2.isBluetoothEnabled()); 
    } 
}