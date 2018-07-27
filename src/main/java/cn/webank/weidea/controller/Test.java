package cn.webank.weidea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {
	@RequestMapping(value = "aaa")
	@ResponseBody
	public String test(@RequestParam(name = "ddd", required = false) String ddd) {
		System.out.println(ddd);
		return "zzzz";
	}
}
