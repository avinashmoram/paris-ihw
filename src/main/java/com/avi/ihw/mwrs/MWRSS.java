package com.avi.ihw.mwrs;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MWRSS implements Serializable {

	private static final long serialVersionUID = 1L;
	private String receiverSWR;
	private String month;
	private int year;

	public MWRSS() {
	}

	public MWRSS(String receiverSWR, String month, int year){
		this.receiverSWR = receiverSWR;
		this.month = month;
		this.year = year;
	}

	public String getReceiverSWR() {
		return receiverSWR;
	}

	public void setReceiverSWR(String receiverSWR) {
		this.receiverSWR = receiverSWR;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + (this.receiverSWR != null ? this.receiverSWR.hashCode() : 0);
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
		final MWRSS other = (MWRSS) obj;
		if ((this.receiverSWR == null) ? (other.receiverSWR != null) : !this.receiverSWR.equals(other.receiverSWR)) {
			return false;
		}
		return true;
	}
}
