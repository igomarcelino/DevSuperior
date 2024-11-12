package com.github.igomarcelino.projeto_dev_superior.controllers;

import com.github.igomarcelino.projeto_dev_superior.dto.GameListDTO;
import com.github.igomarcelino.projeto_dev_superior.dto.GameMinDTO;
import com.github.igomarcelino.projeto_dev_superior.services.GameListService;
import com.github.igomarcelino.projeto_dev_superior.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    GameListService gameListService;

    @Autowired
    GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{id}/games")
    public List<GameMinDTO> findByList(@PathVariable Long id){
        return gameService.findByGameList(id);
    }
}
