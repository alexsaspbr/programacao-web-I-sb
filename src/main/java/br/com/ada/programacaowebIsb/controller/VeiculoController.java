package br.com.ada.programacaowebIsb.controller;

import br.com.ada.programacaowebIsb.model.Veiculo;
import br.com.ada.programacaowebIsb.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/veiculos")
    public ModelAndView veiculos(
            @RequestParam(defaultValue = "1", value = "page") Integer numeroPagina,
            @RequestParam(defaultValue = "3", value = "size") Integer tamanhoPagina) {
        //Model, ModelMap e ModelAndView
        ModelAndView modelAndView = new ModelAndView("veiculos");
        Page<Veiculo> veiculoPage = this.veiculoService.listarPaginado(numeroPagina-1, tamanhoPagina);
        modelAndView.addObject("veiculos", veiculoPage.getContent());
        modelAndView.addObject("totalPages", veiculoPage.getTotalPages());
        modelAndView.addObject("currentPage", numeroPagina);
        modelAndView.addObject("pageSize", veiculoPage.getSize());
        return modelAndView;
    }

    @GetMapping("/veiculo/add")
    public String addVeiculo(Model model, Veiculo veiculo) {
        model.addAttribute("add", Boolean.TRUE);
        model.addAttribute("veiculo", Objects.nonNull(veiculo) ? veiculo : new Veiculo());
        return "veiculo-add";
    }

    @PostMapping("/veiculo/add")
    public String criarVeiculo(@Valid @ModelAttribute("veiculo") Veiculo veiculo,
                               BindingResult result,
                               Model model) {

        if(result.hasErrors()) {
            return addVeiculo(model, veiculo);
        }

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
