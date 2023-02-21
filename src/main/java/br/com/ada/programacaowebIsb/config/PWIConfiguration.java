package br.com.ada.programacaowebIsb.config;

import br.com.ada.programacaowebIsb.model.Carro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PWIConfiguration {

    @Bean
    public Carro getCarro() {
        return new Carro();
    }

}
