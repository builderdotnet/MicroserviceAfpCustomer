package com.association.afp.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultModel <T> {
    private String message ;
    private T data;
    private Boolean succeeded;
}
