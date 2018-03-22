package com.example.trainingnew.reprository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trainingnew.model.Coinmodel;

public interface CoinRepo extends JpaRepository<Coinmodel, Long>{

}
