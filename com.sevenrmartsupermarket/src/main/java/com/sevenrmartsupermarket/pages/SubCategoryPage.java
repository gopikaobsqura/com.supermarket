package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;

public class SubCategoryPage {
	
	WebDriver driver;
	public SubCategoryPage(WebDriver driver){		
		this.driver = driver;	
		PageFactory.initElements(driver,this);
		
		
	}

}
