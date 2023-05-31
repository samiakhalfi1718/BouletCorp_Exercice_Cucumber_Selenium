package com.e2etest.automation.step_definitions;
import org.junit.Assert;

import com.e2etest.automation.page_objects.BouletCorpPage;
import com.e2etest.automation.utils.ConfigFileReader;
import com.e2etest.automation.utils.SeleniumUtils;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Quand;

public class BouletCorpStepDefinition {

	protected ConfigFileReader configFileReader;
	protected SeleniumUtils seleniumUtils;
	protected BouletCorpPage bouletCorpPage;

	public BouletCorpStepDefinition() {

		configFileReader = new ConfigFileReader();
		seleniumUtils = new SeleniumUtils();
		bouletCorpPage = new BouletCorpPage();
	}

	@Etantdonné("Je me rends sur le site Bouletcorp {string}")
	public void jeMeRendsSurLeSiteBouletcorp(String URL) {
		seleniumUtils.get(configFileReader.getProperties(URL));
	}

	@Quand("Je clique sur l' onglet aleatoire")
	public void jeCliqueSurLOngletAleatoire() {
		seleniumUtils.click(BouletCorpPage.buttonAleatoire);
	}

	@Alors("la page a changé")
	public void laPageAChangé() {
		bouletCorpPage.checkUrlChnaged();
	}

	@Alors("Les widgets facebook twitter et tumblr sont bien affiches")
	public void lesWidgetsFacebookTwitterEtTumblrSontBienAffiches() {
		boolean facebook = seleniumUtils.isElementDisplayed(BouletCorpPage.facebookWidget);
		Assert.assertTrue(facebook);
		boolean twitter = seleniumUtils.isElementDisplayed(BouletCorpPage.twitterWidget);
		Assert.assertTrue(twitter);
		boolean tumblr = seleniumUtils.isElementDisplayed(BouletCorpPage.tumblrWidget);
		Assert.assertTrue(tumblr);
	}

}