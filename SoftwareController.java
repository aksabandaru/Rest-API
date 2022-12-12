package com.example.Software.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Software.Model.Software;
import com.example.Software.InterfaceforDef.SoftwareIntforDef;
import com.example.Software.Model.Software;

@RestController
@RequestMapping("/software")
public class SoftwareController {
	private  SoftwareIntforDef softwaredef;

	public SoftwareController(SoftwareIntforDef softwaredef) {
		this.softwaredef = softwaredef;
	}
	@PostMapping("/insert")
	public ResponseEntity<Software> saveLeaners(@RequestBody Software obj) {
		return new ResponseEntity<Software>(softwaredef.savesoftware(obj),HttpStatus.CREATED);
			
	}
	@GetMapping("/viewsoftwaredetails")
			
	public List<Software> toviewAllRecords(){
		return  softwaredef.fetchAllRecords();
	}
	@GetMapping("{id}")
	public ResponseEntity<Software> fetchonerecord(@PathVariable("id") int softwareid) throws Exception {
		return new ResponseEntity<Software>(softwaredef.fetchOneRecord(softwareid),HttpStatus.OK);
			
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteLearnerByAcceptingId(@PathVariable("id") int id){
		softwaredef.deletesoftware(id);
		return new ResponseEntity<String>("record has been deleted", HttpStatus.OK);
	}
	@PutMapping("{id}/update")
	public ResponseEntity<Software> updateLearnerByAcceptingId(@PathVariable("id") int id,@RequestBody Software url){
		return new ResponseEntity<Software>(softwaredef.updateSoftware(id, url),HttpStatus.OK);
	}
 
	



}
	

