package com.github.igomarcelino.projeto_dev_superior.controllers;

import com.github.igomarcelino.projeto_dev_superior.dto.GameDTO;
import com.github.igomarcelino.projeto_dev_superior.dto.GameMinDTO;
import com.github.igomarcelino.projeto_dev_superior.dto.ReplacementDTO;
import com.github.igomarcelino.projeto_dev_superior.entities.Game;
import com.github.igomarcelino.projeto_dev_superior.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
@Tag(name = "Game")
@CrossOrigin
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping

    @Operation(summary = "Todos os Games", description = "Retorna todos os games cadastrados")
    public List<GameMinDTO> findAll(){
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Game por ID", description = "Localiza um game informando um id")
    public GameDTO findById(@PathVariable Long id){
        return gameService.findById(id);
    }


}
