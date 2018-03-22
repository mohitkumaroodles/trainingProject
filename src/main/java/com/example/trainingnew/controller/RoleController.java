package com.example.trainingnew.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingnew.model.Rolemodel;
import com.example.trainingnew.model.Usermodel;
import com.example.trainingnew.reprository.RoleRepo;
import com.example.trainingnew.reprository.UserRepo;

@RestController
@RequestMapping(value="/trainapi")
public class RoleController {
	
	@Autowired
	RoleRepo rolerepo;
	
	@Autowired
	UserRepo userrepo;
	
	@RequestMapping(value="/showrole",method= RequestMethod.GET)
	public List<Rolemodel> showrole() {
		return rolerepo.findAll();
	}
	
	
	//createRoledataServices
	@RequestMapping(value = "/insertrole", method = RequestMethod.POST)
		public Rolemodel createRole(@RequestBody Rolemodel note) {
			
			return rolerepo.save(note);
		}
	
	
	@RequestMapping(value = "/adding", method = RequestMethod.POST)
	public Usermodel insertDataWithRole(@Valid @RequestBody Rolemodel note) {
		
		Usermodel up=userrepo.findOneById(note.getId());
		up.getRoles().add(note);
		return userrepo.save(up);
	}
	
}
