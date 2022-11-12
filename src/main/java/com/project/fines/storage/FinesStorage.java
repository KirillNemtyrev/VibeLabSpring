package com.project.fines.storage;

import com.project.fines.entity.FineEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FinesStorage {

    private final Map<Integer, FineEntity> map = new HashMap<>();
    private int count = 0;

    public void add(FineEntity fineEntity){
        fineEntity.setId(count++);
        map.put(count, fineEntity);
    }

    public void remove(int id){
        map.remove(id);
    }

    public void update(int id, FineEntity fineEntity) {
        map.put(id, fineEntity);
    }

    public FineEntity get(int id){
        return map.get(id);
    }

    public Collection<FineEntity> getMap() {
        return map.values();
    }
}
