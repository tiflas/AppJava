package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.ProductoModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long> {
    public abstract ArrayList<ProductoModel> findByPrioridad(Integer prioridad);
    public abstract ArrayList<ProductoModel> findByNombre(String nombre);
}
