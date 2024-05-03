package com.symon.receipt_app_v2;


public class ShoppingItem {
    int count = 0;
    float price;
    float grossAmount = 0;
    float vat = 0;
    float actualPrice = 0;

    // constructor: sets the button and price
    public ShoppingItem(float price) {
        this.price = price;
    }
    // button click increments the count
    public void incrementCount() {
        if (count < 4) {
            count++;
            grossAmount = calculateGrossAmount(price, count);
            vat = calculateVat(grossAmount);
            actualPrice = calculateActualPrice(grossAmount);
        }
    }

    private float calculateGrossAmount(float price, int count) {
        return price * count;
    }
    private float calculateVat(float grossAmount) {
        return (float) (grossAmount * 0.16);
    }
    private  float calculateActualPrice(float grossAmount) {
        return grossAmount + calculateVat(grossAmount);
    }
}
