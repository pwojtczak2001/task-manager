package com.taskmanager;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                    --------------------------------------------------
                    MENU
                    1. Show tasks
                    2. Add task
                    3. Delete task
                    4. Mark task as done
                    5. Exit
                    --------------------------------------------------""");
            System.out.println("Your choice (1-5): ");
            while (!scanner.hasNextInt()) {
                System.out.println("It's not Integer! Your choice (1-5): ");
                scanner.nextLine();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (taskManager.getTasksCount() == 0) {
                        System.out.println("\nTask list is empty!\n");
                    }
                    for (int i = 0; i < taskManager.getTasksCount(); i++) {
                        if (taskManager.isTaskCompleted(i+1)) {
                            System.out.println((i + 1) + ". [X] " + taskManager.getTaskDescription(i+1));
                        } else {
                            System.out.println((i + 1) + ". [ ] " + taskManager.getTaskDescription(i+1));
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nWrite description: ");
                    taskManager.addTask(scanner.nextLine());
                    System.out.println("Task added!\n");
                    break;
                case 3:
                    System.out.println("Write task ID to delete: ");
                    taskManager.deleteTask(validId(scanner, taskManager));
                    System.out.println("Task deleted!");
                    break;
                case 4:
                    System.out.println("Write task ID to mark as done: ");
                    if (taskManager.completeTask(validId(scanner, taskManager))) {
                        System.out.println("Task marked as done!");
                    } else {
                        System.out.println("This task is already completed");
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Bad choice, try again!");
                    break;
            }
        }
        while (choice != 5);
    }
    private static int validId(Scanner scanner, TaskManager taskManager) {

        int id;
        while (true) {
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                if (id >= 1 && id <= taskManager.getTasksCount()) {
                    break;
                }
            } else {
                scanner.nextLine();
            }
            if (taskManager.getTasksCount() != 1) {
                System.out.println("It's not Integer or it's out of range! Your choice (1-" + taskManager.getTasksCount() + "): ");
            } else {
                System.out.println("It's not Integer or it's out of range! You have only ID 1. Your choice: ");
            }
        }
        return id;
    }
}