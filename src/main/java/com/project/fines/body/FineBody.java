package com.project.fines.body;

import lombok.Data;

import java.util.Date;

@Data
public class FineBody {
    private String numberCar;
    private String intruder;
    private String cop;
    private Date dateProtocol;
    private int total;
    private Date dateDeadline;
}
