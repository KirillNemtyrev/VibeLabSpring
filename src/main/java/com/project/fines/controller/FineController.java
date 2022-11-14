package com.project.fines.controller;

import com.project.fines.dto.FineDto;
import com.project.fines.entity.FineEntity;
import com.project.fines.service.FineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/fines")
public class FineController {

    @Autowired
    private FineService fineService;

    @GetMapping
    public Collection<FineEntity> getList(){
        return fineService.getList();
    }

    @PostMapping
    public ResponseEntity<?> addFine(@RequestBody FineDto fineDto){
        fineService.create(fineDto);
        return new ResponseEntity<>("Fine is created!", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateFine(int fineId, @RequestBody FineDto fineDto) {
        return new ResponseEntity<>(fineService.update(fineId, fineDto) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(int fineId){
        return new ResponseEntity<>(fineService.delete(fineId) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{fineId}")
    public FineEntity getFine(@PathVariable int fineId){
        return fineService.get(fineId);
    }

    @PatchMapping("/{fineId}/pay")
    public ResponseEntity<?> pay(@PathVariable int fineId){
        return new ResponseEntity<>(fineService.pay(fineId) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/{fineId}/court")
    public ResponseEntity<?> court(@PathVariable int fineId){
        return new ResponseEntity<>(fineService.court(fineId) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
