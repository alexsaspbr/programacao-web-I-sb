package br.com.ada.programacaowebIsb.controller;

import br.com.ada.programacaowebIsb.model.Veiculo;
import br.com.ada.programacaowebIsb.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/")
    public void createVeiculo(@RequestBody Veiculo veiculo) {
        this.veiculoService.createVeiculo(veiculo);
    }

}
