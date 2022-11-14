package com.project.fines.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="fines")
public class FineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberCar;
    private String intruder;
    private String cop;
    private Date dateProtocol;
    private int total;
    private boolean paid;
    private boolean court;
    private Date dateOfPayment;
    private Date dateDeadline;

    public FineModel(){}
    public FineModel(String numberCar, String intruder, String cop, Date dateProtocol, int total, Date dateDeadline) {
        this.numberCar = numberCar;
        this.intruder = intruder;
        this.cop = cop;
        this.dateProtocol = dateProtocol;
        this.total = total;
        this.dateDeadline = dateDeadline;
    }
}
