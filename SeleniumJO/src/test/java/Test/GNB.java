package Test;

import org.testng.annotations.Test;

import Testrail_client.Testrails.TestRails;
import junit.framework.Assert;

public class GNB extends _0_BaseTest {
	
	
	
	@Test
	public void GNB() throws InterruptedException {

		objLoginPage.Login("joshin1@getnada.com", "tlswnsdh2@@");

		objGNB.get();
		
		objGNB.Externaldocuments_btn();
		
		objGNB.Templates_btn();
		
		objGNB.Archived_documents_btn();
		
		objGNB.Bulkrequests_btn();
		
		objGNB.Linksignature_btn();

		objGNB.Approvals_btn();
		
		objGNB.Editing_documents_btn();
		
		objGNB.Signatures_btn();
		
		objGNB.Drafts_btn();
		
		//objGNB.Blank_btn();
		
		objGNB.Settings_btn();
		
		objGNB.Documents_btn();
		
		Thread.sleep(5000);
		
	}
}
	

