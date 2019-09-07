package com.axiom.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

import com.axiom.entity.MobileHandSet;
import com.axiom.exception.SystemException;
import com.axiom.exception.codes.ErrorCodes;
import com.axiom.repository.MobileHandSetRepo;
import com.axiom.wrapper.MobileHandsetClient;

@Configuration
public class DataIoader {
	@Autowired
	private MobileHandSetRepo handSetRepo;
	@Autowired
	private MobileHandsetClient handsetClient;
	/**
	 * 
	 * @author sherif
	 *	retreve dataset and insert data into mongodb
	 */
	@Bean
	CommandLineRunner initDB() {
		return (String... args) -> {
			List<MobileHandSet> handSets = handsetClient.getAllMobileHandset();
			if (CollectionUtils.isEmpty(handSets))
				throw new SystemException("failed to load data", HttpStatus.INTERNAL_SERVER_ERROR,
						ErrorCodes.FAILED_TO_LOAD_DATA);
			handSetRepo.saveAll(handSets);
		};
	}
}
