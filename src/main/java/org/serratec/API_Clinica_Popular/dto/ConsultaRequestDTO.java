package org.serratec.API_Clinica_Popular.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public class ConsultaRequestDTO {

	@NotNull(message = "ERRO! A data e hora da consulta são obrigatórias.")
	@Future(message = "ERRO! A consulta deve ser agendada para uma data e hora no futuro.")
	private LocalDateTime dataHora;

	@NotNull(message = "ERRO! O ID do paciente é obrigatório.")
	private Long pacienteId;

	@NotNull(message = "ERRO! O ID do médico é obrigatório.")
	private Long medicoId;

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}

	public Long getMedicoId() {
		return medicoId;
	}

	public void setMedicoId(Long medicoId) {
		this.medicoId = medicoId;
	}
}
