package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ProductoModel;
import com.example.demo.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping()
    public ArrayList<ProductoModel> obtenerProducto(){
        return productoService.obtenerProducto();
    }

    @GetMapping("/buscar")
    public ArrayList<ProductoModel> searchItems(@RequestParam("nombre") String nombre) {
        // Lógica para buscar ítems en la base de datos y devolver resultados
        return this.productoService.searchItems(nombre);
    }

    @PostMapping()
    public ProductoModel guardarProdcuto(@RequestBody ProductoModel producto){
        return this.productoService.guardaProducto(producto);
    }

    @GetMapping( path = "/{id}")
    public Optional<ProductoModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.productoService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<ProductoModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.productoService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.productoService.eliminarProdcuto(id);
        if (ok){
            return "Se eliminó el producto con id " + id;
        }else{
            return "No pudo eliminar el producto con id" + id;
        }
    }
}
