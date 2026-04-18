package LLD.HotelManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderBill {
    List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(int id) {
        orders.removeIf(order -> order.getOrderId() == id);
    }

    public double getDiscountedPrice(double price) {
        if (price < 40) {
            return price-20;
        } else if (price < 100)
            return price - price * 0.2;
        else
            return price - price * 0.15;
    }

//    public double getDiscount(double price){
//        if(price < 40)
//
//    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Order order : orders) {
            totalPrice += getDiscountedPrice(order.getPrice());
        }
        return totalPrice;

}
}
