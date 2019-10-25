package br.com.machadowelton.repos;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.com.machadowelton.models.Usuario;

public class Repo {
	
	
	public static List<Usuario> usuarios = Arrays.asList(
			Usuario.builder()
					.nomUsuario("Welton Machado")
					.datNascimento(new Date())
					.build(),
			Usuario.builder()
					.nomUsuario("Welton Machado")
					.datNascimento(new Date())
					.build()
		);
	
}
