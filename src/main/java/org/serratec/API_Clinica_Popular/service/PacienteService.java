package org.serratec.API_Clinica_Popular.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.API_Clinica_Popular.domain.Paciente;
import org.serratec.API_Clinica_Popular.dto.PacienteRequestDTO;
import org.serratec.API_Clinica_Popular.dto.PacienteResponseDTO;
import org.serratec.API_Clinica_Popular.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;

	public List<PacienteResponseDTO> listarTodos() {

		List<Paciente> lista = repository.findAll();
		return lista.stream().map(paciente -> {

			PacienteResponseDTO response = new PacienteResponseDTO();
			response.setId(paciente.getId());
			response.setNome(paciente.getNome());
			response.setCpf(paciente.getCpf());
			response.setTelefone(paciente.getTelefone());
			response.setEmail(paciente.getEmail());
			return response;

		}).collect(Collectors.toList());
	}

	public PacienteResponseDTO buscarPorId(Long id) {

		Paciente paciente = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));

		PacienteResponseDTO response = new PacienteResponseDTO();
		response.setId(paciente.getId());
		response.setNome(paciente.getNome());
		response.setCpf(paciente.getCpf());
		response.setTelefone(paciente.getTelefone());
		response.setEmail(paciente.getEmail());
		return response;

	}

	public PacienteResponseDTO criar(PacienteRequestDTO dto) {
		
		//DTO -> Entidade -> DTO
		Paciente paciente = new Paciente();

		paciente.setNome(dto.getNome());
		paciente.setCpf(dto.getCpf());
		paciente.setTelefone(dto.getTelefone());
		paciente.setEmail(dto.getEmail());

		paciente = repository.save(paciente);

		PacienteResponseDTO response = new PacienteResponseDTO();
		response.setId(paciente.getId());
		response.setNome(paciente.getNome());
		response.setCpf(paciente.getCpf());
		response.setTelefone(paciente.getTelefone());
		response.setEmail(paciente.getEmail());
		return response;

	}

	public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto) {

		Paciente paciente = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));

		paciente.setNome(dto.getNome());
		paciente.setCpf(dto.getCpf());
		paciente.setTelefone(dto.getTelefone());
		paciente.setEmail(dto.getEmail());

		paciente = repository.save(paciente);

		PacienteResponseDTO response = new PacienteResponseDTO();
		response.setId(paciente.getId());
		response.setNome(paciente.getNome());
		response.setCpf(paciente.getCpf());
		response.setTelefone(paciente.getTelefone());
		response.setEmail(paciente.getEmail());
		return response;

	}
	
	public void deletar(Long id) {
		Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));
        
        repository.delete(paciente);
    }
}