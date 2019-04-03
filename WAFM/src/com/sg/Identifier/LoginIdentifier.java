package com.sg.Identifier;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import main.java.BasePage;

public class LoginIdentifier extends BasePage {

	@AndroidFindBy(id = "com.sg.R27A.waf:id/sgid")
	public MobileElement Login_SGID;

	@AndroidFindBy(id = "com.sg.R27A.waf:id/password")
	public MobileElement Login_Password;

	@AndroidFindBy(id = "com.sg.R27A.waf:id/btn_connection")
	public MobileElement Login_ConnectionBtn;

	@AndroidFindBy(id = "com.sg.R27A.waf:id/searchInvoice")
	public MobileElement InvList_SearchBox;

	@AndroidFindBy(id = "com.sg.R27A.waf:id/leftIcon")
	@iOSFindBy(xpath = "//XCUIElementTypeTextField[@value='SGID']")
	public MobileElement InvList_Drawer;

	@AndroidFindBy(id = "com.sg.R27A.waf:id/rightIcon")
	@iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Mot de passe']")
	public MobileElement InvList_WAFMIcon;

	@AndroidFindBy(accessibility = "En attente")
	public MobileElement InvList_PendingTab;

	@AndroidFindBy(accessibility = "Validé/Bloqué")
	public MobileElement InvList_BlockTab;

	@AndroidFindBy(id = "com.sg.R27A.myiam:id/toolbar_title")
	public MobileElement tv_Recherche_label;

	@AndroidFindBy(id = "com.sg.R27A.myiam:id/menu")
	public MobileElement im_Iam_Logo;
	
	@AndroidFindBy(id = "com.sg.R27A.waf:id/fournisseurNom")
	public MobileElement InvoiceListAftersearch;

	@AndroidFindBy(id = "com.sg.R27A.myiam:id/icon")
	public MobileElement im_Collaborateurs_Icon;

	@AndroidFindBy(id = "com.sg.R27A.myiam:id/title_tab")
	public MobileElement tv_Collaborateurs_titleTab;
	

/*---------------------------------------HomePage Items-------------------------------------------------------------------*/
//	@AndroidFindBy(xpath = "//android.support.v7.app.ActionBar.Tab[2]/android.widget.LinearLayout[contains(@resource-id,'icon')]")
//	public MobileElement im_Points_de_ventes_titleTab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='COLLABORATEURS']")
	public MobileElement tv_COLLABORATEURS_titleTab;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/lastName_Edittext")
	public MobileElement et_Nom_homePage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/firstName_Edittext")
	public MobileElement et_Prenom_homePage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/sgid_Edittext")
	public MobileElement et_SgId_homePage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/view_more")
	public MobileElement btn_ViewMore_homePage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/phoneNumber_Edittext")
	public MobileElement et_Tel_homePage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/filiere_Edittext")
	public MobileElement et_Filiere_homePage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/manager_Edittext")
	public MobileElement et_Manager_homePage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/enseigne_Edittext")
	public MobileElement et_Enseigne_homePage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/region_Edittext")
	public MobileElement et_Region_homePage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/search_Button")
	public MobileElement btn_Recherche_homePage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/menu")
	public MobileElement img_IamLogo_homePage; 
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement imgBtn_hamburger_homePage;
	
	/*---------------------------------------HamBurger Items-------------------------------------------------------------------*/
	@AndroidFindBy(id="com.sg.R27A.myiam:id/profile_image")
	public MobileElement img_Profile_hamburger;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/FullName")
	public MobileElement tv_DisplayName_hamburger;
	
	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@text='Recherche']")
	public MobileElement tv_Recherche_hamburger;
	
	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@text='Mon profil']")
	public  MobileElement tv_Mon_Profil_hamburger;
	

	@AndroidFindBy(id="com.sg.R27A.myiam:id/design_menu_item_text")
	public List<MobileElement> hamburgerList;
	
	
	

	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@text='Favoris']")
	public MobileElement tv_Favoris_hamburger;
	
	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@text=\"Mode d'emploi\"]")
	public MobileElement tv_Mode_hamburger;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/nav_footer_textview")
	public MobileElement btn_LogOut_hamburger;
	
	@AndroidFindBy(id="android:id/button1")
	public MobileElement btn_Oui_hamburger;

	@AndroidFindBy(id="android:id/button2")
	public MobileElement btn_Mon_hamburger;
	
	
	
/*---------------------------------------PointDe Vente Items-------------------------------------------------------------------*/	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='POINTS DE VENTES']")
	public MobileElement tv_Point_De_titleTab;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/name_Edittext")
	public MobileElement et_NomDuPointe_homePage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/codeAgence_Edittext")
	public MobileElement et_Code_Agence_homePage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/manager_Edittext")
	public MobileElement et_Manager_Point_De_homePage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/locality_Edittext")
	public MobileElement btn_Ville_homePage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/street_Edittext")
	public MobileElement et_Adresse_homePage;
	
/*---------------------------------------MonProfil Items-------------------------------------------------------------------*/	

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mon profil']")
	public MobileElement tv_Mon_Profil_Header;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/favoris")
	public MobileElement im_favoris_MonProfilPage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/user_iv")
	public MobileElement im_User_Img_MonProfilPage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/name_tv")
	public MobileElement tv_User_Name_MonProfilPage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/position_tv")
	public MobileElement tv_User_Designation_MonProfilPage;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/domain_tv")
	public MobileElement tv_User_Domain_MonProfilPage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CARTE DE VISTE']")
	public MobileElement tv_CARTE_DE_VISTE_Headertab;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='AFFECTATION']")
	public MobileElement tv_AFFECTATION_Headertab;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='COLLABORATEURS']")
	public MobileElement tv_COLLABORATEURS_Headertab;
	
	/*--------------------------------------------Collaborateurs DetailItem--------------------------------------------------------------*/	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/name_tv")	
	public MobileElement tv_Collaborateurs_Name;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/detail_tv")	
	public MobileElement tv_PointDeVentes_Name;
	
	@AndroidFindBy(id="com.sg.R27A.myiam:id/favoris")
	public MobileElement iv_Collaborateurs_favoris;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Open']")
	public MobileElement imgBtn_Back_homePage;
	
}
