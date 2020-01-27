package com.app.controller;

import java.util.List;

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

import com.app.pojos.OdrDtls;
import com.app.pojos.Order;
import com.app.pojos.OrderDetails;
import com.app.service.IVendorService;

@RestController
@CrossOrigin
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	IVendorService vservice;
	
	@GetMapping("/pendingorders/{vid}")
	public ResponseEntity<?> pendingOrders(@PathVariable Integer vid)
	{
		System.out.println("vid "+vid);
		try {
			return new ResponseEntity<List<Order>>(vservice.pendingOrders(vid),HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/acceptorder/{oid}")
	public ResponseEntity<?> acceptOrder(@PathVariable Integer oid)
	{
		System.out.println("oid "+oid);
		try {
			return new ResponseEntity<Order>(vservice.acceptOrder(oid),HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/rejectorder/{oid}")
	public ResponseEntity<?> rejectOrder(@PathVariable Integer oid)
	{
		System.out.println("oid "+oid);
		try {
			return new ResponseEntity<Order>(vservice.rejectOrder(oid),HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/cancleorder/{oid}")
	public ResponseEntity<?> cancelOrder(@PathVariable Integer oid)
	{
		System.out.println("oid "+oid);
		try {
			return new ResponseEntity<Order>(vservice.cancelOrder(oid),HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/acceptedorders/{vid}")
	public ResponseEntity<?> acceptedOrders(@PathVariable Integer vid)
	{
		System.out.println("vid "+vid);
		try {
			return new ResponseEntity<List<Order>>(vservice.acceptedOrders(vid),HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/verifyotp/{oid}")
	public ResponseEntity<?> verifyOTP(@PathVariable Integer oid)
	{
		try {
			return new ResponseEntity<Order>(vservice.verifyOTP(oid),HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
//	@GetMapping("/ratecustomer/{cid}/{rating}")
//	public ResponseEntity<?> rateCustomer(@PathVariable Integer cid,@PathVariable int rating)
//	{
//		try {
//			return new ResponseEntity<String>(vservice.rateCustomer(cid,rating),HttpStatus.OK);
//		} catch (RuntimeException e) {
//			e.printStackTrace();
//			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		}
//	}
	@PostMapping("/setorderdtls")
	public ResponseEntity<?> setOrderDetails(@RequestBody OdrDtls od)
	{
		try {
			return new ResponseEntity<OrderDetails>(vservice.setOrderDetails(od),HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/successfulOrder/{oid}")
	public ResponseEntity<?> SuccessOrder(@PathVariable Integer oid)
	{
		try {
			return new ResponseEntity<Order>(vservice.SuccessOrder(oid),HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
