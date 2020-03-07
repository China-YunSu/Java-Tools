package com.mec.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ViewTool {
	public static final String TITLE = "Œ¬‹∞Ã· æ";
	
	public ViewTool() {
	
	}
	
	public static void showMessage(JFrame jframe, String message) {
		JOptionPane.showMessageDialog(jframe, message, TITLE, JOptionPane.PLAIN_MESSAGE);
	}

	public static void showErrorMessage(JFrame jframe, String message) {
		JOptionPane.showMessageDialog(jframe, message, TITLE, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void showWarnningMessage(JFrame jframe, String message) {
		JOptionPane.showMessageDialog(jframe, message, TITLE, JOptionPane.WARNING_MESSAGE);
	}
	
	public static int getChoice(JFrame jframe, String message,int optionType) {
		return JOptionPane.showConfirmDialog(jframe, message, TITLE, optionType);
	}
}
