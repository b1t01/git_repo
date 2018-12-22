package main.controller;

import main.MainDispatcher;
import main.service.GamerService;

public class SuperController implements Controller {
	GamerService gamerservice = new GamerService();

	@Override
	public void doControl(Request request) {
		String operazione = request.getString("operazione").toString();

		switch (operazione) {
		case "inserimento":
			gamerservice.insertGamer(request.get("username").toString(),request.get("password").toString());
			MainDispatcher.getInstance().callView("GestioneGamer",request);
			break;
		case "modifica":
			gamerservice.updateGamerPassword(request.get("password").toString());
			MainDispatcher.getInstance().callView("SuperUserView",null);
			break;
		case "rimozione":
			gamerservice.removeGamer(request.get("username").toString());
			MainDispatcher.getInstance().callView("SuperUserView",null);
			break;
		default:
			break;
		}
	}

}
