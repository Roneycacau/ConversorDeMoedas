package com.roneycacau.conversormoedas;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ExchangeRate {
    @GET("USD-BRL,EUR-BRL")
    Call findRate();
}
