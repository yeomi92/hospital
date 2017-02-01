package view;

import javax.swing.JOptionPane;

import controller.AdminController;
import controller.PatientController;
import enums.IndexButt;

public class index {
	public static void main(String[] args) {
		IndexButt[] buttons ={IndexButt.CLOSE,IndexButt.MEMBER,IndexButt.ADMIN};
		IndexButt select=(IndexButt)JOptionPane.showInputDialog(null,"INDEX PAGE","SELECT MENU", JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[2]);
		switch(select){
		case CLOSE: return;
		case MEMBER:
			new PatientController().start();
			break;
		case ADMIN:
			new AdminController().start();
			break;
		}
	}
}
