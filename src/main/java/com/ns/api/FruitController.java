package com.ns.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {this.fruitService = fruitService;}

    @PostMapping("/fruits")
    public ResponseEntity addFruit(@RequestBody FruitRequest fruitRequest) {
        log.info("Request : {}", fruitRequest);
        fruitService.saveFruit(fruitRequest.toFruitModel());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/fruits")
    public List<FruitModel> getAllFruit() {
        return fruitService.findAll();
    }
}
