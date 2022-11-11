package com.project.fines.controllers;

import com.project.fines.entity.FineEntity;
import com.project.fines.storage.FinesStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fines")
public class FineController {

    @Autowired
    private FinesStorage finesStorage;

    @GetMapping
    public List<FineEntity> getList(){
        return finesStorage.getList();
    }

    @PostMapping
    public FineEntity addFine(@RequestBody FineEntity fineEntity){
        finesStorage.add(fineEntity);
        return fineEntity;
    }

    @PutMapping
    public FineEntity updateFine(int fineId, @RequestBody FineEntity fineEntity) {
        finesStorage.update(fineId, fineEntity);
        return fineEntity;
    }

    @DeleteMapping
    public ResponseEntity<?> delete(int fineId){
        finesStorage.remove(fineId);
        return new ResponseEntity<>("Fine is deleted!", HttpStatus.OK);
    }

    @GetMapping("/{fineId}")
    public FineEntity getFine(@PathVariable int fineId){
        return finesStorage.get(fineId);
    }

    @PatchMapping("/{fineId}/pay")
    public ResponseEntity<?> pay(@PathVariable int fineId){
        FineEntity fineEntity = finesStorage.get(fineId);
        fineEntity.setPaid(true);
        finesStorage.update(fineId, fineEntity);
        return new ResponseEntity<>("Fine is paid!", HttpStatus.OK);
    }

    @PatchMapping("/{fineId}/court")
    public ResponseEntity<?> court(@PathVariable int fineId){
        FineEntity fineEntity = finesStorage.get(fineId);
        fineEntity.setAgenda(true);
        finesStorage.update(fineId, fineEntity);
        return new ResponseEntity<>("The notice has been sent!", HttpStatus.OK);
    }
}
