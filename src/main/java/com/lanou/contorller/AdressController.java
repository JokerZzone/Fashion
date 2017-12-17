package com.lanou.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Address;
import com.lanou.entity.User;
import com.lanou.service.AddressService;

@Controller
@RequestMapping("/address")
public class AdressController {
	
	@Autowired
	private AddressService addressService;
	
	@InitBinder("address")
	public void initAddress(WebDataBinder binder) {
		
		binder.setFieldDefaultPrefix("address.");
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public List<Address> show(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		return addressService.selectAll(user.getuId());
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String addAddress(Address address, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		address.setUserId(user.getuId());
		addressService.addAddress(address);
		return "success";
	}
	
	@RequestMapping("/update")
	public void updateAddress(Address address, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		address.setUserId(user.getuId());
		addressService.updateAddress(address);		
	}
	
	@RequestMapping("/delete")
	public void deleteAddress(int address_id) {
		addressService.deleteAddress(address_id);
	}
	
}
