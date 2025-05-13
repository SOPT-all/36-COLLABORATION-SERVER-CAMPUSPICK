package org.sopt.collaboration.global.exception.message;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {
	BAD_REQUEST(HttpStatus.METHOD_NOT_ALLOWED, "FAILURE", "잘못된 HTTP method 요청입니다."),
	INVALID_TAG_NAME(HttpStatus.BAD_REQUEST, "FAILURE", "잘못된 검색조건입니다."),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "ERROR", "서버 내부 오류입니다.");

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;
}
