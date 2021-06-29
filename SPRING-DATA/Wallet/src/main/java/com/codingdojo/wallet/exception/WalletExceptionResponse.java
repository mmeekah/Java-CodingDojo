package com.codingdojo.wallet.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WalletExceptionResponse {
    public WalletExceptionResponse(String message) {
		// TODO Auto-generated constructor stub
	}

	private String id;
}