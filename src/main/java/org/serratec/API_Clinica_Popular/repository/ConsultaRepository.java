package org.serratec.API_Clinica_Popular.repository;

import org.serratec.API_Clinica_Popular.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}