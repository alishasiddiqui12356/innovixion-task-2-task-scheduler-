import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    private String title;
    private String dueDate;
    private int priority;

    public Task(String title, String dueDate, int priority) {
        this.title = title;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }
}

public class TaskScheduler {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Scheduler Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    System.out.println("Exiting Task Scheduler. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task title: ");
        String title = scanner.next();

        System.out.print("Enter due date: ");
        String dueDate = scanner.next();

        System.out.print("Enter priority (1 for low, 2 for medium, 3 for high): ");
        int priority = scanner.nextInt();

        Task newTask = new Task(title, dueDate, priority);
        tasks.add(newTask);

        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            // Sort tasks based on due date and priority
            Collections.sort(tasks, Comparator.comparing(Task::getDueDate).thenComparing(Task::getPriority));

            System.out.println("\nTask List:");
            for (Task task : tasks) {
                System.out.println("Title: " + task.getTitle());
                System.out.println("Due Date: " + task.getDueDate());
                System.out.println("Priority: " + task.getPriority());
                System.out.println("---------------");
            }
        }
    }
}
