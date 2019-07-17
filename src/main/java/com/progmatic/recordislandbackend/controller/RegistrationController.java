package com.progmatic.recordislandbackend.controller;

import com.progmatic.recordislandbackend.dto.GenreResponseDTO;
import com.progmatic.recordislandbackend.service.LastFmServiceImpl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    
    private final LastFmServiceImpl lastFmServiceImpl;
    
    @Autowired
    public RegistrationController(LastFmServiceImpl lastFmServiceImpl) {
        this.lastFmServiceImpl = lastFmServiceImpl;
    }
    
    @GetMapping(path = "/api/genres")
    public List<GenreResponseDTO> listGenres(){
        List<GenreResponseDTO> response = lastFmServiceImpl.listGenres().stream().map(this::convertToDto).collect(Collectors.toList());
        System.out.println(response.size());
        return response;
    }
    
    private GenreResponseDTO convertToDto(String name){
        return new GenreResponseDTO(name);
    }
}
