package com.sg.Identifier;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import main.java.BasePage;

public class InvoiceListidentifiers extends BasePage {
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/fournisseurNom")
	public MobileElement InvoiceListAftersearch;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/searchInvoice")
	public MobileElement InvList_SearchBox;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/add_user")
	public MobileElement InvDetl_AddApprover;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/fournisseurNom")
	public MobileElement InvDetl_Invoicename;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/pdf_detail")
	public MobileElement InvDetl_PDF;	

	@AndroidFindBy(id = "Facture détail")
	public MobileElement InvDetl_DetailsTab;
	
	@AndroidFindBy(id = "Historique")
	public MobileElement InvDetl_HistoryTab;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/btn_reject")
	public MobileElement InvDetl_RejectBtn;	
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/btn_approve")
	public MobileElement InvDetl_ApproveBtn;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/switch_on_off")
	public MobileElement InvDetl_PaySwitchBtn;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/txt_approver_comment_header")
	public MobileElement InvDetl_CommentField;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/date")
	public MobileElement InvDetl_INvoiceclick;	
	
	@AndroidFindBy(id = "android:id/text1")
	public MobileElement Approver_list;	
	
	@AndroidFindBy(id = "android:id/button1")
	public MobileElement Approver_ListOKbtn;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/addAssigneeSpinner")
	public MobileElement Approver_AddBox;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/valider")
	public MobileElement Approver_AddOK;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public MobileElement Allow_Fileaccess;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/txt_payment_comment_header")
	public MobileElement Payment_Tab;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/title")
	public MobileElement Invoice_title;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/close")
	public MobileElement Invoice_Close;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/facture")
	public MobileElement Invoice_facture;
	
	
	
	
	
	
	
	
	
	
	

}
