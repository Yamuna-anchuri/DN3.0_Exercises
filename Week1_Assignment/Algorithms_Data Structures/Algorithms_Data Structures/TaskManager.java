public class TaskManager { 
    private class Node { 
        Task task; 
        Node next; 
 
        Node(Task task) { 
            this.task = task; 
            this.next = null; 
        } 
    } 
 
    private Node head; 
 
    // Constructor 
    public TaskManager() { 
        this.head = null; 
    } 
 
    // Method to add a task 
    public void addTask(Task task) { 
        Node newNode = new Node(task); 
        if (head == null) { 
            head = newNode; 
        } else { 
            Node current = head; 
            while (current.next != null) { 
                current = current.next; 
            } 
            current.next = newNode; 
        } 
    } 
 
    // Method to search for a task by ID 
    public Task searchTask(String taskId) { 
        Node current = head; 
        while (current != null) { 
            if (current.task.getTaskId().equals(taskId)) { 
                return current.task; 
            } 
            current = current.next; 
        } 
        return null; // Task not found 
    } 
 
    // Method to traverse and display all tasks 
    public void traverseTasks() { 
        Node current = head; 
        while (current != null) { 
            System.out.println(current.task); 
            current = current.next; 
        } 
    } 
 
    // Method to delete a task by ID 
    public void deleteTask(String taskId) { 
        if (head == null) return; 
 
        if (head.task.getTaskId().equals(taskId)) { 
            head = head.next; 
            return; 
        } 
 
        Node current = head; 
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) { 
            current = current.next; 
        } 
 
        if (current.next != null) { 
            current.next = current.next.next; 
        } 
    } 
}