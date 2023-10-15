package com.itb.suplementos.mrprotein2g.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.itb.suplementos.mrprotein2g.enums.EnumatProd;


@Entity
@Table(name="Produto")

public class Produto {

    @Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-incremento
	private Long Id;
  
    private String  nome;
    private String  descricao;
    //private String imagen;
  
    @Column (columnDefinition = "VARBINARY(max)")
    private double  preco;    
    private byte[] imagen;    

    @Enumerated(EnumType.STRING)    
	private EnumatProd  categoriaProd;

    private String codStatusProduto;  
     // setter e getters


	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public Long getId() {
		return Id;
	}
	
    public void setId(Long id)
    {
	
    	this.Id = id;	
    }
	
	
	


	
	public EnumatProd getCategoriaProd() {
		return categoriaProd;
	}

	public void setCategoriaProd(EnumatProd categoriaProd) {
		this.categoriaProd = categoriaProd;
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

	public String getCodStatusProduto() {
		return codStatusProduto;
	}

	public void setCodStatusProduto(String codStatusProduto) {
		this.codStatusProduto = codStatusProduto;
	}
	
	
        
}
