package com.avi.ihw.groups;

import org.apache.deltaspike.core.api.scope.ConversationSubGroup;

/**<b>Author:</b>	Srividya Jawaharlal
 *<p><b>Date:</b>	05-18-2017
 *
 *<p><b>PAGE DESCRIPTION:
 *==================================================================================</b>
 * MWRS Group
 *
 *<p><b>CHANGE LOG:
 *==================================================================================
 *Date			UserName	PhoneEx.	- Comment </b><p>
 *05-18-2017	SJAWAHAR		x0898		Initial creation
 *09-28-2017	AMoram			x0821		fixing parent group
 *
 */
@ConversationSubGroup(of = IHWGrp.class, subGroup = MWRSGrp.class)
public class MWRSImplicitSubGrp {

}
