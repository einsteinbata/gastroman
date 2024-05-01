package com.bata.exemp.controllers;

import com.bata.exemp.entity.MenuItem;
import com.bata.exemp.service.MenuService;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/menu")
@Setter
public class MenuController {

    private MenuService menuService;
    private final ResponseEntity RESP = new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<MenuItem>> getAllMenuItems(){
        return RESP;
    }

    @GetMapping(value = "/getById")
    public ResponseEntity<MenuItem> getById(){
        return RESP;
    }

    @GetMapping(value = "/getAllByCategory")
    public ResponseEntity<List<MenuItem>> getAllMenuItemsByCategory(){
        return RESP;
    }

    @PostMapping(value = "/addItem")
    public ResponseEntity<MenuItem> addMenuItem(MenuItem menuItem){
        return RESP;
    }

}
