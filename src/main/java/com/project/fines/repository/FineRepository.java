package com.project.fines.repository;

import com.project.fines.model.FineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FineRepository extends JpaRepository<FineModel, Long> {
    Optional<FineModel> findById(Long Id);

}
