package com.avi.ihw.groups;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.spi.scope.conversation.GroupedConversationManager;

/**<b>Author:</b>	Srividya Jawaharlal
 *<p><b>Date:</b>	05-18-2017
 *
 *<p><b>PAGE DESCRIPTION:
 *==================================================================================</b>
 * MSPR Group
 *
 *<p><b>CHANGE LOG:
 *==================================================================================
 *Date			UserName	PhoneEx.	- Comment </b><p>
 *05-18-2017	SJAWAHAR		x0898		Initial creation
 *
 */
@Named
@SessionScoped
public class MSPRImplicitSubGrpHandler implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
    private GroupedConversationManager conversationManager;

    public void finish() {
        this.conversationManager.closeConversationGroup(MSPRImplicitSubGrp.class);
    }


}
