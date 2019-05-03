package com.repo;

import org.springframework.data.repository.CrudRepository;

import com.model.Usuario;

public interface IUsuarioRepo extends CrudRepository<Usuario, Long>{

}
