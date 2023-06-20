package br.com.wallace.clickbus.controller;

import br.com.wallace.clickbus.model.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<PlaceResponse> getPlace(@PathVariable Long id){
        var place = repository.getReferenceById(id);
        var placeDetail = new PlaceResponse(place);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(placeDetail);
    }

    @GetMapping
    public ResponseEntity<List<PlaceResponse>> listPlaces(@PageableDefault(sort = "name") Pageable page){
        Page<Place> placePage = repository.findAll(page);
        List<PlaceResponse> places = placePage.getContent().stream()
                .map(PlaceResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(places);

    }

    @PostMapping
    @Transactional
    public ResponseEntity<PlaceRequest> insertPlace(@RequestBody @Valid PlaceRequest data){
        var place = new Place(data);
        repository.save(place);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PlaceRequest(place));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PlaceResponse> updatePlace(@RequestBody @Valid PlaceUpdate update){
        var place = repository.getReferenceById(update.id());
        place.updatePlace(update);
        return ResponseEntity.ok(new PlaceResponse(place));
    }

}
