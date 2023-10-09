package com.itb.suplementos.mrprotein2g.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Produto")

public class Produto {

    @Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-incremento
	private Long Id;
  
	private String  categoria;
    private String  nome;
    private String  descricao;
    private double  preco;
    private boolean codStatusProduto;
    
     // setter e getters

    public Long getId() {
		return Id;
	}
	
    public void setId(Long id)
    {
	
    	this.Id = id;	
    }
	
	
	

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getDescricao() 
	{
		return descricao;
	}
	
	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}
	
	public double getPreco() 
	{
		return preco;
	}
	
	public void setPreco(double preco) 
	{
		this.preco = preco;
	}
	
	public boolean getCodStatusProduto() 
	{
		return codStatusProduto;
	}
	
	public void setCodStatusProduto(boolean codStatusProduto) 
	{
		this.codStatusProduto = codStatusProduto;
	}
    
        
}
