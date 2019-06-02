package ro.utcn.spet.example.a1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ro.utcn.spet.example.a1.dto.OfferDTO;
import ro.utcn.spet.example.a1.service.OfferManagementService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OfferController {
    private final OfferManagementService offerService;

    @GetMapping("/offers")
    public List<OfferDTO> readAll() {
        return offerService.offer();
    }

    @PostMapping("/offers")
    public OfferDTO create(@RequestBody OfferDTO dto) {
        return offerService.insert(dto);
    }

    @GetMapping("/offers/title/{title}")
    public List<OfferDTO> fitlerOffersByTitle(@PathVariable("title") String title){
        return offerService.findtitle(title);
    }
    @GetMapping("/offers/location/{location}")
    public List<OfferDTO> fitlerOffersByLocation(@PathVariable("location") String location){
        return offerService.findLocation(location);
    }

    @GetMapping("/offers/available_date/{available_date}")
    public List<OfferDTO> fitlerOffersByAvailableDate(@PathVariable("available_date") String location){
        return offerService.findAvailableDate(location);
    }
}
