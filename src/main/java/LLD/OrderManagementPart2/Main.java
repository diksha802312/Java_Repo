package LLD.OrderManagementPart2;

public class Main {
    public static void main(String[] args) {
        IOrderManagement system = new OrderManagement();

        // Sample Input
        system.addOrder("Order-1", new Order("Order-1", 49));
        system.addOrder("Order-2", new Order("Order-2", 30));
        system.addOrder("Order-3", new Order("Order-3", 15));
        system.addOrder("Order-4", new Order("Order-4", 7));
        system.addOrder("Order-1", new Order("Order-1", 49)); // Duplicate item

        // Count duplicate items
        system.countDuplicateOrders();

        // Output
        System.out.println("Cart Contents: " + system.showCart());
        System.out.println("Discounted Price: $" + system.calculateTotalDiscountedPrice());

        // Get category discounts
        System.out.println("Category Discounts: " + system.getCategoryDiscounts());

        // Removing an order
        system.removeOrder("Order-2");
        system.countDuplicateOrders(); // Recalculate duplicates

        System.out.println("Cart contents after removal: " + system.showCart());
        System.out.println("Discounted Price after removal: $" + system.calculateTotalDiscountedPrice());
    }
    }

