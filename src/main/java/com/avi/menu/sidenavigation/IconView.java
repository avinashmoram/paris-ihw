package com.avi.menu.sidenavigation;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;

@ManagedBean(name="treeIconView")
@SessionScoped
public class IconView implements Serializable {


	private static final long serialVersionUID = -1896720664709374590L;
	private TreeNode root;
	private TreeNode selectedNode;

	@ManagedProperty("#{documentService}")
	private DocumentService service;

	@PostConstruct
	public void init() {
		root = service.createDocuments();
	}

	public void setService(DocumentService service) {
		this.service = service;
	}

	public TreeNode getRoot() {
		return root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public void onNodeSelect(NodeSelectEvent event) throws IOException{
		TreeNode currentNode = event.getTreeNode();
		Document doc = new Document("Home", "home", "Folder");
		if(currentNode.getData() instanceof Document){
			doc = (Document) currentNode.getData();
		}

		currentNode.setSelected(true);
		TreeNode parent = currentNode.getParent();
		currentNode.getRowKey();

		if(!parent.isExpanded()){
			expand(parent);
		}


		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		String url = request.getRequestURI();
		//		System.err.println("url-"+url);
		/*System.err.println("request.getContextPath()-"+request.getContextPath());
		System.err.println((request.getContextPath()+"/pages/").length()+"-"+url.indexOf("."));
		String nodeText = url.substring((request.getContextPath()+"/pages/").length(), url.indexOf("."));*/
		String nodeText = url.substring(url.lastIndexOf('/')+1, url.indexOf('.'));

		//		System.err.println(nodeText+":nodeText");
		findNode(nodeText, getRoot());



		//		int length = (request.getContextPath()+"/").length();
		//		System.err.println(request.getContextPath());
		//		String baseURL = url.substring(length, url.length() - request.getRequestURI().length());
		//		System.err.println(baseURL);

		ec.redirect(ec.getApplicationContextPath()+"/"+doc.getLink()+".xhtml");

		/* Use the below when you have additional request parameters that you woudl like to send
		 * ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		String url = request.getRequestURL().toString();
		System.err.println("url:"+url);
		String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
		System.err.println(baseURL+doc.getLink()+".xhtml");
		ec.redirect(baseURL+doc.getLink()+".xhtml");*/
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

	private void expand(TreeNode treeNode){
		if (treeNode.getParent()!=null){
			treeNode.getParent().setExpanded(true);
			expand(treeNode.getParent());
		}
	}

	private void findNode(String nodeText, TreeNode parent){
		//		System.err.println("Trying to find node:"+nodeText);
		//		boolean found = false;
		for (TreeNode node : parent.getChildren()) {
			//			System.err.println("Childern:"+parent.getChildren());
			if(!node.isLeaf()){
				//				System.err.println(node.toString()+": not a leaf");
				findNode(nodeText, node);
			} else {
				String tempUrl = ((Document)node.getData()).getLink();
				//				System.err.println(nodeText+":nodeText, node:"+tempUrl.split("/")[1]);
				if (nodeText.equals(tempUrl.split("/")[1])) {
					//					System.out.println("found the node to select" + node.getData().toString());
					node.setSelected(false);
					//					found = true;
					break;
				}
			}
		}
		/*if(found){
			System.out.println(nodeText+"- FOUND yay!");
		}*/
		//		System.out.println(nodeText+"-NOT FOUND");
	}

}
