package com.itb.suplementos.mrprotein2g.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/mrprotein/v1")
public class IndexController {

	@GetMapping("/index")
	public String index() {
	return"index";
	}

	@GetMapping("/p1")
	public String produto1() {
		return"produto1";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/criar")
	   public String criar() {
		   return "criarConta";
	   }
	
	@GetMapping("/home")
	public String home(){
		return "princi";
	}
	@GetMapping("/pc1")
	public String produto1c() {
		return"produto1c";
	}
   
	@GetMapping("/adm")
    public String adm() {
    return "adm";
   }
	
	@GetMapping("/produto")
	public String produto() {
		return "Cadastro-de-produtos";
	}
	


}
	
	
	


