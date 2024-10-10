package com.challenger.api_pedidos.repository;

import com.challenger.api_pedidos.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Pedido findByClienteId(Long clienteId);

    void deleteById(Long id);
}
