package br.com.bunbismuth.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
// Localização das requests será definida da seguinte forma:
// http://localhost:8080/users para esse Controller.
public class UserController {
    /**
     * Métodos de acesso HTTP
     * GET    - Buscar uma informação
     * POST   - Adicionar um dado/informação
     * PUT    - Alterar uma informação/dado
     * DELETE - Remover um dado/informação
     * PATCH  - Alterar somente uma parte do dado/informação
     */

    // Podemos alterar aqui também para ser uma rota específica que possui esse get, como por exemplo alterar para
    // @GetMapping("/primeiroMetodo")

    /**
     * Para pegarmos as informações do usuário, precisamos
     * explicitar ao Spring que estamos pegando do corpo da requisição,
     * por isso utilizamos o @RequestBody
     */

    // Quando passamos um repositório, temos que inicializar ele se não ele será passado como nulo por default.
    // Com o Spring podemos utilizar a anotação @Autowired que gerenciar o ciclo de vida do userRepository.
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel){
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if (user != null){
            // Status Code e Mensagem de erro
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }
        // o método save retorna a entidade que foi criada no banco de dados, por isso, podemos alocar ela em uma variável
        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
