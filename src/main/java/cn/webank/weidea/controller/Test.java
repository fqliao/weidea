package cn.webank.weidea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.webank.weidea.dao.UserRepository;

@Controller
public class Test {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "aaa")
	@ResponseBody
	public String test(@RequestParam(name = "ddd", required = false) String ddd) {
		System.out.println(ddd);
		System.out.println("count=:" + userRepository.count());
		return "zzzz";
	}
}
