package LLD.EcommerceOrderSystem;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item(1, "iron", 10.0, 2, CategoryDiscount.ELECTRONICS);
        Item item2 = new Item(2, "top", 20.0, 3, CategoryDiscount.FASHION);
        Item item3 = new Item(3, "apple", 30.0, 2, CategoryDiscount.GROCERY);
        Item item4 = new Item(4, "clip", 5.0, 2, CategoryDiscount.OTHERS);

        EcommerceService service = new EcommerceService();

        service.addItem(item1);
        service.addItem(item2);
        service.addItem(item3);
        service.addItem(item4);
        System.out.println(service.getTotalPrice());
        System.out.println(service.getTotalPriceWithDiscount());


        service.removeItem("clip");
        System.out.println(service.getTotalPrice());
        System.out.println(service.getTotalPriceWithDiscount());
    }
}
