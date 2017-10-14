package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/admin/")
public class Controller {

	
	@GET
	@Path("/overload")
	@Produces(MediaType.APPLICATION_JSON)
	public OverVO retrieveAllProduct() {
		OverVO total = new OverVO();
		total.setCategories(DAO.retrieveAllCategories());
		total.setProduct(DAO.retrieveAllProduct());
		return total;
	}
}
