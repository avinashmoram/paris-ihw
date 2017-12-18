package com.avi.ihw.mspr;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


@ManagedBean (name = "msprSearchResultsView")
public class MSPRSearchResultsView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<MSPR> mspr;

	@ManagedProperty("#{msprSearchResultsService}")
	private MSPRSearchResultsService service;

	@PostConstruct
	public void init() {
		mspr = service.createMSPR(110);
	}
























	public List<MSPR> getMwrs() {
		return mspr;
	}

	public void setService(MSPRSearchResultsService service) {
		this.service = service;
	}
}