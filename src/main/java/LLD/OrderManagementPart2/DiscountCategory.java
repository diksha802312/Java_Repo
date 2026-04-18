package LLD.OrderManagementPart2;

public enum DiscountCategory {
    CHEAP(10),
    MODERATE(20),
    EXPENSIVE(30);

    private final int discount;

    DiscountCategory(int discount){
        this.discount = discount;
    }

    public int getDiscount(){
        return discount;
    }

    public static DiscountCategory getCategory(double price){
        if(price < 10) return CHEAP;
        if(price <=20) return MODERATE;
        else return EXPENSIVE;
    }


}
