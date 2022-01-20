package contactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.objectRepository.ContactInfomationPage;
import com.crm.comcast.objectRepository.ContactsPage;
import com.crm.comcast.objectRepository.CreatingNewContactPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.OrganizationLookUpPage;

/**
 * 
 * @author mamatha
 *
 */
@Listeners(com.crm.comcast.GenericUtility.ListenerImpClass.class)
public class CreateContactTC_21Test extends BaseClass{


	/**
	 * create contact with required field
	 * @param args
	 * @throws Throwable
	 */
	
	@Test (groups={"smokeTest","regressionTest"})

	public  void createContactTest() throws Throwable {

		//object creation for utilies
		ExcelUtility Exelutil = new ExcelUtility();



		// getting data from excel sheet
		String lastname = Exelutil.getStringCellData("sheet1", 3, 2);
		String childWindowURL = Exelutil.getStringCellData("sheet1", 3, 3);
		String parentWindowURL = Exelutil.getStringCellData("sheet1", 3, 4);

		//home page
		HomePage homePage =new HomePage(driver);
		homePage.clickOnContactsLink();;

		//contact page
		ContactsPage contactsPage= new ContactsPage(driver);
		contactsPage.clickOnCreateContactPlusImg();

		//create new contact
		CreatingNewContactPage newContact = new CreatingNewContactPage(driver);
		newContact.lastnameTextField(lastname);
		newContact.orgNameLookUpPlusButton();


		//organization look up switch and switch back window
		OrganizationLookUpPage OrgLookUpPage = new OrganizationLookUpPage(driver);
		OrgLookUpPage.clickOnOrgNameLink(childWindowURL, parentWindowURL);

		//create new contact
		newContact.clickOnOrgNameClearImg();
		newContact.clickOnSaveButton();


		//Contact Infomation Page
		ContactInfomationPage contactInfo = new ContactInfomationPage(driver);
		String actualText = contactInfo.contactInfoText();


		//verifying created contact title 
		Assert.assertEquals(actualText.contains(lastname), true);

		/*if(actualText.contains(lastname))
		{
			System.out.println("contact created and verified");
		}
		else
		{
			System.out.println("contact not created");
		}*/
	}

}

