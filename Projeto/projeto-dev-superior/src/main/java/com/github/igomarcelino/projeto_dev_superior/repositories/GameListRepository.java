package com.github.igomarcelino.projeto_dev_superior.repositories;

import com.github.igomarcelino.projeto_dev_superior.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList,Long> {
}
