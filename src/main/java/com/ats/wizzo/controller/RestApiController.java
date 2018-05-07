package com.ats.wizzo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ats.wizzo.model.Device;
import com.ats.wizzo.model.Order;
import com.ats.wizzo.model.Room;
import com.ats.wizzo.model.ScanDevices;
import com.ats.wizzo.model.Scheduler;
import com.ats.wizzo.model.User;
import com.ats.wizzo.respository.DeviceRepository;
import com.ats.wizzo.respository.OrderRepository;
import com.ats.wizzo.respository.RoomRepository;
import com.ats.wizzo.respository.ScanDeviceRepository;
import com.ats.wizzo.respository.SchedulerRepository;
import com.ats.wizzo.respository.UserRepository;
import com.ats.wizzo.util.AuthKeyGenerator;

@RestController
public class RestApiController {

	private String TAG = "RestAPiController";

	@Autowired
	UserRepository userRepository;

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	SchedulerRepository schedulerRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	ScanDeviceRepository scanDeviceRepository;

	@Autowired
	OrderRepository orderRepository;

	// USER
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Map registerNewUser(@RequestBody User user) {

		Map<String, Object> myMap = new HashMap<String, Object>();

		AuthKeyGenerator authKeyGenerator = new AuthKeyGenerator();
		String authKey = authKeyGenerator.randomUUID(32);

		// System.out.println("auth key " + authKey);

		user.setAuthKey(authKey);

		try {

			User prevUser = userRepository.findByUserMobile(user.getUserMobile());

			if (prevUser == null) {
				User userResult = userRepository.save(user);
				myMap.put("error", false);
				myMap.put("message", "success");
				myMap.put("user", userResult);
			} else {

				user = new User();
				myMap.put("error", true);
				myMap.put("message", "User is already register");
				myMap.put("user", user);

			}

		} catch (Exception e) {

			user = new User();
			myMap.put("error", true);
			myMap.put("message", "Failed to register");
			myMap.put("user", user);

		}

		return myMap;
	}

	// USER
	@RequestMapping(value = "/updateUserProfile", method = RequestMethod.POST)
	public Map updateUserProfile(@RequestBody User user) {

		Map<String, Object> myMap = new HashMap<String, Object>();

		try {

			User userResult = userRepository.save(user);
			myMap.put("error", false);
			myMap.put("message", "success");
			myMap.put("user", userResult);

		} catch (Exception e) {

			user = new User();
			myMap.put("error", true);
			myMap.put("message", "Failed to update");
			myMap.put("user", user);

		}

		return myMap;
	}

	@RequestMapping(value = "/getUserDetails", method = RequestMethod.POST)
	public Map getUserDetails(@RequestParam int userId) {

		Map<String, Object> myMap = new HashMap<String, Object>();

		try {

			User prevUser = userRepository.findByUserId(userId);

			if (prevUser == null) {
				prevUser = new User();
				myMap.put("error", true);
				myMap.put("message", "No user found");
				myMap.put("user", prevUser);
			} else {

				myMap.put("error", false);
				myMap.put("message", "success");
				myMap.put("user", prevUser);

			}

		} catch (Exception e) {

			User prevUser = new User();
			myMap.put("error", true);
			myMap.put("message", "Failed to register");
			myMap.put("user", prevUser);

		}

		return myMap;
	}

	// SCAN Devices

	@RequestMapping(value = "/getScanDevices", method = RequestMethod.POST)
	public Map getScanDevices(@RequestParam int userId) {

		Map<String, Object> myMap = new HashMap<String, Object>();

		try {
			List<ScanDevices> scanDeviceList = scanDeviceRepository.findByUserId(userId);

			if (scanDeviceList == null) {
				scanDeviceList = new ArrayList<ScanDevices>();
				myMap.put("error", true);
				myMap.put("message", "No user found");
				myMap.put("scanList", scanDeviceList);
			} else {
				myMap.put("error", false);
				myMap.put("message", "success");
				myMap.put("scanList", scanDeviceList);

			}

		} catch (Exception e) {

			List<ScanDevices> scanDeviceList = new ArrayList<ScanDevices>();
			myMap.put("error", true);
			myMap.put("message", "Failed to register");
			myMap.put("scanList", scanDeviceList);

		}

		return myMap;
	}

