package com.association.afp.customer.controller;

import com.association.afp.customer.model.ClienteModel;
import com.association.afp.customer.model.ResultModel;
import com.association.afp.customer.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Slf4j
public class ClienteController {
    private final ClienteService customerService;

    @GetMapping(path = {"customer"}, produces = {"application/json"})
    public ResponseEntity<ResultModel<List<ClienteModel>>> getAll() throws Exception {
        ResultModel<List<ClienteModel>> response = customerService.findAll();
        log.info("getAll Ok");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = {"customer/{id}"}, produces = {"application/json"})
    public ResponseEntity<ResultModel<ClienteModel>> getById(@PathVariable("id") Integer id) throws Exception {
        ResultModel<ClienteModel> response = customerService.findById(id);
        log.info("getById Ok");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "customer")
    public ResponseEntity<ResultModel<Integer>> create(@RequestBody ClienteModel customerModel) throws Exception {
        ResultModel<Integer> response = customerService.create(customerModel);
        log.info("create Ok");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = {"customer/{id}"}, produces = {"application/json"})
    public ResponseEntity<ResultModel<String>> update(
            @PathVariable("id") Integer id,
            @RequestBody ClienteModel customerModel) throws Exception {

        ResultModel<String> response = customerService.update(id, customerModel);
        log.info("update Ok");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping({"customer/{id}"})
    public ResponseEntity<ResultModel<String>> deleteById(@PathVariable("id") Integer id) throws Exception {
        ResultModel<String> response =  customerService.deleteById(id);
        log.info("deleteById Ok");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
