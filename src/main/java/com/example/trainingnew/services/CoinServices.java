package com.example.trainingnew.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.trainingnew.exception.ResourcesNotFoundException;
import com.example.trainingnew.model.Coinmodel;
import com.example.trainingnew.reprository.CoinRepo;


@Service
public class CoinServices {

	@Autowired
	CoinRepo coinrepo;
	
	public Coinmodel addCoin(Coinmodel model) {
		// TODO Auto-generated method stub
		return coinrepo.save(model);
	}
	

	public List<Coinmodel> showAllCoins() {
		// TODO Auto-generated method stub
		return coinrepo.findAll();
	}


	public Coinmodel updateCoin(Long coinid, Coinmodel model) {
		// TODO Auto-generated method stub
			Coinmodel md=coinrepo.findById(coinid).orElseThrow(()-> new ResourcesNotFoundException("Note","id", coinid));
		md.setName(model.getName());
		md.setIntial_suplly(model.getIntial_suplly());
		md.setSymbol(model.getSymbol());
		md.setPrice(model.getPrice());
		return coinrepo.save(md);
	}


	public ResponseEntity<?> deleteCoin(Long noteId) {
	    Coinmodel note = coinrepo.findById(noteId)
	            .orElseThrow(() -> new ResourcesNotFoundException("Note", "id", noteId));
	    coinrepo.delete(note);
	    return ResponseEntity.ok().build();
	}


}
