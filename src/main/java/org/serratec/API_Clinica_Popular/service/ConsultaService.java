package org.serratec.API_Clinica_Popular.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.API_Clinica_Popular.domain.Consulta;
import org.serratec.API_Clinica_Popular.domain.Medico;
import org.serratec.API_Clinica_Popular.domain.Paciente;
import org.serratec.API_Clinica_Popular.dto.ConsultaRequestDTO;
import org.serratec.API_Clinica_Popular.dto.ConsultaResponseDTO;
import org.serratec.API_Clinica_Popular.dto.EspecialidadeResponseDTO;
import org.serratec.API_Clinica_Popular.dto.MedicoResponseDTO;
import org.serratec.API_Clinica_Popular.dto.PacienteResponseDTO;
import org.serratec.API_Clinica_Popular.repository.ConsultaRepository;
import org.serratec.API_Clinica_Popular.repository.MedicoRepository;
import org.serratec.API_Clinica_Popular.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private PacienteRepository pacienteRepository;


	public List<ConsultaResponseDTO> listarTodos() {

		List<Consulta> lista = consultaRepository.findAll();

		return lista.stream().map(consulta -> {
			ConsultaResponseDTO response = new ConsultaResponseDTO();
			response.setId(consulta.getId());
			response.setDataHora(consulta.getDataHora());

			if (consulta.getPaciente() != null) {
				PacienteResponseDTO pacienteDTO = new PacienteResponseDTO();
				pacienteDTO.setId(consulta.getPaciente().getId());
				pacienteDTO.setNome(consulta.getPaciente().getNome());
				pacienteDTO.setCpf(consulta.getPaciente().getCpf());
				pacienteDTO.setTelefone(consulta.getPaciente().getTelefone());
				pacienteDTO.setEmail(consulta.getPaciente().getEmail());
				response.setPaciente(pacienteDTO);
			}

			if (consulta.getMedico() != null) {
				MedicoResponseDTO medicoDTO = new MedicoResponseDTO();
				medicoDTO.setId(consulta.getMedico().getId());
				medicoDTO.setNome(consulta.getMedico().getNome());
				medicoDTO.setCpf(consulta.getMedico().getCpf());
				medicoDTO.setTelefone(consulta.getMedico().getTelefone());
				medicoDTO.setEmail(consulta.getMedico().getEmail());
				medicoDTO.setCrm(consulta.getMedico().getCrm());

				if (consulta.getMedico().getEspecialidade() != null) {
					EspecialidadeResponseDTO espDTO = new EspecialidadeResponseDTO();
					espDTO.setId(consulta.getMedico().getEspecialidade().getId());
					espDTO.setNome(consulta.getMedico().getEspecialidade().getNome());
					espDTO.setDescricao(consulta.getMedico().getEspecialidade().getDescricao());
					medicoDTO.setEspecialidade(espDTO);
				}

				response.setMedico(medicoDTO);
			}

			return response;
		}).collect(Collectors.toList());
	}


	public ConsultaResponseDTO buscarPorId(Long id) {
		Consulta consulta = consultaRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não encontrada"));

		ConsultaResponseDTO response = new ConsultaResponseDTO();
		response.setId(consulta.getId());
		response.setDataHora(consulta.getDataHora());

		if (consulta.getPaciente() != null) {
			PacienteResponseDTO pacienteDTO = new PacienteResponseDTO();
			pacienteDTO.setId(consulta.getPaciente().getId());
			pacienteDTO.setNome(consulta.getPaciente().getNome());
			pacienteDTO.setCpf(consulta.getPaciente().getCpf());
			pacienteDTO.setTelefone(consulta.getPaciente().getTelefone());
			pacienteDTO.setEmail(consulta.getPaciente().getEmail());
			response.setPaciente(pacienteDTO);
		}

		if (consulta.getMedico() != null) {
			MedicoResponseDTO medicoDTO = new MedicoResponseDTO();
			medicoDTO.setId(consulta.getMedico().getId());
			medicoDTO.setNome(consulta.getMedico().getNome());
			medicoDTO.setCpf(consulta.getMedico().getCpf());
			medicoDTO.setTelefone(consulta.getMedico().getTelefone());
			medicoDTO.setEmail(consulta.getMedico().getEmail());
			medicoDTO.setCrm(consulta.getMedico().getCrm());

			if (consulta.getMedico().getEspecialidade() != null) {
				EspecialidadeResponseDTO espDTO = new EspecialidadeResponseDTO();
				espDTO.setId(consulta.getMedico().getEspecialidade().getId());
				espDTO.setNome(consulta.getMedico().getEspecialidade().getNome());
				espDTO.setDescricao(consulta.getMedico().getEspecialidade().getDescricao());
				medicoDTO.setEspecialidade(espDTO);
			}

			response.setMedico(medicoDTO);
		}

		return response;
	}


	public ConsultaResponseDTO criar(ConsultaRequestDTO dto) {

		Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Paciente informado não existe!"));

		Medico medico = medicoRepository.findById(dto.getMedicoId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Médico informado não existe!"));

		Consulta consulta = new Consulta();
		consulta.setDataHora(dto.getDataHora());
		consulta.setPaciente(paciente);
		consulta.setMedico(medico);

		consulta = consultaRepository.save(consulta);

		ConsultaResponseDTO response = new ConsultaResponseDTO();
		response.setId(consulta.getId());
		response.setDataHora(consulta.getDataHora());

		PacienteResponseDTO pacienteDTO = new PacienteResponseDTO();
		pacienteDTO.setId(consulta.getPaciente().getId());
		pacienteDTO.setNome(consulta.getPaciente().getNome());
		pacienteDTO.setCpf(consulta.getPaciente().getCpf());
		pacienteDTO.setTelefone(consulta.getPaciente().getTelefone());
		pacienteDTO.setEmail(consulta.getPaciente().getEmail());
		response.setPaciente(pacienteDTO);

		MedicoResponseDTO medicoDTO = new MedicoResponseDTO();
		medicoDTO.setId(consulta.getMedico().getId());
		medicoDTO.setNome(consulta.getMedico().getNome());
		medicoDTO.setCpf(consulta.getMedico().getCpf());
		medicoDTO.setTelefone(consulta.getMedico().getTelefone());
		medicoDTO.setEmail(consulta.getMedico().getEmail());
		medicoDTO.setCrm(consulta.getMedico().getCrm());

		if (consulta.getMedico().getEspecialidade() != null) {
			EspecialidadeResponseDTO espDTO = new EspecialidadeResponseDTO();
			espDTO.setId(consulta.getMedico().getEspecialidade().getId());
			espDTO.setNome(consulta.getMedico().getEspecialidade().getNome());
			espDTO.setDescricao(consulta.getMedico().getEspecialidade().getDescricao());
			medicoDTO.setEspecialidade(espDTO);
		}
		response.setMedico(medicoDTO);

		return response;
	}


	public ConsultaResponseDTO atualizar(Long id, ConsultaRequestDTO dto) {
		Consulta consulta = consultaRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não encontrada"));

		Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Paciente informado não existe!"));

		Medico medico = medicoRepository.findById(dto.getMedicoId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Médico informado não existe!"));

		consulta.setDataHora(dto.getDataHora());
		consulta.setPaciente(paciente);
		consulta.setMedico(medico);

		consulta = consultaRepository.save(consulta);

		ConsultaResponseDTO response = new ConsultaResponseDTO();
		response.setId(consulta.getId());
		response.setDataHora(consulta.getDataHora());

		PacienteResponseDTO pacienteDTO = new PacienteResponseDTO();
		pacienteDTO.setId(consulta.getPaciente().getId());
		pacienteDTO.setNome(consulta.getPaciente().getNome());
		pacienteDTO.setCpf(consulta.getPaciente().getCpf());
		pacienteDTO.setTelefone(consulta.getPaciente().getTelefone());
		pacienteDTO.setEmail(consulta.getPaciente().getEmail());
		response.setPaciente(pacienteDTO);

		MedicoResponseDTO medicoDTO = new MedicoResponseDTO();
		medicoDTO.setId(consulta.getMedico().getId());
		medicoDTO.setNome(consulta.getMedico().getNome());
		medicoDTO.setCpf(consulta.getMedico().getCpf());
		medicoDTO.setTelefone(consulta.getMedico().getTelefone());
		medicoDTO.setEmail(consulta.getMedico().getEmail());
		medicoDTO.setCrm(consulta.getMedico().getCrm());

		if (consulta.getMedico().getEspecialidade() != null) {
			EspecialidadeResponseDTO espDTO = new EspecialidadeResponseDTO();
			espDTO.setId(consulta.getMedico().getEspecialidade().getId());
			espDTO.setNome(consulta.getMedico().getEspecialidade().getNome());
			espDTO.setDescricao(consulta.getMedico().getEspecialidade().getDescricao());
			medicoDTO.setEspecialidade(espDTO);
		}
		response.setMedico(medicoDTO);

		return response;
	}
	
	public void deletar(Long id) {
		Consulta consulta = consultaRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não encontrada"));
		consultaRepository.delete(consulta);
	}
}