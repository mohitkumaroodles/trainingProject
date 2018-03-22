package com.example.trainingnew.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingnew.model.Usermodel;
import com.example.trainingnew.reprository.UserRepo;
import com.example.trainingnew.services.TrainingServices;

@RestController
@RequestMapping("/trainapi")
public class TrainingController {
	
	@Autowired
	TrainingServices services;
	
	@Autowired
	UserRepo userrepo;

	//show all 
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public List<Usermodel> showData() {
		return services.getAllData();
	}

	// insert new data
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Usermodel insertData(@Valid @RequestBody Usermodel note) {
		
		return services.createData(note);
	}
	
	//insert data with role
//	@RequestMapping(value = "/adding", method = RequestMethod.POST)
//	public UserPojo insertDataWithRole(@Valid @RequestBody UserPojo note) {
//		
//		UserPojo up=new UserPojo();
//		Rolepojo rp=new Rolepojo();
//		
//		up.getRoles().add(rp);
//		return userrepo.save(up);
//	}

	//get single data by id
	@RequestMapping(value="/show/{id}",method=RequestMethod.POST)
	public Usermodel getById(@PathVariable(value="id") Long id) {
		return services.getDataById(id);
	}
		
	//update a data with id
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	public Usermodel update(@PathVariable(value="id") Long id,@RequestBody Usermodel allDetails) {
		return services.updateData(id, allDetails);
	}
		
	//delete a note
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable(value="id") Long id){
		return services.deletData(id);
	}
		
		
}
