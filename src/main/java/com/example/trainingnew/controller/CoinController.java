package com.example.trainingnew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingnew.model.Coinmodel;
import com.example.trainingnew.services.CoinServices;

@RestController
public class CoinController {
	
	@Autowired
	CoinServices services;
	
	//create coins
	@RequestMapping(value="/addcoins",method=RequestMethod.POST)
	public Coinmodel addcoin(@RequestBody Coinmodel model) {
		return services.addCoin(model);
	}
	
	//to get all coins
	@RequestMapping(value="/showcoins",method=RequestMethod.GET)
	public List<Coinmodel> showCoin() {
		return services.showAllCoins();
	}
	
	//to update coins
	@RequestMapping(value="/updatecoin/{id}",method=RequestMethod.PUT)
	public Coinmodel updatecoin(@PathVariable("id") Long coinid ,@RequestBody Coinmodel model) {
		
		return services.updateCoin(coinid,model);
	}
	
	//
	@RequestMapping(value="/deletecoin/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable(value="id") Long id){
		return services.deleteCoin(id);
	}
	

}
