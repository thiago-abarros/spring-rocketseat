package br.com.bunbismuth.todolist.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * O JpaRespository precisa de duas informações para funcionar
 * sendo a primeira a classe que o repositório está representando
 * e o segundo é o identificador da classe.
  */

public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUsername(String username);

}
