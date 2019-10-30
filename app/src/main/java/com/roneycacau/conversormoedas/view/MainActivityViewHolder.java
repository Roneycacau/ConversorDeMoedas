package com.roneycacau.conversormoedas.view;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.roneycacau.conversormoedas.R;

public class MainActivityViewHolder {
    private EditText editValue;
    private TextView textDolar;
    private TextView textEuro;
    private Button calculate;
    //O ViewHolder só armazena variaveis do tipo de componentes do Xml que ele se refere

    public MainActivityViewHolder(AppCompatActivity view) {
        editValue = view.findViewById(R.id.edit_brl_value);
        textDolar = view.findViewById(R.id.text_usd_value);
        textEuro = view.findViewById(R.id.text_eur_value);
        calculate = view.findViewById(R.id.button_calculate);
    }

    public EditText getEditValue() {
        return editValue;
    }

    public TextView getTextDolar() {
        return textDolar;
    }

    public TextView getTextEuro() {
        return textEuro;
    }

    public Button getCalculate() {
        return calculate;
    }
}
