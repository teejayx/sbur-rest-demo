package com.theheclers.sburrestdemo;

import org.springframework.data.repository.CrudRepository;

public interface CoffeeRespository extends CrudRepository<Coffee, String> {
}
