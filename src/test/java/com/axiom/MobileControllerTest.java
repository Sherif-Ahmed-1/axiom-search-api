package com.axiom;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.axiom.controller.MobileController;
import com.axiom.entity.MobileHandSet;
import com.axiom.service.SearchService;

@RunWith(SpringRunner.class)
@WebMvcTest(MobileController.class)
public class MobileControllerTest {
	@Autowired
	private MockMvc mvc;
	@MockBean
	private SearchService searchService;
	@Test
	public void getAllMobileHandSet() throws Exception {

		List<MobileHandSet> handSets = createMoblieHandSetList();
		given(searchService.searchForMobile(Mockito.any(Map.class))).willReturn(handSets);
		mvc.perform(get("/mobile/search?").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)));
	}


	private List<MobileHandSet> createMoblieHandSetList() {
		List<MobileHandSet> handSets = new ArrayList<>();
		MobileHandSet mobileHandSet = MobileHandSet.builder().brand("Apple").phone("Apple iPad Pro 12.9 (2018)")
				.picture("https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-129-2018.jpg").sim("Nano-SIM eSIM")
				.resolution("2048 x 2732 pixels").build();
		MobileHandSet mobileHandSet2 = MobileHandSet.builder().brand("Apple").phone("Apple iPad Pro 12.9 (2018)")
				.picture("https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-129-2018.jpg").sim("Nano-SIM eSIM")
				.resolution("2048 x 2732 pixels").build();
		handSets.add(mobileHandSet);
		handSets.add(mobileHandSet2);
		return handSets;
	}

}
