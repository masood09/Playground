package com.hello.world.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.PageObject;

@PageObject
public class CheckoutPageFieldErrors {

  @FindBy(id = "firstName-error")
  private WebElement firstNameFieldError;

  public String getFirstNameError() {
    return firstNameFieldError.getText();
  }


  @FindBy(id = "lastName-error")
  private WebElement lastNameFieldError;

  public String getLastNameError() {
    return lastNameFieldError.getText();
  }


  @FindBy(id = "telephone-error")
  private WebElement phoneFieldError;

  public String getPhoneError() {
    return phoneFieldError.getText();
  }


  @FindBy(id = "cardNumber-error")
  private WebElement cardNumberFieldError;

  public String getCardNumberError() {
    return cardNumberFieldError.getText();
  }


  @FindBy(id = "expiryDate-error")
  private WebElement cardExpiryDateFieldError;

  public String getCardExpiryDateError() {
    return cardExpiryDateFieldError.getText();
  }


  @FindBy(id = "cvv-error")
  private WebElement cardCVVFieldError;

  public String getCardCVVError() {
    return cardCVVFieldError.getText();
  }
}
