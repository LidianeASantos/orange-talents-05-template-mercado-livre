package validaemail;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import usuario.Usuario;
import usuario.UsuarioRepository;
import usuario.UsuarioRequest;

@Component
public class ImpedeEmailDuplicado implements Validator {

	 @Autowired
	    UsuarioRepository usuarioRepository;
	 
	 	@Override
	    public boolean supports(Class<?> clazz) {
	        return UsuarioRequest.class.isAssignableFrom(clazz);
	    }

	 	@Override
	    public void validate(Object target, Errors errors) {
	        if (errors.hasErrors()) {
	            return;
	        }
	        UsuarioRequest request = (UsuarioRequest) target;
	        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(request.getEmail());

	        if (usuarioExistente.isPresent()) {
	            errors.rejectValue("email", null, "Email já cadastrado " + request.getEmail());
	        }

	    }
}
