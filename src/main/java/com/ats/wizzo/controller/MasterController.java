package com.ats.wizzo.controller;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.wizzo.common.Firebase;
import com.ats.wizzo.model.AdminUser;
import com.ats.wizzo.model.BuyNow;
import com.ats.wizzo.model.DashboardCount;
import com.ats.wizzo.model.Device;
import com.ats.wizzo.model.DeviceByUserId;
import com.ats.wizzo.model.Employee;
import com.ats.wizzo.model.Enquiry;
import com.ats.wizzo.model.ErrorMessage;
import com.ats.wizzo.model.GetSupportList;
import com.ats.wizzo.model.GetTouch;
import com.ats.wizzo.model.LoginResponse;
import com.ats.wizzo.model.LoginResponseAdmin;
import com.ats.wizzo.model.LoginResponseUser;
import com.ats.wizzo.model.Order;
import com.ats.wizzo.model.Room;
import com.ats.wizzo.model.Support;
import com.ats.wizzo.model.TotalRoom;
import com.ats.wizzo.model.User;
import com.ats.wizzo.model.UserPassword;
import com.ats.wizzo.model.UserPwd;
import com.ats.wizzo.respository.AdminUserRepository;
import com.ats.wizzo.respository.BuyNowRepository;
import com.ats.wizzo.respository.DeviceByUserIdRepository;
import com.ats.wizzo.respository.DeviceRepository;
import com.ats.wizzo.respository.EmployeeRepository;
import com.ats.wizzo.respository.EnquiryRepository;
import com.ats.wizzo.respository.GetSupportListRepository;
import com.ats.wizzo.respository.GetTouchRepository;
import com.ats.wizzo.respository.OrderRepository;
import com.ats.wizzo.respository.RoomRepository;
import com.ats.wizzo.respository.ScanDeviceRepository;
import com.ats.wizzo.respository.SchedulerRepository;
import com.ats.wizzo.respository.SupportRepository;
import com.ats.wizzo.respository.TotalRoomRepository;
import com.ats.wizzo.respository.UserPasswordRepository;
import com.ats.wizzo.respository.UserPwdRepository;
import com.ats.wizzo.respository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MasterController {

	@Autowired
	AdminUserRepository adminUserRepository;

	@Autowired
	UserPwdRepository userPwdRepository;

	@Autowired
	EnquiryRepository enquiryRepository;

	@Autowired
	BuyNowRepository buyNowRepository;

	@Autowired
	UserPasswordRepository userPasswordRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	SupportRepository supportRepository;

	@Autowired
	DeviceByUserIdRepository deviceByUserIdRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ScanDeviceRepository scanDeviceRepository;

	@Autowired
	SchedulerRepository schedulerRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	GetSupportListRepository getSupportListRepository;

	@Autowired
	GetTouchRepository getTouchRepository;

	@Autowired
	TotalRoomRepository totalRoomRepository;

	// ----------------------------------------Enquiry------------------------------------

	@RequestMapping(value = { "/saveEnquiryDirect" }, method = RequestMethod.POST)
	public @ResponseBody Enquiry saveEmployee(@RequestBody Enquiry enquiry) {

		Enquiry enq = new Enquiry();

		try {

			enq = enquiryRepository.saveAndFlush(enquiry);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enq;

	}

	@RequestMapping(value = { "/saveEnquiry" }, method = RequestMethod.POST)
	public @ResponseBody Enquiry saveEmployee(@RequestParam("name") String name,
			@RequestParam("emailId") String emailId, @RequestParam("mobileNo") String mobileNo,
			@RequestParam("location") String location, @RequestParam("message") String message,
			@RequestParam("enqType") int enqType) {

		Enquiry enquiry = new Enquiry();
		Enquiry enq = new Enquiry();

		try {
			System.out.println("name " + name);
			System.out.println("emailId " + emailId);
			System.out.println("mobileNo " + mobileNo);
			System.out.println("location " + location);
			System.out.println("message " + message);
			System.out.println("enqType " + enqType);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();

			enquiry.setName(name);
			enquiry.setEmailId(emailId);
			enquiry.setMobileNo(mobileNo);
			enquiry.setLocation(location);
			enquiry.setMessage(message);
			enquiry.setEnqType(enqType);
			enquiry.setEnqDatetime(sf.format(date));
			enq = enquiryRepository.saveAndFlush(enquiry);

			ObjectMapper om = new ObjectMapper();
			String jsonStr = om.writeValueAsString(enq);
			if (enq == null) {

			} else {

				List<String> tokens = adminUserRepository.findTokens();

				try {
					for (String token : tokens) {
						if (token != null) {
							Firebase.sendPushNotifForCommunication(token, "Wizzo_ContactUs", jsonStr, "contactUs");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enq;

	}

	@RequestMapping(value = { "/enquiryByStatus" }, method = RequestMethod.POST)
	public @ResponseBody Enquiry enquiryByStatus(@RequestParam("status") int status) {

		Enquiry enquiry = new Enquiry();

		try {
			enquiry = enquiryRepository.findByStatus(status);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enquiry;

	}

	// ------------------------------------Buy Now--------------------

	@RequestMapping(value = { "/saveBuyNowDirect" }, method = RequestMethod.POST)
	public @ResponseBody BuyNow saveBuyNow(@RequestBody BuyNow buyNow) {

		BuyNow buy = new BuyNow();

		try {

			buy = buyNowRepository.saveAndFlush(buyNow);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return buy;

	}

	@RequestMapping(value = { "/saveBuyNow" }, method = RequestMethod.POST)
	public @ResponseBody BuyNow saveBuyNow(@RequestParam("name") String name, @RequestParam("emailId") String emailId,
			@RequestParam("address") String address, @RequestParam("city") String city,
			@RequestParam("state") String state, @RequestParam("pincode") String pincode,
			@RequestParam("orderQty") int orderQty) {

		System.out.println("name " + name);
		System.out.println("emailId " + emailId);
		System.out.println("address " + address);
		System.out.println("city " + city);
		System.out.println("state " + state);
		System.out.println("pincode " + pincode);
		System.out.println("orderQty " + orderQty);

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();

		BuyNow buyNow = new BuyNow();
		buyNow.setName(name);
		buyNow.setEmailId(emailId);
		buyNow.setAddress(address);
		buyNow.setCity(city);
		buyNow.setState(state);
		buyNow.setPincode(pincode);
		buyNow.setOrderQty(orderQty);
		buyNow.setOrderDatetime(sf.format(date));

		BuyNow buy = new BuyNow();

		try {

			buy = buyNowRepository.saveAndFlush(buyNow);

			ObjectMapper om = new ObjectMapper();
			String jsonStr = om.writeValueAsString(buy);
			if (buy == null) {

			} else {

				List<String> tokens = adminUserRepository.findTokens();

				try {
					for (String token : tokens) {
						if (token != null) {
							Firebase.sendPushNotifForCommunication(token, "Wizzo_ContactUs", jsonStr, "contactUs");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return buy;

	}

	@RequestMapping(value = { "/saveGetTouch" }, method = RequestMethod.POST)
	public @ResponseBody GetTouch saveGetTouch(@RequestParam("name") String name,
			@RequestParam("emailId") String emailId, @RequestParam("message") String message) {

		System.out.println("name " + name);
		System.out.println("emailId " + emailId);
		System.out.println("message " + message);

		GetTouch getTouch = new GetTouch();
		getTouch.setName(name);
		getTouch.setEmail(emailId);
		getTouch.setMessage(message);

		GetTouch touch = new GetTouch();

		try {

			touch = getTouchRepository.saveAndFlush(getTouch);

			ObjectMapper om = new ObjectMapper();
			String jsonStr = om.writeValueAsString(touch);
			if (touch == null) {

			} else {

				List<String> tokens = adminUserRepository.findTokens();

				try {
					for (String token : tokens) {
						if (token != null) {
							Firebase.sendPushNotifForCommunication(token, "Wizzo_ContactUs", jsonStr, "contactUs");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return touch;

	}

	@RequestMapping(value = { "/buyNowByStatus" }, method = RequestMethod.POST)
	public @ResponseBody BuyNow buyNowByStatus(@RequestParam("status") int status) {

		BuyNow buyNow = new BuyNow();

		try {
			buyNow = buyNowRepository.findByStatus(status);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return buyNow;

	}

	// ----------------------------------Order-------------------

	@RequestMapping(value = { "/getAllOrders" }, method = RequestMethod.GET)
	public @ResponseBody List<Order> getAllOrdersList() {

		List<Order> orderList = new ArrayList<Order>();

		try {

			orderList = (List<Order>) orderRepository.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return orderList;

	}

	// --------------------------------User-------------------

	@RequestMapping(value = { "/getAllUsersByUserIsUsed" }, method = RequestMethod.POST)
	public @ResponseBody List<User> getAllUsersByUserIsUsed(@RequestParam("userIsUsed") int userIsUsed) {

		List<User> userList = new ArrayList<User>();

		try {
			userList = userRepository.findAllByUserIsUsed(userIsUsed);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userList;

	}

	@RequestMapping(value = { "/saveUser" }, method = RequestMethod.POST)
	public @ResponseBody User saveUser(@RequestBody User User) {

		User user = new User();

		try {

			user = userRepository.saveAndFlush(User);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return User;

	}

	@RequestMapping(value = { "/saveUserPwd" }, method = RequestMethod.POST)
	public @ResponseBody UserPwd saveUserPwd(@RequestBody UserPwd UserPwd) {

		UserPwd userres = new UserPwd();

		try {
			System.out.println(UserPwd);
			userres = userPwdRepository.saveAndFlush(UserPwd);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userres;

	}

	@RequestMapping(value = { "/getDataByUserId" }, method = RequestMethod.POST)
	public @ResponseBody UserPwd getDataByUserId(@RequestParam("userId") int userId) {

		UserPwd user = new UserPwd();

		try {
			user = userPwdRepository.findByUserId(userId);
			if(user==null)
			{
				user = new UserPwd();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return user;

	}

	@RequestMapping(value = { "/getUserByMobileNo" }, method = RequestMethod.POST)
	public @ResponseBody User getUserByMobileNo(@RequestParam("userMobile") String userMobile) {

		User user = new User();

		try {
			user = userRepository.findByUserMobile(userMobile);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return user;

	}

	@RequestMapping(value = { "/checkMobileNo" }, method = RequestMethod.POST)
	public @ResponseBody User checkMobileNo(@RequestParam("userMobile") String userMobile) {

		User user = new User();

		try {
			user = userRepository.findByUserMobile(userMobile);
			if (user == null) {
				user = new User();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return user;

	}

	@RequestMapping(value = { "/getUserByUserId" }, method = RequestMethod.POST)
	public @ResponseBody User UserByUserId(@RequestParam("userId") int userId) {

		User user = new User();

		try {
			user = (User) userRepository.findByUserId(userId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return user;

	}

	@RequestMapping(value = { "/getAllUserListByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUserListByIsUsed() {

		List<User> userList = new ArrayList<User>();

		try {

			userList = userRepository.findAllByUserIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userList;

	}

	@RequestMapping(value = { "/getAllDevicesByUserId" }, method = RequestMethod.POST)
	public @ResponseBody List<DeviceByUserId> getAllDevicesByUserId(@RequestParam("userId") int userId) {

		List<DeviceByUserId> deviceByUserIdList = new ArrayList<DeviceByUserId>();

		try {
			deviceByUserIdList = deviceByUserIdRepository.findAllDevicesByUserId(userId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return deviceByUserIdList;

	}

	// -----------------------------------Support-----------------------------------

	@RequestMapping(value = { "/saveSupport" }, method = RequestMethod.POST)
	public @ResponseBody Support saveSupport(@RequestBody Support support) {

		Support sup = new Support();

		try {

			sup = supportRepository.saveAndFlush(support);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return sup;

	}

	@RequestMapping(value = { "/suppportByStatus" }, method = RequestMethod.POST)
	public @ResponseBody Support suppportByStatus(@RequestParam("status") int status) {

		Support suppport = new Support();

		try {
			suppport = supportRepository.findByStatus(status);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return suppport;

	}

	@RequestMapping(value = { "/getSupportById" }, method = RequestMethod.POST)
	public @ResponseBody Support getSupportById(@RequestParam("tokenId") int tokenId) {

		Support suppport = new Support();

		try {
			suppport = supportRepository.findByTokenId(tokenId);

		} catch (Exception e) {

			e.printStackTrace();
			suppport = new Support();

		}
		return suppport;

	}

	@RequestMapping(value = { "/resolvedListFromSupprt" }, method = RequestMethod.GET)
	public @ResponseBody List<GetSupportList> resolvedListFromSupprt() {

		List<GetSupportList> suppport = new ArrayList<GetSupportList>();

		try {

			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String fDate = sf.format(date) + " 00:00:00";
			String tDate = sf.format(date) + " 23:59:59";

			suppport = getSupportListRepository.resolvedListFromSupprt(fDate, tDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return suppport;

	}

	@RequestMapping(value = { "/pendingListFromSupprt" }, method = RequestMethod.GET)
	public @ResponseBody List<GetSupportList> pendingListFromSupprt() {

		List<GetSupportList> suppport = new ArrayList<GetSupportList>();

		try {

			suppport = getSupportListRepository.pendingListFromSupprt();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return suppport;

	}

	@RequestMapping(value = { "/getAllSupport" }, method = RequestMethod.GET)
	public @ResponseBody List<Support> getAllSupportList() {

		List<Support> supportList = new ArrayList<Support>();

		try {

			supportList = supportRepository.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return supportList;

	}

	@RequestMapping(value = { "/getAllSupportListByAssinedTo" }, method = RequestMethod.POST)
	public @ResponseBody List<Support> getAllSupportListByAssinedTo(@RequestParam("assignedTo") int assignedTo) {

		List<Support> supportList = new ArrayList<Support>();

		try {

			supportList = supportRepository.findByAssignedTo(assignedTo);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return supportList;

	}

	// --------------------------Employee----------------------------------

	@RequestMapping(value = { "/saveEmployee" }, method = RequestMethod.POST)
	public @ResponseBody Employee saveEmployee(@RequestBody Employee employee) {

		Employee emp = new Employee();

		try {

			emp = employeeRepository.saveAndFlush(employee);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return employee;

	}

	@RequestMapping(value = { "/empLogin" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponse findByEmpMobileAndEmpPassword(@RequestParam("empMobile") String empMobile,
			@RequestParam("empPassword") String empPassword) {

		Employee employee = employeeRepository.findByEmpMobileAndEmpPassword(empMobile, empPassword);

		LoginResponse loginResponse = new LoginResponse();

		if (employee == null) {
			employee = new Employee();
			loginResponse.setEmployee(employee);

			loginResponse.setError(true);
			loginResponse.setMsg("Invalid Login Details ");

		} else {

			loginResponse.setEmployee(employee);
			loginResponse.setError(false);
			loginResponse.setMsg("Login Successfully");
		}

		return loginResponse;
	}

	@RequestMapping(value = { "/getAllEmpList" }, method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmpList() {

		List<Employee> empList = new ArrayList<Employee>();

		try {

			empList = employeeRepository.findByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return empList;

	}

	// ---------------------------Employee Delete Action------------
	@RequestMapping(value = { "/deleteEmployee" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteEmployee(@RequestParam("empId") int empId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = employeeRepository.deleteEmployee(empId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" Deleted to Delete");

		}
		return errorMessage;

	}

	// -------------------------------UnActive User------------------------------

	@RequestMapping(value = { "/unActiveUser" }, method = RequestMethod.GET)
	public @ResponseBody List<User> unActiveUser() {

		List<User> userList = new ArrayList<User>();

		try {

			userList = userRepository.findAllUsersWithNoScanDevices();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userList;

	}

	// -------------------------------Device Delete Action------------
	@RequestMapping(value = { "/deleteDevice" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteDevice(@RequestParam("devId") int devId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			Device d = deviceRepository.findByDevId(devId);
			int delete = deviceRepository.deleteDeviceByMac(d.getDevMac());
			if (delete == 0) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" Deleted to Delete");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/deleteScanDevice" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteScanDevice(@RequestParam("devId") int devId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = scanDeviceRepository.removeByDevId(devId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" Deleted to Delete");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/deleteSchedulerById" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteScheduler(@RequestParam("schId") int schId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = schedulerRepository.removeBySchId(schId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" Deleted to Delete");

		}
		return errorMessage;

	}

	// -------------------------------User Delete Action------------
	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteUser(@RequestParam("userId") int userId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = userRepository.deleteUser(userId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("successfully Deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage(" Deleted to Delete");

		}
		return errorMessage;

	}

	// ---------------------------- User List Need Assistance----------------

	@RequestMapping(value = { "/userListNeedAssistance" }, method = RequestMethod.GET)
	public @ResponseBody List<User> userListNeedAssistance() {

		List<User> userList = new ArrayList<User>();

		try {

			userList = userRepository.findAllUsersWithscanDevicesNotInDevice();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userList;

	}

	// ---------------------------------Dashboard Count-------------------

	@RequestMapping(value = { "/getAllCount" }, method = RequestMethod.GET)
	public @ResponseBody DashboardCount getAllCount() {

		DashboardCount count = new DashboardCount();

		try {

			int totalUsers = userRepository.totalCountOfUsers();

			int totalNewOrders = orderRepository.totalCountOfOredrs();

			int totalIssues = supportRepository.totalPendingIssues();

			int totalDevices = deviceRepository.totalCountOfUsers();

			count.setTotalNoOfUsers(totalUsers);
			count.setDeviceCount(totalDevices);
			count.setTotalNewOrders(totalNewOrders);
			count.setTotalPendingIssues(totalIssues);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return count;

	}

	@RequestMapping(value = { "/userLogin" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponseUser userLogin(@RequestParam("userMobile") String userMobile,
			@RequestParam("userPassword") String userPassword) {

		UserPassword userPasswordRes = userPasswordRepository.findByUserMobileAndUserPassword(userMobile, userPassword);
		LoginResponseUser loginResponse = new LoginResponseUser();

		if (userPasswordRes == null) {
			userPasswordRes = new UserPassword();
			loginResponse.setUserPassword(userPasswordRes);

			loginResponse.setError(true);
			loginResponse.setMsg("Invalid Login Details ");

		} else {

			loginResponse.setUserPassword(userPasswordRes);
			loginResponse.setError(false);
			loginResponse.setMsg("Login Successfully");

		}

		return loginResponse;
	}

	@RequestMapping(value = { "/adminUserLogin" }, method = RequestMethod.POST)
	public @ResponseBody LoginResponseAdmin findByUserMobileAndUserPassword(
			@RequestParam("userMobile") String userMobile, @RequestParam("userPassword") String userPassword,
			@RequestParam("token") String token) {

		AdminUser adminUser = adminUserRepository.findByUserMobileAndUserPassword(userMobile, userPassword);

		LoginResponseAdmin loginResponse = new LoginResponseAdmin();

		if (adminUser == null) {
			adminUser = new AdminUser();
			loginResponse.setAdminUser(adminUser);

			loginResponse.setError(true);
			loginResponse.setMsg("Invalid Login Details ");

		} else {

			loginResponse.setAdminUser(adminUser);
			loginResponse.setError(false);
			loginResponse.setMsg("Login Successfully");

			int isUpdated = adminUserRepository.updateToken(adminUser.getUserId(), token);

		}

		return loginResponse;
	}

	@RequestMapping(value = { "/getRoomListByUsertId" }, method = RequestMethod.POST)
	public @ResponseBody List<TotalRoom> getRoomListByUsertId(@RequestParam("userId") int userId) {

		List<TotalRoom> roomList = new ArrayList<TotalRoom>();

		try {

			roomList = totalRoomRepository.findByUserIdAndRoomIsUsed(userId, 1);

			for (int i = 0; i < roomList.size(); i++) {
				List<Device> switchList = deviceRepository.findByRoomIdAndDevIsUsed(roomList.get(i).getRoomId(), 1);
				roomList.get(i).setDeviceList(switchList);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return roomList;

	}

}
