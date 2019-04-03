package WAFMTest;

import org.testng.annotations.Test;

import com.sg.Page.InvoiceListPage;

import main.java.BasePage;
import main.java.BaseTest;

public class InvoiceListTest extends BaseTest{
	
	InvoiceListPage InvPage = new InvoiceListPage();

	@Test(priority = 1,enabled=false)
	public void SearchInvoice() throws InterruptedException {
		InvPage.SearchInvoice();
	}
	
	@Test(priority = 2,enabled=false)
	public void verifyDetailsofInvoice() throws InterruptedException {
		InvPage.verifyDetailsofInvoice();
	}
	
	@Test(priority = 3,enabled=false)
	public void ApprovedInvoice() throws InterruptedException {
		InvPage.ApprovedInvoice();
	}
	
	@Test(priority = 4,enabled=false)
	public void RejectInvoice() throws InterruptedException {
		InvPage.RejectedInvoice();
	}
	
	@Test(priority = 5)
	public void PDFDownload() throws InterruptedException {
		InvPage.PDFDownload();
	}
	
	@Test(priority = 6)
	public void AddApprover() throws InterruptedException {
		InvPage.AddApprover();
	}




}
