package com.handmade.atelie.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handmade.atelie.backend.exceptions.CopyBooksNotFoundException;
import com.handmade.atelie.backend.models.product.Copybook;
import com.handmade.atelie.backend.models.product.CopybookDTO;
import com.handmade.atelie.backend.models.product.CopybookDTOWithID;
import com.handmade.atelie.backend.models.product.CopybookEspecification;
import com.handmade.atelie.backend.models.product.CopybookEspecificationDTOWithID;
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

    // public CopybookDTOWithID updateCopybook(String id, CopybookDTO data) { //todo - terminar este método, criar o getbyid, e criar o delete

    //     Copybook copybook = this.copybookRepository.findById(data.id()).orElseThrow();

    //     copybook.setName(data.name());
    //     copybook.setDescription(data.description());
    //     copybook.setImageUrl(data.imageUrl());
    //     copybook.setPrice(data.price());

    //     List<CopybookEspecification> especifications = new ArrayList<>();
    //     data.especifications().forEach(especification -> {
    //         especifications.add(new CopybookEspecification(especification.title(), especification.content(), copybook));
    //     });

    //     copybook.setEspecifications(especifications);

    //     this.copybookRepository.save(copybook);

    //     return data;
    // }


    public List<CopybookDTOWithID> getAllCopybooks() {

        List<Copybook> copybooks = this.copybookRepository.findAll();

        if(copybooks.isEmpty())
            throw new CopyBooksNotFoundException();

        List<CopybookDTOWithID> copybooksDTO = new ArrayList<>();
        copybooks.forEach(copybook -> {
           
            List<CopybookEspecificationDTOWithID> especifications = new ArrayList<>();
            copybook.getEspecifications().forEach(especification -> {
                especifications.add(new CopybookEspecificationDTOWithID(especification.getId(), especification.getTitle(), especification.getContent()));
            });

            copybooksDTO.add(new CopybookDTOWithID(copybook.getId(), copybook.getName(), copybook.getDescription(), copybook.getImageUrl(), copybook.getPrice(), especifications));
            
        });

        return copybooksDTO;
    }


}
