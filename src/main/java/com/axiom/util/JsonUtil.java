package com.axiom.util;

import java.util.Map;

import com.axiom.entity.MobileHandSet;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static final ObjectMapper mapper = new ObjectMapper();
// cast map to Object
	public static MobileHandSet mapToMobile(Map<String, Object> obj) {
		return mapper.convertValue(obj, new TypeReference<MobileHandSet>() {
		});
	}
}
