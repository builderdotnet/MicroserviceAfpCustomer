package com.association.afp.customer.service.interfaces;

import com.association.afp.customer.model.ResultModel;

import java.util.List;

public interface ICrudService<T , E> {
    ResultModel<List<T>> findAll() throws Exception;

    ResultModel<T> findById(E id) throws Exception;

    ResultModel<E> create(T entityModel) throws Exception;

    ResultModel<String> update(E id, T entityModel) throws Exception;

    ResultModel<String> deleteById(E id) throws Exception;

}
