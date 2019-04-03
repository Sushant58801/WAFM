package com.sg.Page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sg.Identifier.LoginIdentifier;
import com.sg.mobile.MyIam.Utils.AppProperties;
import com.sg.mobile.MyIam.Utils.AppStringConstants;
import com.sg.mobile.MyIam.Utils.WAFMHelper;
import com.sg.mobile.MyIam.Utils.UserProperty;

import main.java.BasePage;
import main.java.BaseTest;
import main.java.DriverController;

public class LoginPage extends BasePage {

	LoginIdentifier login = new LoginIdentifier();
	DriverController driverc = new DriverController();
	private SoftAssert homePage = new SoftAssert();
	private SoftAssert hamburger = new SoftAssert();
	private SoftAssert pointDe = new SoftAssert();
	public ExtentTest logger;
	WAFMHelper helper = new WAFMHelper();
	String className = "";
	String userName = AppProperties.getProperty(UserProperty.APP_USER_NAME, "testindec2");
	String passWord = AppProperties.getProperty(UserProperty.APP_PASSWORD, "testppdev");
	BaseTest baseT = new BaseTest();

	public void launch() throws InterruptedException {
		className = this.getClass().getName();
		createDirectory("WAFM" + className);
		logger = baseT.extent.startTest("launch app ");
		
		if (helper.isElementPresent(login.Login_SGID)) {
			logger.log(LogStatus.PASS,
					"a : Verify applcation Launch in mobile " + "<br/>"
							+ "<b>Result: applcation Launched successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Applcation Launched sucessfully ")));
		} else {
			logger.log(LogStatus.FAIL,
					"a : Verify applcation Launch in mobile  " + "<b>Result: Applcation not Launched <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Application not launched")));
		}

	}

	public void performLogin() throws InterruptedException {

		logger = baseT.extent.startTest("Perform Login ");
		login.Login_SGID.sendKeys(userName);
		System.out.print(userName);
		login.Login_Password.sendKeys(passWord);
		login.Login_ConnectionBtn.click();
		Thread.sleep(1000);
		if (helper.isElementPresent(login.InvList_SearchBox)) {
			logger.log(LogStatus.PASS,
					"a : Verify user able to logged in " + "<br/>" + "<b>Result: User Logged in successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, " User Logged in successfully  ")));
		}

		else {
			logger.log(LogStatus.PASS, "a : Verify user able to logged in " + "<br/>" + "<b>Result: Lgged in fail <b>"
					+ logger.addScreenCapture(captureScreenShot(driver, "Lgged in fail ")));
		}

	}

	public void verifyHomePage() throws InterruptedException {

		// homePage.assertTrue(
		// helper.isElementPresent(login.im_Points_de_ventes_titleTab),
		// "POINTS DE VENTES is Seen");
		
			WebDriverWait wait = new WebDriverWait(driver,50);
			WebElement waitforlist;
			waitforlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.sg.R27A.waf:id/fournisseurNom")));
			
		
		logger = baseT.extent.startTest("Verify home page");
		try {
			Assert.assertTrue(helper.isElementPresent(login.InvList_BlockTab), "Block/Valid Tab is Seen");
			logger.log(LogStatus.PASS, "a : Verify Block/Valid Tab field present on home page " + "<br/>"
					+ "<b>Result: Block/Valid Tab is Seen <b>");

		} catch (Error e) {
			logger.log(LogStatus.FAIL, "a : Verify Block/Valid Tab field present on home page " + "<br/>"
					+ "<b>Result: Block/Valid Tab is not available <b>");
		}
		try {
			Assert.assertTrue(helper.isElementPresent(login.InvList_Drawer), "Drawer option is Seen");
			logger.log(LogStatus.PASS,
					"b :Verify  Drawer option is avaiable on home page " + "<br/>" + "<b>Result: Drawer option is Seen <b>");

		}

		catch (Error e) {
			logger.log(LogStatus.FAIL,
					"b : Verify  Drawer option is avaiable on home page " + "<br/>" + "<b>Result: Drawer option is not Seen <b>");

		}
		try {
			homePage.assertTrue(helper.isElementPresent(login.InvList_PendingTab), "Pending tab is Seen");
			logger.log(LogStatus.PASS,
					"c : Verify  Pending tab  is avaiable on home page " + "<br/>" + "<b>Result: Pending tab  is Seen <b>");

		} catch (Error e) {
			logger.log(LogStatus.FAIL, "d : Verify  Pending tab  is avaiable on home page " + "<br/>"
					+ "<b>Result: Pending tab  is not Seen <b>");
		}

		try {

			homePage.assertTrue(helper.isElementPresent(login.InvList_WAFMIcon), "WAFM Icon is Seen");
			logger.log(LogStatus.PASS,
					"d : Verify  WAFM Icon is avaiable on home page " + "<br/>" + "<b>Result: WAFM Icon is Seen <b>"+ 
			logger.addScreenCapture(captureScreenShot(driver, " User Logged in successfully  ")));
		} catch (Error e) {
			logger.log(LogStatus.FAIL, "d : Verify  WAFM Icon is avaiable on home page " + "<br/>"
					+ "<b>Result: WAFM Icon is  not Seen <b>");
		}
		
		homePage.assertAll();
	}
		
	public void verifyHamburgerMenu() {
		
		logger = baseT.extent.startTest("Verify HamburgerMenu");
		login.imgBtn_hamburger_homePage.click();
		try {
			hamburger.assertTrue(helper.isElementPresent(login.hamburgerList.get(1)), "Self is Seen");
			logger.log(LogStatus.PASS, "a : Verify Nom deSelf is Seen  is avaiable in HamburgerMenu " + "<br/>"
					+ "<b>Result: Self is Seen is Seen <b>");

		} catch (Error e) {
			hamburger.assertTrue(helper.isElementPresent(login.hamburgerList.get(1)), "Self is Seen");
			logger.log(LogStatus.FAIL, "a : Verify Nom deSelf   is avaiable in HamburgerMenu " + "<br/>"
					+ "<b>Result: Self is Seen is Seen <b>");
		}
		try {
			hamburger.assertTrue(helper.isElementPresent(login.hamburgerList.get(2)), "Favoris is Seen");
			logger.log(LogStatus.PASS,
					"b : Verify Favoris  is avaiable in HamburgerMenu " + "<br/>" + "<b>Result: Favoris is Seen <b>");
		} catch (Error e) {
			hamburger.assertTrue(helper.isElementPresent(login.hamburgerList.get(2)), "Favoris is Seen");
			logger.log(LogStatus.FAIL, "b : Verify Favoris   is avaiable in HamburgerMenu " + "<br/>"
					+ "<b>Result: Favoris is not Seen <b>");
		}
		try {
			hamburger.assertTrue(helper.isElementPresent(login.hamburgerList.get(3)), "Mode d'emploi is Seen");
			logger.log(LogStatus.PASS, "c : Verify Mode d'emploi  is avaiable in HamburgerMenu " + "<br/>"
					+ "<b>Result: Mode d'emploi is Seen <b>");
		} catch (Error e) {
			hamburger.assertTrue(helper.isElementPresent(login.hamburgerList.get(3)), "Mode d'emploi is Seen");
			logger.log(LogStatus.FAIL, "c : Verify Favoris is Seenis Seen  is avaiable in HamburgerMenu " + "<br/>"
					+ "<b>Result: Mode d'emploi is not Seen <b>");
		}
		try {
			hamburger.assertTrue(helper.isElementPresent(login.tv_DisplayName_hamburger), "Full name is Seen");
			logger.log(LogStatus.PASS, "d : Verify Full name   is avaiable in HamburgerMenu " + "<br/>"
					+ "<b>Result: Full name  is Seen <b>");
		} catch (Error e) {
			logger.log(LogStatus.FAIL, "d : Verify Full name   is avaiable in HamburgerMenu " + "<br/>"
					+ "<b>Result: Full name  is not Seen <b>");
		}
		try {
			hamburger.assertTrue(helper.isElementPresent(login.btn_LogOut_hamburger), "Déconnexion is Seen");
			logger.log(LogStatus.PASS, "e : Verify Déconnexion   is avaiable in HamburgerMenu " + "<br/>"
					+ "<b>Result: Déconnexion  is Seen <b>"+logger.addScreenCapture(captureScreenShot(driver, "verify HamburgerMenus")));
		} catch (Error e) {
			logger.log(LogStatus.PASS, "e : Verify Déconnexion  is avaiable in HamburgerMenu " + "<br/>"
					+ "<b>Result: Déconnexion  is not Seen <b>"+logger.addScreenCapture(captureScreenShot(driver, "verify HamburgerMenus")));
		}

		hamburger.assertAll();
	}

	public void verifyPointDeVente() {
		logger = baseT.extent.startTest("Verify PointDeVente");
		login.tv_Point_De_titleTab.click();

		try
		{
		pointDe.assertTrue(helper.isElementPresent(login.tv_Point_De_titleTab), "Profile image is Seen");
		logger.log(LogStatus.PASS, "a : Verify Profile image  is avaiable on PointDeVente" + "<br/>"
				+ "<b>Result: Profile image   is Seen <b>");
		}
		catch(Error e)
		{
			logger.log(LogStatus.FAIL, "a : Verify Profile image  is avaiable on PointDeVente" + "<br/>"
					+ "<b>Result: Profile image   is Seen <b>");
		}
		try
		{
		pointDe.assertTrue(helper.isElementPresent(login.et_NomDuPointe_homePage), "Nom du point de vente is Seen");
		logger.log(LogStatus.PASS, "b : Verify Nom du point de vente is avaiable on PointDeVente" + "<br/>"
				+ "<b>Result: Nom du point de vente   is Seen <b>");
		}
		catch(Error e)
		{
			logger.log(LogStatus.FAIL, "b : Nom du point de vente  is avaiable on PointDeVente" + "<br/>"
					+ "<b>Result: Nom du point de vente  is Seen <b>");
		}
		try
		{
		pointDe.assertTrue(helper.isElementPresent(login.et_Code_Agence_homePage), "Code Agence  is Seen");
		logger.log(LogStatus.PASS, "c : Code Agence is avaiable on PointDeVente" + "<br/>"
				+ "<b>Result: Code Agence is Seen <b>");
		
		}
		catch(Error e)
		{
			logger.log(LogStatus.FAIL, "c : Code Agence is avaiable on PointDeVente" + "<br/>"
					+ "<b>Result: Code Agence is not Seen <b>");
			
		}
		try
		{
		pointDe.assertTrue(helper.isElementPresent(login.et_Manager_Point_De_homePage), "Nom du chef d'agence is Seen");
		logger.log(LogStatus.PASS, "d : Nom du chef d'agence is avaiable on PointDeVente" + "<br/>"
				+ "<b>Result: Nom du chef d'agence is  Seen <b>");
		
		}
		catch(Error e)
		{
			logger.log(LogStatus.FAIL, "d : Nom du chef d'agence is avaiable on PointDeVente" + "<br/>"
					+ "<b>Result: Nom du chef d'agence is not Seen <b>");
			
		}
		login.btn_ViewMore_homePage.click();
try
{
		pointDe.assertTrue(helper.isElementPresent(login.btn_Ville_homePage), "Ville is Seen");
		logger.log(LogStatus.PASS, "e : Nom du chef d'agence is avaiable on PointDeVente" + "<br/>"
				+ "<b>Result: Ville  is  Seen <b>");
		
}
catch(Error e)
{
	logger.log(LogStatus.FAIL, "e : Ville  is avaiable on PointDeVente" + "<br/>"
			+ "<b>Result: Ville  is not Seen <b>");
	
}
try
{
		pointDe.assertTrue(helper.isElementPresent(login.et_Adresse_homePage), "Address is Seen");
		logger.log(LogStatus.PASS, "f : Address is avaiable on PointDeVente" + "<br/>"
				+ "<b>Result: Address is Seen <b>"+logger.addScreenCapture(captureScreenShot(driver, "verify PointDeVente")));
		
}
catch(Error e)
{
	logger.log(LogStatus.FAIL, "f : Address is avaiable on PointDeVente" + "<br/>"
			+ "<b>Result: Addressis not Seen <b>"+logger.addScreenCapture(captureScreenShot(driver, "verify PointDeVente")));
	
}
System.out.print("1");
	}

	public void verifyMonProfil() {
		logger = baseT.extent.startTest("Verify MonProfil");
		login.hamburgerList.get(1).click();

		/*
		 * pointDe.assertTrue(helper.isElementPresent(login.tv_Mon_Profil_Header
		 * ), "MON Profile Header is Seen");
		 */
		try {
			pointDe.assertTrue(helper.isElementPresent(login.im_favoris_MonProfilPage), "Favoris is Seen");
			logger.log(LogStatus.PASS, "a : Favoris is is avaiable onMonProfi" + "<br/>"
					+ "<b>Result: Favoris is  not Seen <b>");
			
		} catch (Error e) 
		{
			logger.log(LogStatus.FAIL, "a : Favoris is avaiable onMonProfi" + "<br/>"
					+ "<b>Result: Favoris is  not Seen <b>");
			

		}
		/*
		 * pointDe.assertTrue(
		 * helper.isElementPresent(login.im_User_Img_MonProfilPage),
		 * "User Image is Seen");
		 */try
		 {

		pointDe.assertTrue(helper.isElementPresent(login.tv_User_Name_MonProfilPage), "User Name is Seen");
		
		logger.log(LogStatus.PASS, "b : User Name is avaiable onMonProfi" + "<br/>"
				+ "<b>Result: User Name is  Seen <b>");
		 }
		 catch(Error e)
		 {
				logger.log(LogStatus.FAIL, "b : User Name is  avaiable onMonProfi" + "<br/>"
						+ "<b>Result: Favoris is  not Seen <b>");
		 }
		 
		 try
		 {
		pointDe.assertTrue(helper.isElementPresent(login.tv_User_Designation_MonProfilPage),
				"User Designation is Seen");
		logger.log(LogStatus.PASS, "c : User Designationis  avaiable onMonProfi" + "<br/>"
				+ "<b>Result:User Designation is   Seen <b>");
		 }
		 catch(Error e)
		 {
				logger.log(LogStatus.FAIL, "c : User Designation is  avaiable onMonProfi" + "<br/>"
						+ "<b>Result: User Designation is  not Seen <b>");
		 }
		 try
		 {
		pointDe.assertTrue(helper.isElementPresent(login.tv_User_Domain_MonProfilPage), "User Domain is Seen");
		logger.log(LogStatus.PASS, "d : User Domainis  avaiable onMonProfi" + "<br/>"
				+ "<b>Result: User Domain is   Seen <b>");
		 }
		 catch(Error e)
		 {
			 logger.log(LogStatus.FAIL, "d : User Domain is  avaiable onMonProfi" + "<br/>"
						+ "<b>Result: User Domain is  not Seen <b>");
		 }
		 
		 try
		 {
		pointDe.assertTrue(helper.isElementPresent(login.tv_CARTE_DE_VISTE_Headertab), "CARTE_DE_VISTE is Seen");
		logger.log(LogStatus.PASS, "e : CARTE_DE_VISTE is  avaiable onMonProfi" + "<br/>"
				+ "<b>Result: CARTE_DE_VISTE is  Seen <b>");
		 }
		 catch(Error e){
			 logger.log(LogStatus.FAIL, "e : CARTE_DE_VISTE is  avaiable onMonProfi" + "<br/>"
						+ "<b>Result:CARTE_DE_VISTE is  not Seen <b>");
		 }
		 
		 try
		 {
	
		 pointDe.assertTrue(helper.isElementPresent(login.tv_AFFECTATION_Headertab), "AFFECTATION is Seen");
		 logger.log(LogStatus.PASS," f : AFFECTATION is  avaiable onMonProfi" + "<br/>"
					+ "<b>Result:AFFECTATIONis  n Seen <b>");
		 }
		 catch(Error e)
		 {
			 logger.log(LogStatus.FAIL, "f : AFFECTATION is  avaiable onMonProfi" + "<br/>"
						+ "<b>Result:AFFECTATION  is  not Seen <b>"); 
		 }

		 try
		 {
		pointDe.assertTrue(helper.isElementPresent(login.tv_COLLABORATEURS_Headertab), "COLLABORATEURS is Seen");
		logger.log(LogStatus.PASS, "g : COLLABORATEURS is  avaiable onMonProfi" + "<br/>"
				+ "<b>Result:COLLABORATEURS  is  not Seen <b>"); 
 }
		 
		 catch(Error e){
			 logger.log(LogStatus.FAIL, "g : COLLABORATEURS is  avaiable on  MonProfi" + "<br/>"
						+ "<b>Result:COLLABORATEURS  is  not Seen <b>"+logger.addScreenCapture(captureScreenShot(driver, "verify MonProfi"))); 
		 
		 }
		pointDe.assertAll();

	}

	public void verifyFavoris(String favorisType) throws InterruptedException {
		Thread.sleep(2000);
		logger = baseT.extent.startTest("Verify Favoris");
		String memberName;

		login.imgBtn_hamburger_homePage.click();

		login.tv_Recherche_hamburger.click();

		if (favorisType.equals(AppStringConstants.POINTS_DE_VENTES)) {
			login.tv_Point_De_titleTab.click();
		}

		if (favorisType.equals(AppStringConstants.COLLABORATEURS)) {
			login.et_Nom_homePage.sendKeys(AppStringConstants.SearchNameString + "\n");
		} else {
			login.et_NomDuPointe_homePage.sendKeys(AppStringConstants.SearchNameStringAgency + "\n");
		}

		login.btn_Recherche_homePage.click();

		selectMember();

		if (favorisType.equals(AppStringConstants.COLLABORATEURS)) {
			memberName = login.tv_Collaborateurs_Name.getText();
		} else {
			memberName = login.tv_PointDeVentes_Name.getText();
		}

		login.iv_Collaborateurs_favoris.click();

		login.imgBtn_hamburger_homePage.click();

		login.imgBtn_Back_homePage.click();

		login.imgBtn_hamburger_homePage.click();

		login.tv_Favoris_hamburger.click();

		if (favorisType.equals(AppStringConstants.POINTS_DE_VENTES)) {
			login.tv_Point_De_titleTab.click();
		}

		try
		{
		Assert.assertTrue(helper.scrollTo(memberName), "Member added to the list");
		 logger.log(LogStatus.PASS, "a : Verify Member added to the list   " + "<br/>"
					+ "<b>Result:Member added to the list <b>"); 
	 
		}
		catch(Error e)
		{
			 logger.log(LogStatus.FAIL, "a : Verify Member added to the list  " + "<br/>"
						+ "<b> Result:Member added to the list   <b>"+logger.addScreenCapture(captureScreenShot(driver, "verify Favoris "))); 
		 
		}
	}

	public void selectMember() {
		List<MobileElement> listOfMemberName = DriverController.driver.findElements(By.id("com.sg.R27A.myiam:id/name"));
		int dataIndex = helper.generateIndex(listOfMemberName.size());
		listOfMemberName.get(dataIndex).click();
	}

	public void verifyLogOut() throws InterruptedException {
		Thread.sleep(2000);
		logger = baseT.extent.startTest("Verify logout");
		login.imgBtn_hamburger_homePage.click();
		login.btn_LogOut_hamburger.click();
		login.btn_Oui_hamburger.click();
try
{
		Assert.assertTrue(helper.isElementPresent(login.InvList_WAFMIcon), "My Iam Logo seen  on logOut");
		 logger.log(LogStatus.PASS, "a : verify user should able to logged out   " + "<br/>"
					+ "<b> Result: user able to logged out t <b>"+logger.addScreenCapture(captureScreenShot(driver, "loogeout successfully"))); 
}
catch(Error e)
{
	 logger.log(LogStatus.PASS, "a : verify user should able to logged out   " + "<br/>"
				+ "<b> Result:user not able to logged out  <b>"+logger.addScreenCapture(captureScreenShot(driver, "unable to looged out"))); 
}

	}

}
