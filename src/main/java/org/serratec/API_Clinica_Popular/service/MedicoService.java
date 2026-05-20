package org.serratec.API_Clinica_Popular.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.API_Clinica_Popular.domain.Especialidade;
import org.serratec.API_Clinica_Popular.domain.Medico;
import org.serratec.API_Clinica_Popular.dto.EspecialidadeResponseDTO;
import org.serratec.API_Clinica_Popular.dto.MedicoRequestDTO;
import org.serratec.API_Clinica_Popular.dto.MedicoResponseDTO;
import org.serratec.API_Clinica_Popular.repository.EspecialidadeRepository;
import org.serratec.API_Clinica_Popular.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	public List<MedicoResponseDTO> listarTodos() {

		List<Medico> lista = repository.findAll();
		
		return lista.stream().map(medico -> {
			MedicoResponseDTO response = new MedicoResponseDTO();
			response.setId(medico.getId());
			response.setNome(medico.getNome());
			response.setCpf(medico.getCpf());
			response.setTelefone(medico.getTelefone());
			response.setEmail(medico.getEmail());
			response.setCrm(medico.getCrm());

			if (medico.getEspecialidade() != null) {
				EspecialidadeResponseDTO espDTO = new EspecialidadeResponseDTO();
				espDTO.setId(medico.getEspecialidade().getId());
				espDTO.setNome(medico.getEspecialidade().getNome());
				espDTO.setDescricao(medico.getEspecialidade().getDescricao());
				response.setEspecialidade(espDTO);
			}
			
			return response;
		}).collect(Collectors.toList());
	}

	public MedicoResponseDTO buscarPorId(Long id) {

		Medico medico = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico não encontrado"));

		MedicoResponseDTO response = new MedicoResponseDTO();
		response.setId(medico.getId());
		response.setNome(medico.getNome());
		response.setCpf(medico.getCpf());
		response.setTelefone(medico.getTelefone());
		response.setEmail(medico.getEmail());
		response.setCrm(medico.getCrm());

		if (medico.getEspecialidade() != null) {
			EspecialidadeResponseDTO espDTO = new EspecialidadeResponseDTO();
			espDTO.setId(medico.getEspecialidade().getId());
			espDTO.setNome(medico.getEspecialidade().getNome());
			espDTO.setDescricao(medico.getEspecialidade().getDescricao());
			response.setEspecialidade(espDTO);
		}
		
		return response;
	}

	public MedicoResponseDTO criar(MedicoRequestDTO dto) {
		
		Especialidade especialidadeMedico = especialidadeRepository.findById(dto.getEspecialidadeId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Especialidade informada não existe!"));

		//DTO -> Entidade -> DTO
		Medico medico = new Medico();

		medico.setNome(dto.getNome());
		medico.setCpf(dto.getCpf());
		medico.setTelefone(dto.getTelefone());
		medico.setEmail(dto.getEmail());
		medico.setCrm(dto.getCrm());
		medico.setEspecialidade(especialidadeMedico);

		medico = repository.save(medico);

		MedicoResponseDTO response = new MedicoResponseDTO();
		response.setId(medico.getId());
		response.setNome(medico.getNome());
		response.setCpf(medico.getCpf());
		response.setTelefone(medico.getTelefone());
		response.setEmail(medico.getEmail());
		response.setCrm(medico.getCrm());

		if (medico.getEspecialidade() != null) {
			EspecialidadeResponseDTO espDTO = new EspecialidadeResponseDTO();
			espDTO.setId(medico.getEspecialidade().getId());
			espDTO.setNome(medico.getEspecialidade().getNome());
			espDTO.setDescricao(medico.getEspecialidade().getDescricao());
			response.setEspecialidade(espDTO);
		}
		
		return response;
	}
	
	public MedicoResponseDTO atualizar(Long id, MedicoRequestDTO dto) {

		Medico medico = repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico não encontrado"));
		
		Especialidade especialidadeMedico = especialidadeRepository.findById(dto.getEspecialidadeId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Especialidade informada não existe!"));

		medico.setNome(dto.getNome());
		medico.setCpf(dto.getCpf());
		medico.setTelefone(dto.getTelefone());
		medico.setEmail(dto.getEmail());
		medico.setCrm(dto.getCrm());
		medico.setEspecialidade(especialidadeMedico);

		medico = repository.save(medico);

		MedicoResponseDTO response = new MedicoResponseDTO();
		response.setId(medico.getId());
		response.setNome(medico.getNome());
		response.setCpf(medico.getCpf());
		response.setTelefone(medico.getTelefone());
		response.setEmail(medico.getEmail());
		response.setCrm(medico.getCrm());

		if (medico.getEspecialidade() != null) {
			EspecialidadeResponseDTO espDTO = new EspecialidadeResponseDTO();
			espDTO.setId(medico.getEspecialidade().getId());
			espDTO.setNome(medico.getEspecialidade().getNome());
			espDTO.setDescricao(medico.getEspecialidade().getDescricao());
			response.setEspecialidade(espDTO);
		}
		
		return response;
	}
	
	public void deletar(Long id) {
		Medico medico = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico não encontrado"));
        
        repository.delete(medico);
    }
}
