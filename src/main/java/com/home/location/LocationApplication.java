package com.home.location;

import com.home.location.entities.Locataire;
import com.home.location.entities.Location;
import com.home.location.entities.Paiement;
import com.home.location.repositories.LocataireRepository;
import com.home.location.repositories.LocationRepository;
import com.home.location.repositories.PaiementRepository;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

@Log
@SpringBootApplication
public class LocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationApplication.class, args);
	}

	// a Method that is being executed every time the server runs
	// That's why we did repository.deleteAll() , to remove the old data and replace with new ones or else we will have
	// the same data persisted every time we launch the server.
	// TODO: after developping the services, change this method to use them instead of repositories.
	@Bean
	CommandLineRunner commandLineRunner(LocationRepository locationRepository,
										LocataireRepository locataireRepository,
										PaiementRepository paiementRepository) {
		return args -> {
			paiementRepository.deleteAll();
			locataireRepository.deleteAll();
			locationRepository.deleteAll();

			Locataire locataire = new Locataire();
			locataire.setCin("06950455");
			locataire.setFullName("Ala BEN KHLIFA");
			locataire.setNumTel(Collections.singletonList("50280400"));
//			locataireRepository.save(locataire);
			log.info(locataire.toString());

			// There is no need to save the entity locataire because we have a cascade type persist in the location entity
			// it will persist the locataire entity with the location entity

			Location location = new Location();
			location.setDateDebut(LocalDateTime.now(ZoneId.of("GMT+00:00")));
			location.setDateFin(LocalDateTime.now(ZoneId.of("GMT+00:00")).plusDays(10));
			// The locataire will be saved to the database
			location.setLocataire(locataire);
			location.setColor("#1e90ff");
			locationRepository.save(location);
			log.info(location.toString());

			Paiement paiement = new Paiement();
			paiement.setLocation(location);
			paiement.setMontant(50L);
			paiement.setDatePaiement(LocalDateTime.now(ZoneId.of("GMT+02:00")));
			paiementRepository.save(paiement);
			log.info(paiement.toString());
		};
	}
}
