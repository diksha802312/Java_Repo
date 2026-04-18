package LLD.CategoryCoupon;

import java.util.Date;

public class Coupon {
    public String categoryName;
    public String couponName;
    public Date dateModified;
    public double discount;
    public DiscountType discountType;

    public Coupon(String categoryName, String couponName, Date dateModified, double discount, DiscountType discountType) {
        this.categoryName = categoryName;
        this.couponName = couponName;
        this.dateModified = dateModified;
        this.discount = discount;
        this.discountType = discountType;
    }
}
