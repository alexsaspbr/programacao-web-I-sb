package br.com.ada.programacaowebIsb.config;

import br.com.ada.programacaowebIsb.model.Veiculo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PWIConfiguration {

    @Bean
    public Veiculo getCarro() {
        return new Veiculo();
    }

}
