package LLD.EcommerceOrderSystem;

import java.util.HashMap;
import java.util.Map;

public class EcommerceService {
    Map<String, Item> itemMap = new HashMap<>();

    public void addItem(Item item){
        itemMap.put(item.name, item);
    }

    public void removeItem(String name){
        itemMap.remove(name);
    }

    public double getTotalPrice(){
        double totalPrice = 0.0;
        for(Item item : itemMap.values()){
            totalPrice += item.getItemPrice();
        }
        return totalPrice;
    }

    public double getTotalDiscount(){
        double totalDiscountPrice = 0.0;

        for(Item item : itemMap.values()){
            totalDiscountPrice += item.getItemDiscount();
        }
        return totalDiscountPrice;
    }

    public double getTotalPriceWithDiscount(){
        double totalDiscountPrice = 0.0;
        return getTotalPrice() - getTotalDiscount();
    }
}
