package Test_Contract;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Test.TestBase;
import Testrail_client.Testrails.TestRails;
import junit.framework.Assert;


@Ignore
public class Templete_NormalSign_On_Case extends TestBase {

	@TestRails(id = "16289")
	@Test(priority = 1, enabled = true)
	@Parameters({ "signature_requester_email", "Signatory_1_email", "Signatory_2_name", "Signatory_2_email" })

	public void Templete_NormalSign_On_Case(@Optional String signature_requester_email,
			@Optional String Signatory_1_email, @Optional String Signatory_2_name, @Optional String Signatory_2_email)
			throws InterruptedException {
		ObjLoginPage.Login_m(signature_requester_email, "tlswnsdh2@@");

		Thread.sleep(2000);

		ObjGNB.Templates_btn();

		ObjDomcumentUpload_Modal.Templete_Contract_SampleDocselect();
		
		ObjTempletePage_CreateTempleteStep1Page.Templete_Request_Step1Page_Case("자동화서명");
		ObjTempletePage_CreateTempleteStep2Page.Templete_Request_Step2Page_Off_Case();
		ObjTempletePage_CreateTempleteStep3Page.Templete_Request_Step3Page_Off_Case();

		ObjContractSetup_Step1page.NormalSign_OnandOff_Case(Signatory_1_email, Signatory_2_name,
				Signatory_2_email);

		ObjContractSetup_Step2page.NormalSign_On_Case("첨부파일 올려주세요");

		ObjContractSetup_Step3page.NomarlAccount_NormalSign_On_Case("NomarlAccount_NormalSign_On_Case", "12341234",
				"joshin1@getnada.com", "메롱", "1234");

	}

	@TestRails(id = "16290")
	@Test(priority = 2, enabled = true)
	@Parameters({ "Signatory_1_email" })

	public void Templete_NormalSign_On_Case_Singatory_1_(@Optional String Signatory_1_email)
			throws InterruptedException, IOException {

		ObjLoginPage.Login_m(Signatory_1_email, "tlswnsdh2@@");

		Thread.sleep(2000);

		ObjDocumentsPage.Documents_Dropdown_1_select_m();

		ObjDocumentsPage_ContractPage.NormalSign_On_Case("1234", "텍스트필드 입력");

		Thread.sleep(2000);

	}

	@TestRails(id = "16291")
	@Test(priority = 2, enabled = true)
	@Parameters({ "Signatory_2_email" })

	public void Templete_NormalSign_On_Case_Singatory_2_(@Optional String Signatory_2_email)
			throws InterruptedException, IOException {

		ObjLoginPage.Login_m(Signatory_2_email, "tlswnsdh2@@");

		Thread.sleep(2000);

		ObjDocumentsPage.Documents_Dropdown_1_select_m();

		ObjDocumentsPage_ContractPage.NormalSign_On_Case("1234", "텍스트필드 입력");

		Thread.sleep(2000);
	}
}
