package com.avi.menu.sidenavigation;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "documentService")
@ApplicationScoped
public class DocumentService {

	public TreeNode createDocuments() {
		TreeNode root = new DefaultTreeNode(new Document("Menu", "pages/home", "Folder"), null);
		TreeNode home = new DefaultTreeNode(new Document("Home", "pages/home", "Folder"), root);

		/*// Home
		TreeNode admin = new DefaultTreeNode(new Document("Admin", "pages/home", "Folder"), home);
		TreeNode parisUtilities = new DefaultTreeNode(new Document("PARIS Utilities", "pages/home", "Folder"), home);
		TreeNode billing = new DefaultTreeNode(new Document("Billing", "pages/home", "Folder"), home);
		TreeNode centralRegistry = new DefaultTreeNode(new Document("CR", "pages/home", "Folder"), home);*/
		TreeNode industrialHazardousWaste = new DefaultTreeNode(new Document("IHW", "pages/home", "Folder"), home);

		/*// Admin
		TreeNode staff = new DefaultTreeNode("document", new Document("Staff", "pages/home", "Document"), admin);
		TreeNode news = new DefaultTreeNode("document", new Document("News", "pages/home", "Document"), admin);
		TreeNode availability = new DefaultTreeNode("document", new Document("Availability", "pages/home", "Document"), admin);
		TreeNode printService = new DefaultTreeNode("document", new Document("PrintService", "pages/home", "Document"), admin);
		TreeNode referenceDataCommon = new DefaultTreeNode("document", new Document("Reference Data Common", "pages/home", "Document"), admin);

		// PARIS Utilities
		TreeNode communicationsLog = new DefaultTreeNode("document", new Document("Communications Log", "pages/home", "Document"), parisUtilities);
		TreeNode generateDocumentOrOutput = new DefaultTreeNode("document", new Document("Generate Document/Output", "pages/home", "Document"), parisUtilities);
		TreeNode referenceData = new DefaultTreeNode("document", new Document("Reference Data", "pages/home", "Document"), parisUtilities);
		TreeNode notesSearch = new DefaultTreeNode("document", new Document("Notes Search", "pages/home", "Document"), parisUtilities);

		// Billing
		TreeNode initiateBilling = new DefaultTreeNode("document",new Document("Initiate Billing", "pages/home", "Document"), billing);
		TreeNode billingMaintenance = new DefaultTreeNode("document",new Document("Billing Maintenance", "pages/home", "Document"), billing);
		TreeNode viewBilling = new DefaultTreeNode("document", new Document("View Billing", "pages/home", "Document"), billing);

		// CR index Central Registry
		TreeNode reSearch = new DefaultTreeNode("document", new Document("RE Search", "pages/home", "Document"), centralRegistry);
		TreeNode crUtilities = new DefaultTreeNode(new Document("Utilities", "pages/home", "Folder"), centralRegistry);
		TreeNode customerUtilities = new DefaultTreeNode(new Document("Customer Utilities", "pages/home", "Folder"), crUtilities);
		TreeNode contactUtilities = new DefaultTreeNode(new Document("Contact Utilities", "pages/home", "Folder"), crUtilities);

		// CR index> Customer Utilities
		TreeNode changeCustomer = new DefaultTreeNode("document", new Document("Change Customer", "pages/home", "Document"), customerUtilities);
		TreeNode updateCustomer = new DefaultTreeNode("document", new Document("Update Customer", "pages/home", "Document"), customerUtilities);
		TreeNode addCustomer = new DefaultTreeNode("document", new Document("Add Customer", "pages/home", "Document"), customerUtilities);
		TreeNode setIssuedToName = new DefaultTreeNode("document", new Document("Set Issued To Name", "pages/home", "Document"), customerUtilities);

		// CR index> Contact Utilities
		TreeNode changeContact = new DefaultTreeNode("document", new Document("Change Contact", "pages/home", "Document"), contactUtilities);
		TreeNode updateContact = new DefaultTreeNode("document", new Document("Update Contact", "pages/home", "Document"), contactUtilities);
		TreeNode addContact = new DefaultTreeNode("document", new Document("Add Contact", "pages/home", "Document"), contactUtilities);

		// IHW Industrial Hazardous Waste
		TreeNode nor = new DefaultTreeNode("document",new Document("NOR", "pages/home", "Document"), industrialHazardousWaste);
		TreeNode eapIdSearchOrGenerate = new DefaultTreeNode("document",new Document("EAP ID Search/Generate", "pages/home", "Document"), industrialHazardousWaste);
		TreeNode aws = new DefaultTreeNode(new Document("AWS", "pages/home", "Folder"), industrialHazardousWaste);
		TreeNode awsFeeExempt = new DefaultTreeNode("document", new Document("AWS Fee Exempt", "pages/home", "Document"), aws);
		TreeNode awsFormsRequest = new DefaultTreeNode("document", new Document("AWS Forms Request", "pages/home", "Document"), aws);*/
		TreeNode mwrs = new DefaultTreeNode("document", new Document("MWRS", "pages/mwrs", "Document"), industrialHazardousWaste);
		TreeNode mspr = new DefaultTreeNode("document", new Document("MSPR", "pages/mspr", "Document"), industrialHazardousWaste);
		/*TreeNode otsAndWSS = new DefaultTreeNode("document", new Document("OTS & WSS", "pages/home", "Document"), industrialHazardousWaste);
		TreeNode wasteAudits = new DefaultTreeNode("document", new Document("Waste Audits", "pages/home", "Document"), industrialHazardousWaste);
		TreeNode wasteRecycling = new DefaultTreeNode("document", new Document("Waste Recycling", "pages/home", "Document"), industrialHazardousWaste);
		TreeNode ihwUtilities = new DefaultTreeNode(new Document("Utilities", "pages/home", "Folder"), industrialHazardousWaste);
		TreeNode mergeNOR = new DefaultTreeNode("document", new Document("Merge NOR", "pages/home", "Document"), ihwUtilities);
		TreeNode unmergeNOR = new DefaultTreeNode("document", new Document("Unmerge NOR", "pages/home", "Document"), ihwUtilities);*/
		collapsingORexpanding(root, true);
		home.setExpanded(true);
		//		mwrs.setSelected(true);
		return root;
	}

	public void collapsingORexpanding(TreeNode n, boolean option) {
		if(n.getChildren().size() == 0) {
			n.setSelected(false);
		}
		else {
			for(TreeNode s: n.getChildren()) {
				collapsingORexpanding(s, option);
			}
			n.setExpanded(option);
			n.setSelected(false);
		}
	}
}