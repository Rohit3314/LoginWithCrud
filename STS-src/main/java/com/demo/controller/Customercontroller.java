package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Customer;
import com.demo.model.Login;
import com.demo.repository.Customerrepository;
import com.demo.repository.Loginrepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Customercontroller
{


	@Autowired
	private Customerrepository crepo;
	
	@Autowired
	private Loginrepository lrepo;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login l1)
	{
		Login l3 = l1;
		String ps= l3.getUid();
		String ps1 = l3.getUpswd(); 
		
		boolean l2 = lrepo.existsById(ps);
		if(l2)
		{
		if(ps1.equals(l3.getUpswd()))
		return ResponseEntity.ok(l3);		
		}
		return (ResponseEntity<Login>) ResponseEntity.internalServerError();	
	}
	
	
	@PostMapping("/insert")
	public Customer insert(@RequestBody Customer c1)
	{
		return this.crepo.save(c1);
	}
}






