package br.com.ada.programacaowebIsb.controller;

import br.com.ada.programacaowebIsb.model.Veiculo;
import br.com.ada.programacaowebIsb.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        model.addAttribute("veiculo", new Veiculo());
        return "veiculo-add";
    }

    @PostMapping("/veiculo/add")
    public String criarVeiculo(@ModelAttribute("veiculo") Veiculo veiculo) {
        this.veiculoService.createVeiculo(veiculo);
        return "redirect:/veiculos";
    }

}
