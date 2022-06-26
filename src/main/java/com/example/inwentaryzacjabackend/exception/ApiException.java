package com.example.inwentaryzacjabackend.exception;

import org.springframework.http.HttpStatus;
/**
 *Klasa ApiException rozszerza klasę RuntimeException
 */
public class ApiException extends RuntimeException {

	private static final long serialVersionUID = -6593330219878485669L;

	private final HttpStatus status;
	private final String message;
	/**
	 * Funkcja ApiException typu public zawiera informacje o statusie http i wyświetlanej wiadomości
	 * @param status  zmienna typu HttpStatus
	 * @param message  zmienna typu String
	 */
	public ApiException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	/**
	 * Funkcja ApiException typu public zawiera informacje o wyjątku
	 * @param status  zmienna typu HttpStatus
	 * @param message  zmienna typu String
	 * @param exception  zmienna typu Throwable
	 */
	public ApiException(HttpStatus status, String message, Throwable exception) {
		super(exception);
		this.status = status;
		this.message = message;
	}
	/**
	 * Funkcja getStatus typu public pobiera informację o statusie http
	 * @return Ta funkcja zwraca informację o statusie http
	 */
	public HttpStatus getStatus() {
		return status;
	}
	/**
	 * Funkcja getMessage typu public pobiera informację o wyświetlanej wiadomości
	 * @return Ta funkcja zwraca wiadomość
	 */
	public String getMessage() {
		return message;
	}

}
