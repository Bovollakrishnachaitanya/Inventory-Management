package com.example;

import java.util.Scanner;

public class InventoryManager {
    private static Inventory inventory = new Inventory();
    private static Scanner scanner = new Scanner(System.in);

    public static void run() {
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    viewAllProducts();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== Inventory Management System ===");
        System.out.println("1. Add Product");
        System.out.println("2. Delete Product");
        System.out.println("3. View All Products");
        System.out.println("4. Search for a Product");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        Product product = new Product(id, name, quantity, price);
        inventory.addProduct(product);
        System.out.println("Product added successfully!");
    }

    private static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = scanner.nextInt();
        if (inventory.deleteProduct(id)) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void viewAllProducts() {
        System.out.println("\nCurrent Inventory:");
        if (inventory.getAllProducts().isEmpty()) {
            System.out.println("No products in the inventory.");
        } else {
            for (Product product : inventory.getAllProducts()) {
                System.out.println(product);
            }
        }
    }

    private static void searchProduct() {
        System.out.print("Enter product name to search: ");
        String name = scanner.nextLine();
        Product product = inventory.searchProduct(name);
        if (product != null) {
            System.out.println("Product found: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }
}
