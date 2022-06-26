package com.example.inwentaryzacjabackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 *Klasa AppException rozszerza klasę RuntimeException i występuje w przypadku błędu HTTP, który oznacza, że na serwerze występują wewnętrzne problemy.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException {
	/**
	 *serialVersionUID stała typu long
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Funkcja AppException typu public
	 * @param message  zmienna typu String
	 */
	public AppException(String message) {
		super(message);
	}
	/**
	 * @param message  zmienna typu String
	 * @param cause  zmienna typu Throwable
	 */
	public AppException(String message, Throwable cause) {
		super(message, cause);
	}
}
