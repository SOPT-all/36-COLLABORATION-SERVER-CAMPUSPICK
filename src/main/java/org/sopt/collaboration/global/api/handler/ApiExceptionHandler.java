package org.sopt.collaboration.global.api.handler;

import org.sopt.collaboration.global.api.response.ErrorResponse;
import org.sopt.collaboration.global.exception.GlobalException;
import org.sopt.collaboration.global.exception.message.ExceptionMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(GlobalException.class)
	public ResponseEntity<ErrorResponse> handleGlobalException(GlobalException e) {
		ExceptionMessage exceptionMessage = e.getExceptionMessage();

		return ResponseEntity
			.status(exceptionMessage.getHttpStatus())
			.body(ErrorResponse.of(e.getExceptionMessage()));
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException() {
		ExceptionMessage exceptionMessage =ExceptionMessage.BAD_REQUEST;

		return ResponseEntity
			.status(exceptionMessage.getHttpStatus())
			.body(ErrorResponse.of(exceptionMessage));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleUndefinedException(Exception e) {
		ExceptionMessage exceptionMessage = ExceptionMessage.INTERNAL_SERVER_ERROR;

		return ResponseEntity
			.status(exceptionMessage.getHttpStatus())
			.body(ErrorResponse.of(exceptionMessage));
	}
}
