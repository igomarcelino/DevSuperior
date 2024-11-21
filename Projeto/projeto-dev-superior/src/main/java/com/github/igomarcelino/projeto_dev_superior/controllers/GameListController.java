package com.github.igomarcelino.projeto_dev_superior.controllers;

import com.github.igomarcelino.projeto_dev_superior.dto.GameListDTO;
import com.github.igomarcelino.projeto_dev_superior.dto.GameMinDTO;
import com.github.igomarcelino.projeto_dev_superior.dto.ReplacementDTO;
import com.github.igomarcelino.projeto_dev_superior.services.GameListService;
import com.github.igomarcelino.projeto_dev_superior.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    GameListService gameListService;

    @Autowired
    GameService gameService;

    @GetMapping
    @Operation(tags = "Retorna todas as listas dos games")
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{id}/games")
    @Operation(tags = "Retorna todos os games presentes em uma determinada lista")
    public List<GameMinDTO> findByList(@PathVariable Long id){
        return gameService.findByGameList(id);
    }

    @PostMapping(value = "/{listId}/replacement")
    @Operation(tags = "Reorganiza os jogos no banco de dados" +
            "")
    public void move(@PathVariable Long listId,@RequestBody ReplacementDTO body){
        gameListService.updatePosition(listId, body.getSourceIndex(),body.getDestinationIndex());
    }
}
