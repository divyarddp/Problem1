package com.longest.palindrome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.longest.palindrome.model.LongestPalindrome;
import com.longest.palindrome.service.LongestPalindromeService;

@RestController
public class LongestPalindromeController {
	@Autowired
	private LongestPalindromeService longestPalindromeService;
	
	@PostMapping("/saveLongestPalindrome")
	public LongestPalindrome saveLongestPalindrome(@RequestBody String input) throws Exception {
		if(input ==null || input.length()>1000) {
			throw new Exception("Please try with less than 1000 characters");
		}
		return longestPalindromeService.saveLongestPalindrome(input);
	}
	
	@GetMapping("/getLongestPalindrome/{input}")
	public String getLongestPalindrome(@PathVariable("input") String input) {
		return longestPalindromeService.getLongestPalindrome(input);
	}

}
