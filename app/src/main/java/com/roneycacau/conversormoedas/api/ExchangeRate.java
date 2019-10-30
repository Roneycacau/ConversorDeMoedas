package com.roneycacau.conversormoedas.api;

import com.roneycacau.conversormoedas.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ExchangeRate {
    @GET("USD-BRL,EUR-BRL")
    Call<ApiResponse> findRate();
}
