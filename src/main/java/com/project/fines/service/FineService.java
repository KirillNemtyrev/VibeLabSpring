package com.project.fines.service;

import com.project.fines.dto.FineDto;
import com.project.fines.entity.FineEntity;
import com.project.fines.storage.FinesStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class FineService {

    private FinesStorage finesStorage;

    public void create(FineDto fineDto){
        FineEntity fineEntity = new FineEntity(
                fineDto.getNumberCar(),
                fineDto.getIntruder(),
                fineDto.getCop(),
                fineDto.getDateProtocol(),
                fineDto.getTotal(),
                fineDto.getDateDeadline());

        finesStorage.add(fineEntity);
    }

    public boolean update(int fineId, FineDto fineDto){
        FineEntity fineEntity = finesStorage.get(fineId);

        if(fineEntity == null){
            return false;
        }

        if(fineDto.getNumberCar() != null){
            fineEntity.setNumberCar(fineDto.getNumberCar());
        }

        if(fineDto.getIntruder() != null){
            fineEntity.setIntruder(fineDto.getIntruder());
        }

        if(fineDto.getCop() != null){
            fineEntity.setCop(fineDto.getCop());
        }

        if(fineDto.getTotal() > 0){
            fineEntity.setTotal(fineDto.getTotal());
        }

        if(fineDto.getDateDeadline() != null){
            fineEntity.setDateDeadline(fineDto.getDateDeadline());
        }

        if(fineDto.getDateProtocol() != null){
            fineEntity.setDateProtocol(fineDto.getDateProtocol());
        }

        finesStorage.update(fineId, fineEntity);
        return true;
    }

    public boolean delete(int fineId){
        FineEntity fineEntity = finesStorage.get(fineId);
        if(fineEntity == null){
            return false;
        }

        finesStorage.remove(fineId);
        return true;
    }

    public FineEntity get(int fineId){
        return finesStorage.get(fineId);
    }

    public boolean pay(int fineId){
        FineEntity fineEntity = finesStorage.get(fineId);
        if(fineEntity == null){
            return false;
        }

        if(fineEntity.isPaid()){
            return false;
        }

        fineEntity.setPaid(true);
        finesStorage.update(fineId, fineEntity);
        return true;
    }

    public boolean court(int fineId){
        FineEntity fineEntity = finesStorage.get(fineId);
        if(fineEntity == null){
            return false;
        }

        if(fineEntity.isAgenda()){
            return false;
        }

        fineEntity.setAgenda(true);
        finesStorage.update(fineId, fineEntity);
        return true;
    }

    public Collection<FineEntity> getList(){
        return finesStorage.getMap();
    }
}
