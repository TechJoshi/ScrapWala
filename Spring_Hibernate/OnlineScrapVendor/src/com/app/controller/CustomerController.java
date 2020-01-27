package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Order;
import com.app.service.ICustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
	@Autowired 
	private ICustomerService cservice;
	
	@PostConstruct
	public void myInit() {
		System.out.println("Inside init of .." + getClass().getName());
	}
	
	@PostMapping("/raisereq/{cid}")
	public ResponseEntity<?> raiseRequest(@RequestBody Order o,@PathVariable Integer cid)
	{
		System.out.println(o +" "+cid);
		try {
			return new ResponseEntity<Order>(cservice.raiseRequest(o,cid),HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/orderlist/{cid}")
	public ResponseEntity<?> getOrderList(@PathVariable Integer cid)
	{
		System.out.println("cid "+cid);
		try {
			return new ResponseEntity<List<Order>>(cservice.getOrderList(cid),HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/orderdetails/{oid}")
	public ResponseEntity<?> getOrderDetails(@PathVariable Integer oid)
	{
		try {
			return new ResponseEntity<Order>(cservice.getOrderDetails(oid),HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/cancelorder/{oid}")
	public ResponseEntity<?> cancelOrder(@PathVariable Integer oid)
	{
		try {
			return new ResponseEntity<Order>(cservice.cancelOrder(oid),HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
//	@GetMapping("/ratevendor/{vid}/{rating}")
//	public ResponseEntity<?> rateVendor(@PathVariable Integer vid,@PathVariable int rating)
//	{
//		try {
//			return new ResponseEntity<String>(cservice.rateVendor(vid,rating),HttpStatus.OK);
//		} catch (RuntimeException e) {
//			e.printStackTrace();
//			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		}
//	}
	
}
