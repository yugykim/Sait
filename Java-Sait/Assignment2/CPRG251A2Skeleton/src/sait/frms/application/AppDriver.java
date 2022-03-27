package sait.frms.application;

import sait.frms.gui.MainWindow;

import java.io.FileNotFoundException;

/**
 * Application driver.
 * 
 */
public class AppDriver {

	/**
	 * Entry point to Java application.
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		MainWindow mainWindow = new MainWindow();
		mainWindow.display();
	}

}
