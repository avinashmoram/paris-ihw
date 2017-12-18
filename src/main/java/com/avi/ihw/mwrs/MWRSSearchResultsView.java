package com.avi.ihw.mwrs;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
 
 
@ManagedBean (name = "mwrsSearchResultsView")
public class MWRSSearchResultsView implements Serializable {
     
	private static final long serialVersionUID = 1L;

	private List<MWRSS> mwrs;
         
	@ManagedProperty("#{mwrsSearchResultsService}")
    private MWRSSearchResultsService service;
     
    @PostConstruct
    public void init() {
        mwrs = service.createMWRS(110);
    }
 
    public List<MWRSS> getMwrs() {
        return mwrs;
    }
 
    public void setService(MWRSSearchResultsService service) {
        this.service = service;
    }
}