package usuario;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;



public class UsuarioRequest {

		@NotBlank
	    @Email
	    private String email;

	    @NotBlank @Length(min = 6)
	    private String senha;


	    public String getEmail() {
	        return email;
	    }

	    public String getSenha() {
	        return senha;
	    }

	    public Usuario converter() {
	        return new Usuario(this.email, this.senha);
	    }
	    
	 
}

	

