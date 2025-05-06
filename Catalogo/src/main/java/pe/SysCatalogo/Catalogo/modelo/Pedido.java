package pe.SysCatalogo.Catalogo.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @Column(length = 30)
    private String estado;

    @Column(name = "total_estimado")
    private Double totalEstimado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
}
