package jp.co.test_gradle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.test_gradle.form.LoginForm;
import jp.co.test_gradle.service.LoginService;

//@ContorollerでContorollerであることをSpringに登録する
@Controller
public class LoginController {

	@Autowired
	private LoginService service;

	//@RequestMappingでHTMLヵらどのsubmitに紐づいているか指定する
	//(value="/")は初期画面
	@RequestMapping(value = "/")
	public String index1(Model model) {
		//ModelはMVC間の値の受け渡しに必要なオブジェクト

		//model.addAttributeでkeyとvalueのセットでModelに値を登録できる
		//z今回はloginFormというkeyで、new LoginForm()して空のLoginFormを詰めている
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	//@RequestMapping(value="/")と同じ動き
	@RequestMapping(value = "/login")
	public String index2(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	//HTMLで『th:action="@{/result}"』とした先がここになる
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String indexFormSubmit(@ModelAttribute LoginForm loginForm, Model model) {
		//z引数に『@ModelAttribute LoginForm loginForm』をとる事で画面に入力された値がLoginFormに入った状態でもらえる

		String result = service.calc(loginForm.getA(), loginForm.getB());

		//modelに値の入ったLoginFormをいれてあげる。すると遷移先で値を使用することができる。
		model.addAttribute("loginForm", loginForm);
		model.addAttribute("result", result);
		return "result";
	}
}
