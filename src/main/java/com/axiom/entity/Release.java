package com.axiom.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Release {
	private String announceDate;
	private Integer priceEur;
}
