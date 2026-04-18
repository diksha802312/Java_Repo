package LLD.EcommerceOrderSystem;

public class Item {
    public int id;
    public String name;
    public double price;
    public int quantity;
    public CategoryDiscount category;


   public Item(int id, String name, double price, int quantity, CategoryDiscount category) {
       this.id = id;
       this.name = name;
       this.price = price;
       this.quantity = quantity;
       this.category = category;
   }

   public double getItemDiscount(){
        return price * quantity * category.getDiscount();
   }

   public double getItemPrice(){
       return price * quantity;
   }

   public void increaseQuantity(int qty){
       quantity += qty;
   }

   public void decreaseQuantity(int qty){
       quantity -= qty;
   }


}
