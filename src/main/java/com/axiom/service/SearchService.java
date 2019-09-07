package com.axiom.service;

import java.util.List;
import java.util.Map;

import com.axiom.entity.MobileHandSet;

public interface SearchService {

	List<MobileHandSet> searchForMobile(Map<String, Object> predicate);

}
