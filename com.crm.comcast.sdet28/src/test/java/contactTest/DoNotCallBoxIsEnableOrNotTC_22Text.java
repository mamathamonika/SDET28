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
public class DoNotCallBoxIsEnableOrNotTC_22Text extends BaseClass {

	/**
	 * to check Do Not Call Box Is Enable Or Not in contact module
	 * @param args
	 * @throws Throwable
	 */

	@Test (groups = {"regressionTest"})
	public void doNotCallBox() throws Throwable {

		//HomePage
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContactsLink();

		//contacts page
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.clickOnCreateContactPlusImg();

		//create new contact

		CreatingNewContactPage NewContactPage = new CreatingNewContactPage (driver);

		Assert.assertEquals(NewContactPage.getDoNotCallCheckBox().isEnabled(), true);
		NewContactPage.clickOnDoNotCallCheckBox();

	}
	
	// second text method
/*	@Test(groups = {"regressionTest"})
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
		if(newContactPage.getEmailOptOutCheckBox().isEnabled())
		{
			System.out.println("email opt out box is enabled");
			newContactPage.getEmailOptOutCheckBox();
		}

		else
		{
			System.out.println("email opt out box is not enabled");
		}
	} */

}


