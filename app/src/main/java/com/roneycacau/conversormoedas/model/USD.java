package com.roneycacau.conversormoedas.model;

public class USD {
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
