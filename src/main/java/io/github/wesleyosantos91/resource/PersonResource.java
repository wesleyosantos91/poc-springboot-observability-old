package io.github.wesleyosantos91.resource;

import io.github.wesleyosantos91.domain.request.PersonRequest;
import io.github.wesleyosantos91.domain.response.PersonResponse;
import io.github.wesleyosantos91.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonResource {

    private final PersonService service;

    @PostMapping
    public ResponseEntity<PersonResponse> create(@RequestBody PersonRequest request) throws Exception {

        var response = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonResponse> findByCode(@PathVariable Long id) {
        var response = service.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<Page<PersonResponse>>findAllPage(
            @PageableDefault(sort = "id",
                    direction = Sort.Direction.ASC,
                    page = 0,
                    size = 10) Pageable page) {

        var pages = service.findAllPage(page);
        return ResponseEntity.ok().body(pages);
    }

    @GetMapping(value ="/all")
    public ResponseEntity<List<PersonResponse>> findAll() {

        var persons = service.findAll();
        return ResponseEntity.ok().body(persons);
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<PersonResponse> update(@PathVariable Long id, @RequestBody PersonRequest request) throws Exception {

        var response = service.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
