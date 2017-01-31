package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkBox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        EditText name = (EditText) findViewById(R.id.name_editText);
         String name_editText = name.getText().toString();
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, name_editText);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order for: " + name_editText);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Calculates the price of the order.
     *
     * we return total price
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
//        int whippedCreamPrice = 1;
//        int chocolatePrice = 2;
        int pricePerCup = 5;
        int price = quantity * pricePerCup;

        if (hasChocolate){
            price = price + 2;
        }
        if (hasWhippedCream){
            price = price + 1;
        }
        return price;
    }


    /**
     * Summary
     *
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name){
  //      boolean hasWhippedCream = clicked(vi);

        String priceMessage= getString(R.string.order_summary_name, name);
        priceMessage += "\nAdd Whipped Cream? " + addWhippedCream;
        priceMessage += "\nAdd Chocolate? " + addChocolate;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + (price) + "\n" + getString(R.string.thank_you);
        return priceMessage;
    }

    /**
     * increment method
     */
    public void increment(View view) {
        quantity++;
        if(quantity > 100)
    {
        quantity = 100;
        Context context = getApplicationContext();
        CharSequence text = "Maximum Cups of Coffee order cannot Exceede 100";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
        displayQuantity(quantity);
    }
    /**
     * decrement method
     */
    public void decrement(View view) {

        quantity--;
        if(quantity < 1)
        {
            CharSequence text = "Minimum Cups of Coffee order cannot go below 1";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            quantity = 1;

        }
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

}