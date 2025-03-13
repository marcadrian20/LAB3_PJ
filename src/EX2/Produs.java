package EX2;

import EX1.Parabola;

import java.time.LocalDate;


public class Produs {
    //    @FunctionalInterface
//    private interface Setter<T>{
//        void set(T t);
//    }
//    @FunctionalInterface
//    private interface Getter<T>{
//        T get();
//    }

    private String productName;
    private float price;
    private int quantity;
    private LocalDate expiryDate;
    private static int sales=0;
//    public Setter<String> setName=(productName)->this.productName=productName;

    public Produs(String productName, float price, int quantity, LocalDate expiryDate) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Produs: " + productName + " Cantitate: " + quantity + " Pret: " + price + " Data expirare: " + expiryDate.toString();
    }

    public static int getSales() {
        return sales;
    }

    public void incrementSales(int increment) {
        sales += (int) (increment*this.price);
    }
    public boolean checkExpired()
    {
        return expiryDate.isBefore(LocalDate.now());
    }

}
