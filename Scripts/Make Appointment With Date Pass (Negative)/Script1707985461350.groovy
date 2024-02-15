import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.util.Locale as Locale

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_CURA Healthcare Service/select_Tokyo CURA Healthcare Center        _5b4107'), 
    'Hongkong CURA Healthcare Center', true)

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/label_Medicaid'))

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Visit Date (Required)_visit_date'))

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/td_13'))

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Visit Date (Required)_visit_date'))

//Get today's date
LocalDate today = LocalDate.now()

DateTimeFormatter formatter = DateTimeFormatter.ofPattern('dd/MM/yyyy', Locale.ENGLISH)

String appointmentDateString = WebUI.getText(findTestObject('DatePicker/DatePicker'))

println(appointmentDateString)

LocalDate appointmentDate = LocalDate.parse(appointmentDateString, formatter)

if (appointmentDate.isBefore(today)) {
    WebUI.comment('Appointment cannot be set to date earlier than today.')
} else {
    WebUI.comment('Appointment is Valid')
}

//try catch

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/td_15'))

WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/textarea_Comment_comment'), 'HAHAHAHHAHAAH')

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/button_Book Appointment'))

WebUI.findWebElement(findTestObject('Page_CURA Healthcare Service/Confirmation_Please be informed that your appointment _11813a'), 
    0)

WebUI.findWebElement(findTestObject('Page_CURA Healthcare Service/Confirmation_Hongkong CURA Healthcare Center'), 0)

WebUI.findWebElement(findTestObject('Page_CURA Healthcare Service/Confirmation_Medicaid'), 0)

//
//WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/a_Go to Homepage'))
WebUI.closeBrowser()

