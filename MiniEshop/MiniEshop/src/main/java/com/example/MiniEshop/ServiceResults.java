package com.example.MiniEshop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceResults {

    private String message;
    private String status;
    private Integer code;

}