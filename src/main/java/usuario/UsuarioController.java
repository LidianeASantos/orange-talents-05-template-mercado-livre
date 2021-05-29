package usuario;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository; 
	
	@PostMapping
	@Transactional
	public String cadastra(@RequestBody @Valid UsuarioRequest usuarioRequest) {
		Usuario usuario = usuarioRequest.converter();
		usuarioRepository.save(usuario);
		return usuario.toString();
		
	}
}
