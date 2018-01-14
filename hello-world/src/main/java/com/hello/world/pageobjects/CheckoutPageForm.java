package com.hello.world.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.PageObject;

@PageObject
public class CheckoutPageForm {

  @FindBy(id = "submit")
  private WebElement submitField;

  public void submitForm() {
    submitField.click();
  }

  @FindBy(id = "form-submitMessage")
  private WebElement formMessage;

  public String getFormMessage() {
    return formMessage.getText();
  }
}
