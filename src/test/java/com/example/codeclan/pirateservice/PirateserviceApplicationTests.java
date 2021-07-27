package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void createPirate(){
//		Pirate jack = new Pirate("Jack", "Sparrow", 32, ship);
//		pirateRepository.save(jack);
//	}

	@Test
	public void createPirateAndShip() {
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Raid raid = new Raid("Dalmarnock");
		raidRepository.save(raid);

		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship, raid);
		pirateRepository.save(pirate1);

		raid.addPirate(pirate1);
		raidRepository.save(raid);
	}
}
