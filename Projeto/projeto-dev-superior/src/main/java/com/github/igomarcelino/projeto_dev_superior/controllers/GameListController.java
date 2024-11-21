package com.github.igomarcelino.projeto_dev_superior.controllers;

import com.github.igomarcelino.projeto_dev_superior.dto.GameListDTO;
import com.github.igomarcelino.projeto_dev_superior.dto.GameMinDTO;
import com.github.igomarcelino.projeto_dev_superior.dto.ReplacementDTO;
import com.github.igomarcelino.projeto_dev_superior.services.GameListService;
import com.github.igomarcelino.projeto_dev_superior.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
@Tag(name = "GameList")
public class GameListController {

    @Autowired
    GameListService gameListService;

    @Autowired
    GameService gameService;

    @GetMapping
    @Operation(summary = "Lista de games",description ="Retorna todas as listas")
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{id}/games")
    @Operation(summary = "Game Por lista", description = "Retorna todos os games presentes em uma lista")
    public List<GameMinDTO> findByList(@PathVariable Long id){
        return gameService.findByGameList(id);
    }

    @PostMapping(value = "/{listId}/replacement")
    @Operation(summary = "Alterar Posicao" ,description = "Altera a posicao dos jogos no banco de dados")
    public void move(@PathVariable Long listId,@RequestBody ReplacementDTO body){
        gameListService.updatePosition(listId, body.getSourceIndex(),body.getDestinationIndex());
    }
}
