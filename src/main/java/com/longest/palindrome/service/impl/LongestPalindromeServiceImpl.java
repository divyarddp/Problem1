package com.longest.palindrome.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longest.palindrome.model.LongestPalindrome;
import com.longest.palindrome.repository.LongestPalindromeRepository;
import com.longest.palindrome.service.LongestPalindromeService;

@Service
public class LongestPalindromeServiceImpl implements LongestPalindromeService{

	@Autowired
	private LongestPalindromeRepository repository;
	
	@Override
	public String getLongestPalindrome(String input) {
		LongestPalindrome t = repository.findByInput(input);
		return t !=null ? t.getPalindrome():"Longest palindrom is not available in database.";
	}
	
	@Override
	public LongestPalindrome saveLongestPalindrome(String input) {
		boolean[][] dp = new boolean[input.length()][input.length()];

        int maxLength = 1;
        int startIndex = 0;
        for(int j = 1 ; j < input.length() ; j ++) {
            for(int i = 0; i <= j ; i ++) {
                if(input.charAt(i) == input.charAt(j)) {
                	int len = j - i + 1;
                    if(len <= 3) {
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }

                    if(dp[i][j] && len > maxLength) {
                        maxLength = len;
                        startIndex = i;
                    }
                	
                }else{
                    dp[i][j] = false;
                }
            }
        }

        String longest = input.substring(startIndex, startIndex + maxLength);
		return saveDetails(input,longest);
	}
	
	private LongestPalindrome saveDetails(String input , String longest) {
		LongestPalindrome t = new LongestPalindrome();
		t.setInput(input);
		t.setPalindrome(longest);
		return repository.save(t);
	}

}
