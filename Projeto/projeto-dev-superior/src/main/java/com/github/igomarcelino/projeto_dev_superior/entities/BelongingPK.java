package com.github.igomarcelino.projeto_dev_superior.entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
/**
 * Essa classe ficara responsavel por fazer a associacao de muitos para muitos, pois
 * quando ha esse tipo de associacao devemos ter uma classe associativa. Porem o JpaRepository
 * nao aceita dois tipos de id, sendo assim estamos usando essa classe para gerar um id,
 * referenciando esse para um id que represente duas classes, no caso game_id e list_id
 * */
@Embeddable
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList gameList;


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BelongingPK that)) return false;

        if (getGame() != null ? !getGame().equals(that.getGame()) : that.getGame() != null) return false;
        return getGameList() != null ? getGameList().equals(that.getGameList()) : that.getGameList() == null;
    }

    @Override
    public int hashCode() {
        int result = getGame() != null ? getGame().hashCode() : 0;
        result = 31 * result + (getGameList() != null ? getGameList().hashCode() : 0);
        return result;
    }
}
