package br.com.rooting.roxana.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to swagger api documentation
 */
@Controller
public class SwaggerController {

	@RequestMapping(value = {"/", "/swagger", "/sandbox"})
	public String index(Model model) {
		return "/index.html";
	}
}
