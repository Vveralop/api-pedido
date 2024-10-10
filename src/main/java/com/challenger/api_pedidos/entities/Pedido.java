package com.challenger.api_pedidos.entities;

import com.challenger.api_pedidos.enums.PedidoEstadoEnum;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "El clienteId es obligatorio")
    private int clienteId;

    @Column
    @NotNull(message = "El producto es obligatorio")
    private String producto;

    @Column
    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    private PedidoEstadoEnum estado;
}
