package test

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Test {

	@Keyword
	public static Optional<String> login (String account, String encryptpassword ){

		WebUI.openBrowser('https://stg.eslite.dev/login')

		Optional<String> data = (account == null) ? Optional.empty() : Optional.of(account)
		Optional<String> data2 = (encryptpassword == null) ? Optional.empty() : Optional.of(encryptpassword)

		if(data.isPresent() && data2.isPresent()) {

			WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/account_inputText'), account )
			WebUI.setEncryptedText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/password_inputText'), encryptpassword )
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/login_button'))
		}
	}
}
