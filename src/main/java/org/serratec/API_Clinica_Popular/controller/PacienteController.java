package org.serratec.API_Clinica_Popular.controller;

import java.util.List;

import org.serratec.API_Clinica_Popular.dto.PacienteRequestDTO;
import org.serratec.API_Clinica_Popular.dto.PacienteResponseDTO;
import org.serratec.API_Clinica_Popular.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService service;

	@GetMapping
	public List<PacienteResponseDTO> listar() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public PacienteResponseDTO buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PacienteResponseDTO criar(@Valid @RequestBody PacienteRequestDTO dto) {
		return service.criar(dto);
	}

	@PutMapping("/{id}")
	public PacienteResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody PacienteRequestDTO dto) {
		return service.atualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}
