package com.github.igomarcelino.projeto_dev_superior.services;

import com.github.igomarcelino.projeto_dev_superior.dto.GameDTO;
import com.github.igomarcelino.projeto_dev_superior.dto.GameMinDTO;
import com.github.igomarcelino.projeto_dev_superior.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    /**
     * Aqui estamos retornando o DTO, seguindo o padrao de projeto
     * */
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        return gameRepository.
                findAll().
                stream().
                map(game -> new GameMinDTO(game)).
                toList();
    }

    /**
     * Aqui retornara um game com toda sua descricao
     * */
    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId){
       return gameRepository.
               findById(gameId).
               map(game -> new GameDTO(game)).
               get();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByGameList(Long listId){
        return gameRepository
                .searchByList(listId)
                .stream().
                map(gameMinProjetion -> new GameMinDTO(gameMinProjetion)).
                toList();

    }
}
