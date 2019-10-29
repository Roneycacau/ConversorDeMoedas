package com.roneycacau.conversormoedas;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://economia.awesomeapi.com.br/all/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public ExchangeRate getRate(){
        return this.retrofit.create(ExchangeRate.class);
    }
}
