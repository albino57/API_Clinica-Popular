package org.serratec.API_Clinica_Popular.dto;

import java.time.LocalDateTime;

public class ConsultaResponseDTO {

	private Long id;
	private LocalDateTime dataHora;
	private PacienteResponseDTO paciente;
	private MedicoResponseDTO medico;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public PacienteResponseDTO getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteResponseDTO paciente) {
		this.paciente = paciente;
	}
	public MedicoResponseDTO getMedico() {
		return medico;
	}
	public void setMedico(MedicoResponseDTO medico) {
		this.medico = medico;
	}
}
