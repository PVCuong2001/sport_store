package main;

import java.awt.EventQueue;

import controller.ControllerLogin;
import controller.ControllerMainView;
import view.Login;
import view.MainView;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					ControllerLogin c = new ControllerLogin(frame);
					c.ActionButtonLogin();
					c.ActionButtonReset();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



}
