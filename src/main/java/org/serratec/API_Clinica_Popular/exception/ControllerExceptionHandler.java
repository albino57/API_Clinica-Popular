package org.serratec.API_Clinica_Popular.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	//Erros de validação @NotBlank...
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<String> erros = new ArrayList<>();
		
		for (FieldError buscaErro : ex.getBindingResult().getFieldErrors()) {
			erros.add(buscaErro.getDefaultMessage());
		}

		ErroResposta erroResposta = new ErroResposta();
		erroResposta.setStatus(status.value());
		erroResposta.setTitulo("ERRO! Tem campos inválidos. Preencha direitinho.");
		erroResposta.setDataHora(LocalDateTime.now());
		erroResposta.setErros(erros);

		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}

	//Erros de Regra de Negócio Not Found...
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException exMSG) {
		
		ErroResposta erroResposta = new ErroResposta();
		erroResposta.setStatus(exMSG.getStatusCode().value());
		erroResposta.setTitulo(exMSG.getReason()); 
		erroResposta.setDataHora(LocalDateTime.now());
		
		return ResponseEntity.status(exMSG.getStatusCode()).body(erroResposta);
	}
}