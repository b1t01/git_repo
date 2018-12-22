package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class GestionePOIView implements View {

	private int scelta;

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void showOptions() {
		System.out.println("Gestisci POI");
		System.out.println("1-Insert");
		System.out.println("2-View");
		System.out.println("3-Modify");
		System.out.println("4-Delete");

		scelta = Integer.parseInt(getInput());

	}

	public void showResults(Request request) {

	}

	public void submit() {
		Request request = new Request();
		switch (this.scelta) {
		case 1:
			request.put("scelta", "insert");
			MainDispatcher.getInstance().callAction("GestionePOI", "doControl", request);
			return;
		case 2:
			request.put("scelta", "view");
			MainDispatcher.getInstance().callAction("GestionePOI", "doControl", request);
			return;
		case 3:
			request.put("scelta", "modify");
			MainDispatcher.getInstance().callAction("GestionePOI", "doControl", request);
			return;
		case 4:
			request.put("scelta", "delete");
			MainDispatcher.getInstance().callAction("GestionePOI", "doControl", request);
			return;
		default:
			return;
		}

	}
}