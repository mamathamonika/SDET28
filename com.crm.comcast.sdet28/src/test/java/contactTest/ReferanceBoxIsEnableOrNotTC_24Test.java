package contactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.objectRepository.ContactsPage;
import com.crm.comcast.objectRepository.CreatingNewContactPage;
import com.crm.comcast.objectRepository.HomePage;

/**
 * 
 * @author Mamatha
 *
 */
@Listeners(com.crm.comcast.GenericUtility.ListenerImpClass.class)
public class ReferanceBoxIsEnableOrNotTC_24Test extends BaseClass {

	/**
	 * to check Referance Box Is Enable Or Not in contact module TC_24Test
	 * @param args
	 * @throws Throwable
	 */
	@Test(groups = {"regressionTest"})
	public  void referanceBoxIsEnable() throws Throwable {

		//homepage
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContactsLink();

		//contacts page
		ContactsPage contactsPage =new ContactsPage(driver);
		contactsPage.clickOnCreateContactPlusImg();

		//create new contact page
		CreatingNewContactPage newContactPage = new CreatingNewContactPage(driver);
	
		//verification
		Assert.assertEquals(newContactPage.getReferenceCheckBox().isEnabled(), true);
		newContactPage.clickOnReferenceCheckBox();

	}
}

