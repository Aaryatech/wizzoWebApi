package com.ats.wizzo.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.wizzo.model.BuyNow;
import com.ats.wizzo.model.DashboardCount;
import com.ats.wizzo.model.Device;
import com.ats.wizzo.model.DeviceByUserId;
import com.ats.wizzo.model.Employee;
import com.ats.wizzo.model.Enquiry;
import com.ats.wizzo.model.ErrorMessage;
import com.ats.wizzo.model.LoginResponse;
import com.ats.wizzo.model.Order;
import com.ats.wizzo.model.Support;
import com.ats.wizzo.model.User;
import com.ats.wizzo.respository.BuyNowRepository;
import com.ats.wizzo.respository.CountUsersRepository;
import com.ats.wizzo.respository.DeviceByUserIdRepository;
import com.ats.wizzo.respository.DeviceConuntRepository;
import com.ats.wizzo.respository.DeviceRepository;
import com.ats.wizzo.respository.EmployeeRepository;
import com.ats.wizzo.respository.EnquiryRepository;
import com.ats.wizzo.respository.OrderRepository;
import com.ats.wizzo.respository.RoomRepository;
import com.ats.wizzo.respository.ScanDeviceRepository;
import com.ats.wizzo.respository.SchedulerRepository;
import com.ats.wizzo.respository.SupportRepository;
import com.ats.wizzo.respository.TotalNewOrdersRepository;
import com.ats.wizzo.respository.TotalPendingIssuesRepository;
import com.ats.wizzo.respository.UserRepository;

@RestController
public class MasterController {

	@Autowired
	EnquiryRepository enquiryRepository;

	@Autowired
	BuyNowRepository buyNowRepository;

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
	CountUsersRepository countUsersRepository;

	@Autowired
	TotalNewOrdersRepository totalNewOrdersRepository;

	@Autowired
	TotalPendingIssuesRepository totalPendingIssuesRepository;

	@Autowired
	DeviceConuntRepository deviceConuntRepository;

	// ----------------------------------------Enquiry------------------------------------

	@RequestMapping(value = { "/saveEnquiry" }, method = RequestMethod.POST)
	public @ResponseBody Enquiry saveEmployee(@RequestBody Enquiry enquiry) {

		Enquiry enq = new Enquiry();

		try {

			enq = enquiryRepository.saveAndFlush(enquiry);

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

	@RequestMapping(value = { "/saveBuyNow" }, method = RequestMethod.POST)
	public @ResponseBody BuyNow saveBuyNow(@RequestBody BuyNow buyNow) {

		BuyNow buy = new BuyNow();

		try {

			buy = buyNowRepository.saveAndFlush(buyNow);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return buy;

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

			int totalUsers = countUsersRepository.totalCountOfUsers();

			int totalNewOrders = totalNewOrdersRepository.totalCountOfOredrs();

			int totalIssues = totalPendingIssuesRepository.totalPendingIssues();

			int totalDevices = deviceConuntRepository.totalCountOfUsers();
			count.setTotalNoOfUsers(totalUsers);
			count.setDeviceCount(totalDevices);

			count.setTotalNewOrders(totalNewOrders);

			count.setTotalPendingIssues(totalIssues);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return count;

	}

}