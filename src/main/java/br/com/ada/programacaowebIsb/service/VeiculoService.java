package br.com.ada.programacaowebIsb.service;

import br.com.ada.programacaowebIsb.model.Veiculo;
import br.com.ada.programacaowebIsb.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public void createVeiculo(Veiculo veiculo){
        this.veiculoRepository.save(veiculo);
    }

}
