package jp.co.test_gradle;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public String calc(int a, int b) {
		return String.valueOf(a * b);
	}

}
