package com.example.sellpizza;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView favpizza, result, selectedPizzaNames, pizzaCount1, pizzaCount3, pizzaCount5;

    private CheckBox pizza1, pizza3, pizza5;

    private TextView totalprice;

    private Button calculate, clear, plusButton1, plusButton3;
    private Button plusButton5 = findViewById(R.id.plusButton5);
    private Button minusButton1, minusButton3;
    private Button minusButton5 = findViewById(R.id.minusButton5);

    private int sum = 0;
    private int pizzacount1, pizzacount3, pizzacount5;
    private int pricePizza1 = 350, pricePizza3 = 365, pricePizza5 = 400;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        favpizza = findViewById(R.id.sellpizza);
        selectedPizzaNames = findViewById(R.id.selectedPizzas);

        favpizza.setText("FavPizza");

        pizza1 = findViewById(R.id.pizza1);
//        pizza2 = findViewById(R.id.pizza2);
        pizza3 = findViewById(R.id.pizza3);
//        pizza4 = findViewById(R.id.pizza4);
        pizza5 = findViewById(R.id.pizza5);
//        pizza6 = findViewById(R.id.pizza6);

        calculate = findViewById(R.id.calculate);
        clear = findViewById(R.id.clear);

        totalprice = findViewById(R.id.totalprice);

        result = findViewById(R.id.result);

        plusButton1 = findViewById(R.id.plusButton1);
        plusButton3 = findViewById(R.id.plusButton3);

        minusButton1 = findViewById(R.id.minusButton1);
        minusButton3 = findViewById(R.id.minusButton3);

        pizzaCount1 = findViewById(R.id.pizzaCount1);
        pizzaCount3 = findViewById(R.id.pizzaCount3);
        pizzaCount5 = findViewById(R.id.pizzaCount5);

        calculate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                StringBuilder selectedpizzas = new StringBuilder();

                if (pizza1.isChecked()) {
                    sum+=350;
                    selectedpizzas.append(pizza1.getText()).append(" || ");
                }
                if (pizza3.isChecked()) {
                    sum += 365;
                    selectedpizzas.append(pizza3.getText()).append(" || ");
                }
                if (pizza5.isChecked()) {
                    sum += 400;
                    selectedpizzas.append(pizza5.getText()).append(" || ");
                }

                selectedPizzaNames.setText(selectedpizzas.toString());

                totalprice.setText("Total Price: " + sum + "\n");
                if (totalprice != null) {
                    result.setText("Successfully ordered. Thanks for using the portal.");
                    pizza1.setChecked(false);
                    pizza3.setChecked(false);
                    pizza5.setChecked(false);
                }

            }

        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum = 0;
                totalprice.setText("Total Price: " + sum + "\n");
                result.setText("Order the pizza you like.");
                selectedPizzaNames.setText(null);
            }
        });

//        plusButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pizzacount1++;
//                pizzaCount1.setText(String.valueOf(pizzacount1));
//            }
//        });
//
//        minusButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pizzacount1--;
//                if (pizzacount1 < 0){
//                    pizzaCount1.setText("0");
//                }
//                else {
//                    pizzaCount1.setText(String.valueOf(pizzacount1));
//                }
//            }
//        });

        plusButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increasePizza1();
            }
        });

        minusButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreasePizza1();
            }
        });

        plusButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increasePizza3();
            }
        });

        minusButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreasePizza3();
            }
        });

        plusButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increasePizza5();
            }
        });

        minusButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pizzacount5 > 0) {
                    decreasePizza5();
                }
            }
        });
    }

//    private void updatePizzaCount(int count, int pizzaType) {
//        switch (pizzaType) {
//            case 1:
//                ((TextView) findViewById(R.id.pizzaCount1)).setText(String.valueOf(count));
//                break;
//            case 3:
//                ((TextView) findViewById(R.id.pizzaCount3)).setText(String.valueOf(count));
//                break;
//            case 5:
//                ((TextView) findViewById(R.id.pizzaCount5)).setText(String.valueOf(count));
//                break;
//            default:
//                break;
//        }
//
//    }

    private void increasePizza1(){
        pizzacount1 = 0;
        String pizzacount1str = pizzaCount1.getText().toString();

        if (!pizzacount1str.isEmpty()){
            pizzacount1 = Integer.parseInt(pizzacount1str);
        }
        pizzacount1++;
        pizzaCount1.setText(String.valueOf(pizzacount1));
    }

    private void decreasePizza1(){
        pizzacount1 = 0;
        String pizzacount1str = pizzaCount1.getText().toString();

        if (!pizzacount1str.isEmpty()){
            pizzacount1 = Integer.parseInt(pizzacount1str);
        }
        if (pizzacount1 > 0){
            pizzacount1--;
            pizzaCount1.setText(String.valueOf(pizzacount1));
        }
    }

    private void increasePizza3(){
        pizzacount3 = 0;
        String pizzacount3str = pizzaCount3.getText().toString();

        if (!pizzacount3str.isEmpty()){
            pizzacount3 = Integer.parseInt(pizzacount3str);
        }
        pizzacount3++;
        pizzaCount3.setText(String.valueOf(pizzacount3));
    }

    private void decreasePizza3(){
        pizzacount3 = 0;
        String pizzacount3str = pizzaCount3.getText().toString();

        if (!pizzacount3str.isEmpty()){
            pizzacount3 = Integer.parseInt(pizzacount3str);
        }
        if (pizzacount3 > 0){
            pizzacount3--;
            pizzaCount3.setText(String.valueOf(pizzacount3));
        }
    }

    private void increasePizza5(){
        pizzacount5 = 0;
        String pizzacount5str = pizzaCount5.getText().toString();

        if (!pizzacount5str.isEmpty()){
            pizzacount5 = Integer.parseInt(pizzacount5str);
        }
        pizzacount5++;
        pizzaCount5.setText(String.valueOf(pizzacount5));
    }

    private void decreasePizza5(){
        pizzacount5 = 0;
        String pizzacount5str = pizzaCount5.getText().toString();

        if (!pizzacount5str.isEmpty()){
            pizzacount5 = Integer.parseInt(pizzacount5str);
        }
        if (pizzacount5 > 0){
            pizzacount5--;
            pizzaCount5.setText(String.valueOf(pizzacount5));
        }
    }

}