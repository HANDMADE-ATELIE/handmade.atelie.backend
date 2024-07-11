package com.handmade.atelie.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handmade.atelie.backend.models.product.CopybookDTO;
import com.handmade.atelie.backend.models.product.CopybookDTOWithID;
import com.handmade.atelie.backend.services.CopybookService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("copybook")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CopybookController {

    @Autowired
    CopybookService copybookService;
    
    @PostMapping("/registerCopybook")
    public ResponseEntity<CopybookDTO> registerCopybook(@Validated @RequestBody CopybookDTO data) {
        CopybookDTO result = this.copybookService.registerCopybook(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


    @GetMapping("/getAllCopybooks")
    public ResponseEntity<List<CopybookDTOWithID>> getAllCopybooks() {
        List<CopybookDTOWithID> result = this.copybookService.getAllCopybooks();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("updateCopybook/{id}")
    public ResponseEntity<CopybookDTOWithID> updateCopybook(@PathVariable String id, @RequestBody CopybookDTO data) {
        CopybookDTOWithID entity = this.copybookService.updateCopybook(id, data);
        
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("deleteCopybook/{id}")
    public ResponseEntity<Void> deleteCopybook(@PathVariable String id) {
        this.copybookService.deleteCopybookById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    
}
