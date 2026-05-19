package org.serratec.API_Clinica_Popular.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.API_Clinica_Popular.domain.Especialidade;
import org.serratec.API_Clinica_Popular.dto.EspecialidadeRequestDTO;
import org.serratec.API_Clinica_Popular.dto.EspecialidadeResponseDTO;
import org.serratec.API_Clinica_Popular.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EspecialidadeService {

	@Autowired
    private EspecialidadeRepository repository;
    
    public List<EspecialidadeResponseDTO> listarTodos() {
    	
        List<Especialidade> lista = repository.findAll();
        return lista.stream().map(especialidade -> {
        	
            EspecialidadeResponseDTO response = new EspecialidadeResponseDTO();
            response.setId(especialidade.getId());
            response.setNome(especialidade.getNome());
            response.setDescricao(especialidade.getDescricao());
            return response;
            
        }).collect(Collectors.toList());
    }

    public EspecialidadeResponseDTO buscarPorId(Long id) {
       
        Especialidade especialidade = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidade não encontrada"));

        EspecialidadeResponseDTO response = new EspecialidadeResponseDTO();
        response.setId(especialidade.getId());
        response.setNome(especialidade.getNome());
        response.setDescricao(especialidade.getDescricao());
        return response;
        
    }
    
    public EspecialidadeResponseDTO criar(EspecialidadeRequestDTO dto) {

		//Converte o DTO para a Entidade real
    Especialidade especialidade = new Especialidade();
    especialidade.setNome(dto.getNome());
    especialidade.setDescricao(dto.getDescricao());

    //Salva no banco
    especialidade = repository.save(especialidade);

    EspecialidadeResponseDTO response = new EspecialidadeResponseDTO();
    response.setId(especialidade.getId());
    response.setNome(especialidade.getNome());
    response.setDescricao(especialidade.getDescricao());
    return response;
    
}

    public EspecialidadeResponseDTO atualizar(Long id, EspecialidadeRequestDTO dto) {
        
    	Especialidade especialidade = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidade não encontrada"));
    		
    		//Aqui faz a atualização
        especialidade.setNome(dto.getNome());
        especialidade.setDescricao(dto.getDescricao());

        //Salva no banco
        especialidade = repository.save(especialidade);

        EspecialidadeResponseDTO response = new EspecialidadeResponseDTO();
        response.setId(especialidade.getId());
        response.setNome(especialidade.getNome());
        response.setDescricao(especialidade.getDescricao());
        return response;
        
    }

    public void deletar(Long id) {
        Especialidade especialidade = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidade não encontrada"));
        
        repository.delete(especialidade);
    }
}