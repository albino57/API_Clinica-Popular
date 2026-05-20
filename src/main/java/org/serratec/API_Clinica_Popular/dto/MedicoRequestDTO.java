package org.serratec.API_Clinica_Popular.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MedicoRequestDTO {
	
	@NotBlank(message = "ERRO! Nome não pode ficar vazio")
	@Size(max = 100, message = "ERRO! O nome deve ter 100 caracteres no máximo.")
    private String nome;
    
	@NotBlank(message = "ERRO! CPF não pode ficar vazio")
	@Size(max = 11, message = "ERRO! O CPF deve ter apenas números e 11 números.")
    private String cpf;
    
	@NotBlank(message = "ERRO! Telefone não pode ficar vazio")
	@Size(max = 14, message = "ERRO! Seu telefone deve ter 14 caracteres no máximo ex: [+5524981058105]")
    private String telefone;
    
	@NotBlank(message = "ERRO! Email não pode ficar vazio")
	@Email(message = "ERRO! Formato de e-mail inválido. E-mail tem que ter @")
	@Size(max = 50, message = "ERRO! O E-mail deve ter 50 caracteres no máximo.")
    private String email;
	
	@NotBlank(message = "ERRO! CRM JAMAIS pode ficar vazio")
	@Size(max = 13, message = "ERRO! O CRM deve ser ex: [CRM/RJ 123456]")
	private String crm;
	
	@NotNull(message = "ERRO! O ID da especialidade é obrigatório.")
	private Long especialidadeId;
	
	
	//os Getters e Setters ↓
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

	public Long getEspecialidadeId() {
		return especialidadeId;
	}

	public void setEspecialidadeId(Long especialidadeId) {
		this.especialidadeId = especialidadeId;
	}
}
