package com.Basics.TaskTracker;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final TaskDAO dao = new TaskDAO();

    public static void main(String[] args) {
        System.out.println("=== TASK TRACKER ===");

        while (true) {
            printMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> addTask();
                case "2" -> viewTasks();
                case "3" -> markCompleted();
                case "4" -> deleteTask();
                case "0" -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Mark Task Completed");
        System.out.println("4. Delete Task");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine().trim();
        dao.addTask(new Task(title));
    }

    private static void viewTasks() {
        List<Task> tasks = dao.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        tasks.forEach(System.out::println);
    }

    private static void markCompleted() {
        System.out.print("Enter task ID to mark completed: ");
        int id = Integer.parseInt(sc.nextLine());
        dao.markCompleted(id);
    }

    private static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        dao.deleteTask(id);
    }
}
