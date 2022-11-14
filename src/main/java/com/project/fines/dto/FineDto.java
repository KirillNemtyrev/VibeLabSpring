package com.project.fines.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FineDto {
    private String numberCar;
    private String intruder;
    private String cop;
    private Date dateProtocol;
    private int total;
    private Date dateDeadline;
}