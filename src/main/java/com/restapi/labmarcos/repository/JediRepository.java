package com.restapi.labmarcos.repository;

import com.restapi.labmarcos.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

}
