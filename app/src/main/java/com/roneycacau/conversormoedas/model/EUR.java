package com.roneycacau.conversormoedas.model;

public class EUR {
    private String ask;

    public String getAsk ()
    {
        return ask.replace(",",".");
    }
    public void setAsk (String ask)
    {
        this.ask = ask;
    }
}
