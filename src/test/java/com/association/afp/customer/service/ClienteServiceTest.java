package com.association.afp.customer.service;

import com.association.afp.customer.domain.Afp;
import com.association.afp.customer.domain.Cliente;
import com.association.afp.customer.mapper.ClienteMapper;
import com.association.afp.customer.mapper.ClienteMapperImpl;
import com.association.afp.customer.model.ClienteModel;
import com.association.afp.customer.model.ResultModel;
import com.association.afp.customer.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ClienteServiceTest {

    @Mock
    ClienteRepository clienteRepository;
    ClienteMapper clienteMapper;
    List<Cliente> getListData() {
        List<Cliente> AllClientes = new ArrayList<Cliente>();
        AllClientes.add(new Cliente(1,"Juan", "Calla",44840472,"","",new Afp() ));
        return AllClientes;
    }
    Optional<Cliente> getDataFirst() {

        return getListData().stream().findFirst();
    }
    ClienteService clienteService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteMapper = new ClienteMapperImpl() ;
        clienteService = new ClienteService(clienteRepository, clienteMapper);
        when(clienteRepository.findAll()).thenReturn(getListData());
        when(clienteRepository.findById(1)).thenReturn(getDataFirst());
        when(clienteRepository.save(any(Cliente.class))).thenReturn(getDataFirst().get());
    }

    @Test
    void findAll() throws Exception {
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente(1,"Juan", "Calla",44840472,"","",new Afp() ));
        var response = new ResultModel<List<ClienteModel>>("Listado de Clientes", clienteMapper.EntitiesToModels(clientes), true);
        Assertions.assertEquals( response, clienteService.findAll());
        Assertions.assertEquals(response.getData().size() , clienteService.findAll().getData().size());
    }

    @Test
    void findById() throws Exception {
       var cliente = new Cliente(1,"Juan", "Calla",44840472,"","",new Afp() ) ;
       var response = new ResultModel<ClienteModel>("Cliente encontrado!",clienteMapper.EntityToModel(cliente), true);
       Assertions.assertEquals(response, clienteService.findById(1) );
    }

    @Test
    void create() throws Exception {
        var request = new ClienteModel(1,"Juan", "Calla",44840472,"","",new Afp() );
        var responseOk = new ResultModel<Integer>("Cliente Creado Correctamente!", 1, true);
        Assertions.assertEquals(responseOk, clienteService.create(request));
    }

    @Test
    void update() throws Exception {
        var request = new ClienteModel(1,"Juan", "Calla Bruna",44840472,"","",new Afp() );
        var responseOk = new ResultModel<String>("Cliente actualizado correctamente!",  "", true);
        var responseUpdate = clienteService.update(1,request);
        Assertions.assertEquals(responseOk, responseUpdate );

    }

    @Test
    void deleteById() throws Exception {
         var responseOk = new ResultModel<String>("Cliente eliminado correctamente!",  "", true);
        var responseUpdate = clienteService.deleteById(1);
        Assertions.assertEquals(responseOk, responseUpdate );
    }
}