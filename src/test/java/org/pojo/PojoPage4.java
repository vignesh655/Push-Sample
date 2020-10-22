package org.pojo;

import org.maven.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoPage4 extends BaseClass {
public PojoPage4() {
	PageFactory.initElements(driver, this);
}

@FindBy(id="first_name")
private WebElement fname;

@FindBy(id="last_name")
private WebElement lname;

@FindBy(id="address")
private WebElement add;

@FindBy(id="cc_num")
private WebElement ccno;

@FindBy(id="cc_type")
private WebElement cctype;

@FindBy(id="cc_exp_month")
private WebElement ccexpmonth;

@FindBy(id="cc_exp_year")
private WebElement ccexpyear;

@FindBy(id="cc_cvv")
private WebElement cvv;

@FindBy(id="book_now")
private WebElement book;

public WebElement getFname() {
	return fname;
}

public WebElement getLname() {
	return lname;
}

public WebElement getAdd() {
	return add;
}

public WebElement getCcno() {
	return ccno;
}

public WebElement getCctype() {
	return cctype;
}

public WebElement getCcexpmonth() {
	return ccexpmonth;
}

public WebElement getCcexpyear() {
	return ccexpyear;
}

public WebElement getCvv() {
	return cvv;
}

public WebElement getBook() {
	return book;
}
}
