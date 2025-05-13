package org.sopt.collaboration.global.api.handler;

import org.sopt.collaboration.global.api.message.ResponseMessage;
import org.sopt.collaboration.global.api.response.ErrorResponse;
import org.sopt.collaboration.global.api.response.SuccessfulResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ApiResponseHandler implements ResponseBodyAdvice<Object> {
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
		Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
		ServerHttpResponse response) {

		// 예외처리된 응답에 대한 상태코드 설정 및 apiResponse wrapping 생략
		if (body instanceof ErrorResponse errorResponse) {
			return body;
		}

		// 이미 응답 형태로 감싸진 경우 바로 body를 반환
		if (body instanceof SuccessfulResponse) {
			return body;
		}

		return SuccessfulResponse.of(ResponseMessage.SUCCESS, body);
	}
}
