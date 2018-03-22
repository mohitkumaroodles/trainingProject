package com.example.trainingnew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingnew.model.Walletmodel;
import com.example.trainingnew.services.WalletServices;

@RestController
public class WalletController {
	
	@Autowired
	WalletServices services;
	
	@RequestMapping(value="/createwallet",method=RequestMethod.POST)
	public Walletmodel createWallet(@RequestBody Walletmodel mode) {
		return services.createModel(mode);
	}
	
}
