package com.challenger.api_pedidos.services.impl;

import com.challenger.api_pedidos.entities.Pedido;
import com.challenger.api_pedidos.exceptions.NotFoundException;
import com.challenger.api_pedidos.repository.PedidoRepository;
import com.challenger.api_pedidos.services.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService {
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> findAllPedido() {
            List<Pedido> pedidos = pedidoRepository.findAll();
            return pedidos;
    }

    @Override
    public Pedido findPedidoById(Long idCliente){
            Pedido pedido = pedidoRepository.findByClienteId(idCliente);
            return pedido;
    }

    @Override
    public int deletePedidoById(Long id) throws Exception {
        if (!pedidoRepository.existsById(id)) {
            return 1;
        }
        pedidoRepository.deleteById(id);
        return 0;
    }

    @Override
    public Pedido updatePedidoById(Pedido pedido, Long id) {
        Pedido pedidoExistente = pedidoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pedido con ID " + id + " no encontrado"));
        pedidoExistente.setClienteId(pedido.getClienteId());
        pedidoExistente.setProducto(pedido.getProducto());
        pedidoExistente.setEstado(pedido.getEstado());
        return pedidoRepository.save(pedidoExistente);
    }
}
