package com.vaishnavi.jpa.cab.booking.controller;

import com.vaishnavi.jpa.cab.booking.model.CabModel;
import com.vaishnavi.jpa.cab.booking.service.CabService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/cabManagement")
public class CabController {

    @Resource(name = "cabService")
    private CabService cabService;

    @GetMapping("/cabs")
    public List<CabModel> getAllCabs() {
        return cabService.getAllCabs();
    }

    @GetMapping("/cab/{id}")
    public CabModel getCabById(@PathVariable int id) {
        return cabService.getCabById(id);
    }

    @PostMapping("/cab")
    public CabModel saveCab(@RequestBody CabModel cabModel) {
        return cabService.saveCab(cabModel);
    }

    @DeleteMapping("/cab/{id}")
    public boolean deleteCab(@PathVariable int id) {
        return cabService.deleteCab(id);
    }
}


