package com.avi.ihw.mwrs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;

import org.apache.deltaspike.core.api.scope.ConversationGroup;
import org.apache.deltaspike.core.api.scope.GroupedConversationScoped;

import com.avi.ihw.groups.IHWGrp;
import com.avi.ihw.groups.MWRSGrp;

@ManagedBean(name = "mwrsSearchResultsService")
@GroupedConversationScoped
@ConversationGroup(IHWGrp.class)
public class MWRSSearchResultsService implements Serializable , MWRSGrp{

	private static final long serialVersionUID = -784419375910836943L;
	private final static String[] months;

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
	}

	public List<MWRSS> createMWRS(int size) {
		List<MWRSS> list = new ArrayList<>();
		for(int i = 0 ; i < size ; i++) {
			list.add(new MWRSS(getRandomSWR(), getRandomMonth(), getRandomYear()));
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
}