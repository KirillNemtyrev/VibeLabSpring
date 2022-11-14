package com.project.fines.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
public class FineEntity {
    private int id;
    private String numberCar;
    private String intruder;
    private String cop;
    private Date dateProtocol;
    private int total;
    private boolean paid;
    private boolean agenda;
    private Date dateOfPayment;
    private Date dateDeadline;

    public FineEntity(String numberCar, String intruder, String cop, Date dateProtocol, int total, Date dateDeadline) {
        this.numberCar = numberCar;
        this.intruder = intruder;
        this.cop = cop;
        this.dateProtocol = dateProtocol;
        this.total = total;
        this.dateDeadline = dateDeadline;
    }

}
