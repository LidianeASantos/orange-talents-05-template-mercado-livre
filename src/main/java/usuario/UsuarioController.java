package usuario;


import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import validaemail.ImpedeEmailDuplicado;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
    UsuarioRepository usuarioRepository;
	
	@Autowired
    ImpedeEmailDuplicado impedeEmailDuplicado;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(impedeEmailDuplicado);
    }


    @PostMapping
    @Transactional
    public String cadastra(@RequestBody @Valid UsuarioRequest UsuarioRequest) {
        Usuario usuario = UsuarioRequest.converter();
        usuarioRepository.save(usuario);
        return usuario.toString();
    }
}
