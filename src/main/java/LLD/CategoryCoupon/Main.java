package LLD.CategoryCoupon;

import java.text.SimpleDateFormat;
import java.util.*;

import static LLD.CategoryCoupon.CouponService.*;

public class Main {

    public static void main(String[] args) throws Exception {

        List<String[]> coupons = List.of(

                new String[]{"CategoryName:Comforter Sets","CouponName:Comforters Sale","DateModified:2020-01-01","Discount:10%"},
                new String[]{"CategoryName:Comforter Sets","CouponName:Cozy Comforter Coupon","DateModified:2020-01-01","Discount:$15"},
                new String[]{"CategoryName:Bedding","CouponName:Best Bedding Bargains","DateModified:2019-01-01","Discount:35%"},
                new String[]{"CategoryName:Bedding","CouponName:Savings on Bedding","DateModified:2019-01-01","Discount:25%"},
                new String[]{"CategoryName:Bed & Bath","CouponName:Low price for Bed & Bath","DateModified:2018-01-01","Discount:50%"},
                new String[]{"CategoryName:Bed & Bath","CouponName:Bed & Bath extravaganza","DateModified:2019-01-01","Discount:75%"}
        );

        List<String[]> categories = List.of(

                new String[]{"CategoryName:Comforter Sets","CategoryParentName:Bedding"},
                new String[]{"CategoryName:Bedding","CategoryParentName:Bed & Bath"},
                new String[]{"CategoryName:Bed & Bath","CategoryParentName:None"},
                new String[]{"CategoryName:Soap Dispensers","CategoryParentName:Bathroom Accessories"},
                new String[]{"CategoryName:Bathroom Accessories","CategoryParentName:Bed & Bath"},
                new String[]{"CategoryName:Toy Organizers","CategoryParentName:Baby And Kids"},
                new String[]{"CategoryName:Baby And Kids","CategoryParentName:None"}
        );

        List<String[]> products = List.of(

                new String[]{"ProductName:Cozy Comforter Sets","Price:100.00","CategoryName:Comforter Sets"},
                new String[]{"ProductName:All-in-one Bedding Set","Price:50.00","CategoryName:Bedding"},
                new String[]{"ProductName:Infinite Soap Dispenser","Price:500.00","CategoryName:Bathroom Accessories"},
                new String[]{"ProductName:Rainbow Toy Box","Price:257.00","CategoryName:Baby And Kids"}
        );

        categoryToCouponsMap = new HashMap<>();
        categoryToParentMap = new HashMap<>();
        categoryToLatestCouponsMap = new HashMap<>();
        productMap = new HashMap<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        /* BUILD COUPON MAP */
        for(String[] str : coupons){

            String category = parse(str[0]);
            String couponName = parse(str[1]);
            String dateModified = parse(str[2]);
            String discount = parse(str[3]);

            DiscountType discountType =
                    discount.startsWith("$")
                            ? DiscountType.ABSOLUTE
                            : DiscountType.PERCENTAGE;

            double totalDiscount =
                    Double.parseDouble(
                            discount.replace("%","")
                                    .replace("$","")
                    );

            categoryToCouponsMap
                    .computeIfAbsent(category,
                            k -> new ArrayList<>())
                    .add(new Coupon(
                            couponName,
                            category,
                            format.parse(dateModified),
                            totalDiscount,
                            discountType
                    ));
        }

        /* BUILD CATEGORY HIERARCHY */
        for(String[] str : categories){

            categoryToParentMap.put(
                    parse(str[0]),
                    parse(str[1])
            );
        }

        /* BUILD LATEST COUPON CACHE */
        for(String category : categoryToCouponsMap.keySet()){
            CouponService.getLatestCoupons(category);
        }

        /* RESOLVE INHERITED COUPONS */
        for(String category : categoryToParentMap.keySet()){

            if(categoryToLatestCouponsMap.containsKey(category))
                continue;

            String parent = findParent(category);

            if(!parent.equals("None")){

                categoryToLatestCouponsMap.put(
                        category,
                        categoryToLatestCouponsMap
                                .getOrDefault(parent, List.of())
                );
            }
        }

        /* BUILD PRODUCTS */
        for(String[] product : products){

            String productName = parse(product[0]);

            double price =
                    Double.parseDouble(
                            parse(product[1])
                    );

            String category =
                    parse(product[2]);

            productMap.put(
                    productName,
                    new Product(
                            productName,
                            price,
                            category
                    )
            );
        }

        /* TEST */

        System.out.print("Cozy Comforter Sets => ");
        getDiscountedPrice("Cozy Comforter Sets")
                .forEach(p -> System.out.print(p+" , "));
        System.out.println();

        System.out.print("All-in-one Bedding Set => ");
        getDiscountedPrice("All-in-one Bedding Set")
                .forEach(p -> System.out.print(p+" , "));
        System.out.println();

        System.out.print("Infinite Soap Dispenser => ");
        getDiscountedPrice("Infinite Soap Dispenser")
                .forEach(p -> System.out.print(p+" , "));
        System.out.println();

        System.out.print("Rainbow Toy Box => ");
        getDiscountedPrice("Rainbow Toy Box")
                .forEach(p -> System.out.print(p+" , "));
    }
}