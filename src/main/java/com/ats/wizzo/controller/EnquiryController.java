package com.ats.wizzo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.wizzo.model.BuyNow;
import com.ats.wizzo.model.Enquiry;
import com.ats.wizzo.model.ErrorMessage;
import com.ats.wizzo.model.GetTouch;
import com.ats.wizzo.model.Support;
import com.ats.wizzo.respository.BuyNowRepository;
import com.ats.wizzo.respository.EnquiryRepository;
import com.ats.wizzo.respository.GetTouchRepository;

@RestController
public class EnquiryController {

	@Autowired
	EnquiryRepository enquiryRepository;

	@Autowired
	BuyNowRepository buyNowRepository;

	
	@Autowired
	GetTouchRepository 	getTouchRepository;
	
	
	
	
	@RequestMapping(value = { "/getContactEnquiry" }, method = RequestMethod.GET)
	public @ResponseBody List<Enquiry> getContactEnquiry() {

		List<Enquiry> enquiryList = new ArrayList<Enquiry>();

		try {

			enquiryList = enquiryRepository.findAllEnqByContactEnq();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enquiryList;

	}

	@RequestMapping(value = { "/getDistributerEnquiry" }, method = RequestMethod.GET)
	public @ResponseBody List<Enquiry> getDistributerEnquiry() {

		List<Enquiry> enquiryList = new ArrayList<Enquiry>();

		try {

			enquiryList = enquiryRepository.findAllEnqByDistributerEnq();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enquiryList;

	}
	
	
	@RequestMapping(value = { "/updateEnquiry" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateEnquiry(@RequestParam("enqId") int enqId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int update = enquiryRepository.updateEnq(enqId);

			if (update == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Updated");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("not  update");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" not update");

		}
		return errorMessage;

	}
	
	//--------------------Order Buy Now-------------------------

	@RequestMapping(value = { "/getOrderListInBuyNow" }, method = RequestMethod.GET)
	public @ResponseBody List<BuyNow> getOrderListInBuyNow() {

		List<BuyNow> buyNowList = new ArrayList<BuyNow>();

		try {

			buyNowList = buyNowRepository.findAllOrders();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return buyNowList;

	}

	

	@RequestMapping(value = { "/updateBuyNow" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateBuyNow(@RequestParam("orderId") int orderId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int update = buyNowRepository.updateOrderStatus(orderId);

			if (update == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Updated");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("not  update");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" not update");

		}
		return errorMessage;

	}
	
	
	
	//-------------------Get Touch-------------------------

		@RequestMapping(value = { "/getAllData" }, method = RequestMethod.GET)
		public @ResponseBody List<GetTouch> getAllData() {

			List<GetTouch> getTouchList = new ArrayList<GetTouch>();

			try {

			getTouchList = getTouchRepository.findAllByStatus();

			} catch (Exception e) {

				e.printStackTrace();

			}
			return getTouchList;

		}
		
		
		
		@RequestMapping(value = { "/updateGetTouch" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage updateGetTouch(@RequestParam("trId") int trId) {

			ErrorMessage errorMessage = new ErrorMessage();

			try {
				int update = getTouchRepository.updateGetTouchStatus(trId);

				if (update == 1) {
					errorMessage.setError(false);
					errorMessage.setMessage("successfully Updated");
				} else {
					errorMessage.setError(true);
					errorMessage.setMessage("not  update");
				}

			} catch (Exception e) {

				e.printStackTrace();
				errorMessage.setError(true);
				errorMessage.setMessage(" not update");

			}
			return errorMessage;

		}
		

		

}
