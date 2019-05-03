package com.resource;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.ws.rs.core.Response;

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
    @Produces("application/csv")
    public Response listarTodos() {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(baos);		
		
		try {
			out.writeUTF("Id;Nome;Sobrenome;");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		List<Usuario> usuariosRp = (List<Usuario>)usuarioRepo.findAll();		
		usuariosRp.forEach(u ->
			{
				try {
					out.writeUTF(u.getId() + ";" +	u.getNome() + ";" +	u.getSobreNome() + ";");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		);
		
		return Response.ok(baos.toByteArray(), "application/csv")
				.header("content-disposition","attachment; filename = usuarios.csv")
				.build();
    }	

}