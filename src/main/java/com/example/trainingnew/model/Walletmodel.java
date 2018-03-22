package com.example.trainingnew.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wallet")
public class Walletmodel {
	
	@Id
	private long id;
	private long user_id;
	private double balance;
	private double shadow_balance;
	private String wallet_type;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getShadow_balance() {
		return shadow_balance;
	}
	public void setShadow_balance(double shadow_balance) {
		this.shadow_balance = shadow_balance;
	}
	public String getWallet_type() {
		return wallet_type;
	}
	public void setWallet_type(String wallet_type) {
		this.wallet_type = wallet_type;
	}
	
	
}
