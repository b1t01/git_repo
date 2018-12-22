package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Poi;
import main.service.PoiService;

public class PoiReadView implements View {
	private String mode = "";
	private String scelta1;
	private PoiService poiService = new PoiService();

	public PoiReadView() {

	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();

	}

	@Override
	public void showOptions() {

	}

	@Override
	public void showResults(Request request) {
		if (request != null) {

			List<Poi> listapoi = (List<Poi>) request.get("listaPoi");
			System.out.println("----- Visualizza point of interests-----");
			System.out.println();
			System.out.println();
			System.out.format(
					"+------------------------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.format("%12s %40s %80s %12s %n", "1. ID ", "2. CITY", "3. HYSTORICAL");
			System.out.format(
					"+------------------------------------------------------------------------------------------------------------------------------------------------+%n");

			for (Poi poi : listapoi) {

				System.out.format("%12s %40s %80s %12s %n", poi.getId(), poi.getCity(), poi.getHistorycal());
			}
			System.out.println();
		}

	}

	@Override
	public void submit() {
		Request requestType = new Request();
		requestType.put("choice", "readPoi");
		MainDispatcher.getInstance().callAction("Poi", "doControl", requestType);

	}

}