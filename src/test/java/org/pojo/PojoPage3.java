package org.pojo;

import org.maven.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoPage3 extends BaseClass{
 public PojoPage3() {
	PageFactory.initElements(driver, this);
}
 
 @FindBy(id="radiobutton_0")
 private WebElement radio;
 
 @FindBy(id="continue")
 private WebElement cont;

public WebElement getRadio() {
	return radio;
}

public WebElement getCont() {
	return cont;
}
 
}
