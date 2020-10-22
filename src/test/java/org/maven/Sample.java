package org.maven;

import java.io.IOException;
import java.util.Date;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.pojo.PojoPage1;
import org.pojo.PojoPage2;
import org.pojo.PojoPage3;
import org.pojo.PojoPage4;
import org.pojo.PojoPage5;

public class Sample extends BaseClass {
	public static WebDriver driver;
	@BeforeClass
	public static void Page1() {
		WebDriver d = launchBrowser();
		loadUrl("http://adactinhotelapp.com/");
		maxBrowser();
		implicitWait();

	}
	@AfterClass
	public static void quitBrowser() {
		driver.quit();

	}
	@Before
	public void startTime() {
		Date dt=new Date();
		System.out.println(dt);

	}
	@After
	public void endTime() {
		Date dt=new Date();
		System.out.println(dt);

	}
	@Test
	public void tc1() throws IOException {
		PojoPage1 a=new PojoPage1();
		
		fill(a.getTextUserName(), excelRead(1, 0));
		
		fill(a.getTextPass(), excelRead(1, 1));
		
		btnClick(a.getBtnLogin());

	}
	@Test
	public void tc2() {
		PojoPage2 b=new PojoPage2();
		
		dDSSVisibleText(b.getCity(), "Melbourne");
		
		dDSSVisibleText(b.getHotel(), "Hotel Sunshine");
		
		dDSSVisibleText(b.getRoomType(), "Super Deluxe");
		
		btnClick(b.getSearch());

	}
	
	@Test
	public void tc3() {
		PojoPage3 c=new PojoPage3();
		
		btnClick(c.getRadio());
		
		btnClick(c.getCont());

	}
	@Test
	public void tc4() throws IOException, InterruptedException {
		PojoPage4 e=new PojoPage4();
		
		fill(e.getFname(), excelRead(1, 2));
		
		fill(e.getLname(), excelRead(1, 3));
		
		fill(e.getAdd(), excelRead(1, 4));
		
		fill(e.getCcno(), excelRead(1, 5));
		
		dDSSVisibleText(e.getCctype(), "American Express");
		
		dDSSVisibleText(e.getCcexpmonth(), "February");

		dDSSVisibleText(e.getCcexpyear(), "2022");
		
		fill(e.getCvv(), excelRead(1, 8));
		
		btnClick(e.getBook());
		
		Thread.sleep(8000);

	}
	@Test
	public void tc5() throws IOException {
		PojoPage5 f=new PojoPage5();
		
		
		String text = f.getOrderno().getAttribute("value");
		System.out.println(text);
		excelWrite(1, 11, text);

	}
	
	
	
}

