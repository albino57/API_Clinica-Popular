package org.serratec.API_Clinica_Popular.controller;

import java.util.List;

import org.serratec.API_Clinica_Popular.dto.MedicoRequestDTO;
import org.serratec.API_Clinica_Popular.dto.MedicoResponseDTO;
import org.serratec.API_Clinica_Popular.service.MedicoService;
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
@RequestMapping ("/medicos")
public class MedicoController {

	@Autowired
	private MedicoService service;

	@GetMapping
	public List<MedicoResponseDTO> listar() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public MedicoResponseDTO buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MedicoResponseDTO criar(@Valid @RequestBody MedicoRequestDTO dto) {
		return service.criar(dto);
	}

	@PutMapping("/{id}")
	public MedicoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody MedicoRequestDTO dto) {
		return service.atualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}
