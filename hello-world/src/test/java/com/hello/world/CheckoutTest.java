package com.hello.world;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.google.inject.Inject;
import com.hello.world.GuiceModule;
import com.hello.world.pageobjects.CheckoutPage;

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class CheckoutTest {
  private static final String FORM_MESSAGE_VALID = "Form submitted successfully!";
  private static final String FORM_MESSAGE_INVALID = "Errors in the form!";

  private static final String FIRSTNAME_MESSAGE_VALID = "";
  private static final String FIRSTNAME_MESSAGE_INVALID_REQUIRED = "First name is a required field.";
  private static final String FIRSTNAME_MESSAGE_INVALID_MORE20 = "The maximum length of First Name is 20.";
  private static final String FIRSTNAME_MESSAGE_INVALID_ONLYCHARS = "First name can only be characters.";
  private static final String FIRSTNAME_VALID = "Masood";
  private static final String FIRSTNAME_INVALID_SPACES = "Masood Ahmed";
  private static final String FIRSTNAME_INVALID_EMPTY = "";
  private static final String FIRSTNAME_INVALID_SPECIALCHARS = "Masood%";
  private static final String FIRSTNAME_INVALID_MORE20 = "MasoodAhmedMasoodAhmed";


  private static final String LASTNAME_MESSAGE_VALID = "";
  private static final String LASTNAME_MESSAGE_INVALID_REQUIRED = "Last name is a required field.";
  private static final String LASTNAME_MESSAGE_INVALID_MORE20 = "The maximum length of Last Name is 20.";
  private static final String LASTNAME_MESSAGE_INVALID_ONLYCHARS = "Last name can only be characters.";
  private static final String LASTNAME_VALID = "Ahmed";
  private static final String LASTNAME_INVALID_SPACES = "Masood Ahmed";
  private static final String LASTNAME_INVALID_EMPTY = "";
  private static final String LASTNAME_INVALID_SPECIALCHARS = "Ahmed%";
  private static final String LASTNAME_INVALID_MORE20 = "MasoodAhmedMasoodAhmed";


  private static final String PHONE_MESSAGE_VALID = "";
  private static final String PHONE_MESSAGE_INVALID = "Phone number is in incorrect format.";
  private static final String PHONE_VALID_EMPTY = "";
  private static final String PHONE_VALID_FORMAT1 = "4168760904";
  private static final String PHONE_VALID_FORMAT2 = "416-876-0904";
  private static final String PHONE_INVALID_LESSDIGITS = "416";
  private static final String PHONE_INVALID_CHARS = "416ABC";
  private static final String PHONE_INVALID_FORMAT = "416--876-0904";


  private static final String CARD_NUMBER_MESSAGE_VALID = "";
  private static final String CARD_NUMBER_MESSAGE_INVALID_REQUIRED = "Card number is a required field.";
  private static final String CARD_NUMBER_MESSAGE_INVALID_FORMAT = "Please enter a correct Visa card number.";
  private static final String CARD_NUMBER_VALID_16 = "4111111111111111";
  private static final String CARD_NUMBER_VALID_13 = "4111111111111";
  private static final String CARD_NUMBER_INVALID_EMPTY = "";
  private static final String CARD_NUMBER_INVALID_CHARS = "41111111111A1111";
  private static final String CARD_NUMBER_INVALID_FORMAT_MOREDIGITS = "41111111111111111";
  private static final String CARD_NUMBER_INVALID_FORMAT_LESSDIGITS = "411111111111111";
  private static final String CARD_NUMBER_INVALID_FORMAT_NONVISA = "3111111111111111";

  private static final String CARD_EXPIRY_MESSAGE_VALID = "";
  private static final String CARD_EXPIRY_MESSAGE_INVALID_REQUIRED = "Card Expiry is a required field.";
  private static final String CARD_EXPIRY_MESSAGE_INVALID_DATE = "Please select valid Expiry date.";
  private static final String CARD_EXPIRY_VALID_MONTH = "02";
  private static final String CARD_EXPIRY_VALID_YEAR = "2019";
  private static final String CARD_EXPIRY_INVALID_MONTH = "12";
  private static final String CARD_EXPIRY_INVALID_YEAR = "2017";

  private static final String CARD_CVV_MESSAGE_VALID = "";
  private static final String CARD_CVV_MESSAGE_INVALID_REQUIRED = "Card CVV number is a required field.";
  private static final String CARD_CVV_MESSAGE_INAVLID_FORMAT = "Card CVV number can only be either 3 or 4 digits.";
  private static final String CARD_CVV_VALID_3 = "111";
  private static final String CARD_CVV_VALID_4 = "2222";
  private static final String CARD_CVV_INVALID_EMPTY = "";
  private static final String CARD_CVV_INVALID_CHARS = "11A";
  private static final String CARD_CVV_INVALID_SPACES = "1 1";
  private static final String CARD_CVV_INVALID_SPECIALCHARS = "1#1";
  private static final String CARD_CVV_INVALID_LESSDIGITS = "11";
  private static final String CARD_CVV_INVALID_MOREDIGITS = "11111";

  @Inject
  private CheckoutPage checkoutPage;

  @Test
  public void firstNameValidTest() {
    checkoutPage.open().getCheckoutPageFields().setFirstName(FIRSTNAME_VALID);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getFirstNameError(), is(FIRSTNAME_MESSAGE_VALID));
  }

  @Test
  public void firstNameInvalidSpacesTest() {
    checkoutPage.open().getCheckoutPageFields().setFirstName(FIRSTNAME_INVALID_SPACES);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getFirstNameError(), is(FIRSTNAME_MESSAGE_INVALID_ONLYCHARS));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void firstNameInvalidEmptyTest() {
    checkoutPage.open().getCheckoutPageFields().setFirstName(FIRSTNAME_INVALID_EMPTY);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getFirstNameError(), is(FIRSTNAME_MESSAGE_INVALID_REQUIRED));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void firstNameInvalidSpecialCharsTest() {
    checkoutPage.open().getCheckoutPageFields().setFirstName(FIRSTNAME_INVALID_SPECIALCHARS);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getFirstNameError(), is(FIRSTNAME_MESSAGE_INVALID_ONLYCHARS));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void firstNameInvalidMore20Test() {
    checkoutPage.open().getCheckoutPageFields().setFirstName(FIRSTNAME_INVALID_MORE20);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getFirstNameError(), is(FIRSTNAME_MESSAGE_INVALID_MORE20));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }



  @Test
  public void lastNameValidTest() {
    checkoutPage.open().getCheckoutPageFields().setLastName(LASTNAME_VALID);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getLastNameError(), is(LASTNAME_MESSAGE_VALID));
  }

  @Test
  public void lastNameInvalidSpacesTest() {
    checkoutPage.open().getCheckoutPageFields().setLastName(LASTNAME_INVALID_SPACES);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getLastNameError(), is(LASTNAME_MESSAGE_INVALID_ONLYCHARS));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void lastNameInvalidEmptyTest() {
    checkoutPage.open().getCheckoutPageFields().setLastName(LASTNAME_INVALID_EMPTY);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getLastNameError(), is(LASTNAME_MESSAGE_INVALID_REQUIRED));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void lastNameInvalidSpecialCharsTest() {
    checkoutPage.open().getCheckoutPageFields().setLastName(LASTNAME_INVALID_SPECIALCHARS);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getLastNameError(), is(LASTNAME_MESSAGE_INVALID_ONLYCHARS));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void lastNameInvalidMore20Test() {
    checkoutPage.open().getCheckoutPageFields().setLastName(LASTNAME_INVALID_MORE20);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getLastNameError(), is(LASTNAME_MESSAGE_INVALID_MORE20));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }



  @Test
  public void phoneValidEmptyTest() {
    checkoutPage.open().getCheckoutPageFields().setPhone(PHONE_VALID_EMPTY);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getPhoneError(), is(PHONE_MESSAGE_VALID));
  }

  @Test
  public void phoneValidFormat1Test() {
    checkoutPage.open().getCheckoutPageFields().setPhone(PHONE_VALID_FORMAT1);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getPhoneError(), is(PHONE_MESSAGE_VALID));
  }

  @Test
  public void phoneValidFormat2Test() {
    checkoutPage.open().getCheckoutPageFields().setPhone(PHONE_VALID_FORMAT2);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getPhoneError(), is(PHONE_MESSAGE_VALID));
  }

  @Test
  public void phoneInvalidLessdigitsTest() {
    checkoutPage.open().getCheckoutPageFields().setPhone(PHONE_INVALID_LESSDIGITS);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getPhoneError(), is(PHONE_MESSAGE_INVALID));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void phoneInvalidCharsTest() {
    checkoutPage.open().getCheckoutPageFields().setPhone(PHONE_INVALID_CHARS);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getPhoneError(), is(PHONE_MESSAGE_INVALID));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void phoneInvalidFormatTest() {
    checkoutPage.open().getCheckoutPageFields().setPhone(PHONE_INVALID_FORMAT);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getPhoneError(), is(PHONE_MESSAGE_INVALID));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }



  @Test
  public void cardNumberValid16Test() {
    checkoutPage.open().getCheckoutPageFields().setCardNumber(CARD_NUMBER_VALID_16);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardNumberError(), is(CARD_NUMBER_MESSAGE_VALID));
  }

  @Test
  public void cardNumberValid13Test() {
    checkoutPage.open().getCheckoutPageFields().setCardNumber(CARD_NUMBER_VALID_13);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardNumberError(), is(CARD_NUMBER_MESSAGE_VALID));
  }

  @Test
  public void cardNumberInvalidEmptyTest() {
    checkoutPage.open().getCheckoutPageFields().setCardNumber(CARD_NUMBER_INVALID_EMPTY);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardNumberError(), is(CARD_NUMBER_MESSAGE_INVALID_REQUIRED));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void cardNumberInvalidCharsTest() {
    checkoutPage.open().getCheckoutPageFields().setCardNumber(CARD_NUMBER_INVALID_CHARS);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardNumberError(), is(CARD_NUMBER_MESSAGE_INVALID_FORMAT));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void cardNumberInvalidMoredigitsTest() {
    checkoutPage.open().getCheckoutPageFields().setCardNumber(CARD_NUMBER_INVALID_FORMAT_MOREDIGITS);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardNumberError(), is(CARD_NUMBER_MESSAGE_INVALID_FORMAT));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void cardNumberInvalidLessdigitsTest() {
    checkoutPage.open().getCheckoutPageFields().setCardNumber(CARD_NUMBER_INVALID_FORMAT_LESSDIGITS);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardNumberError(), is(CARD_NUMBER_MESSAGE_INVALID_FORMAT));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void cardNumberInvalidNonvisaTest() {
    checkoutPage.open().getCheckoutPageFields().setCardNumber(CARD_NUMBER_INVALID_FORMAT_NONVISA);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardNumberError(), is(CARD_NUMBER_MESSAGE_INVALID_FORMAT));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }



  @Test
  public void cardExpiryDateValidTest() {
    checkoutPage.open().getCheckoutPageFields().setCardExpiryDate(CARD_EXPIRY_VALID_MONTH, CARD_EXPIRY_VALID_YEAR);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardExpiryDateError(), is(CARD_EXPIRY_MESSAGE_VALID));
  }

  @Test
  public void cardExpiryDateInvalidRequiredTest() {
    checkoutPage.open();
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardExpiryDateError(), is(CARD_EXPIRY_MESSAGE_INVALID_REQUIRED));
  }

  @Test
  public void cardExpiryDateInvalidDateTest() {
    checkoutPage.open().getCheckoutPageFields().setCardExpiryDate(CARD_EXPIRY_INVALID_MONTH, CARD_EXPIRY_INVALID_YEAR);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardExpiryDateError(), is(CARD_EXPIRY_MESSAGE_INVALID_DATE));
  }



  @Test
  public void cardCVVValid3Test() {
    checkoutPage.open().getCheckoutPageFields().setCardCVV(CARD_CVV_VALID_3);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardCVVError(), is(CARD_CVV_MESSAGE_VALID));
  }

  @Test
  public void cardCVVValid4Test() {
    checkoutPage.open().getCheckoutPageFields().setCardCVV(CARD_CVV_VALID_4);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardCVVError(), is(CARD_CVV_MESSAGE_VALID));
  }

  @Test
  public void cardCVVInvalidEmptyTest() {
    checkoutPage.open().getCheckoutPageFields().setCardCVV(CARD_CVV_INVALID_EMPTY);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardCVVError(), is(CARD_CVV_MESSAGE_INVALID_REQUIRED));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void cardCVVInvalidCharsTest() {
    checkoutPage.open().getCheckoutPageFields().setCardCVV(CARD_CVV_INVALID_CHARS);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardCVVError(), is(CARD_CVV_MESSAGE_INAVLID_FORMAT));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void cardCVVInvalidSpacesTest() {
    checkoutPage.open().getCheckoutPageFields().setCardCVV(CARD_CVV_INVALID_SPACES);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardCVVError(), is(CARD_CVV_MESSAGE_INAVLID_FORMAT));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void cardCVVInvalidSpecialcharsTest() {
    checkoutPage.open().getCheckoutPageFields().setCardCVV(CARD_CVV_INVALID_SPECIALCHARS);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardCVVError(), is(CARD_CVV_MESSAGE_INAVLID_FORMAT));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void cardCVVInvalidLessdigitsTest() {
    checkoutPage.open().getCheckoutPageFields().setCardCVV(CARD_CVV_INVALID_LESSDIGITS);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardCVVError(), is(CARD_CVV_MESSAGE_INAVLID_FORMAT));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }

  @Test
  public void cardCVVInvalidMoredigitsTest() {
    checkoutPage.open().getCheckoutPageFields().setCardCVV(CARD_CVV_INVALID_MOREDIGITS);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageFieldErrors().getCardCVVError(), is(CARD_CVV_MESSAGE_INAVLID_FORMAT));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
  }



  @Test
  public void validFormTest() {
    checkoutPage.open();
    checkoutPage.getCheckoutPageFields().setFirstName(FIRSTNAME_VALID);
    checkoutPage.getCheckoutPageFields().setLastName(LASTNAME_VALID);
    checkoutPage.getCheckoutPageFields().setPhone(PHONE_VALID_EMPTY);
    checkoutPage.getCheckoutPageFields().setCardNumber(CARD_NUMBER_VALID_16);
    checkoutPage.getCheckoutPageFields().setCardExpiryDate(CARD_EXPIRY_VALID_MONTH, CARD_EXPIRY_VALID_YEAR);
    checkoutPage.getCheckoutPageFields().setCardCVV(CARD_CVV_VALID_3);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_VALID));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), not(FORM_MESSAGE_INVALID));
  }

  @Test
  public void invalidFormTest() {
    checkoutPage.open();
    checkoutPage.getCheckoutPageFields().setFirstName(FIRSTNAME_VALID);
    checkoutPage.getCheckoutPageFields().setLastName(LASTNAME_VALID);
    checkoutPage.getCheckoutPageFields().setPhone(PHONE_INVALID_FORMAT);
    checkoutPage.getCheckoutPageFields().setCardNumber(CARD_NUMBER_VALID_16);
    checkoutPage.getCheckoutPageFields().setCardExpiryDate(CARD_EXPIRY_VALID_MONTH, CARD_EXPIRY_VALID_YEAR);
    checkoutPage.getCheckoutPageFields().setCardCVV(CARD_CVV_VALID_3);
    checkoutPage.getCheckoutPageForm().submitForm();
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), is(FORM_MESSAGE_INVALID));
    assertThat(checkoutPage.getCheckoutPageForm().getFormMessage(), not(FORM_MESSAGE_VALID));
  }
}
