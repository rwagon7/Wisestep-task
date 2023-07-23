package com.ws.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.Repository.DNSRepo;
import com.ws.document.Server;

@Service
public class RandomUrlService {

	private final DNSRepo repository;

	@Autowired
	RandomUrlService(DNSRepo repository) {
		this.repository = repository;
	}

	public String getShortUrl(String country) {
		List<Server> serverList = repository.getShortUrlBasedOnProximity(country).stream().collect(Collectors.toList());

		Random random = new Random();
		Server randomServer = serverList.get(random.nextInt(serverList.size()));

		if (randomServer.getUrl() == null)
			return null;
		return randomServer.getUrl();
	}

}
