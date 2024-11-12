package com.github.igomarcelino.projeto_dev_superior.services;

import com.github.igomarcelino.projeto_dev_superior.dto.GameMinDTO;
import com.github.igomarcelino.projeto_dev_superior.entities.Game;
import com.github.igomarcelino.projeto_dev_superior.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    /**
     * Aqui estamos retornando o DTO, seguindo o padrao de projeto
     * */
    public List<GameMinDTO> findAll(){
        return gameRepository.
                findAll().
                stream().
                map(game -> new GameMinDTO(game)).
                toList();
    }
}
