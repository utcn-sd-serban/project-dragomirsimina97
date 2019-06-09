package ro.utcn.spet.example.a1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.spet.example.a1.dto.AuthorDTO;
import ro.utcn.spet.example.a1.entity.Author;
import ro.utcn.spet.example.a1.service.AuthorManagementService;


import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorManagementService offerService;

    @GetMapping("/authors")
    public List<AuthorDTO> readAll() {
        return offerService.author();
    }

}
