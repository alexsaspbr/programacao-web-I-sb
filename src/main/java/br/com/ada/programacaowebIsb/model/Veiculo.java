package br.com.ada.programacaowebIsb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_veiculo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String placa;
    private String marca;

    private String modelo;

    private String tipo;

    private Boolean disponivel;

}
