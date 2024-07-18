package br.com.hotelCalifornia.infraestructure.exceptions.handle;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.hotelCalifornia.infraestructure.exceptions.BusinessException;
import br.com.hotelCalifornia.infraestructure.exceptions.ConflictException;
import br.com.hotelCalifornia.infraestructure.exceptions.UnprocessableEntityException;



@ControllerAdvice  //esta anotação é necessária para informar o que será manipulado, no caso pode ser o business ou conflict...
public class GlobalExceptionHandler {


	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErroResponse> handleBusReponseEntity(BusinessException ex, HttpServletRequest request){
			return response(ex.getMessage(), request, HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());	
	}
	
	
	@ExceptionHandler(ConflictException.class)
	public ResponseEntity<ErroResponse> handleConflictException(ConflictException cf, HttpServletRequest request){
			return response(cf.getMessage(), request, HttpStatus.CONFLICT, LocalDateTime.now());	
	}
	
	@ExceptionHandler(UnprocessableEntityException.class)
	public ResponseEntity<ErroResponse> handleUnprocessableEntityException(UnprocessableEntityException unp, HttpServletRequest request){
			return response(unp.getMessage(), request, HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now());	
	}
	
	
	private ResponseEntity<ErroResponse> response(final String message, final HttpServletRequest request,
		final HttpStatus status, LocalDateTime data){
		return ResponseEntity.status(status)
				.body(new ErroResponse(message, data, status.value(), request.getRequestURI()));
	}
}
