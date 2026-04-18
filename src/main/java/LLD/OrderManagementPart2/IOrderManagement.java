package LLD.OrderManagementPart2;

import java.util.List;
import java.util.Map;

public interface IOrderManagement {
    void addOrder(String itemName, Order order);
    void removeOrder(String itemName);
    int calculateTotalDiscountedPrice();
    List<String> getCategoryDiscounts();
    void countDuplicateOrders();
    Map<String, Integer> showCart();
}
