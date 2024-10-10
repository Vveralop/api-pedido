package com.challenger.api_pedidos.controllers;

import com.challenger.api_pedidos.entities.Pedido;
import com.challenger.api_pedidos.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoService.savePedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedido);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedido() {
        List<Pedido> pedidos = pedidoService.findAllPedido();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) throws Exception {
        Pedido pedido = pedidoService.findPedidoById(id);
        if (pedido == null){
            System.out.println("Cae en notfound");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> deletePedidoById(@PathVariable Long id) throws Exception {
        int existe = pedidoService.deletePedidoById(id);
        if (existe == 1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> deletePedidoById(@PathVariable Long id, @RequestBody Pedido body) {
        Pedido pedido = pedidoService.updatePedidoById(body, id);
        if (pedido == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
