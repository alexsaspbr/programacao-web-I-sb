package br.com.ada.programacaowebIsb.controller;

import br.com.ada.programacaowebIsb.model.Veiculo;
import br.com.ada.programacaowebIsb.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/veiculos")
    public String veiculos(Model model) {
        List<Veiculo> veiculos = this.veiculoService.listarTodos();
        model.addAttribute("veiculos", veiculos);
        return "veiculos";
    }

    @GetMapping("/veiculo/add")
    public String addVeiculo(Model model) {
        model.addAttribute("add", Boolean.TRUE);
        model.addAttribute("veiculo", new Veiculo());
        return "veiculo-add";
    }

    @PostMapping("/veiculo/add")
    public String criarVeiculo(@ModelAttribute("veiculo") Veiculo veiculo) {
        this.veiculoService.createVeiculo(veiculo);
        return "redirect:/veiculos";
    }

    @GetMapping("/veiculo/{veiculoId}/delete")
    public String deletarVeiculo(@PathVariable("veiculoId") Long veiculoId) {
        this.veiculoService.removerVeiculoPorId(veiculoId);
        return "redirect:/veiculos";
    }

    @GetMapping("/veiculo/{veiculoId}/edit")
    public String mostrarEdicaoVeiculo(Model model, @PathVariable("veiculoId") Long veiculoId) {
        Optional<Veiculo> optionalVeiculo = this.veiculoService.buscarVeiculoPorId(veiculoId);
        optionalVeiculo.ifPresent(veiculo -> model.addAttribute("veiculo", veiculo));
        model.addAttribute("add", Boolean.FALSE);
        return "veiculo-add";
    }

    @PutMapping("/veiculo/{veiculoId}/edit")
    public String editarVeiculo(@ModelAttribute("veiculo") Veiculo veiculo,
                                @PathVariable("veiculoId") Long veiculoId) {
        veiculo.setId(veiculoId);
        this.veiculoService.createVeiculo(veiculo);
        return "redirect:/veiculos";
    }

}
