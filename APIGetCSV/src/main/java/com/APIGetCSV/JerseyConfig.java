package com.APIGetCSV;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.resource.UsuarioResource;

@Component
public class JerseyConfig extends ResourceConfig {	
	public JerseyConfig()
    {
        register(UsuarioResource.class);
    }
}
