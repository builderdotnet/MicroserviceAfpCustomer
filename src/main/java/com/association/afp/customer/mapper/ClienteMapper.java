package com.association.afp.customer.mapper;

import com.association.afp.customer.domain.Cliente;
import com.association.afp.customer.model.ClienteModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente ModelToEntity (ClienteModel model);
    ClienteModel EntityToModel (Cliente Cliente);
    List<ClienteModel> EntitiesToModels(List<Cliente> Clientes);
    void update(@MappingTarget Cliente entity, ClienteModel model);

}
