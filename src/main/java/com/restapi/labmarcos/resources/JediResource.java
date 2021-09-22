package com.restapi.labmarcos.resources;

import com.restapi.labmarcos.model.Jedi;
import com.restapi.labmarcos.repository.JediRepository;
import com.restapi.labmarcos.service.JediService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/jedis")
public class JediResource{

    @Autowired
    private JediService jediService;

    @GetMapping
    public ResponseEntity<?> getAll() {

        return ResponseEntity.ok(jediService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getJedi(@PathVariable Long id) {

        return ResponseEntity.ok(jediService.findById(id));
    }

    @PostMapping
    public ResponseEntity createJedi(@Valid @RequestBody Jedi jedi) {

        Jedi jediCreate = jediService.save(jedi);

        return ResponseEntity.status(HttpStatus.CREATED).body(jediCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateJedi (@PathVariable Long id, @Valid @RequestBody Jedi jedi) {

        Jedi jediEntity = jediService.update(id, jedi);

        return ResponseEntity.ok(jediEntity);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeJedi(@PathVariable Long id) {

        jediService.delete(id);
    }


}
