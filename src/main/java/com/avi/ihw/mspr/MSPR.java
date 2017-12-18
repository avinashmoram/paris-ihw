package com.avi.ihw.mspr;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MSPR implements Serializable {

	private static final long serialVersionUID = 1L;
	private String swrNumber;
	private String reportMonth;
	private int reportYear;
	private String commercialStatus;
	private String wasteClassification;
	private String inState;
	private String outOfState;
	private String total;


	public MSPR() {
	}

	public MSPR(String swrNumber, String month, int year, String commercialStatus, String wasteClassification,
			String inState, String outOfState, String total) {
		this.swrNumber = swrNumber;
		this.reportMonth = month;
		this.reportYear = year;
		this.commercialStatus = commercialStatus;
		this.wasteClassification = wasteClassification;
		this.inState = inState;
		this.outOfState = outOfState;
		this.total = total;
	}

	public String getReportMonth() {
		return reportMonth;
	}

	public void setReportMonth(String reportMonth) {
		this.reportMonth = reportMonth;
	}

	public int getReportYear() {
		return reportYear;
	}

	public void setReportYear(int reportYear) {
		this.reportYear = reportYear;
	}

	public String getSwrNumber() {
		return swrNumber;
	}

	public void setSwrNumber(String swrNumber) {
		this.swrNumber = swrNumber;
	}

	public String getCommercialStatus() {
		return commercialStatus;
	}

	public void setCommercialStatus(String commercialStatus) {
		this.commercialStatus = commercialStatus;
	}

	public String getWasteClassification() {
		return wasteClassification;
	}

	public void setWasteClassification(String wasteClassification) {
		this.wasteClassification = wasteClassification;
	}

	public String getInState() {
		return inState;
	}

	public void setInState(String inState) {
		this.inState = inState;
	}

	public String getOutOfState() {
		return outOfState;
	}

	public void setOutOfState(String outOfState) {
		this.outOfState = outOfState;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + (this.swrNumber != null ? this.swrNumber.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final MSPR other = (MSPR) obj;
		if ((this.swrNumber == null) ? (other.swrNumber != null) : !this.swrNumber.equals(other.swrNumber)) {
			return false;
		}
		return true;
	}
}
