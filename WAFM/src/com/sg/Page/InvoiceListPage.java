package com.sg.Page;

import java.util.List;

import javax.lang.model.util.Elements;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sg.Identifier.InvoiceListidentifiers;
import com.sg.mobile.MyIam.Utils.AppProperties;
import com.sg.mobile.MyIam.Utils.UserProperty;
import com.sg.mobile.MyIam.Utils.WAFMHelper;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import main.java.BasePage;
import main.java.BaseTest;

public class InvoiceListPage extends BasePage {

	InvoiceListidentifiers invid = new InvoiceListidentifiers();

	public ExtentTest logger;
	String className = "";
	BaseTest baseT = new BaseTest();
	WAFMHelper helper = new WAFMHelper();
	String InvoiceName, Rejectinvoice;

	public void SearchInvoice() throws InterruptedException {
		className = this.getClass().getName();
		createDirectory("WAFM" + className);
		logger = baseT.extent.startTest("launch app ");

		List<MobileElement> list1 = driver.findElements(By.id("com.sg.R27A.waf:id/fournisseurNom"));
		InvoiceName = list1.get(2).getText();
		Thread.sleep(2000);
		invid.InvList_SearchBox.click();
		invid.InvList_SearchBox.sendKeys(InvoiceName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);

		if (invid.InvoiceListAftersearch.getText().equals(InvoiceName) == true) {
			logger.log(LogStatus.PASS,
					"1: Search Invoice " + "<br/>" + "2 : Verify invoice can be search " + "<br/>"
							+ "<b>Result: Invoice should be displayed. <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "search invoice")));
		} else {
			logger.log(LogStatus.FAIL, "invoice is not displayed");
		}

	}

	public void verifyDetailsofInvoice() {

		invid.InvDetl_Invoicename.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		try {
			Assert.assertTrue(helper.isElementPresent(invid.InvDetl_AddApprover), " Add Approver button is Seen");
			logger.log(LogStatus.PASS, "a : Add Approver button present on home page " + "<br/>"
					+ "<b>Result: Add Approver button is Seen <b>");

		} catch (Error e) {
			logger.log(LogStatus.FAIL, "a :  Add Approver button is not present on home page " + "<br/>"
					+ "<b>Result: Add Approver button is not available <b>");
		}

		try {
			Assert.assertTrue(helper.isElementPresent(invid.InvDetl_PDF), "PDF icon is Seen");
			logger.log(LogStatus.PASS,
					"a : PDF icon present on home page " + "<br/>" + "<b>Result: PDF icon is Seen <b>");

		} catch (Error e) {
			logger.log(LogStatus.FAIL, "a :  PDF icon field is not present on home page " + "<br/>"
					+ "<b>Result: PDF icon is not available <b>");
		}

		try {
			Assert.assertTrue(helper.isElementPresent(invid.InvDetl_DetailsTab), "Invoice Details Tab  is Seen");
			logger.log(LogStatus.PASS, "a : Invoice Details Tab present on home page " + "<br/>"
					+ "<b>Result: Invoice Details Tab is Seen <b>");

		} catch (Error e) {
			logger.log(LogStatus.FAIL, "a : Invoice Details Tab field is not present on home page " + "<br/>"
					+ "<b>Result: Invoice Details Tab is not available <b>");
		}

		try {
			Assert.assertTrue(helper.isElementPresent(invid.InvDetl_HistoryTab), "Invoice history Tab is Seen");
			logger.log(LogStatus.PASS, "a : Verify Invoice history Tab field present on home page " + "<br/>"
					+ "<b>Result: Invoice history Tab is Seen <b>");

		} catch (Error e) {
			logger.log(LogStatus.FAIL, "a :  Invoice history Tab field is not present on home page " + "<br/>"
					+ "<b>Result: Invoice history Tab is not available <b>");
		}

		try {
			Assert.assertTrue(helper.isElementPresent(invid.InvDetl_RejectBtn), "Reject button is Seen");
			logger.log(LogStatus.PASS,
					"a : Reject button present on home page " + "<br/>" + "<b>Result: Reject button is Seen <b>");

		} catch (Error e) {
			logger.log(LogStatus.FAIL, "a : Reject button is not  present on home page " + "<br/>"
					+ "<b>Result: Reject button is not available <b>");
		}

		try {
			Assert.assertTrue(helper.isElementPresent(invid.InvDetl_ApproveBtn), "Approver button is Seen");
			logger.log(LogStatus.PASS,
					"a : Approver button present on home page " + "<br/>" + "<b>Result: Block/Valid Tab is Seen <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, " Invoice details page ")));

		} catch (Error e) {
			logger.log(LogStatus.FAIL,
					"a : Approver button is not  field present on home page " + "<br/>"
							+ "<b>Result: Block/Valid Tab is not available <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, " Invoice details page ")));
		}

		helper.scrollTo("Paiment");

		try {
			Assert.assertTrue(helper.isElementPresent(invid.InvDetl_PaySwitchBtn), "payment button is Seen");
			logger.log(LogStatus.PASS,
					"a : payment button is  present on home page " + "<br/>" + "<b>Result: payment button is Seen <b>");

		} catch (Error e) {
			logger.log(LogStatus.FAIL, "a : payment button field present on home page " + "<br/>"
					+ "<b>Result: payment button is not available <b>");
		}

		try {
			Assert.assertTrue(helper.isElementPresent(invid.InvDetl_CommentField), "commend option  is Seen");
			logger.log(LogStatus.PASS,
					"a : commend option is  present on home page " + "<br/>" + "<b>Result: commend option  is Seen <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, " Invoice details page ")));

		} catch (Error e) {
			logger.log(LogStatus.FAIL,
					"a : commend option  field present on home page " + "<br/>"
							+ "<b>Result:commend option  is not available <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, " Invoice details page ")));
		}

	}

	public void ApprovedInvoice() {

		invid.InvDetl_ApproveBtn.click();
		driver.switchTo().alert().accept();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		invid.InvList_SearchBox.sendKeys(InvoiceName);

		if (invid.InvoiceListAftersearch.getText().equals(InvoiceName) == false) {
			logger.log(LogStatus.PASS,
					"1: Search approved Invoice " + "<br/>" + "2 : Verify approved invoice" + "<br/>"
							+ "<b>Result: Approved invoice should not be displayed <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Verify with approved invoice")));
		} else {
			logger.log(LogStatus.FAIL, "invoice is displayed");
		}
	}

	public void RejectedInvoice() throws InterruptedException {

		helper.swaipverticle(driver, 0.50, 0.90);
		Thread.sleep(5000);
		List<MobileElement> list1 = driver.findElements(By.id("com.sg.R27A.waf:id/fournisseurNom"));
		Rejectinvoice = list1.get(1).getText();
		invid.InvList_SearchBox.sendKeys(Rejectinvoice);
		Thread.sleep(2000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
		invid.InvDetl_INvoiceclick.click();
		invid.InvDetl_RejectBtn.click();		
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		if (invid.InvoiceListAftersearch.getText().equals(Rejectinvoice) == false) {
			logger.log(LogStatus.PASS,
					"1: Search rejected Invoice " + "<br/>" + "2 : Verify rejected invoice" + "<br/>"
							+ "<b>Result: rejected invoice should not be displayed <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Verify with rejected invoice")));
		} else {
			logger.log(LogStatus.FAIL, "invoice is displayed");
		}
	}
		
		public void PDFDownload() throws InterruptedException {

			invid.InvDetl_Invoicename.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}			
			String invoice = invid.Invoice_facture.getText();
			String invoicenumber = invoice.substring(10);
			System.out.println(invoicenumber);
			invid.InvDetl_PDF.click();
			//driver.switchTo().alert().accept();
			//com.android.packageinstaller:id/permission_allow_button
			if(invid.Allow_Fileaccess.isDisplayed() == true){
				invid.Allow_Fileaccess.click();
			}
			Thread.sleep(2000);			
			String FileLocation = "/storage/emulated/.WAF/.invoice/";
			String Filename = "INV_"+invoicenumber;
			System.out.println(Filename);	
			
			if (helper.isFileDownloaded(FileLocation,Filename) == true) {
				logger.log(LogStatus.PASS,
						"1: File is downloaded " + "<br/>" + "2 : PDF is downloaded" + "<br/>"
								+ "<b>Result: PDF is present on path <b>");
			} else {
				logger.log(LogStatus.FAIL, "PDF is not present");
			}		
					
			invid.Invoice_Close.click();
		}
			
			public void AddApprover() throws InterruptedException {

				helper.swaipverticle(driver, 0.50, 0.90);
				Thread.sleep(5000);
				List<MobileElement> list1 = driver.findElements(By.id("com.sg.R27A.waf:id/fournisseurNom"));
				Rejectinvoice = list1.get(1).getText();
				invid.InvList_SearchBox.sendKeys(Rejectinvoice);
				Thread.sleep(2000);

				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
				invid.InvDetl_INvoiceclick.click();

				invid.InvDetl_AddApprover.click();
				invid.Approver_AddBox.click();
				List<MobileElement> approverList = driver.findElements(By.id("android:id/text1"));
				approverList.get(1).click();
				invid.Approver_ListOKbtn.click();
				invid.Approver_AddOK.click();
				
				
			

				if (invid.InvoiceListAftersearch.getText().equals(Rejectinvoice) == false) {
					logger.log(LogStatus.PASS,
							"1: Search rejected Invoice " + "<br/>" + "2 : Verify rejected invoice" + "<br/>"
									+ "<b>Result: rejected invoice should not be displayed <b>"
									+ logger.addScreenCapture(captureScreenShot(driver, "Verify with rejected invoice")));
				} else {
					logger.log(LogStatus.FAIL, "invoice is displayed");
				}

	}
	
	
	
	
	

}
