package com.example.demo;

import com.example.demo.database.PrintSqlException;

import java.sql.SQLException;

// todo KORISTI ovaj exception svuda!
public class AppException extends RuntimeException {

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(Throwable cause) {
		super(cause);
		if (cause instanceof SQLException) {
			new PrintSqlException().printSQLException((SQLException) cause);
		}
	}
}
