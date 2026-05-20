package org.serratec.API_Clinica_Popular.repository;

import org.serratec.API_Clinica_Popular.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

}