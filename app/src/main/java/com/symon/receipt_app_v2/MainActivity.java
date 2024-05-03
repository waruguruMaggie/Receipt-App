package com.symon.receipt_app_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button milkButton, sugarButton, flourButton, breadButton, grandTotalButton, discountButton, netPayButton;
    TextView milkPrice, milkPriceVat, actualMilkPrice;
    TextView sugarPrice, sugarPriceVat, actualSugarPrice;
    TextView breadPrice, breadPriceVat, actualBreadPrice;
    TextView flourPrice, flourPriceVat, actualFlourPrice;
    TextView grandTotal, discount, netPay;

    float grandTotalAmount = 0, discountAmount = 0, netPayAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind the buttons
        milkButton = findViewById(R.id.milk_button);
        sugarButton = findViewById(R.id.sugar_button);
        flourButton = findViewById(R.id.flour_button);
        breadButton = findViewById(R.id.bread_button);
        grandTotalButton = findViewById(R.id.grand_total_button);
        discountButton = findViewById(R.id.discount_button);
        netPayButton = findViewById(R.id.net_pay_button);

        // Bind the EditTexts
        milkPrice = findViewById(R.id.milk_price);
        milkPriceVat = findViewById(R.id.milk_price_after_vat);
        actualMilkPrice = findViewById(R.id.milk_price_total);

        sugarPrice = findViewById(R.id.sugar_price);
        sugarPriceVat = findViewById(R.id.sugar_price_after_vat);
        actualSugarPrice = findViewById(R.id.sugar_price_total);

        flourPrice = findViewById(R.id.flour_price);
        flourPriceVat = findViewById(R.id.flour_price_after_vat);
        actualFlourPrice = findViewById(R.id.flour_price_total);

        breadPrice = findViewById(R.id.bread_price);
        breadPriceVat = findViewById(R.id.bread_price_after_vat);
        actualBreadPrice = findViewById(R.id.bread_price_total);

        grandTotal = findViewById(R.id.grand_total_amount);
        discount = findViewById(R.id.discount_total_amount);
        netPay = findViewById(R.id.net_pay_amount);


        // instantiating the ShoppingItem class
        ShoppingItem milk = new ShoppingItem(999);
        ShoppingItem sugar = new ShoppingItem(2400);
        ShoppingItem flour = new ShoppingItem(3720);
        ShoppingItem bread = new ShoppingItem(1080);

        // Button click listeners
        milkButton.setOnClickListener(v -> {
            if (milk.count < 4)
            {
                milk.incrementCount();
                milkPrice.setText(String.valueOf(milk.grossAmount));
                milkPriceVat.setText(String.valueOf(milk.vat));
                actualMilkPrice.setText(String.valueOf(milk.actualPrice));
            }
            else
                Toast.makeText(this, "You can Only buy 4 Litres", Toast.LENGTH_SHORT).show();
        });
        sugarButton.setOnClickListener(v -> {
            if (sugar.count < 4)
            {
                sugar.incrementCount();
                sugarPrice.setText(String.valueOf(sugar.grossAmount));
                sugarPriceVat.setText(String.valueOf(sugar.vat));
                actualSugarPrice.setText(String.valueOf(sugar.actualPrice));
            }
            else
                Toast.makeText(this, "You can Only buy 4 Kgs", Toast.LENGTH_SHORT).show();
        });

        flourButton.setOnClickListener(v -> {
            if (flour.count < 4)
            {
                flour.incrementCount();
                flourPrice.setText(String.valueOf(flour.grossAmount));
                flourPriceVat.setText(String.valueOf(flour.vat));
                actualFlourPrice.setText(String.valueOf(flour.actualPrice));
            }
            else
                Toast.makeText(this, "You can Only buy 4 Kgs", Toast.LENGTH_SHORT).show();
        });

        breadButton.setOnClickListener(v -> {
            if (bread.count < 4)
            {
                bread.incrementCount();
                breadPrice.setText(String.valueOf(bread.grossAmount));
                breadPriceVat.setText(String.valueOf(bread.vat));
                actualBreadPrice.setText(String.valueOf(bread.actualPrice));
            }
            else
                Toast.makeText(this, "You can Only buy 4 loaves", Toast.LENGTH_SHORT).show();
        });

        grandTotalButton.setOnClickListener(v -> {
            grandTotalAmount = (milk.actualPrice + sugar.actualPrice + flour.actualPrice + bread.actualPrice);
            grandTotal.setText(String.valueOf(grandTotalAmount));
        });

        discountButton.setOnClickListener(v -> {
            if (grandTotalAmount > 10_000) {
                discountAmount = (float) (grandTotalAmount * 0.05);
                discount.setText(String.valueOf(discountAmount));
            }
            else
                Toast.makeText(this, "You are not eligible for a discount", Toast.LENGTH_SHORT).show();
        });

        netPayButton.setOnClickListener(v -> {
            netPayAmount = grandTotalAmount - discountAmount;
            netPay.setText(String.valueOf(netPayAmount));
        });
    }
}