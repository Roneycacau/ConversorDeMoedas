package com.roneycacau.conversormoedas;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mViewHolder.editValue = findViewById(R.id.edit_brl_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_usd_value);
        this.mViewHolder.textEuro = findViewById(R.id.text_eur_value);
        this.mViewHolder.calculate = findViewById(R.id.button_calculate);

        this.mViewHolder.calculate.setOnClickListener(this);
    }

    private void clearValues(){
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_calculate){
            String value = this.mViewHolder.editValue.getText().toString();
            if(value.isEmpty()){
                Toast.makeText(this, this.getString(R.string.informe_valor),Toast.LENGTH_LONG).show();
            }else{
                double real = Double.valueOf(value);
                this.mViewHolder.textDolar.setText(String.format("%.2f",real/4));
                this.mViewHolder.textEuro.setText(String.format("%.2f",real/5));
            }
        }
    }

    private static class ViewHolder{
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button calculate;
    }
}
