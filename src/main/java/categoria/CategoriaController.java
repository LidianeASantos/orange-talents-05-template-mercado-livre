package categoria;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	 @PostMapping
	 @Transactional
	 public String cadastra(@RequestBody @Valid CategoriaRequest categoriaRequest) {
	       Categoria categoria = categoriaRequest.converter(categoriaRepository);
	       categoriaRepository.save(categoria);
	       return categoria.toString();
	    }
}
