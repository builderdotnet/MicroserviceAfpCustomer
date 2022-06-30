package com.association.afp.customer.model;

import com.association.afp.customer.domain.Afp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {
    private Integer id;

    private String nombres;

    private String apellidos;

    private Integer dni;

    private String telefono;

    private String correo;
 @Builder.Default
    private Afp idafp = null;

}
