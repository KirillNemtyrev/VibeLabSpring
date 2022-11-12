package com.project.fines.controllers;

import com.project.fines.body.FineBody;
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
    public FineEntity addFine(@RequestBody FineBody fineBody){
        FineEntity fineEntity = new FineEntity(
                finesStorage.getCount(),
                fineBody.getNumberCar(),
                fineBody.getIntruder(),
                fineBody.getCop(),
                fineBody.getDateProtocol(),
                fineBody.getTotal(),
                fineBody.getDateDeadline());


        finesStorage.add(fineEntity);
        return fineEntity;
    }

    @PutMapping
    public ResponseEntity<?> updateFine(int fineId, @RequestBody FineBody fineBody) {
        FineEntity fineEntity = finesStorage.get(fineId);

        if(fineEntity == null){
            return new ResponseEntity<>("Fine is not found!", HttpStatus.BAD_REQUEST);
        }

        int index = finesStorage.getPosition(fineEntity);
        if(fineBody.getNumberCar() != null){
            fineEntity.setNumberCar(fineBody.getNumberCar());
        }

        if(fineBody.getIntruder() != null){
            fineEntity.setIntruder(fineBody.getIntruder());
        }

        if(fineBody.getCop() != null){
            fineEntity.setCop(fineBody.getCop());
        }

        if(fineBody.getTotal() > 0){
            fineEntity.setTotal(fineBody.getTotal());
        }

        if(fineBody.getDateDeadline() != null){
            fineEntity.setDateDeadline(fineBody.getDateDeadline());
        }

        if(fineBody.getDateProtocol() != null){
            fineEntity.setDateProtocol(fineBody.getDateProtocol());
        }

        finesStorage.update(index, fineEntity);
        return new ResponseEntity<>(fineEntity, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(int fineId){

        FineEntity fineEntity = finesStorage.get(fineId);
        if(fineEntity == null){
            return new ResponseEntity<>("Fine is not found!", HttpStatus.BAD_REQUEST);
        }

        finesStorage.remove(fineId);
        return new ResponseEntity<>("Fine is deleted!", HttpStatus.OK);
    }

    @GetMapping("/{fineId}")
    public ResponseEntity<?> getFine(@PathVariable int fineId){
        FineEntity fineEntity = finesStorage.get(fineId);
        if(fineEntity == null){
            return new ResponseEntity<>("Fine is not found!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(fineEntity, HttpStatus.OK);
    }

    @PatchMapping("/{fineId}/pay")
    public ResponseEntity<?> pay(@PathVariable int fineId){
        FineEntity fineEntity = finesStorage.get(fineId);
        if(fineEntity == null){
            return new ResponseEntity<>("Fine is not found!", HttpStatus.BAD_REQUEST);
        }

        if(fineEntity.isPaid()){
            return new ResponseEntity<>("The fine has already been paid!", HttpStatus.BAD_REQUEST);
        }

        fineEntity.setPaid(true);
        int index = finesStorage.getPosition(fineEntity);
        finesStorage.update(index, fineEntity);
        return new ResponseEntity<>("Fine is paid!", HttpStatus.OK);
    }

    @PatchMapping("/{fineId}/court")
    public ResponseEntity<?> court(@PathVariable int fineId){
        FineEntity fineEntity = finesStorage.get(fineId);
        if(fineEntity == null){
            return new ResponseEntity<>("Fine is not found!", HttpStatus.BAD_REQUEST);
        }

        if(fineEntity.isAgenda()){
            return new ResponseEntity<>("The notice has already been sent!", HttpStatus.BAD_REQUEST);
        }

        int index = finesStorage.getPosition(fineEntity);
        fineEntity.setAgenda(true);
        finesStorage.update(index, fineEntity);
        return new ResponseEntity<>("The notice has been sent!", HttpStatus.OK);
    }
}
