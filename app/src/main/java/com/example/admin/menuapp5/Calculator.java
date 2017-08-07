package com.example.admin.menuapp5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Admin on 8/6/2017.
 */

public class Calculator extends android.support.v4.app.Fragment {

    EditText etNum1, etNum2;
    Button zero, one, two, three, four, five, six, seven, eight, nine, add, sub, mult, div, mod, percent, equal;
    TextView stage;
    String operation;
    double operand;
    boolean result_flag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_calculator, container, false);

        stage = (TextView) view.findViewById(R.id.stage);

        zero = (Button) view.findViewById(R.id.zero);
        one = (Button) view.findViewById(R.id.one);
        two = (Button) view.findViewById(R.id.two);
        three = (Button) view.findViewById(R.id.three);
        four = (Button) view.findViewById(R.id.four);
        five = (Button) view.findViewById(R.id.five);
        six = (Button) view.findViewById(R.id.six);
        seven = (Button) view.findViewById(R.id.seven);
        eight = (Button) view.findViewById(R.id.eight);
        nine = (Button) view.findViewById(R.id.nine);

        //decimal = (Button) findViewById(R.id.decimal);

        add = (Button) view.findViewById(R.id.add);
        sub = (Button) view.findViewById(R.id.sub);
        mult = (Button) view.findViewById(R.id.mul);
        div = (Button) view.findViewById(R.id.div);
        mod = (Button) view.findViewById(R.id.mod);
        percent = (Button) view.findViewById(R.id.percent);
        equal = (Button) view.findViewById(R.id.equal);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Calculator");

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result_flag){
                    stage.setText("");
                    result_flag = false;
                }
                stage.setText(stage.getText()+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result_flag){
                    stage.setText("");
                    result_flag = false;
                }
                stage.setText(stage.getText()+ "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result_flag){
                    stage.setText("");
                    result_flag = false;
                }
                stage.setText(stage.getText()+ "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result_flag){
                    stage.setText("");
                    result_flag = false;
                }
                stage.setText(stage.getText()+ "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result_flag){
                    stage.setText("");
                    result_flag = false;
                }
                stage.setText(stage.getText()+ "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result_flag){
                    stage.setText("");
                    result_flag = false;
                }
                stage.setText(stage.getText()+ "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result_flag){
                    stage.setText("");
                    result_flag = false;
                }
                stage.setText(stage.getText()+ "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result_flag){
                    stage.setText("");
                    result_flag = false;
                }
                stage.setText(stage.getText()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result_flag){
                    stage.setText("");
                    result_flag = false;
                }
                stage.setText(stage.getText()+ "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result_flag){
                    stage.setText("");
                    result_flag = false;
                }
                stage.setText(stage.getText()+ "9");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double out = Double.parseDouble(stage.getText().toString());
                switch(operation){
                    case "ADDITION":
                        out += operand;
                        break;
                    case "SUBTRACTION":
                        out -= operand;
                        break;
                    case "MULT":
                        out = out * operand;
                        break;
                    case "DIVISION":
                        out = out/operand;
                        break;
                    case "MOD":
                        out %= operand;
                        break;
                    case "PERCENT":
                        out = out/operand*100;
                        break;
                }
                stage.setText(String.valueOf(out));
                result_flag = true;
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operand = Double.parseDouble(stage.getText().toString());
                operation = "ADDITION";
                stage.setText("");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operand = Double.parseDouble(stage.getText().toString());
                operation = "SUBTRACTION";
                stage.setText("");
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operand = Double.parseDouble(stage.getText().toString());
                operation = "MULT";
                stage.setText("");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operand = Double.parseDouble(stage.getText().toString());
                operation = "DIVISION";
                stage.setText("");
            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operand = Double.parseDouble(stage.getText().toString());
                operation = "MOD";
                stage.setText("");
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operand = Double.parseDouble(stage.getText().toString());
                operation = "PERCENT";
                stage.setText("");
            }
        });
    }

}




