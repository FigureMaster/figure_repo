package com.study.figure.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.figure.service.SearchService;

@RestController
public class SearchController {

	@Autowired
	private SearchService searchService;

	@GetMapping("/search")
	public ResponseEntity<Map<String, Object>> integratedSearch(@RequestParam String token, @RequestParam String searchKeyword) throws Exception {
		ResponseEntity<Map<String, Object>> rs = null;

		try {
			Map<String, Object> result = searchService.integratedSearch(token, searchKeyword);
			rs = new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			rs = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return rs;
	}

	@GetMapping("/search/user/{userId}")
	public ResponseEntity<Map<String, Object>> userSearch(@PathVariable Long userId, @RequestParam String token) throws Exception {
		ResponseEntity<Map<String, Object>> rs = null;

		try {
			Map<String, Object> result = searchService.userSearch(userId, token);
			rs = new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			rs = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}

		return rs;
	}
}
