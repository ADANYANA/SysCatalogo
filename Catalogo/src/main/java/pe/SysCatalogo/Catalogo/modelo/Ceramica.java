package pe.SysCatalogo.Catalogo.modelo;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ceramica")
public class Ceramica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(name = "precio_base", nullable = false)
    private Double precioBase;

    @Column(name = "imagen_url")
    private String imagenUrl;

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false)
    private TipoCeramica tipo;

    @ManyToOne
    @JoinColumn(name = "id_proceso", nullable = false)
    private ProcesoFabricacion proceso;
}

