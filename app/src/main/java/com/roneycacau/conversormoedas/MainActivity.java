package com.roneycacau.conversormoedas;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        Call<Exchange> call = new RetrofitConfig().getRate().findRate();
        call.enqueue(new Callback<Exchange>() {
            @Override
            public void onResponse(Call<Exchange> call, Response<Exchange> response) {
                Exchange exchange = response.body();
                String code = exchange.getCode();
                if(code.equalsIgnoreCase("usd")){
                    mViewHolder.usd = Double.valueOf(exchange.getAsk());
                }
                if(code.equalsIgnoreCase("eur")){
                    mViewHolder.eur = Double.valueOf(exchange.getAsk());
                }
            }

            @Override
            public void onFailure(Call<Exchange> call, Throwable t) {
                Log.e("ExchangeRate   ", "Erro ao buscar cotação:" + t.getMessage());

            }
        });
        if(v.getId() == R.id.button_calculate){
            String value = this.mViewHolder.editValue.getText().toString();
            if(value.isEmpty()){
                Toast.makeText(this, this.getString(R.string.informe_valor),Toast.LENGTH_LONG).show();
            }else{
                double real = Double.valueOf(value);
                this.mViewHolder.textDolar.setText(String.format("%.2f",real/mViewHolder.usd));
                this.mViewHolder.textEuro.setText(String.format("%.2f",real/mViewHolder.eur));
            }
        }
    }

    private static class ViewHolder{
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button calculate;
        double usd;
        double eur;
    }
}
