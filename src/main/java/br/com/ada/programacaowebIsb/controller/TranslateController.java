package br.com.ada.programacaowebIsb.controller;

import br.com.ada.programacaowebIsb.model.Carro;
import br.com.ada.programacaowebIsb.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translate")
public class TranslateController {

    @Autowired
    private TranslateService translateService;

    @Autowired
    private Carro carro;

    //@RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/{language}")
    public String getTranslate(@PathVariable("language") String language){
        System.out.println(carro);
        return translateService.getMensagem(language);
    }

}
