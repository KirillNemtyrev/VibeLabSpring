package com.project.fines.controller;

import com.project.fines.dto.FineDto;
import com.project.fines.model.FineModel;
import com.project.fines.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fines")
public class FineController {

    @Autowired
    private FineService fineService;

    @GetMapping
    public Page<FineModel> getList(int page){
        return fineService.get(page);
    }

    @PostMapping
    public ResponseEntity<?> addFine(@RequestBody FineDto fineDto){
        fineService.create(fineDto);
        return new ResponseEntity<>("Fine is created!", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateFine(Long fineId, @RequestBody FineDto fineDto) {
        return new ResponseEntity<>(fineService.update(fineId, fineDto) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(Long fineId){
        return new ResponseEntity<>(fineService.delete(fineId) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{fineId}")
    public FineModel getFine(@PathVariable Long fineId){
        return fineService.get(fineId);
    }

    @PatchMapping("/{fineId}/pay")
    public ResponseEntity<?> pay(@PathVariable Long fineId){
        return new ResponseEntity<>(fineService.pay(fineId) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/{fineId}/court")
    public ResponseEntity<?> court(@PathVariable Long fineId){
        return new ResponseEntity<>(fineService.court(fineId) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
