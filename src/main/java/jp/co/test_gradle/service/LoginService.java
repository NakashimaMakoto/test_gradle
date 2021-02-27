package jp.co.test_gradle.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public String calc(int a, int b) {
		return String.valueOf(a * b);
	}

}
