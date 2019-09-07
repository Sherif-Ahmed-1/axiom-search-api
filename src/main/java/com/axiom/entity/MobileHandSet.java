package com.axiom.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class MobileHandSet {
	@Id
	private Long id;
	private String brand;
	private String phone;
	private String picture;
	@Embedded
	private Release release;
	private String sim;
	private String resolution;
	@Embedded
	private Hardware hardware;

	@JsonProperty("priceEur")
	public void setPriceEur(Integer price) {
		if (release == null)
			release = new Release();
		release.setPriceEur(price);

	}

	@JsonProperty("announceDate")
	public void setAnnounceDate(String announceDate) {
		if (release == null)
			release = new Release();
		release.setAnnounceDate(announceDate);

	}

	@JsonProperty("audioJack")
	public void setAudioJack(String audioJack) {
		if (hardware == null)
			hardware = new Hardware();
		hardware.setAudioJack(audioJack);
	}

	@JsonProperty("gps")
	public void setGps(String gps) {
		if (hardware == null)
			hardware = new Hardware();
		hardware.setGps(gps);

	}

	@JsonProperty("battery")
	public void setBattery(String battery) {
		if (hardware == null)
			hardware = new Hardware();
		hardware.setBattery(battery);

	}
}
