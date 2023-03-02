package br.com.ada.programacaowebIsb;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoDTO {

    private String placa;
    private String marca;

    @NotBlank(message = "Preencher o campo")
    private String modelo;

    private String tipo;

    private Boolean disponivel;



}
