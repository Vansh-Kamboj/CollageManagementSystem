package com.example.demo.Frontpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class frontpageControl {
	@GetMapping("/apnacollage")
	public String LetsStart() {
		return "Frontpage_apnacollage";
	}
}
