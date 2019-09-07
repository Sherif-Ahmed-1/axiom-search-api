package com.axiom.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Hardware {
	private String audioJack;
	private String gps;
	private String battery;
}
