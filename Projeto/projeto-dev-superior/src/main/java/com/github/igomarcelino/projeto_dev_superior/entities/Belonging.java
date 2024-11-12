package com.github.igomarcelino.projeto_dev_superior.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    BelongingPK id = new BelongingPK();
    private Integer position;

    public Belonging() {
    }

    public Belonging(Game game,GameList gameList, Integer position) {

        id.setGame(game);
        id.setGameList(gameList);
        this.position = position;
    }
}
