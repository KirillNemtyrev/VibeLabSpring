package com.project.fines.service;

import com.project.fines.dto.FineDto;
import com.project.fines.model.FineModel;
import com.project.fines.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class FineService {

    @Autowired
    private FineRepository fineRepository;

    public void create(FineDto fineDto){
        fineRepository.save(new FineModel(
                fineDto.getNumberCar(),
                fineDto.getIntruder(),
                fineDto.getCop(),
                fineDto.getDateProtocol(),
                fineDto.getTotal(),
                fineDto.getDateDeadline()));
    }

    public boolean update(Long fineId, FineDto fineDto){
        FineModel fineModel = fineRepository.findById(fineId)
                .orElse(null);

        if(fineModel == null){
            return false;
        }

        if(fineDto.getNumberCar() != null){
            fineModel.setNumberCar(fineDto.getNumberCar());
        }

        if(fineDto.getIntruder() != null){
            fineModel.setIntruder(fineDto.getIntruder());
        }

        if(fineDto.getCop() != null){
            fineModel.setCop(fineDto.getCop());
        }

        if(fineDto.getTotal() > 0){
            fineModel.setTotal(fineDto.getTotal());
        }

        if(fineDto.getDateDeadline() != null){
            fineModel.setDateDeadline(fineDto.getDateDeadline());
        }

        if(fineDto.getDateProtocol() != null){
            fineModel.setDateProtocol(fineDto.getDateProtocol());
        }
        fineRepository.save(fineModel);
        return true;
    }

    public boolean delete(Long fineId){
        FineModel fineModel = fineRepository.findById(fineId)
                .orElse(null);

        if(fineModel == null){
            return false;
        }

        fineRepository.delete(fineModel);
        return true;
    }

    public FineModel get(Long fineId){
        return fineRepository.findById(fineId).orElse(null);
    }

    public boolean pay(Long fineId){
        FineModel fineModel = fineRepository.findById(fineId)
                .orElse(null);

        if(fineModel == null){
            return false;
        }

        if(fineModel.isPaid()){
            return false;
        }

        fineModel.setPaid(true);
        fineRepository.save(fineModel);
        return true;
    }

    public boolean court(Long fineId){
        FineModel fineModel = fineRepository.findById(fineId)
                .orElse(null);

        if(fineModel == null){
            return false;
        }

        if(fineModel.isCourt()){
            return false;
        }

        fineModel.setCourt(true);
        fineRepository.save(fineModel);
        return true;
    }

    public Page<FineModel> get(int page){
        Pageable pageable = PageRequest.of(page, 5, Sort.by("id"));
        return fineRepository.findAll(pageable);
    }
}
