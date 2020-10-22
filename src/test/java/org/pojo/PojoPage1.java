package org.pojo;

import org.maven.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoPage1 extends BaseClass {
public PojoPage1() {
	PageFactory.initElements(driver, this);
	
}
@FindBy(id="username")
private WebElement textUserName;

@FindBy(id="password")
private WebElement textPass;

@FindBy(id="login")
private WebElement btnLogin;

public WebElement getTextUserName() {
	return textUserName;
}

public WebElement getTextPass() {
	return textPass;
}

public WebElement getBtnLogin() {
	return btnLogin;
}
}
