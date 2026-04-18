package LLD.EcommerceOrderSystem;

public enum CategoryDiscount {
    ELECTRONICS(0.1),
    FASHION(0.2),
    GROCERY(0.05),
    OTHERS(0);

    public double discount;

    CategoryDiscount(double discount){
        this.discount = discount;
    }

    public double getDiscount(){
        return discount;
    }
}
