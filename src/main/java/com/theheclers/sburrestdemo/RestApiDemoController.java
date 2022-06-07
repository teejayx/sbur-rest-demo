package com.theheclers.sburrestdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")

public class RestApiDemoController {

    private final CoffeeRespository coffeeRespository;
    private List<Coffee> coffees = new ArrayList<>();

    public RestApiDemoController(CoffeeRespository coffeeRespository) {
        this.coffeeRespository = coffeeRespository;

        this.coffeeRespository.saveAll(List.of(
                new Coffee("Cafe Cereza"),
                new Coffee("Cafe Ganador"),
                new Coffee("Cafe Lareno")
        ));
    }


    @GetMapping
    Iterable<Coffee> getCoffee(){
        return  this.coffeeRespository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeebyId(@PathVariable String id){
       return coffeeRespository.findById(id);
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee){
      return coffeeRespository.save(coffee);
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee ){
        return (!coffeeRespository.existsById(id)) ? new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
                                     new ResponseEntity<>(coffeeRespository.save(coffee), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id){
        coffeeRespository.deleteById(id);

    }


}
