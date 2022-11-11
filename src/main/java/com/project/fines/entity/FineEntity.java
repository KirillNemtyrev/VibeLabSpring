package com.project.fines.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
public class FineEntity {
    private String numberCar;
    private String fullNameIntruder;
    private String fullNameCop;
    private Date drawingProtocol;
    private int totalFine;
    private boolean paid;
    private boolean agenda;
    private Date dateOfPayment;
    private Date dateDeadline;
}
