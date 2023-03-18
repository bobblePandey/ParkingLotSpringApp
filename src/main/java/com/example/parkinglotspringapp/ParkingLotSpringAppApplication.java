package com.example.parkinglotspringapp;

import com.example.parkinglotspringapp.Services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;

@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class})
public class ParkingLotSpringAppApplication implements CommandLineRunner {

	ParkingLotService service;

	@Autowired
	ParkingLotSpringAppApplication(ParkingLotService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(ParkingLotSpringAppApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		service.createParkingLot();
	}
}
