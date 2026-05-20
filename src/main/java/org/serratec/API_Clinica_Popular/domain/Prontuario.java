package org.serratec.API_Clinica_Popular.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prontuario")
public class Prontuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 500)
	private String historicoMedico;

	@Column(nullable = false, length = 100)
	private String observacoesAlergias;

	
	@OneToOne
	@JoinColumn(name = "paciente_id", nullable = false, unique = true)
	private Paciente paciente;

	
	public Prontuario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHistoricoMedico() {
		return historicoMedico;
	}

	public void setHistoricoMedico(String historicoMedico) {
		this.historicoMedico = historicoMedico;
	}

	public String getObservacoesAlergias() {
		return observacoesAlergias;
	}

	public void setObservacoesAlergias(String observacoesAlergias) {
		this.observacoesAlergias = observacoesAlergias;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}