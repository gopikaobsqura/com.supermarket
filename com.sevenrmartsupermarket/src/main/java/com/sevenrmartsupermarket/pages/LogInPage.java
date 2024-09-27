package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;

public class LogInPage {
	
	WebDriver driver;
	Properties properties=new Properties();
	
	@FindBy(xpath="//input[@type='text']") 	
	WebElement userNameField;
	@FindBy(xpath="//input[@type='password']") 	
	WebElement passwardField;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']") 	
	WebElement signInButton;
	
	
  public LogInPage(WebDriver driver){		
		this.driver = driver;	
		PageFactory.initElements(driver,this);
		
		try {
			FileInputStream inputStream=new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(inputStream);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  
  public void Enterusername(String userName) {
	  userNameField.sendKeys(userName);
}
  
  public void EnterPassward(String passward) {
		passwardField.sendKeys(passward);
  }
	
  public void ClickOnSignInButton() {
	  signInButton.click();
}
  public void Login(String userName,String passward) {
	  Enterusername(userName);
	  EnterPassward(passward);
	  ClickOnSignInButton();
	  
  }
  
  public void Login() {
	  String userName=properties.getProperty("userName");// to read from config file
	  String password=properties.getProperty("password");
	  Enterusername(userName);
	  EnterPassward(password);
	  ClickOnSignInButton();
  }
public void verifyInvalidCredentials() {
  
}
}
