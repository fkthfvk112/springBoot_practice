package com.example.demo.controller;

import java.awt.image.DataBufferDouble;
import java.io.File;
import java.io.FileOutputStream;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.naver.NaverCloud;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class NaverCloudController {
	
	//음성 인식 wav -> String
	@PostMapping("fileUpload")
	public String fileUpload(@RequestParam("uploadFile")MultipartFile uploadFile,
			HttpServletRequest request) {
		System.out.println("NaverCloudController fileUpload ");
		
		//tomcat
		String uploadPath = request.getServletContext().getRealPath("/upload");
		
		//파일명 취득
		String filename = uploadFile.getOriginalFilename();
		String filepath = uploadPath + File.separator + filename;
		
		System.out.println(filepath);
		
		//fileupload
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			os.write(uploadFile.getBytes());
			os.close();
		}
		catch(Exception e) {
			return "file load fail";
		}

		//Naver Cloud;
		String respose = NaverCloud.processSTT(filepath);
		
		return respose;
	}
	
	
}
