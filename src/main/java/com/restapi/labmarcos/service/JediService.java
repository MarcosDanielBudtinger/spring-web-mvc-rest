package com.restapi.labmarcos.service;

import com.restapi.labmarcos.exception.JediNotFoundException;
import com.restapi.labmarcos.model.Jedi;
import com.restapi.labmarcos.repository.JediRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JediService {

    @Autowired
    private JediRepository jediRepository;


    public List<Jedi> findAll() {
        return jediRepository.findAll();
    }

    public Jedi findById(Long id) {

        Jedi jedi = jediRepository.findById(id)
                .orElseThrow(() -> new JediNotFoundException());

        return jedi;
    }

    public Jedi save(Jedi jedi) {

        return jediRepository.save(jedi);
    }

    public Jedi update(Long id, Jedi jedi) {

        Jedi jediSalvo = buscarJediPeloId(id);
        BeanUtils.copyProperties(jedi, jediSalvo, "id");

        return jediRepository.save(jediSalvo);
    }

    private Jedi buscarJediPeloId(Long id) {

        Jedi jedi = jediRepository.findById(id)
                .orElseThrow(() -> new JediNotFoundException());

        return jedi;
    }

    public void delete(Long id) {

        jediRepository.deleteById(id);
    }
}
