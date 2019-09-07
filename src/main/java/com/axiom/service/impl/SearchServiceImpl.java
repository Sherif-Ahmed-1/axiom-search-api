package com.axiom.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.axiom.entity.MobileHandSet;
import com.axiom.exception.BusinessException;
import com.axiom.exception.codes.ErrorCodes;
import com.axiom.repository.MobileHandSetRepo;
import com.axiom.service.SearchService;
import com.axiom.util.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SearchServiceImpl implements SearchService {

	private MobileHandSetRepo handSetRepo;

	public SearchServiceImpl(MobileHandSetRepo handSetRepo) {
		this.handSetRepo = handSetRepo;
	}

	/*
	 * @author Sherif Ahmed
	 * 
	 * @param Map contain query params
	 * 
	 * @throws BusinessException in case of no records found
	 * 
	 * @returns list of matched elements
	 */
	@Override
	public List<MobileHandSet> searchForMobile(Map<String, Object> params) {

		MobileHandSet handSet = JsonUtil.mapToMobile(params);
		Example<MobileHandSet> example = Example.of(handSet);
		List<MobileHandSet> handSets = StreamSupport.stream(handSetRepo.findAll(example).spliterator(), false)
				.collect(Collectors.toList());
		if (CollectionUtils.isEmpty(handSets))
			throw new BusinessException("no matching record found", HttpStatus.NOT_FOUND, ErrorCodes.NO_RECORDS_FOUND);
		return handSets;
	}

}