	@RequestMapping(value = "/addNewScanDevice", method = RequestMethod.POST)
	public Map addNewScanDevice(@RequestBody ScanDevices scanDevices) {

		Map<String, Object> myMap = new HashMap<String, Object>();

		try {

			ScanDevices prevDevice = null;
			try {
				prevDevice = scanDeviceRepository.findByDevMac(scanDevices.getDevMac());

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (prevDevice != null) {
				scanDevices.setDevId(prevDevice.getDevId());

			}
			ScanDevices device = scanDeviceRepository.save(scanDevices);
			myMap.put("error", false);
			myMap.put("message", "success");
			myMap.put("device", device);
		} catch (Exception e) {
			ScanDevices device = new ScanDevices();
			myMap.put("error", true);
			myMap.put("message", "Failed to add");
			myMap.put("device", device);

		}

		return myMap;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map registerNewUser(@RequestParam String userMob, @RequestParam String userOtp) {

		Map<String, Object> myMap = new HashMap<String, Object>();

		User user = userRepository.findByUserMobile(userMob);

		if (user == null) {
			user = new User();
			myMap.put("error", true);
			myMap.put("message", "no records found");
			myMap.put("user", user);

		} else {
			myMap.put("error", false);
			myMap.put("message", "success");
			myMap.put("user", user);

			final String uri = "http://control.bestsms.co.in/api/sendhttp.php";

			RestTemplate restTemplate = new RestTemplate();

			MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();

			map.add("authkey", "205288AM46YxkjGuf5ab3ac31");
			map.add("mobiles", userMob);
			map.add("message", "Your OTP for Wizzo login is " + userOtp
					+ " . Please don't share your OTP with anyone.\n-Team Wizzo");
			map.add("sender", "TWIZZO");
			map.add("route", "4");

			String result = restTemplate.postForObject(uri, map, String.class);
			if (!result.isEmpty()) {
				System.out.println(result);
			}

		}

		return myMap;
	}

	// DEVICE

	@RequestMapping(value = "/uploadDeviceData", method = RequestMethod.POST)
	public Map dataUpload(@RequestBody List<Device> deviceList) {

		// System.out.println("deviceList " + deviceList.toString());

		Map<String, Object> myMap = new HashMap<String, Object>();

		try {

			for (Device device : deviceList) {

				Device deviceResult = deviceRepository.findByDevMacAndDevType(device.getDevMac(), device.getDevType());

				if (deviceResult != null) {
					device.setDevId(deviceResult.getDevId());
				}

				deviceRepository.save(device);
			}

			myMap.put("error", false);
			myMap.put("message", "success");

		} catch (Exception e) {
			e.printStackTrace();
			myMap.put("error", true);
			myMap.put("message", e.getMessage());
		}
		return myMap;
	}

	@RequestMapping(value = "/getDeviceDataByUserId", method = RequestMethod.POST)
	public Map dataUpload(@RequestParam int userId) {

		Map<String, Object> myMap = new HashMap<String, Object>();

		try {
			List<Device> deviceList = deviceRepository.findByUserId(userId);

			if (deviceList.isEmpty()) {

				deviceList = new ArrayList<>();

				myMap.put("error", true);
				myMap.put("message", "No devices found");
				myMap.put("deviceList", deviceList);

			} else {
				myMap.put("error", false);
				myMap.put("message", "success");
				myMap.put("deviceList", deviceList);
			}

		} catch (Exception e) {
			e.printStackTrace();
			myMap.put("error", true);
			myMap.put("message", e.getMessage());
		}
		return myMap;
	}

	// SCHEDULER
	@RequestMapping(value = "/addNewScheduler", method = RequestMethod.POST)
	public Map addNewScheduler(@RequestBody Scheduler scheduler) {

		// System.out.println("scheduler List " + scheduler.toString());

		Map<String, Object> myMap = new HashMap<String, Object>();

		Scheduler resScheduler = new Scheduler();
		List<Scheduler> schedulerList = new ArrayList<>();

		try {
			resScheduler = schedulerRepository.save(scheduler);
			schedulerList = schedulerRepository.findByUserIdAndDevMacAndDevType(scheduler.getUserId(),
					scheduler.getDevMac(), scheduler.getDevType());

			myMap.put("error", false);
			myMap.put("message", "success");
			myMap.put("schedulerList", schedulerList);

		} catch (Exception e) {
			e.printStackTrace();

			myMap.put("error", true);
			myMap.put("message", e.getMessage());
			myMap.put("schedulerList", schedulerList);
		}

		return myMap;
	}

	@RequestMapping(value = "/updateScheduler", method = RequestMethod.POST)
	public Map updateScheduler(@RequestBody Scheduler scheduler) {

		// System.out.println("scheduler List " + scheduler.toString());

		Map<String, Object> myMap = new HashMap<String, Object>();

		try {
			schedulerRepository.save(scheduler);

			myMap.put("error", false);
			myMap.put("message", "success");

		} catch (Exception e) {
			e.printStackTrace();
			myMap.put("error", true);
			myMap.put("message", e.getMessage());
		}
		return myMap;
	}

	@RequestMapping(value = "/deleteScheduler", method = RequestMethod.POST)
	public Map deleteScheduler(@RequestBody Scheduler scheduler) {

		System.out.println("scheduler List " + scheduler.toString());

		Map<String, Object> myMap = new HashMap<String, Object>();

		try {
			schedulerRepository.delete(scheduler);

			myMap.put("error", false);
			myMap.put("message", "success");

		} catch (Exception e) {
			e.printStackTrace();
			myMap.put("error", true);
			myMap.put("message", e.getMessage());
		}
		return myMap;
	}

	@RequestMapping(value = "/getSchedulerList", method = RequestMethod.POST)
	public Map getSchedulerList(@RequestParam int userId, @RequestParam String mac, @RequestParam int type) {

		Map<String, Object> myMap = new HashMap<String, Object>();

		List<Scheduler> schedulerList = new ArrayList<>();
		try {
			schedulerList = schedulerRepository.findByUserIdAndDevMacAndDevType(userId, mac, type);

			myMap.put("error", false);
			myMap.put("message", "success");
			myMap.put("schedulerList", schedulerList);

		} catch (Exception e) {
			e.printStackTrace();
			myMap.put("error", true);
			myMap.put("message", e.getMessage());
			myMap.put("schedulerList", schedulerList);
		}
		return myMap;
	}

	// ROOM
	@RequestMapping(value = "/addNewRoom", method = RequestMethod.POST)
	public Map addNewRoom(@RequestBody Room room) {

		Map<String, Object> myMap = new HashMap<String, Object>();

		Room resultRoom = roomRepository.save(room);

		if (resultRoom == null) {

			resultRoom = new Room();
			myMap.put("error", true);
			myMap.put("message", "failed");
			myMap.put("room", resultRoom);

		} else {
			myMap.put("error", false);
			myMap.put("message", "success");
			myMap.put("room", resultRoom);

		}

		return myMap;
	}

	@RequestMapping(value = "/deleteRoom", method = RequestMethod.POST)
	public Map deleteRoom(@RequestParam int id) {

		Map<String, Object> myMap = new HashMap<String, Object>();

		try {
			roomRepository.delete(id);

			myMap.put("error", false);
			myMap.put("message", "success");

		} catch (Exception e) {
			myMap.put("error", true);
			myMap.put("message", "failed");
		}

		return myMap;
	}

	@RequestMapping(value = "/getRoomListByUserId", method = RequestMethod.POST)
	public Map getRoomListByUserId(@RequestParam int userId) {

		Map<String, Object> myMap = new HashMap<String, Object>();

		List<Room> roomList = roomRepository.findByUserId(userId);

		if (!roomList.isEmpty()) {

			myMap.put("error", false);
			myMap.put("message", "success");
			myMap.put("roomList", roomList);
		} else {
			roomList = new ArrayList<>();

			Room room1 = new Room();
			room1.setRoomName("Living Room");
			room1.setRoomIsUsed(1);
			room1.setRoomIcon("LR");
			room1.setUserId(userId);
			roomRepository.save(room1);

			Room room2 = new Room();
			room2.setRoomName("Master Bedroom");
			room2.setRoomIsUsed(1);
			room2.setRoomIcon("MB");
			room2.setUserId(userId);
			roomRepository.save(room2);

			Room room3 = new Room();
			room3.setRoomName("Kitchen");
			room3.setRoomIsUsed(1);
			room3.setRoomIcon("K");
			room3.setUserId(userId);
			roomRepository.save(room3);

			Room room4 = new Room();
			room4.setRoomName("Bedroom");
			room4.setRoomIsUsed(1);
			room4.setRoomIcon("B");
			room4.setUserId(userId);
			roomRepository.save(room4);

			roomList = roomRepository.findByUserId(userId);
			myMap.put("error", false);
			myMap.put("message", "success");
			myMap.put("roomList", roomList);
		}

		return myMap;
	}

	@RequestMapping(value = "/updateRoom", method = RequestMethod.POST)
	public Map updateRoom(@RequestBody Room room) {

		Map<String, Object> myMap = new HashMap<String, Object>();

		roomRepository.save(room);

		if (room == null) {

			myMap.put("error", true);
			myMap.put("message", "fail");
		} else {
			myMap.put("error", false);
			myMap.put("message", "success");
		}

		return myMap;
	}

	// ORDER

	@RequestMapping(value = "/newOrder", method = RequestMethod.POST)
	public Map newOrder(@RequestBody Order order) {

		Map<String, Object> myMap = new HashMap<String, Object>();

		Order orderResult = orderRepository.save(order);

		if (orderResult == null) {

			myMap.put("error", true);
			myMap.put("message", "failed");

		} else {
			myMap.put("error", false);
			myMap.put("message", "success");

		}

		return myMap;
	}

}
