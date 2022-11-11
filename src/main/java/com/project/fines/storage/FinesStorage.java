package com.project.fines.storage;

import com.project.fines.entity.FineEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FinesStorage {

    private List<FineEntity> list = new ArrayList<>();

    public void add(FineEntity fineEntity){
        list.add(fineEntity);
    }

    public void remove(FineEntity fineEntity){
        list.remove(fineEntity);
    }

    public void remove(int index){
        list.remove(index);
    }

    public void update(int index, FineEntity fineEntity){
        list.set(index, fineEntity);
    }

    public FineEntity get(int index){
        return list.get(index);
    }

    public List<FineEntity> getList() {
        return list;
    }

    public int size(){
        return list.size();
    }

}
