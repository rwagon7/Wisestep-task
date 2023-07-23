package com.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.service.RandomUrlService;
import com.ws.bean.Request;

@RestController
@CrossOrigin(origins = "*")
public class ShortURLGenController {

	private final RandomUrlService service;

	@Autowired
	public ShortURLGenController(RandomUrlService service) {
		this.service = service;
	}

	@CrossOrigin(origins = "*")
	@PostMapping("generateShortUrl")
	public ResponseEntity<String> createAnewShortUrl(@RequestBody Request request) {

		String response = this.service.getShortUrl(request.getLocation());
		if (response.equals(null)) {
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>(response, HttpStatus.OK);

	}
}