package contactTest;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.objectRepository.ContactsPage;
import com.crm.comcast.objectRepository.CreatingNewContactPage;
import com.crm.comcast.objectRepository.HomePage;

/**
 * 
 * @author Mamatha
 *
 */
@Listeners(com.crm.comcast.GenericUtility.ListenerImpClass.class)
public class EmailOptOutBoxIsEnableOrNotTC_23Test extends BaseClass {

	/**
	 * to check Email Opt Out Box Is Enable Or Not TC_23Test
	 * @param args
	 * @throws Throwable
	 */

	@Test(groups = {"regressionTest"})
	public  void EmailOptOutBox() throws Throwable {

		//homepage
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContactsLink();

		//contacts page
		ContactsPage contactsPage =new ContactsPage(driver);
		contactsPage.clickOnCreateContactPlusImg();

		//create new contact page
		CreatingNewContactPage newContactPage = new CreatingNewContactPage(driver);

       //verification
		Assert.assertEquals(newContactPage.getEmailOptOutCheckBox().isEnabled(), true);
		newContactPage.getEmailOptOutCheckBox();

	}

}

