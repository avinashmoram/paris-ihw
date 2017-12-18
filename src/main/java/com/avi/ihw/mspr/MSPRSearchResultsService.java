package com.avi.ihw.mspr;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;

import org.apache.deltaspike.core.api.scope.ConversationGroup;
import org.apache.deltaspike.core.api.scope.GroupedConversationScoped;

import com.avi.ihw.groups.IHWGrp;
import com.avi.ihw.groups.MSPRGrp;

@ManagedBean(name = "msprSearchResultsService")
@GroupedConversationScoped
@ConversationGroup(IHWGrp.class)
public class MSPRSearchResultsService implements Serializable, MSPRGrp{

	private static final long serialVersionUID = -8634147990284579638L;
	private final static String[] months;
	private final static String[] commercialStatus;
	private final static String[] wasteClassification;

	static {
		months = new String[12];
		months[0] = "January";
		months[1] = "February";
		months[2] = "March";
		months[3] = "April";
		months[4] = "May";
		months[5] = "June";
		months[6] = "July";
		months[7] = "August";
		months[8] = "September";
		months[9] = "October";
		months[10] = "November";
		months[11] = "December";

		commercialStatus = new String[3];
		commercialStatus[0] = "Commercial";
		commercialStatus[1] = "Non-commercial";
		commercialStatus[2] = "TEST";

		wasteClassification = new String[3];
		wasteClassification[0] = "Class 1";
		wasteClassification[1] = "Hazardous";
	}

	public List<MSPR> createMSPR(int size) {
		List<MSPR> list = new ArrayList<>();
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		for (int i = 0; i < size; i++) {
			double tempInState = getRandomeInState();
			double tempOutOfState = getRandomeOutOfState();
			list.add(new MSPR(getRandomSWR(), getRandomMonth(), getRandomYear(), getRandomCommercialStatus(),
					getRandomWasteClassification(), currencyFormatter.format(tempInState),
					currencyFormatter.format(tempOutOfState), currencyFormatter.format(tempInState + tempOutOfState)));
		}
		return list;
	}

	private String getRandomSWR() {
		return UUID.randomUUID().toString().substring(0, 5);
	}

	private int getRandomYear() {
		return (int) (Math.random() * 50 + 2000);
	}

	private String getRandomMonth() {
		return months[(int) (Math.random() * 12)];
	}

	public List<String> getMonths() {
		return Arrays.asList(months);
	}

	private String getRandomCommercialStatus() {
		return commercialStatus[(int) (Math.random() * 3)];
	}

	private String getRandomWasteClassification() {
		return wasteClassification[(int) (Math.random() * 2)];
	}

	private double getRandomeInState(){
		double d = Math.random() * 15000;
		DecimalFormat df = new DecimalFormat("#####.##");
		df.setRoundingMode(RoundingMode.DOWN);
		return Double.valueOf(df.format(d));
	}

	private double getRandomeOutOfState(){
		double d = Math.random() * 15000;
		DecimalFormat df = new DecimalFormat("#####.##");
		df.setRoundingMode(RoundingMode.DOWN);
		return Double.valueOf(df.format(d));
	}
}