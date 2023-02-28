package br.com.ada.programacaowebIsb.repository;

import br.com.ada.programacaowebIsb.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
