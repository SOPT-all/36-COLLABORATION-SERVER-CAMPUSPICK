package org.sopt.collaboration.global.api.message;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseMessage {
	SUCCESS(HttpStatus.OK, "SUCCESS", "요청이 성공적으로 처리되었습니다.");

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;
}
