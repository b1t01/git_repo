package main.service;

import java.util.List;

import main.controller.Request;
import main.dao.PoiDAO;
import main.model.Poi;

public class PoiService {

	private PoiDAO poiDAO;

	public PoiService() {
		poiDAO = new PoiDAO();

	}

	public boolean deletePoi(int id) {
		return this.poiDAO.deletePoi(id);

	}

	public List<Poi> getAllPOI() {
		return this.poiDAO.getAllPoi();

	}

	public boolean insertPoi(Poi poi) {
		return this.poiDAO.insertPoi(poi);
	}

	public boolean updatePoi(Request request) {
		return this.poiDAO.updatePoi(request);
	}

}
