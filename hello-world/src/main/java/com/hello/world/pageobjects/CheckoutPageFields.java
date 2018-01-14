package com.hello.world.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.cognifide.qa.bb.qualifier.PageObject;

@PageObject
public class CheckoutPageFields {

  @FindBy(id = "checkoutForm-firstName")
  private WebElement firstNameField;

  public void setFirstName(String firstName) {
    firstNameField.sendKeys(firstName);
  }


  @FindBy(id = "checkoutForm-lastName")
  private WebElement lastNameField;

  public void setLastName(String lastName) {
    lastNameField.sendKeys(lastName);
  }


  @FindBy(id = "checkoutForm-telephone")
  private WebElement phoneField;

  public void setPhone(String phone) {
    phoneField.sendKeys(phone);
  }


  @FindBy(id = "checkoutForm-cardNumber")
  private WebElement cardNumberField;

  public void setCardNumber(String cardNumber) {
    cardNumberField.sendKeys(cardNumber);
  }


  @FindBy(id = "checkoutForm-expiryMonth")
  private WebElement cardExpiryMonthField;
  @FindBy(id = "checkoutForm-expiryYear")
  private WebElement cardExpiryYearField;

  public void setCardExpiryDate(String month, String year) {
    Select monthDropdown = new Select(cardExpiryMonthField);
    Select yearDropdown = new Select(cardExpiryYearField);

    monthDropdown.selectByVisibleText(month);
    yearDropdown.selectByVisibleText(year);
  }


  @FindBy(id = "checkoutForm-cvv")
  private WebElement cardCVVField;

  public void setCardCVV(String cvv) {
    cardCVVField.sendKeys(cvv);
  }
}
