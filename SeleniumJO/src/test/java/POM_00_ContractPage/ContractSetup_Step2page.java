package POM_00_ContractPage;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import POM_00_BasePage.BasePage;

public class ContractSetup_Step2page extends BasePage  {

	public ContractSetup_Step2page (WebDriver driver) {
        super(driver);
    }
	
	////////////////////// 추가 내용 입력하기 /////////////////////

	///////////////////////////////////////////////////
	
	
	////////////////////// 서명자 1 /////////////////////

	@FindBy(css = (".css-w07yg0 .css-1dgk6ra"))
	WebElement SignatureField_1_btn;
	
	@FindBy(css = (".css-skfhhz"))
	WebElement TextField_1_btn;
	
	@FindBy(css = (".css-w07yg0 .FieldLocator:nth-child(3) > .css-skfhhz"))
	WebElement CheckboxField_1_btn;
	
	@FindBy(css = (".css-w07yg0 .AddAttachFileRequestButton__button-container"))
	WebElement AddAttachFileRequest_1_btn;
	

	// 서명자 2도 같이 씀
	@FindBy(xpath = ("//input[@id='AttachmentRequestCard-0-attachment-type']"))
	WebElement AddAttachFiletype_input;
	
	@FindBy(xpath = ("//button[contains(text(),'설정하기')]"))
	WebElement SetupOk_btn;

	
	////////////////////// 서명자 2 /////////////////////
	
	@FindBy(css = (".css-h6sr04 .css-1dgk6ra"))
	WebElement SignatureField_2_btn;

	@FindBy(css = (".css-h6sr04 .FieldLocator:nth-child(2) > .css-skfhhz"))
	WebElement TextField_2_btn;
	
	@FindBy(css = (".css-h6sr04 .FieldLocator:nth-child(3) > .css-skfhhz"))
	WebElement CheckboxField_2_btn;

	@FindBy(css = (".css-h6sr04 .AddAttachFileRequestButton__button-container"))
	WebElement AddAttachFileRequest_2_btn;
	
	
	///////////////////////////////////////////////////

	
	// PDF 클릭 = pdf에 항목들이 올라감
	@FindBy(css = (".PDFSetupBusinessPage__virtual-layer"))
	WebElement PDFSreen_go_Btn;


	@FindBy(css = (".Btn--primary"))
	WebElement Next_btn;
	
	// 서명 없는 팝업 컨펌 
	@FindBy(css = (".css-1r6iwme"))
	WebElement yes_btn;
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void AddAttachFiletype_1_input_m(String arg1) throws InterruptedException {
		AddAttachFiletype_input.click();
		AddAttachFiletype_input.sendKeys(arg1);
	}
	

	public void ContractSetup_Step2page_Setup_BaseScript() throws InterruptedException {

		SignatureField_1_btn.click();
		PDFSreen_go_Btn.click();
		
		TextField_1_btn.click();
		PDFSreen_go_Btn.click();
		
		CheckboxField_1_btn.click();
		PDFSreen_go_Btn.click();
		
		SignatureField_2_btn.click();
		PDFSreen_go_Btn.click();
		
		TextField_2_btn.click();
		PDFSreen_go_Btn.click();
		
		CheckboxField_2_btn.click();
		PDFSreen_go_Btn.click();
		
		Next_btn.click();

	}
	
	public void NomarlAccount_NormalSign_Off_Case() throws InterruptedException {

		SignatureField_1_btn.click();
		PDFSreen_go_Btn.click();
		
		TextField_1_btn.click();
		PDFSreen_go_Btn.click();
		
		CheckboxField_1_btn.click();
		PDFSreen_go_Btn.click();
		
		SignatureField_2_btn.click();
		PDFSreen_go_Btn.click();
		
		TextField_2_btn.click();
		PDFSreen_go_Btn.click();
		
		CheckboxField_2_btn.click();
		PDFSreen_go_Btn.click();
		
		Next_btn.click();
		


	}



	public void NomarlAccount_NormalSign_On_Case(String arg1) throws InterruptedException {

		SignatureField_1_btn.click();
		PDFSreen_go_Btn.click();
		
		TextField_1_btn.click();
		PDFSreen_go_Btn.click();
		
		CheckboxField_1_btn.click();
		PDFSreen_go_Btn.click();
		
		//AddAttachFileRequest_1_btn.click();
		//AddAttachFiletype_1_input_m(arg1);
		//SetupOk_btn.click();
		
		SignatureField_2_btn.click();
		PDFSreen_go_Btn.click();
		
		TextField_2_btn.click();
		PDFSreen_go_Btn.click();
		
		CheckboxField_2_btn.click();
		PDFSreen_go_Btn.click();
		
		//AddAttachFileRequest_2_btn.click();
		//AddAttachFiletype_1_input_m(arg1);
		//SetupOk_btn.click();
		
		Next_btn.click();

	}
}