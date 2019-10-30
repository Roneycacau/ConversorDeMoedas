package com.roneycacau.conversormoedas.api;

import com.roneycacau.conversormoedas.model.ApiResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig implements ExchangeRate {
    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://economia.awesomeapi.com.br/all/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private ExchangeRate getRate() {
        return this.retrofit.create(ExchangeRate.class);
    }

    @Override
    public Call<ApiResponse> findRate() {
        return getRate().findRate();
    }
}
