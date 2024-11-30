package com.proyectprogram.program.controlller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.proyectprogram.program.Models.Producto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class Controllers {
    private List<Producto> productos = new ArrayList<>(
        Arrays.asList(new Producto(321, "JugoAvena", 4000, 7))
    );

    @GetMapping("/productos")
    public List<Producto> getproductos() {
        return productos;
    }
    

    @GetMapping("/{nombrep}")
    public Producto getidProducts(@PathVariable String NombreProduct) {
        for(Producto c : productos) {
            if(c.getNombreP().equalsIgnoreCase(NombreProduct))
            {
                return c;
            }
        }
        return null;
    }
    
    @PostMapping("/productor")
    public Producto postproductos(@RequestBody Producto producto) {
        productos.add(producto);
        return producto;
    }
    
    @PutMapping("/product")
    public Producto putproductos(@RequestBody Producto producto) {
        for(Producto e : productos) {
            if(e.getIdproducto()== (producto.getIdproducto())) {
                e.setNombreP(producto.getNombreP());
                e.setValorN(producto.getValorN());
                e.setCantidad(producto.getCantidad());
                return e;
            }
        }
        
        return null;
    }
    
    @DeleteMapping("/{idproducto}")
    public Producto deleteProduct(@PathVariable int idProducts) {
        for(Producto p : productos) {
            if(p.getIdproducto() == idProducts) {
            productos.remove(p);
            return p;
            }
        }
        return null;
    }
}


