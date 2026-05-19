package org.serratec.API_Clinica_Popular.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PacienteRequestDTO {
	
	@NotBlank(message = "ERRO! Nome não pode ficar vazio")
    private String nome;
    
	@NotBlank(message = "ERRO! CPF não pode ficar vazio")
	@Size(max = 11, message = "O CPF deve ter apenas números e 11 números.")
    private String cpf;
    
	@NotBlank(message = "ERRO! Telefone não pode ficar vazio")
    private String telefone;
    
	@NotBlank(message = "ERRO! Email não pode ficar vazio")
	@Email(message = "ERRO! Formato de e-mail inválido. E-mail tem que ter @")
    private String email;

	
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
}
