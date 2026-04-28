//package LLD.CategoryCoupon;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class CouponService {
//    public Product product;
//    public Coupon coupon;
//
//    public CouponService(Product product, Coupon coupon) {
//        this.product = product;
//        this.coupon = coupon;
//    }
//
//     public static Map<String,List<Coupon>> categoryToCouponsMap;
//     static Map<String,String> categoryToParentMap;
//     static Map<String,Product> productMap;
//
//    // Latest coupon cache
//     static Map<String,List<Coupon>> categoryToLatestCouponsMap;
//
//    static final String datePattern="yyyy-MM-dd";
//
//
//    static String findParent(String category){
//
//        String parentCategory =
//                categoryToParentMap.get(category);
//
//        if(parentCategory.equals("None")){
//            return "None";
//        }
//
//        if(categoryToCouponsMap
//                .containsKey(parentCategory)){
//
//            return parentCategory;
//        }
//
//        categoryToParentMap.put(
//                category,
//                findParent(parentCategory));
//
//        return categoryToParentMap.get(category);
//    }
//
//
//     static List<Coupon>
//    getCouponDetails(String category){
//
//        if(categoryToCouponsMap.containsKey(category)){
//            return categoryToCouponsMap.get(category);
//        }
//
//        String parentCategory =
//                findParent(category);
//
//        if(parentCategory.equals("None")){
//            return List.of();
//        }
//
//        return categoryToCouponsMap.get(parentCategory);
//    }
//
//
//     static List<Coupon>
//     getLatestCoupons(
//            String category){
//
//        if(categoryToLatestCouponsMap.containsKey(category)){
//            return categoryToLatestCouponsMap.get(category);
//        }
//
//        Date currentDate=new Date();
//
//        List<Coupon> result=new ArrayList<>();
//
//        int i=coupons.size()-1;
//
//        for(;i>=0;i--){
//
//            if(coupons.get(i)
//                    .dateModified
//                    .compareTo(currentDate)>0){
//                continue;
//            }
//            else{
//                break;
//            }
//        }
//
//        if(i<0){
//
//            categoryToLatestCouponsMap.put(
//                    category,result);
//
//            return result;
//        }
//
//        Date latestDate=
//                coupons.get(i).dateModified;
//
//        while(i>=0 &&
//                coupons.get(i)
//                        .dateModified
//                        .compareTo(latestDate)==0){
//
//            result.add(coupons.get(i));
//            i--;
//        }
//
//         categoryToLatestCouponsMap.put(category,result);
//
//        return result;
//    }
//
//
//     static List<Coupon>
//    getCoupon(String category){
//
//        if(categoryToLatestCouponsMap.containsKey(category)){
//            return categoryToLatestCouponsMap.get(category);
//        }
//
//        List<Coupon> coupons=
//                getCouponDetails(category);
//
//        if(coupons==null ||
//                coupons.size()==0)
//            return List.of();
//
//        List<Coupon> latest=
//                getLatestCoupons(
//                        category,coupons);
//
//         categoryToLatestCouponsMap.put(
//                category,latest);
//
//        return latest;
//    }
//
//
//   static String parse(String str){
//
//        return str.split(":")[1];
//    }
//
//
//     static List<Double>
//    getDiscountedPrice(String productName){
//
//        if(!productMap
//                .containsKey(productName)){
//
//            return List.of();
//        }
//
//        Product product=
//                productMap
//                        .get(productName);
//
//        List<Coupon> coupons=
//                getCoupon(product.category);
//
//        if(coupons==null ||
//                coupons.size()==0){
//
//            return List.of(product.price);
//        }
//
//        return coupons.stream()
//                .map(coupon->
//
//                        coupon.discountType
//                                ==DiscountType.ABSOLUTE ?
//
//                                product.price
//                                        -coupon.discount :
//
//                                product.price -
//                                        (product.price
//                                                *coupon.discount)/100.0
//
//                ).collect(Collectors.toList());
//    }
//
//
//}
