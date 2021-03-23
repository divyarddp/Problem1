package com.longest.palindrome.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.longest.palindrome.model.LongestPalindrome;

@Repository
public interface LongestPalindromeRepository extends CrudRepository<LongestPalindrome, Long>{

	LongestPalindrome findByInput(String input);

}
