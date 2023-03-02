package PagesObjectModel;

import static org.testng.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;


public class Documtets_ContractPage extends _0_BasePage {
	
	public Documtets_ContractPage(WebDriver driver) {
		super(driver);

	}

	// 2. 입력 화면 - [서명 시작하기] 버튼 
	@FindBy(xpath = ("//button[contains(.,'서명 시작하기')]"))
	WebElement SignatureStart_btn;
		
	// 사인 
	@FindBy(css= (".ProgressFieldSignatureMarker__box.css-pk1s35"))
	WebElement SignatureMarker_btn;

	// 사인
	@FindBy(css= (".ProgressFieldSignatureMarker__sub-menu.css-az90ea"))
	WebElement Signaturesub_menu_btn;

	// 내 사인 첫번째 이미지
	@FindBy(xpath = ("(//img[@role='presentation'])[1]"))
	WebElement Mysign_image_1_btn;
	
	
	// 사인 입력 모달 
	@FindBy(css = (".css-3630uk"))
	WebElement Image_confirmOK_btn;
	
	
	@FindBy(css = (".WritableTextFieldCore__content"))
	WebElement WritableTextFieldCore_btn;
	

	// 사인 입력 모달 
	@FindBy(css = (".TextFieldTextarea__textarea"))
	WebElement TextFieldTextarea;
	
	
	// 2. 입력 화면 - [입력 완료] 버튼 
	@FindBy(xpath = ("//button[contains(text(),'입력 완료')]"))
	WebElement InputDone_btn;
	
	// 2. 입력 화면 - [입력 완료] 버튼 
	@FindBy(xpath = ("//button[contains(text(),'확인 완료')]"))
	WebElement CheckDone_btn;
	
	
	@FindBy(xpath = ("//button[contains(text(),'동의하고 서명 완료')]"))
	WebElement AgreeandSign_btn;
	
	@FindBy(xpath = ("//button[contains(text(),'홈으로')]"))
	WebElement Home_btn;


	
///////////////////////////////////////////////////////////////////////////
	
	
	// PDF 뷰어 캡쳐용
	@FindBy(css= (".PDFViewer__page-container"))
	WebElement PDFViewer;
	

///////////////////////////////////////////////////////////////////////////
	
	
	public void SignatureStart_btn() {
		SignatureStart_btn.click();

	}

	public void SignatureMarker_btn() {
		SignatureMarker_btn.click();

	}

	public void Signaturesub_menu_btn() {
		Signaturesub_menu_btn.click();

	}
	
	public void Mysign_image_1_btn() {
		Mysign_image_1_btn.click();

	}
	
	public void Image_confirmOK_btn() {
		Image_confirmOK_btn.click();
		
	}

	public void WritableTextFieldCore_btn() {
	WritableTextFieldCore_btn.click();
	
	}
	
	public void TextFieldTextarea(String arg1) {
		//TextFieldTextarea.sendKeys(arg1);
		Wait.until(ExpectedConditions.visibilityOf(TextFieldTextarea)).sendKeys(arg1);
		
	}
	
	public void InputDone_btn() {
		InputDone_btn.click();
		
	}
	
	public void CheckDone_btn() {
		CheckDone_btn.click();
		
	}
	

	public void AgreeandSign_btn() {
		AgreeandSign_btn.click();
	
	}

	
	public void Contract_BaseScript(String arg1) throws InterruptedException { 
		SignatureStart_btn.click();
		//SignatureMarker_btn.click();
		Signaturesub_menu_btn.click();
		Mysign_image_1_btn.click();
		Image_confirmOK_btn.click();
		WritableTextFieldCore_btn.click();
		Wait.until(ExpectedConditions.visibilityOf(TextFieldTextarea)).sendKeys(arg1);
		InputDone_btn.click();
		AgreeandSign_btn.click();
		Home_btn.click();
		Thread.sleep(2000);
	}
	
	

	public void AllScreen() throws IOException, InterruptedException {

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("C:\\SeleniumPractice\\logos/screenshot02.png"));

		System.out.println("The Screenshot is captured.");

	}
	
	
	public void ElementCapture() throws IOException, InterruptedException {

		Thread.sleep(2000);
		// Asot jqury 오류 대응 코드, 근데 Ashot 으로 이미지 캡쳐 안해서 필요는 없을 것 같지만 혹시나 해서 놔둠
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		if (!(Boolean) js.executeScript("return (typeof jQuery != \"undefined\")")) {
//			js.executeScript("var headID = document.getElementsByTagName('head')[0];"
//					+ "var newScript = document.createElement('script');" + "newScript.type = 'text/javascript';"
//					+ "newScript.src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js';"
//					+ "headID.appendChild(newScript);");
//			WebDriverWait waitJQ = new WebDriverWait(driver, 30);
//			Function<WebDriver, Boolean> jQueryAvailable = WebDriver -> ((Boolean) js
//					.executeScript("return (typeof jQuery != \"undefined\")"));
//			waitJQ.until(jQueryAvailable);
//		}

		
		//Screenshot Screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
		//		.takeScreenshot(driver, PDFViewer);
		
		File Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		BufferedImage fullScreen = ImageIO.read(Screenshot);
		Point location = PDFViewer.getLocation();
		
		int width = PDFViewer.getSize().getWidth();
		int height = PDFViewer.getSize().getHeight();
		BufferedImage logo_image = fullScreen.getSubimage(location.getX(), location.getY(), 876, 530);
		
		// 876 x 574.22

		ImageIO.write(logo_image, "png", Screenshot); 
		FileUtils.copyFile(Screenshot, new File("C:\\SeleniumPractice\\logos/screenshot02.png"));
		System.out.println("Screen Capture - Success");

		BufferedImage expectedImage = ImageIO.read(new File("C:\\SeleniumPractice\\logos/screenshot01.png"));
		BufferedImage actualImage = logo_image;

		Thread.sleep(3000);

		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		if (diff.hasDiff() == true) {
			System.out.println("이미지 비교 - Fail");
			driver.quit();
			
		} else {
			System.out.println("이미지 비교 - Pass");
		}

	}
}