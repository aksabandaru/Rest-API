package com.example.Software.Implentaion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Software.InterfaceforDef.SoftwareIntforDef;
import com.example.Software.Model.Software;
import com.example.Software.SoftwareInterface.SoftwareInt;
@Service
public class SoftwareImpforInterface implements  SoftwareIntforDef{
	private SoftwareInt software;
public SoftwareImpforInterface(SoftwareInt software) {
	
		this.software = software;
	}
public 	Software savesoftware(Software obj) {
	return software.save(obj);
}
public List<Software> fetchAllRecords(){
	return software.findAll();
}
 public Software fetchOneRecord(int id) throws Exception {
Optional<Software> obj=software.findById(id);
if(obj.isPresent()) {
	return obj.get();
}
else {
	throw new Exception("not available");
}
}
public void deletesoftware(int id) {
	Optional<Software> obj=software.findById(id);
	if(obj.isPresent()) {
		software.deleteById(id);
	}
	
}

public Software updateSoftware(int id,Software newvalue) {	
Optional<Software> obj=software.findById(id);
if(obj.isPresent()) {
	Software value= obj.get();
	value.setSoftwarename(newvalue.getSoftwarename());
	value.setPrice(newvalue.getPrice());
	software.save(value);
	return value;
}
return new Software();
	

}
}
	


