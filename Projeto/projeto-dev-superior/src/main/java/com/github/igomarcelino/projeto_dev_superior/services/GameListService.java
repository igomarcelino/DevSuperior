package com.github.igomarcelino.projeto_dev_superior.services;

import com.github.igomarcelino.projeto_dev_superior.dto.GameListDTO;
import com.github.igomarcelino.projeto_dev_superior.entities.GameList;
import com.github.igomarcelino.projeto_dev_superior.exceptions.ElementNotFoundException;
import com.github.igomarcelino.projeto_dev_superior.projections.GameMinProjetion;
import com.github.igomarcelino.projeto_dev_superior.repositories.GameListRepository;
import com.github.igomarcelino.projeto_dev_superior.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class GameListService {

    @Autowired
    GameListRepository gameListRepository;
    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        if (gameListRepository.findAll().isEmpty()){
            throw new ElementNotFoundException("A lista esta vazia");
        }else {
            return gameListRepository.
                    findAll().
                    stream().
                    map(gameList -> new GameListDTO(gameList)).
                    toList();
        }
    }
    @Transactional
    public void updatePosition(Long listId, int sourceIndex, int destinationIndex){

        List<GameMinProjetion> gameMinProjetions = gameRepository.searchByList(listId);
        GameMinProjetion obj = gameMinProjetions.remove(sourceIndex);
        gameMinProjetions.add(destinationIndex,obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex ;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex ;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId,gameMinProjetions.get(i).getId(),i);
        }

    }
}
