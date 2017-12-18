package com.avi.ihw.groups;

import org.apache.deltaspike.core.api.scope.ConversationSubGroup;

@ConversationSubGroup(of = ParisGrp.class, subGroup = IHWGrp.class)
public class IHWImplicitSubGrp {
	// Implicit IHW Sub Group
}
