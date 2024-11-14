package com.github.igomarcelino.projeto_dev_superior.repositories;

import com.github.igomarcelino.projeto_dev_superior.entities.Game;
import com.github.igomarcelino.projeto_dev_superior.projections.GameMinProjetion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * JpaRepository possui diversos metodos implementados. entao nao ha necessidade de implementar os principais metodos
 * */

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
    List<GameMinProjetion> searchByList(Long listId);
}
