package com.example.demo.bitcoinvalueapi;

public class BitcoinValueService {
	private final GetRequest getRequest = new GetRequest();

	public String bitcoinValue() {
		getRequest.get("https://api.cryptowat.ch/markets/kraken/btceur/price");
		return String.valueOf(getRequest.getCryptoPrice().getResult().getPrice());
	}
}