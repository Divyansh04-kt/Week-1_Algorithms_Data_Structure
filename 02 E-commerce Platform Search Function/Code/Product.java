package com.ecommerce.platform;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class ProductSearch {

    // Linear search method
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    // Binary search method
    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].getProductId() == productId) {
                return products[mid];
            }

            if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for number of products
        System.out.print("Enter the number of products: ");
        int numberOfProducts = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product[] products = new Product[numberOfProducts];

        // User input for product details
        for (int i = 0; i < numberOfProducts; i++) {
            System.out.print("Enter product ID for product " + (i + 1) + ": ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter product name for product " + (i + 1) + ": ");
            String productName = scanner.nextLine();

            System.out.print("Enter category for product " + (i + 1) + ": ");
            String category = scanner.nextLine();

            products[i] = new Product(productId, productName, category);
        }

        // Sort the products array for binary search
        Arrays.sort(products, new Comparator<Product>() {
            public int compare(Product a, Product b) {
                return Integer.compare(a.getProductId(), b.getProductId());
            }
        });

        // User input for productId to search
        System.out.print("Enter the product ID to search: ");
        int searchId = scanner.nextInt();

        // Linear Search
        Product foundProductLinear = linearSearch(products, searchId);
        if (foundProductLinear != null) {
            System.out.println("Product found using Linear Search: " + foundProductLinear);
        } else {
            System.out.println("Product not found using Linear Search.");
        }

        // Binary Search
        Product foundProductBinary = binarySearch(products, searchId);
        if (foundProductBinary != null) {
            System.out.println("Product found using Binary Search: " + foundProductBinary);
        } else {
            System.out.println("Product not found using Binary Search.");
        }

        scanner.close();
    }
}
