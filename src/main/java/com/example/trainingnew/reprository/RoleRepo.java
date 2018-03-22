package com.example.trainingnew.reprository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trainingnew.model.Rolemodel;

public interface RoleRepo extends JpaRepository<Rolemodel, Long>{

	Rolemodel findOneById(long id);

}
