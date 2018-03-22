package com.example.trainingnew.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.trainingnew.exception.ResourcesNotFoundException;
import com.example.trainingnew.model.Usermodel;
import com.example.trainingnew.reprository.RoleRepo;
import com.example.trainingnew.reprository.UserRepo;

@Service
public class TrainingServices {
	
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	RoleRepo rolerepo;
	
	//getallServices
	public List<Usermodel> getAllData() {
		return userrepo.findAll();
	}
	
//	//createdataServices
	public Usermodel createData(Usermodel note) {
		return userrepo.save(note);
	}
		
	//getdatabyidServies
	public Usermodel getDataById(Long id) {
		return userrepo.findById(id).orElseThrow(()-> new ResourcesNotFoundException("Note", "Id", id));
	}
	
	//updateDataByidServices
	public Usermodel updateData(Long noteid,Usermodel noteDetails) {
		Usermodel note = userrepo.findById(noteid).orElseThrow(()-> new ResourcesNotFoundException("Note","id", noteid));
		note.setUsername(noteDetails.getUsername());
		note.setEmail(noteDetails.getEmail());
		note.setStatus(noteDetails.getStatus());
		note.setPassword(noteDetails.getPassword());
		Usermodel updatedNote = userrepo.save(note);
		return updatedNote;
	}
	
	//DeleteDataSevices
	public ResponseEntity<?> deletData(Long noteId) {
	    Usermodel note = userrepo.findById(noteId)
	            .orElseThrow(() -> new ResourcesNotFoundException("Note", "id", noteId));
	    userrepo.delete(note);
	    return ResponseEntity.ok().build();
	}

}
