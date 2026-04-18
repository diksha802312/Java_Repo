package LLD.OrderManagementPart2;

import java.util.*;

public class OrderManagement implements IOrderManagement {
    List<Order> orders = new ArrayList<Order>();
    Map<String, Integer> cart = new HashMap<String, Integer>();

    @Override
    public void addOrder(String itemName, Order order){
        orders.add(order);
    }

    @Override
    public void removeOrder(String itemName){
        orders.removeIf(order -> order.getName().equals(itemName));
    }

    @Override
    public int calculateTotalDiscountedPrice(){
        int price = 0;
        for(Order order : orders){
            DiscountCategory category = DiscountCategory.getCategory(order.getPrice());
            int discount = category.getDiscount();
            price += Math.round(order.getPrice() - (order.getPrice()*discount)/100);
        }
        return price;
    }

    public List<String> getCategoryDiscounts(){
        return Arrays.asList("CHEAP : 10%", "MODERATE : 20%", "EXPENSIVE : 30%");
    }

    public void countDuplicateOrders(){
        cart.clear();
        for(Order order : orders){
            cart.put(order.getName(), cart.getOrDefault(order.getName(), 0) + 1);
        }
    }

    @Override
    public Map<String, Integer> showCart(){
        return cart;
    }
}
