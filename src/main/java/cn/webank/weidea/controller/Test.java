package cn.webank.weidea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
	@RequestMapping(value = "aaa")
	public String test() {
		return "zzzz";
	}
}
