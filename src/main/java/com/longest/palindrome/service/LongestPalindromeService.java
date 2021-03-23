package com.longest.palindrome.service;

import com.longest.palindrome.model.LongestPalindrome;

public interface LongestPalindromeService {

	LongestPalindrome saveLongestPalindrome(String input);

	String getLongestPalindrome(String input);

}
