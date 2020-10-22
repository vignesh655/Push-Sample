package org.pojo;

import org.maven.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoPage5 extends BaseClass {

	public PojoPage5() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="order_no")
	private WebElement orderno;
	public WebElement getOrderno() {
		return orderno;
	}
}
