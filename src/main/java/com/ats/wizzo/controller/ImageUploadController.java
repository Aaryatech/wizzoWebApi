package com.ats.wizzo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class ImageUploadController {

	private static String PROFILE_FOLDER = "/opt/tomcat-latest/webapps/WizzoWebApi/uploads/";
	
	
	@RequestMapping(value = { "/fileUpload" }, method = RequestMethod.POST)
	public @ResponseBody Map getFarmerContract(@RequestParam("file") MultipartFile uploadfile, @RequestParam("imageName") String imageName) {

		Map<String, Object> myMap = new HashMap<String, Object>();

		System.out.println("File Name " + uploadfile.getOriginalFilename());

		try {
		//	String extension = uploadfile.getOriginalFilename().split("\\.")[1];

			saveUploadedFiles(Arrays.asList(uploadfile) , imageName);

			myMap.put("error", false);
			myMap.put("message", "success");
			myMap.put("imageName", imageName);

		} catch (IOException e) {

			e.printStackTrace();
			myMap.put("error", true);
			myMap.put("message", "fail , "+e.getMessage());
			myMap.put("imageName", "");

		}

		return myMap;
	}

	// save file
	private void saveUploadedFiles(List<MultipartFile> files, String imageName) throws IOException {

		for (MultipartFile file : files) {

			if (file.isEmpty()) {
				continue; 
			}

			Path path =Paths.get(PROFILE_FOLDER + imageName);
			
			byte[] bytes = file.getBytes();
			
			Files.write(path, bytes);

		}

	}

}
