package com.hello.world.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

@PageObject
public class CheckoutPage {

  private static final String URL =  "http://192.168.2.12:8082";

  @Inject
  private WebDriver webDriver;

  @FindBy(id = "checkoutForm")
  private CheckoutPageFields checkoutPageFields;

  public CheckoutPageFields getCheckoutPageFields() {
    return checkoutPageFields;
  }

  @FindBy(id = "checkoutForm")
  private CheckoutPageFieldErrors checkoutPageFieldErrors;

  public CheckoutPageFieldErrors getCheckoutPageFieldErrors() {
    return checkoutPageFieldErrors;
  }

  @FindBy(id = "checkoutForm")
  private CheckoutPageForm checkoutPageForm;

  public CheckoutPageForm getCheckoutPageForm() {
    return checkoutPageForm;
  }

  public CheckoutPage open() {
    webDriver.get(URL);
    return this;
  }
}
