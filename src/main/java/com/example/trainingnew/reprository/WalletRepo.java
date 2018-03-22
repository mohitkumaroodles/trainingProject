package com.example.trainingnew.reprository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trainingnew.model.Walletmodel;

public interface WalletRepo extends JpaRepository<Walletmodel, Long>{

}
