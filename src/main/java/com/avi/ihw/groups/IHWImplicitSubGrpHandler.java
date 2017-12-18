package com.avi.ihw.groups;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.spi.scope.conversation.GroupedConversationManager;

/**<b>Author:</b>	Avinash Moram
 *<p><b>Date:</b>	05-11-2017
 *
 *<p><b>PAGE DESCRIPTION:
 *==================================================================================</b>
 * This class is used for closing the IHWGroup
 *
 *<p><b>CHANGE LOG:
 *==================================================================================
 *Date			UserName	PhoneEx.	- Comment </b><p>
 *05-11-2017	AMORAM		x0821		Initial creation
 *
 */
@Named
@SessionScoped
public class IHWImplicitSubGrpHandler implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
    private GroupedConversationManager conversationManager;

    public void finish() {
        this.conversationManager.closeConversationGroup(IHWImplicitSubGrp.class);
    }
}