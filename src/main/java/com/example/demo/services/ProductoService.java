package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ProductoModel;
import com.example.demo.repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    
    public ArrayList<ProductoModel> obtenerProducto(){
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    public ArrayList<ProductoModel> searchItems(String nombre) {
        return productoRepository.findByNombre(nombre);
         //Lógica para buscar ítems en la base de datos
    }

    public ProductoModel guardaProducto(ProductoModel producto){
        return productoRepository.save(producto);
    }

    public Optional<ProductoModel> obtenerPorId(Long id){
        return productoRepository.findById(id);
    }


    public ArrayList<ProductoModel>  obtenerPorPrioridad(Integer prioridad) {
        return productoRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarProdcuto(Long id) {
        try{
            productoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
