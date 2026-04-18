package LLD.OrderManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class OrderManagementSystem {
    static Map<Integer, ShoppingCart> userCart = new HashMap<>();

    public static ShoppingCart getShoppingCart(int userId){
        return userCart.computeIfAbsent(userId, id-> new ShoppingCart(userId));
    }

    public static void main(String[] args) {
        ShoppingCart scart = getShoppingCart(101);
        scart.addItemToCart(1, 3);
        scart.addItemToCart(2, 5);
        scart.addItemToCart(3, 4);

        System.out.println("total amount " + scart.checkout());
    }



}
