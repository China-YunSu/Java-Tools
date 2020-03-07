package com.mec.util;

public class FrameIsNullException extends Exception {
	private static final long serialVersionUID = -1043423513522661935L;

	public FrameIsNullException() {
	}

	public FrameIsNullException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FrameIsNullException(String message, Throwable cause) {
		super(message, cause);
	}

	public FrameIsNullException(String message) {
		super(message);
	}

	public FrameIsNullException(Throwable cause) {
		super(cause);
	}

	
}
