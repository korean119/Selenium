package Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import POM_00_BasePage.GNB;
import POM_00_BasePage.LoginPage;
import POM_00_ContractPage.ContractSetup_Step1page;
import POM_00_ContractPage.ContractSetup_Step2page;
import POM_00_ContractPage.ContractSetup_Step3page;
import POM_00_DocumentUpload_Modal.DomcumentUpload_Modal;
import POM_01_DocumentsPage.DocumentsPage;
import POM_01_DocumentsPage.DocumentsPage_ContractPage;
import POM_03_TempletePge.TempletePage;
import POM_03_TempletePge.TempletePage_CreateTempleteStep1Page;
import POM_03_TempletePge.TempletePage_CreateTempleteStep2Page;
import POM_03_TempletePge.TempletePage_CreateTempleteStep3Page;
import POM_05_BulkRequestPage.BulkRequestPage_SendPage;
import POM_05_BulkRequestPage.BulkRequestPage_StartPage;
import POM_08_Settings.SettingsPage_PricingPaymentPage;

public class TestBase {

	public WebDriver driver;

	protected LoginPage ObjLoginPage;

	protected DomcumentUpload_Modal ObjDomcumentUpload_Modal;

	protected ContractSetup_Step1page ObjContractSetup_Step1page;
	protected ContractSetup_Step2page ObjContractSetup_Step2page;
	protected ContractSetup_Step3page ObjContractSetup_Step3page;

	protected GNB ObjGNB;
	protected DocumentsPage_ContractPage ObjDocumentsPage_ContractPage;
	protected DocumentsPage ObjDocumentsPage;

	protected TempletePage ObjTempletePage;
	protected TempletePage_CreateTempleteStep1Page ObjTempletePage_CreateTempleteStep1Page;
	protected TempletePage_CreateTempleteStep2Page ObjTempletePage_CreateTempleteStep2Page;
	protected TempletePage_CreateTempleteStep3Page ObjTempletePage_CreateTempleteStep3Page;

	protected BulkRequestPage_StartPage ObjBulkRequestPage_StartPage;
	protected BulkRequestPage_SendPage ObjBulkRequestPage_SendPage;

	protected SettingsPage_PricingPaymentPage ObjSettingsPage_PricingPaymentPage;

	@BeforeMethod
	@Parameters("browser")
	public void initializeWebDriver(String browser) throws IOException {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					// "C:\\Automation_Driver\\chromedriver_win32 (1)/chromedriver.exe");

					"/Users/johnny/Desktop/Selenium_img/driver/chromedriver_mac64/chromedriver");

			// 크롬 업데이트대응
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);

			// 헤드리스 모드 고민 필요
			// 현재 자동화가 브라우저가 켜지면서 돌아가는데 그럴 때 내가 다른 작업을 하면 자동화가 멈추는 경우가 있음
			// 자동화 돌아가는거 구경만 하고 있어야 하는 상황이라 헤드리스를 사용해야 할 것 같긴한데
			// 그럼 Fail 난 경우 추적하기가 번거롭기도 함 --> 대책이 있다면 상관 없음
			// 일단 크롬 드라이버 업데이트로 헤드리스 자체에 에러가 있어 객체 찾지 못해서 보류 상태
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--remote-allow-origins=*");
//			options.addArguments("--headless");
//			options.addArguments("--window-size=1920,1080");
//			options.addArguments("--no-sandbox");
//			options.addArguments("--disable-gpu");
//			driver = new ChromeDriver(options);

		}

		else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Automation_Driver\\edgedriver_win64/msedgedriver.exe");
			driver = new EdgeDriver();
		}

		else if (browser.equalsIgnoreCase("Safari")) {
			SafariOptions options = new SafariOptions();
			driver = new SafariDriver(options);

		}

		else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.driver",
					"/Users/johnny/Desktop/Selenium_img/driver/geckodriver-v0.32.2-macos");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Stage URL
		driver.get("https://stage-app.modusign.co.kr/");

		// 프로덕션 URL
		// driver.get("https://app.modusign.co.kr/");
		
		// 프리뷰 URL
		//driver.get("https://deploy-preview-8249--modusign-app.netlify.app/");


		// 페이지로드 타임아웃 효과가 있는지잘 모르겠음. 없는거 같기도..
		// https://www.browserstack.com/guide/understanding-selenium-timeouts
		// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// 브라우저 위치/크기
		driver.manage().window().setPosition(new Point(-3000, 1));
		driver.manage().window().maximize();
		//driver.manage().window().minimize();

		// 드라이버 재선언
		ObjLoginPage = new LoginPage(driver);

		ObjDomcumentUpload_Modal = new DomcumentUpload_Modal(driver);
		ObjContractSetup_Step1page = new ContractSetup_Step1page(driver);
		ObjContractSetup_Step2page = new ContractSetup_Step2page(driver);
		ObjContractSetup_Step3page = new ContractSetup_Step3page(driver);

		ObjGNB = new GNB(driver);
		ObjDocumentsPage = new DocumentsPage(driver);
		ObjDocumentsPage_ContractPage = new DocumentsPage_ContractPage(driver);

		ObjTempletePage = new TempletePage(driver);
		ObjTempletePage_CreateTempleteStep1Page = new TempletePage_CreateTempleteStep1Page(driver);
		ObjTempletePage_CreateTempleteStep2Page = new TempletePage_CreateTempleteStep2Page(driver);
		ObjTempletePage_CreateTempleteStep3Page = new TempletePage_CreateTempleteStep3Page(driver);

		ObjBulkRequestPage_StartPage = new BulkRequestPage_StartPage(driver);
		ObjBulkRequestPage_SendPage = new BulkRequestPage_SendPage(driver);

		ObjSettingsPage_PricingPaymentPage = new SettingsPage_PricingPaymentPage(driver);
	}

	@AfterMethod
	public void tearDown(ITestResult Result) {
		if (Result.getStatus() == ITestResult.SUCCESS)

			driver.quit();

	}
}
