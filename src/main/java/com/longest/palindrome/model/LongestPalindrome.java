package com.longest.palindrome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LongestPalindrome {
	@Id
	@GeneratedValue
	private Long id;
	private String input;
	private String palindrome;
	public LongestPalindrome() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getPalindrome() {
		return palindrome;
	}
	public void setPalindrome(String palindrome) {
		this.palindrome = palindrome;
	}

}
