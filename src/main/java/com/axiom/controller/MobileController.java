package com.axiom.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axiom.entity.MobileHandSet;
import com.axiom.service.SearchService;

@RestController
@RequestMapping("/mobile")
public class MobileController {

	private SearchService searchService;

	public MobileController(SearchService searchService) {
		super();
		this.searchService = searchService;
	}

	@GetMapping("/search")
	public ResponseEntity<List<MobileHandSet>> seachMoblie(@RequestParam Map<String, Object> params) {
		return ResponseEntity.ok(searchService.searchForMobile(params));
	}
}
