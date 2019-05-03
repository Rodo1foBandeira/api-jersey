package com.resource;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Usuario;
import com.repo.IUsuarioRepo;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "usuario")
@Path("/usuario")
public class UsuarioResource {
	
	@Autowired
	IUsuarioRepo usuarioRepo;
	
	@GET
    @Produces("application/json")
    public List<Usuario> listarTodos() {
        return (List<Usuario>)usuarioRepo.findAll();
    }
}
