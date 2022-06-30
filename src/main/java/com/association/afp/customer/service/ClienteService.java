package com.association.afp.customer.service;

import com.association.afp.customer.domain.Cliente;
import com.association.afp.customer.mapper.ClienteMapper;
import com.association.afp.customer.model.ClienteModel;
import com.association.afp.customer.model.ResultModel;
import com.association.afp.customer.repository.ClienteRepository;
import com.association.afp.customer.service.interfaces.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService implements ICrudService<ClienteModel, Integer> {
    private final ClienteRepository ClienteRepository;
    private final ClienteMapper ClienteMapper;


    @Override
    public ResultModel<List<ClienteModel>> findAll() throws Exception {
        List<Cliente> Clientes = ClienteRepository.findAll();
        List<ClienteModel> ClientesModels = ClienteMapper.EntitiesToModels(Clientes);
        return new ResultModel<List<ClienteModel>>("Listado de Clientes", ClientesModels, true);
    }

    @Override
    public ResultModel<ClienteModel> findById(Integer id) throws Exception {
        Optional<Cliente> Cliente = ClienteRepository.findById(id);
        if (Cliente.isPresent()) {
            ClienteModel ClienteModel = ClienteMapper.EntityToModel(Cliente.get());
            return new ResultModel<ClienteModel>("Cliente encontrado!", ClienteModel, true);
        } else {
            return new ResultModel<ClienteModel>("No se encontraron datos", null, false);
        }
    }

    @Override
    public ResultModel<Integer> create(ClienteModel entityModel) throws Exception {
        Cliente Cliente = ClienteRepository.save(ClienteMapper.ModelToEntity(entityModel));
        Integer ClienteId = Cliente.getId();
        String message = "";
        if (ClienteId > 0)
            message = "Cliente Creado Correctamente!";
        else
            message = "Cliente no fue creado!";

        return new ResultModel<Integer>(message, ClienteId, ClienteId > 0);

    }

    @Override
    public ResultModel<String> update(Integer id, ClienteModel entityModel) throws Exception {
        Optional<Cliente> Cliente = ClienteRepository.findById(id);
        if (Cliente.isPresent()) {
            Cliente ClienteUpdated  = Cliente.get();
            ClienteMapper.update(ClienteUpdated, entityModel);
            ClienteRepository.save(ClienteUpdated);
            return new ResultModel<String>("Cliente actualizado correctamente!","", true);
        } else {
            return new ResultModel<String>("No se encontraron datos", "", false);
        }
    }

    @Override
    public ResultModel<String> deleteById(Integer id) throws Exception {
        ClienteRepository.deleteById(id);
        return new ResultModel<String>("Cliente eliminado correctamente!","", true);
    }
}
