package com.e2etest.automation.page_objects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etest.automation.utils.ConfigFileReader;
import com.e2etest.automation.utils.Setup;

public class BouletCorpPage {
	
	public ConfigFileReader configFileReader;
	
	final static String BUTTON_ALEATOIRE = "//*[contains(text(),'Aléatoire')]";
	final static String FACEBOOK_WIDGET = "//img[@title= 'Facebook']";
	final static String TWITTER_WIDGET = "//img[@title= 'Twitter']";
	final static String TUMBLR_WIDGET = "//a[@title= 'Share on Tumblr']";

	/* @FindBy */
	@FindBy(how = How.XPATH, using = BUTTON_ALEATOIRE)
	public static WebElement buttonAleatoire;
	@FindBy(how = How.XPATH, using = FACEBOOK_WIDGET)
	public static WebElement facebookWidget;
	@FindBy(how = How.XPATH, using = TWITTER_WIDGET)
	public static WebElement twitterWidget;
	@FindBy(how = How.XPATH, using = TUMBLR_WIDGET)
	public static WebElement tumblrWidget;

	public BouletCorpPage() {
		configFileReader = new ConfigFileReader();
		PageFactory.initElements(Setup.getDriver(), this);
	}
	
	public void checkUrlChnaged() {
		String actualUrl=Setup.getDriver().getCurrentUrl();
		System.out.println("Title of page is " + actualUrl);
		String url= configFileReader.getProperties("bouletcorp.url");
		if(actualUrl.equals(url))
		{
			System.out.println("Failed - The URL is not changed");
		}
		else {
			System.out.println("Succesfull - The URL is changed");
		}
	}

}