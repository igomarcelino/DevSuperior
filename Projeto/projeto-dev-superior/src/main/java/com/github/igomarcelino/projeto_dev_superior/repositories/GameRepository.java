package com.github.igomarcelino.projeto_dev_superior.repositories;

import com.github.igomarcelino.projeto_dev_superior.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository possui diversos metodos implementados. entao nao ha necessidade de implementar os principais metodos
 * */

public interface GameRepository extends JpaRepository<Game, Long> {
}
