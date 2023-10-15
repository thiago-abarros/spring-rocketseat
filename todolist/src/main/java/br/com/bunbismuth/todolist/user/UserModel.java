package br.com.bunbismuth.todolist.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
// Podemos também utilizar a funcionalidade dos Records do java para criar a mesma classe

// @Data vai colocar automaticamente todos os getters e setters
@Data
@Entity(name="tb_users")
public class UserModel {
    // Chave primária dos usuários, que é uma chave única para cada usuário
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    /**
     * Caso seja necessário mudar o nome de uma coluna no banco de dados, podemos utilizar o
     * @Column para mudar o nome da coluna respectiva ao atributo para o que desejarmos.
     * Por exemplo, se quisermos mudar a coluna username para "Usuario", podemos fazer assim:
     * @Column(name = "Usuario")
     */

    // Basicamente obriga que para ser inserido no banco, tem que ser um valor único.
    @Column(unique = true)
    private String username;
    private String name;
    private String password;

    // Quando o dado for gerado, de forma automática o BD já vai ter essa informação de quando foi criado
    @CreationTimestamp
    private LocalDateTime createdAt;
}
