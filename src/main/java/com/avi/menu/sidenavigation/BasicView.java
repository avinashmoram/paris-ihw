package com.avi.menu.sidenavigation;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
 
@ManagedBean(name="treeBasicView")
@ViewScoped
public class BasicView implements Serializable {
     
    private TreeNode root;
     
    @PostConstruct
    public void init() {
        root = new DefaultTreeNode("Root", null);
        TreeNode home = new DefaultTreeNode("Home", root);
         
        TreeNode admin = new DefaultTreeNode("Admin", home);
        TreeNode parisUtilities = new DefaultTreeNode("PARIS Utilities", home);
        TreeNode billing = new DefaultTreeNode("Billing", home);
        TreeNode centralRegistry = new DefaultTreeNode("CR", home);
        TreeNode industrialHazardousWaste = new DefaultTreeNode("IHW", home);
         
         
        admin.getChildren().add(new DefaultTreeNode("Staff"));
        admin.getChildren().add(new DefaultTreeNode("News"));
        admin.getChildren().add(new DefaultTreeNode("Availability"));
        admin.getChildren().add(new DefaultTreeNode("PrintService"));
        admin.getChildren().add(new DefaultTreeNode("Reference Data Common"));
        
        parisUtilities.getChildren().add(new DefaultTreeNode("Communications Log"));
        parisUtilities.getChildren().add(new DefaultTreeNode("Genarate Document/Output"));
        parisUtilities.getChildren().add(new DefaultTreeNode("Reference Data"));
        parisUtilities.getChildren().add(new DefaultTreeNode("Notes Search"));
        
        billing.getChildren().add(new DefaultTreeNode("Initiate Billing"));
        billing.getChildren().add(new DefaultTreeNode("Billing Maintenance"));
        billing.getChildren().add(new DefaultTreeNode("View Billing"));
        
        centralRegistry.getChildren().add(new DefaultTreeNode("RE Search"));
        TreeNode crUtilities = new DefaultTreeNode("Utilities", centralRegistry);
        TreeNode customerUtilities = new DefaultTreeNode("Customer Utilities", crUtilities);
        TreeNode contactUtilities = new DefaultTreeNode("Contact Utilities", crUtilities);
        
        customerUtilities.getChildren().add(new DefaultTreeNode("Change Customer"));
        customerUtilities.getChildren().add(new DefaultTreeNode("Update Customer"));
        customerUtilities.getChildren().add(new DefaultTreeNode("Add Customer"));
        customerUtilities.getChildren().add(new DefaultTreeNode("Set Issued To Name"));
        
        contactUtilities.getChildren().add(new DefaultTreeNode("Change Contact"));
        contactUtilities.getChildren().add(new DefaultTreeNode("Update Contact"));
        contactUtilities.getChildren().add(new DefaultTreeNode("Add Contact"));
        
        industrialHazardousWaste.getChildren().add(new DefaultTreeNode("NOR"));
        industrialHazardousWaste.getChildren().add(new DefaultTreeNode("EAP ID Search/Generate"));
        TreeNode aws = new DefaultTreeNode("AWS", industrialHazardousWaste);
        aws.getChildren().add(new DefaultTreeNode("AWS Fee Exempt"));
        aws.getChildren().add(new DefaultTreeNode("AWS Forms Request"));
        industrialHazardousWaste.getChildren().add(new DefaultTreeNode("MWRS"));
        industrialHazardousWaste.getChildren().add(new DefaultTreeNode("MSPR"));
        industrialHazardousWaste.getChildren().add(new DefaultTreeNode("OTS & WSS"));
        industrialHazardousWaste.getChildren().add(new DefaultTreeNode("Waste Audits"));
        industrialHazardousWaste.getChildren().add(new DefaultTreeNode("Waste Recycling"));
        TreeNode ihwUtilities = new DefaultTreeNode("Utilities", industrialHazardousWaste);
        ihwUtilities.getChildren().add(new DefaultTreeNode("Merge NOR"));
        ihwUtilities.getChildren().add(new DefaultTreeNode("Unmerge NOR"));
    }
 
    public TreeNode getRoot() {
        return root;
    }
}