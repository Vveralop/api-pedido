package com.challenger.api_pedidos.services;

import com.challenger.api_pedidos.entities.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido savePedido(Pedido pedido);
    List<Pedido> findAllPedido();
    Pedido findPedidoById(Long id) throws Exception;
    int deletePedidoById(Long id) throws Exception;
    Pedido updatePedidoById(Pedido pedido, Long id);
}
