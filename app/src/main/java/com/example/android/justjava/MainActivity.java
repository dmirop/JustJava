package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText nameEdittext = (EditText) findViewById(R.id.name_editText);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
        boolean hasChocolate = chocolateCheckbox.isChecked();
        Editable name = nameEdittext.getText();
        displayMessage(createOrderSummary(name,calculatePrice(),hasWhippedCream,hasChocolate));
    }

    public void increment(View view) {
        quantity += 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity -= 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice() {
        int pricePerCup = 5;
        return quantity * pricePerCup;
    }


    /**
     * Create summary of the order.
     *
     * @param price
     * @param addWhippedCream
     * @param addChocolate
     * @return text summary
     */
    private String createOrderSummary(Editable name, int price, boolean addWhippedCream, boolean addChocolate){
        String summary = "Name: " + name;
         summary += "\n Add whipped cream? " + addWhippedCream;
         summary += "\n Add chocolate? " + addChocolate;
         summary += "\n Quantity: " + quantity;
         summary += "\n Total: $" + price;
         summary += "\n Thank you!";
        return summary;
    }
}