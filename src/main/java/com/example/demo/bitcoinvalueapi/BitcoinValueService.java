package com.example.demo.bitcoinvalueapi;

public class BitcoinValueService {
    public String bitcoinValue() {

        GetRequest getRequest = new GetRequest();
        getRequest.get("https://api.cryptowat.ch/markets/kraken/btceur/price");

        return String.valueOf(getRequest.getCryptoPrice().getResult().getPrice());
    }
}