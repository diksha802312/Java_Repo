package LLD.OrderManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    int userId;
    Map<Integer, Integer> cart; //item, quantity

    public ShoppingCart(int userId){
        this.userId = userId;
        cart = new HashMap<>();
    }

    private final static Map<Integer, Double> prices = new HashMap<>();

    static{
        prices.put(1, 40.0);
        prices.put(2, 30.0);
        prices.put(3, 50.0);
        prices.put(4, 15.0);
    }

    public void addItemToCart(int itemId, int quantity){
        if(quantity <+0){
            throw new IllegalArgumentException("invalid quantity");
        }
        cart.put(itemId, cart.getOrDefault(itemId, 0) + quantity);
    }

    public void removeItemFromCart(int itemId){
        if (!cart.containsKey(itemId)) {
            throw new IllegalArgumentException("invalid itemId");
        }
        int quantity = cart.get(itemId);
        if(quantity>1)
            cart.put(itemId, quantity-1);
        else
            cart.remove(itemId);
    }

    public double calculateTotal(){
        double total = 0.0;
        for(Map.Entry<Integer, Integer> entry : cart.entrySet()){
            int itemId = entry.getKey();
            double price = prices.get(itemId);
            total += entry.getValue() * price;
        }
        if(total > 100)
        {
            total += total*0.5;
        }
        return total;
    }

    public double checkout(){
        if(cart.isEmpty()){
            throw new IllegalStateException("cart is empty");
        }
        double total = calculateTotal();
        total += total*0.1;
        return total;
    }

    public void viewCart(){
        if (cart.isEmpty()) {
            throw new IllegalStateException("cart is empty");
        }

        for(Map.Entry<Integer, Integer> entry : cart.entrySet()){
            System.out.println("Item " + entry.getKey() + " has qauntity " + entry.getValue());
        }
    }
}
