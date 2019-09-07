package com.axiom.wrapper;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.axiom.entity.MobileHandSet;
/**
 * 
 * @author sherif
 * restClient to retrieve mobilehandset db
 */
@FeignClient(name = "MobileHandsetClient", url = "${mobilehandset.url}")

public interface MobileHandsetClient {
	@GetMapping(value = "/bins/1f2r2v")
	public List<MobileHandSet> getAllMobileHandset();

}
