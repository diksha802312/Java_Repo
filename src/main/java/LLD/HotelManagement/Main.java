package LLD.HotelManagement;

public class Main {
    public static void main(String[] args) {
            OrderBill orderBill = new OrderBill();
            Order order1 = new Order(1, 40);
            Order order2 = new Order(2, 100);
            Order order3 = new Order(3, 105);

            orderBill.addOrder(order1);
            orderBill.addOrder(order2);
            orderBill.addOrder(order3);

            Double finalAmount = orderBill.getTotalPrice();
            System.out.println("finalAmount = " + finalAmount);
        }
    }
