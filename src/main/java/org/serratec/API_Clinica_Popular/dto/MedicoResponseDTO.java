package org.serratec.API_Clinica_Popular.dto;

public class MedicoResponseDTO {
	
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String crm;
	private EspecialidadeResponseDTO especialidade;
	
	
	//os Getters e Setters ↓
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public EspecialidadeResponseDTO getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(EspecialidadeResponseDTO especialidade) {
		this.especialidade = especialidade;
	}
}
