package com.roneycacau.conversormoedas.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.roneycacau.conversormoedas.R;
import com.roneycacau.conversormoedas.api.RetrofitConfig;
import com.roneycacau.conversormoedas.model.ApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewHolder mViewHolder;

    double usd;
    double eur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewHolder = new MainActivityViewHolder(this);

        mViewHolder.getCalculate().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String value = mViewHolder.getEditValue().getText().toString();
                if (value.isEmpty()) {
                    Toast.makeText(MainActivity.this, getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
                    return;
                } else if (Double.parseDouble(value) <= 0) {
                    Toast.makeText(MainActivity.this, getString(R.string.valor_menor_que_zero), Toast.LENGTH_LONG).show();
                    return;
                }
                Call<ApiResponse> call = new RetrofitConfig().findRate();
                call.enqueue(new Callback<ApiResponse>() {
                    @Override
                    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                        ApiResponse apiResponse = response.body();
                        if (apiResponse != null) {
                            if (apiResponse.getUSD() != null)
                                usd = Double.parseDouble(apiResponse.getUSD().getAsk());
                            if (apiResponse.getEUR() != null)
                                eur = Double.parseDouble(apiResponse.getEUR().getAsk());
                        }
                        double real = Double.parseDouble(value);
                        mViewHolder.getTextDolar().setText(String.format("%.2f", real / usd));
                        mViewHolder.getTextEuro().setText(String.format("%.2f", real / eur));
                    }

                    @Override
                    public void onFailure(Call<ApiResponse> call, Throwable t) {
                        Log.e("ExchangeRate   ", "Erro ao buscar cotação:" + t.getMessage());

                    }
                });
            }
        });
    }

    private void clearValues() {
        mViewHolder.getTextDolar().setText("");
        mViewHolder.getTextEuro().setText("");
    }

}
