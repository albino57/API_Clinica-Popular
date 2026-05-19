package org.serratec.API_Clinica_Popular.dto;

import jakarta.validation.constraints.NotBlank;

public class EspecialidadeRequestDTO {
	
	@NotBlank(message = "ERRO! O nome da especialidade não pode ficar em branco.")
    private String nome;
	
	@NotBlank(message = "ERRO! A descrição não pode ficar em branco.")
    private String descricao;

    
    //os Getters e Setters ↓
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
    
}
