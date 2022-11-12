package com.project.fines.storage;

import com.project.fines.entity.FineEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FinesStorage {

    private List<FineEntity> list = new ArrayList<>();
    private int count = 1;

    public void add(FineEntity fineEntity){
        count += 1;
        list.add(fineEntity);
    }

    public void remove(int id){
        list.removeIf(fine -> fine.getId() == id);
    }

    public void update(int index, FineEntity fineEntity) {
        list.set(index, fineEntity);
    }

    public FineEntity get(int id){
        for(FineEntity fine : list){
            if(fine.getId() == id){
                return fine;
            }
        }
        return null;
    }

    public int getPosition(FineEntity fineEntity) {
        for (int i = 0; i < list.size(); i++){
            if(list.get(i) == fineEntity){
                return i;
            }
        }
        return -1;
    }

    public List<FineEntity> getList() {
        return list;
    }

    public int getCount(){
        return count;
    }
}
