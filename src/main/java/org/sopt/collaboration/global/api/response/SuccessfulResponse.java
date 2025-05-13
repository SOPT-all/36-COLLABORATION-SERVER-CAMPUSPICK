package org.sopt.collaboration.global.api.response;

import org.sopt.collaboration.global.api.message.ResponseMessage;

public class SuccessfulResponse<T> extends ApiResponse {
	private final T data;

	public SuccessfulResponse(String code, String message, T data) {
		super(code, message);
		this.data = data;
	}

	public static <T> SuccessfulResponse<T> of(ResponseMessage responseMessage, T data) {
		return new SuccessfulResponse<T>(responseMessage.getCode(), responseMessage.getMessage(), data);
	}

	public T getData() {
		return this.data;
	}
}
