package org.maven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.DefaultEditorKit.CutAction;
import javax.swing.text.DefaultEditorKit.PasteAction;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.Value;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Enter;

public class BaseClass  {
	public static WebDriver driver;
	public static Actions a;
	public static Scanner sc=new Scanner(System.in);
	
	public static WebDriver launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sarsha8\\eclipse-workspace\\SeleniumDay1\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        return driver;
	}

	public static void loadUrl(String url) {
		driver.get(url);

	}
	public static void maxBrowser() {
		driver.manage().window().maximize();
	}
	public static void fill(WebElement element, String text) {
		element.sendKeys(text);
	}
	public static void btnClick(WebElement element) {
		element.click();

	}
	public static void pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);

	}
	public static void pageUrl() {
		String url = driver.getCurrentUrl();
        System.out.println(url);
	}
	public static void performDragDrop(WebElement src,WebElement dest) {
	      a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();
		
	}
	public static void rightClick(WebElement element) {
	      a=new Actions(driver);
		a.contextClick(element).perform();

	}
	public static void selectText(WebElement element) {
	      a=new Actions(driver);
		a.doubleClick(element).perform();
          
	}
	public static void enter() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void tab() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	public static void copy() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_C);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_C);
	}
    public static void cut() throws AWTException {
    	Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_X);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_X);

	}
    public static void paste() throws AWTException {
    	Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);

	}
    public static void close() {
		driver.quit();

	}
    public static void navigateUrl(String url) {
		driver.navigate().to(url);

	}
    public static void forwardPage() {
		driver.navigate().forward();

	}
    public static void backPage() {
		driver.navigate().back();

	}
    public static void refreshPage() {
    	driver.navigate().refresh();
    }
    public static void screenShot(String path) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\sarsha8\\eclipse-workspace\\SeleniumDay1\\screenshots"+path+".png");
        FileUtils.copyFile(src, dest);
	}
   public static void scrolldown(WebElement element) {
		JavascriptExecutor jk=(JavascriptExecutor)driver;
		jk.executeScript("arguments[0].scrollIntoview(false)", element);

	}
   public static void scrollUp(WebElement element) {
		JavascriptExecutor jk=(JavascriptExecutor)driver;
		jk.executeScript("arguments[0].scrollIntoview(true)", element);

	}
   public static void jSFill(WebElement element,String input) {
		JavascriptExecutor jk=(JavascriptExecutor)driver;
		jk.executeScript("arguments[0].setAttribute('value',"+input+")", element);

	}
   public static void jSClick(WebElement element) {
		JavascriptExecutor jk=(JavascriptExecutor)driver;
		jk.executeScript("arguments[0].click", element);

	}
   public static void jSGet(WebElement element) {
		JavascriptExecutor jk=(JavascriptExecutor)driver;
		Object o = jk.executeScript("arguments[0].getAttribute('value')", element);
		String s=(String)o;
		System.out.println(s);
		
   }
   
   public static void windowHandle() {
	    String window = driver.getWindowHandle();
	    System.out.println(window);
}
   public static void windowHandles() {
	    Set<String> allWindowsId = driver.getWindowHandles();
        System.out.println(allWindowsId);
}
   public static void switchWindow() {
	   String window = driver.getWindowHandle();
	   Set<String> allWindowsId = driver.getWindowHandles();
	   for (String windowId : allWindowsId) {
		   if (!(window.equals(windowId))) {
			driver.switchTo().window(windowId);
		}
		
	}
}
   public static void simpleAlert() {
	   Alert a = driver.switchTo().alert();
	   a.accept();
}
   public static void confirmAlert() {
	  Alert a= driver.switchTo().alert();
	  String alert = a.getText();
      System.out.println(alert);
      System.out.println("Enter 1 to accept 2 to reject the alert");
      int result = sc.nextInt();
      if (result==1) {
		a.accept();
	}else {
		a.dismiss();
	}
}
  public static void promptAlert() {
	  Alert a= driver.switchTo().alert();
	  String alert = a.getText();
      System.out.println(alert);
      System.out.println("Enter the Input in Textfield");
      String text = sc.nextLine();
      a.sendKeys(text);
      System.out.println("Enter 1 to accept 2 to reject the alert");
      int result = sc.nextInt();
      if (result==1) {
		a.accept();
	}else {
		a.dismiss();
	}
}
  public static void implicitWait() {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}
  public static void wDWaitInvisibility(WebElement element) {
    WebDriverWait w1=new WebDriverWait(driver, 10);
	w1.until(ExpectedConditions.invisibilityOf(element));

}
  public static void wDWaitFrame(WebElement element) {
      WebDriverWait w1=new WebDriverWait(driver, 10);
	  w1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
  }
  public static void wDWaitAlert() {
	 WebDriverWait w1=new WebDriverWait(driver, 10);
	 w1.until(ExpectedConditions.alertIsPresent());

}
  public static void wDWaitClickable(WebElement element) {
    WebDriverWait w1=new WebDriverWait(driver, 10);
	w1.until(ExpectedConditions.elementToBeClickable(element));

}
  public static void fwaitInvisibility(WebElement element) {
	FluentWait<WebDriver> f=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(1)).ignoring(Throwable.class);  
	f.until(ExpectedConditions.invisibilityOf(element));

}
  public static void fWaitFrame(WebElement element) {
      FluentWait<WebDriver> f=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(1)).ignoring(Throwable.class);
	  f.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
  
} 
  public static void fWaitAlert() {
	     FluentWait<WebDriver> f=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(1)).ignoring(Throwable.class);
		 f.until(ExpectedConditions.alertIsPresent());
  
}
  public static void fWaitClickable(WebElement element) {
        FluentWait<WebDriver> f=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(1)).ignoring(Throwable.class);
		f.until(ExpectedConditions.elementToBeClickable(element));

	}
  public static void newTab(WebElement element) throws AWTException {
	    rightClick(element);
	    Robot r=new Robot();
	    r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

}
  public static void newWindow(WebElement element) throws AWTException {
	    rightClick(element);
	    Robot r=new Robot();
	  r.keyPress(KeyEvent.VK_DOWN);
      r.keyRelease(KeyEvent.VK_DOWN);
      r.keyPress(KeyEvent.VK_DOWN);
      r.keyRelease(KeyEvent.VK_DOWN);
      r.keyPress(KeyEvent.VK_ENTER);
      r.keyRelease(KeyEvent.VK_ENTER);
  
}
  public static void dDSSVisibleText(WebElement element, String text) {
	  Select s=new Select(element);
	  s.selectByVisibleText(text);
}
  public static void dDSSValue(WebElement element, String text) {
	  Select s=new Select(element);
	  s.selectByValue(text);
}
  public static void dDSSIndex(WebElement element, int index) {
	  Select s=new Select(element);
	  s.selectByIndex(index);
}
  public static void dDSSDeVisibleText(WebElement element, String text) {
	  Select s=new Select(element);
	  s.deselectByVisibleText(text);

}
  public static void dDSSDeValue(WebElement element, String text) {
	  Select s=new Select(element);
	  s.deselectByValue(text);
  
}
  public static void dDSSDeIndex(WebElement element, int index) {
	  Select s=new Select(element);
	  s.deselectByIndex(index);
      
}
  public static String excelRead(int rowNo,int cellNo) throws IOException {
	File file=new File("C:\\Users\\sarsha8\\eclipse-workspace\\ProjectMaven\\TestDataExcel\\Data.xlsx");
	FileInputStream finstream=new FileInputStream(file);
	Workbook w=new XSSFWorkbook(finstream);
    Sheet s = w.getSheet("Sheet1");
   
		Row r = s.getRow(rowNo);
		
		Cell c = r.getCell(cellNo);
		int cellType = c.getCellType();
		String value="";
		if (cellType==1) {
			 value = c.getStringCellValue();	
		}
		else if (DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
			 value = sim.format(d);
		}
		else {
			double dd = c.getNumericCellValue();
			long l=(long)dd;
			 value = String.valueOf(l);
		}
		return value;
		}
		
	public static void excelWrite(int rowNo,int cellNo,String data) throws IOException {
		File file=new File("C:\\Users\\sarsha8\\eclipse-workspace\\ProjectMaven\\TestDataExcel\\Data.xlsx");
		FileInputStream fin=new FileInputStream(file);
		Workbook w=new XSSFWorkbook(fin);
        Sheet s = w.getSheet("Sheet1");
        Row r = s.getRow(rowNo);
        Cell c = r.createCell(cellNo);
        c.setCellValue(data);
        FileOutputStream fout=new FileOutputStream(file);
        w.write(fout);
	}
	public static void excelUpdate(int rowNo,int cellNo,String excistig,String newContent) throws IOException {
		File file=new File("C:\\Users\\sarsha8\\eclipse-workspace\\ProjectMaven\\TestDataExcel\\InputData.xlsx");
		FileInputStream fin=new FileInputStream(file);
		Workbook w=new XSSFWorkbook(fin);
		Sheet s1 = w.createSheet("Input");
        Sheet s = w.getSheet("Input");
        Row r = s.getRow(rowNo);
        Cell c = r.getCell(cellNo);
        String value = c.getStringCellValue();
        if (value.contains(excistig)) {
			c.setCellValue(newContent);
		}
        FileOutputStream fout=new FileOutputStream(file);
        w.write(fout);
}
}
  
  

   

