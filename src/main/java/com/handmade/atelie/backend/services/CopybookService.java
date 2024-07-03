package com.handmade.atelie.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handmade.atelie.backend.models.product.Copybook;
import com.handmade.atelie.backend.models.product.CopybookDTO;
import com.handmade.atelie.backend.models.product.CopybookEspecification;
import com.handmade.atelie.backend.repositories.CopybookRepository;

@Service
public class CopybookService {

    @Autowired
    CopybookRepository copybookRepository;

    public CopybookDTO registerCopybook(CopybookDTO data) {

        Copybook copybook = new Copybook(data.name(), data.description(), data.imageUrl(), data.price());
        
        List<CopybookEspecification> especifications = new ArrayList<>();
        data.especifications().forEach(especification -> {
            especifications.add(new CopybookEspecification(especification.title(), especification.content(), copybook));
        });

        copybook.setEspecifications(especifications);

        this.copybookRepository.save(copybook);

        return data;
    }

}
