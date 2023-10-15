package com.itb.suplementos.mrprotein2g.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

 import com.itb.suplementos.mrprotein2g.model.Produto;
import com.itb.suplementos.mrprotein2g.repository.ProdutoRepository;
 
 
 
 
@Controller
@RequestMapping("/mrprotein/produto")
public class ProdutoControler {
    
	@Autowired
	private ProdutoRepository produtoRepository;
	
  //carregar o forum  de cadastro
  @GetMapping("/novo-produto")
	public String NovoProduto(Produto produto,Model model) {
		
	  
	  model.addAttribute("produto",produto);
	  return "Cadastro-de-produtos";
	}
  
  
  
  //inserir produto
  @PostMapping("/add-produto")
  String addNovoProduto(Produto produto,Model model) {

	  produto.setCodStatusProduto(true);
	  Produto produtoDb = produtoRepository.save(produto);
	  
	  return "redirect:/mrprotein/produto/index";
	  
  }
  String showPageSucessoCadastro() {
	  return "/index";
  }
  
  @GetMapping("/sucesso-produto")
  String showPageSuccessCadastro() {
	  return "mrprotein/suceso-usuario";
	  
  }
  
}
