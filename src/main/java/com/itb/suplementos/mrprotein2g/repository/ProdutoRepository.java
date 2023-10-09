package com.itb.suplementos.mrprotein2g.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itb.suplementos.mrprotein2g.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>  {

}
