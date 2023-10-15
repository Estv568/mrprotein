package com.itb.suplementos.mrprotein2g.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.EnumSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itb.suplementos.mrprotein2g.enums.EnumatProd;
import com.itb.suplementos.mrprotein2g.model.Produto;
import com.itb.suplementos.mrprotein2g.repository.ProdutoRepository;

@Controller
@RequestMapping("/mrprotein/produto")
public class ProdutoController {
 
    private ProdutoRepository produtoRepository;
    
    private String imagen = "";
    
    private Object categoria;
    
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/todos-produtos")
    public String todosProdutos(Model model){
        model.addAttribute("produtos", produtoRepository.findAll());
        return "produtos";
    }

    @GetMapping("/novo-produto")
    public String novoProduto(Produto prod, Model model) {
        model.addAttribute("prod", prod);
        model.addAttribute("categoria", categoria);
        return "Cadastro-de-produtos";
    }

    @GetMapping("/add-produto")
    public String gravarnovoproduto(Produto prod, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Cadastro-de-produtos";
        }
        prod.setCodStatusProduto("Ativo");
        produtoRepository.save(prod);
        return "redirect:/mrprotein/v1/produto/todos-produtos";
    }

    @GetMapping("/todos")
    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/editar-prod/{id}")
    public String showUpdateForm(@PathVariable("id") long id, ModelMap model) {
        Produto prod = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid prod Id:" + id));
        if (prod.getImagen() != null) {
            imagen = Base64.getEncoder().encodeToString(prod.getImagen());
        }
        model.addAttribute("prod", prod);
        model.addAttribute("categoria", EnumatProd.values());
        model.addAttribute("imagen", imagen);
        
        return "editar-prod";    
    }

     @PostMapping("/update/{id}")
     public String atualizarprod(@RequestParam(value = "file", required = false) MultipartFile file,
         @PathVariable("id") long id,
         @ModelAttribute("prod") Produto prod,
         BindingResult result) {
         if (result.hasErrors()) {
             prod.setId(id);
             return "editar-prod";
         }
         if (file != null && !file.getOriginalFilename().isEmpty()) {
             try {
                 prod.setImagen(file.getBytes());
             } catch (IOException e) {
                 e.getStackTrace();
             }
         } else {
             prod.setImagen(null);
         }
         produtoRepository.save(prod);
         return "redirect:/mrprotein/v1/produto/todos-produtos";
     }

    @GetMapping
    public String update(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message",
            "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/";
    }

    /*
    @PatchMapping("/atualizar/{id}")
    public String atualizar(@PathVariable("id") int id, Produto prod, BindingResult result, Model model) {

        if (result.hasErrors()) {
            prod.setId(id);
            return "editar-prod";
        }
        produtoRepository.save(prod);
        return "redirect:/api/v1/index";
    }
    */

    List<String> categorias = carregarAtributos();

    private List<String> carregarAtributos() {
        List<EnumatProd> lista = Arrays.asList(EnumatProd.values());
        List<String> retorno = new ArrayList<String>();
        for (int i = 0; i < lista.size(); i++) {
            retorno.add(lista.get(i).toString());
        }
        return retorno;
    }
    
    public List<EnumatProd> carregarAtributos2(){
        return Arrays.asList(EnumatProd.values());
    }
    
    public EnumSet<EnumatProd> listarAtributos(){
        return EnumSet.allOf(EnumatProd.class);
    }
}
