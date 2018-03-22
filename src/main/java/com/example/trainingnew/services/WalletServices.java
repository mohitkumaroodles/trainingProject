package com.example.trainingnew.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.trainingnew.model.Walletmodel;
import com.example.trainingnew.reprository.WalletRepo;

@Service
public class WalletServices {
	
	
	@Autowired
	WalletRepo walletrepo;
	
	public Walletmodel createModel(Walletmodel wmodel) {
		return walletrepo.save(wmodel);
		
	}


}
