package functionTest
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


import com.kms.katalon.core.testdata.InternalData

import org.openqa.selenium.Keys as Keys


public class shoppingCartSystem {

	//登入
	@Keyword
	def public static void loginFrontEnd(String account, String encryptpassword ){

		WebUI.openBrowser('https://stg.eslite.dev/login')
		WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/account_inputText'), account )
		WebUI.setEncryptedText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/password_inputText'), encryptpassword )
		WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/login_button'))
	}

	//搜索商品
	@Keyword
	def public static void searchProduct(String product26) {

		TestData data = findTestData("product")

		boolean check = true

		for(def i=1; i<=data.getRowNumbers(); i++) {

			if(product26==data.getValue(2, i)){

				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/search - Copy"), data.getValue(2,i))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/search_button"))
				check = true
				break
			}else

				check = false
		}

		if(check==false) {
			System.out.println("Not found product26!")
		}
	}

	//商品搜尋頁面
	@Keyword
	def public static void productSearchPage(String text) {

		String cartBtn = WebUI.getText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/加入購物車"))

		if(text == cartBtn ) {
			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/加入購物車"))
			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/cart_label"))
		}
	}

	//購物step1
	@Keyword
	def public static void shoppingCartStepOne(String text) {

		String checkOut = WebUI.getText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/結帳"))

		if(text == checkOut) {

			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/結帳"))
		}
	}


	//選擇配送方式
	@Keyword
	def public static void SCSTwo_selectShippingOption(String text) {

		//String selectShippingOption = WebUI.getText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/選擇配送方式_label"))
		String familyMart = WebUI.getText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/配送＿option",[('x'):'全家取貨']))
		String localDelivery = WebUI.getText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/配送＿option",[('x'):'台灣-宅配(台灣地區)']))
		String eslitePickUp = WebUI.getText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/配送＿option',[('x'):'誠品門市取貨']))
		String internationalDelivery = WebUI.getText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/配送＿option',[('x'):'台灣以外快遞寄送']))
		String esliteDonate = WebUI.getText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/配送＿option',[('x'):'誠品基金會捐書(捐贈訂單成立後即無法退還)']))
		String seven = WebUI.getText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/配送＿option',[('x'):'台灣7-ELEVEN取貨']))


		if(text == familyMart) {

			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/配送＿option",[('x'):'全家取貨']))

		}else if(text == localDelivery) {

			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/配送＿option",[('x'):'台灣-宅配(台灣地區)']))

		}else if(text == eslitePickUp) {

			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/配送＿option',[('x'):'誠品門市取貨']))

		}else if(text == internationalDelivery) {

			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/配送＿option',[('x'):'台灣以外快遞寄送']))

		}else if(text == esliteDonate) {

			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/配送＿option',[('x'):'誠品基金會捐書(捐贈訂單成立後即無法退還)']))

		}else if(text == seven) {

			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/配送＿option',[('x'):'台灣7-ELEVEN取貨']))

		}

	}


	//訂購人資料
	@Keyword
	def public static void SCSTwo_ordererInformation(String text, String text2, String text3, String text4, String text5) {

		//String ordererInformation = WebUI.getText(findTestObject("FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_label"))

		String editOrdererData = WebUI.getText(findTestObject("FunctionTest/信用卡一次付清/訂購人資料/編輯訂購人資料_label"))
		String name = WebUI.getText(findTestObject('FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_姓名_label'))
		String mobile = WebUI.getText(findTestObject('FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_行動電話_label'))
		String contactPhone = WebUI.getText(findTestObject('FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_聯絡電話_label'))
		String address = WebUI.getText(findTestObject('FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_地址_label'))
		//String locationTw= WebUI.getText(findTestObject('FunctionTest/信用卡一次付清/訂購人資料/聯絡電話_海外地區'))

		if(text == editOrdererData) {

			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/訂購人資料/編輯訂購人資料btn"))

			if(text2 == name) {

				WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_姓名_input'))

				WebUI.sendKeys(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_姓名_input'), Keys.chord(Keys.COMMAND,'a'))
				WebUI.sendKeys(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_姓名_input'), Keys.chord(Keys.DELETE))

				WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_姓名_input'),GlobalVariable.orderDataname)

			}else
				println("default option_name")

			if(text3 == mobile) {

				WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_行動電話_input'))

				WebUI.sendKeys(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_行動電話_input'), Keys.chord(Keys.COMMAND,'a'))
				WebUI.sendKeys(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_行動電話_input'), Keys.chord(Keys.DELETE))

				WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_行動電話_input'),GlobalVariable.orderDataMobile)
			}else
				println("default option_mobile")

			if(text4 == contactPhone) {

				WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_聯絡電話_input'))
				WebUI.sendKeys(findTestObject('bject Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_聯絡電話_input'), Keys.chord(Keys.COMMAND,'a'))
				//WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_聯絡電話_input'))
				WebUI.sendKeys(findTestObject('bject Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_聯絡電話_input'), Keys.chord(Keys.DELETE))

				WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_聯絡電話_分機_input'), GlobalVariable.orderDataMobileHome)

				//WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_聯絡電話_分機_input'))
				//WebUI.sendKeys(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_聯絡電話_分機_input'), Keys.chord(Keys.COMMAND,'a'))
				//WebUI.sendKeys(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_聯絡電話_分機_input'), Keys.chord(Keys.DELETE))
				WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_聯絡電話_分機_input'))
				WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_聯絡電話_分機_input'), GlobalVariable.orderDataMobile_extension)

			}else
				println("default option_contactPhone")

			if(text5 == address) {

				//if(locationTw == GlobalVariable.checkboxTW) {

				//WebUI.check(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/聯絡電話_海外地區(checkbox)'))
				WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_海外地址_label'))

				WebUI.sendKeys(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_海外地址_label'), Keys.chord(Keys.COMMAND,'a'))
				WebUI.sendKeys(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_海外地址_label'), Keys.chord(Keys.DELETE))


				WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_海外地址_label'), '台北市松山區吳興街34巷18號')

				//}else
				//WebUI.setText(findTestObject('FunctionTest/信用卡一次付清/訂購人資料/訂購人資料_地址_label'), GlobalVariable.orderDataMobile_extension )

			}else
				println("default option_address")

			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/訂購人資料/儲存btn"))


		}else

			println("default option")

	}

	//收件人資料
	@Keyword
	def public static void SCSTwo_recipientInformation(String text, String text2) {

		String sameAsOrdererCB = WebUI.getText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/同訂購人_label"))


		if(text == "全家取貨收件人") {

			if(sameAsOrdererCB == text2) {

				WebUI.check(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/同訂購人_label"))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/familyMartStore/selectStoreBtn"))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/familyMartStore/familyMartSelectCity",[('city'):'台北市']))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/familyMartStore/familyMartSelectSection",[('section'):'信義區']))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/familyMartStore/familyMartSelectStreet",[('street'):'信義路六段']))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/familyMartStore/familyMartSelectStore"))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/familyMartStore/familyMartConfirmStoreBtn"))

			}else {

				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/姓名_textinput"), GlobalVariable.orderDataname)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/手機號碼_textinput"), GlobalVariable.orderDataname)
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/familyMartStore/selectStoreBtn"))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/familyMartStore/familyMartSelectCity",[('city'):'台北市']))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/familyMartStore/familyMartSelectSection",[('section'):'信義區']))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/familyMartStore/familyMartSelectStreet",[('street'):'信義路六段']))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/familyMartStore/familyMartSelectStore"))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/familyMartStore/familyMartConfirmStoreBtn"))

			}


		}else if(text == "台灣宅配收件人") {

			if( sameAsOrdererCB == text2) {

				WebUI.check(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/同訂購人_label"))

			}else {

				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/姓名_textinput"), GlobalVariable.orderDataname)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/手機號碼_textinput"), GlobalVariable.orderDataMobile)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/聯絡電話_inputtext"), GlobalVariable.orderDataMobile_extension)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/分機_inputtext"), GlobalVariable.orderDataMobile_extension)
				WebUI.selectOptionByIndex(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/cityName"),2)
				WebUI.selectOptionByIndex(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/areaName"), 7)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/addressName"), GlobalVariable.address)

			}

		}else if (text == "誠品門市取貨收件人") {

			if( sameAsOrdererCB == text2) {

				WebUI.check(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/同訂購人_label"))
				WebUI.selectOptionByIndex(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/storeCity"),2)
				WebUI.selectOptionByIndex(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/storeArea"), 2)

			}else {

				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/姓名_textinput"), GlobalVariable.orderDataname)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/手機號碼_textinput"), GlobalVariable.orderDataMobile)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/聯絡電話_inputtext"), GlobalVariable.orderDataMobile_extension)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/分機_inputtext"), GlobalVariable.orderDataMobile_extension)
				WebUI.selectOptionByIndex(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/storeCity"),2)
				WebUI.selectOptionByIndex(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/storeArea"), 2)

			}

		}else if(text == "台灣以外快遞寄送收件人") {

			if(sameAsOrdererCB == text2) {

				WebUI.check(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/同訂購人_label"))
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/分機_inputtext"), GlobalVariable.orderDataMobile_extension)
				WebUI.selectOptionByIndex(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/addressCountry"),2)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/postalCode"), "110")
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/addressCityEn"), "xxx")
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/addressEn"), "xxxxxxxx")

			}else {

				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/姓名_textinput"), GlobalVariable.orderDataname)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/手機號碼_textinput"), GlobalVariable.orderDataMobile)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/聯絡電話_inputtext"), GlobalVariable.orderDataMobile_extension)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/分機_inputtext"), GlobalVariable.orderDataMobile_extension)
				WebUI.selectOptionByIndex(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/addressCountry"),2)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/postalCode"), "110")
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/addressCityEn"), "xxx")
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/addressEn"), "xxxxxxxx")

			}

		}else if (text == "台灣7-11收件人") {

			if(sameAsOrdererCB == text2) {

				WebUI.check(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/同訂購人_label"))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/7-11Store/selectStoreBtn"))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/7-11Store/7-11fchainName"))
				WebUI.switchToFrame(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/7-11Store/7-11iframe"),5)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/7-11Store/7-11chainNameInput"),"信")
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/7-11Store/7-11searchBtn"))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/7-11門市"))
				WebUI.switchToDefaultContent()
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/7-11門市確認"))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/7-11同意_button"))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/7-11確認"))

			}else {

				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/姓名_textinput"), GlobalVariable.orderDataname)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/手機號碼_textinput"), GlobalVariable.orderDataname)
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/7-11Store/selectStoreBtn"))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/7-11Store/7-11fchainName"))
				WebUI.switchToFrame(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/7-11Store/7-11iframe"),5)
				WebUI.setText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/7-11Store/7-11chainNameInput"),"信")
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/收件人資料/7-11Store/7-11searchBtn"))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/7-11門市"))
				WebUI.switchToDefaultContent()
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/7-11門市確認"))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/7-11同意_button"))
				WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/7-11確認"))

			}
		}

	}

	//付款方式
	@Keyword
	def public static void SCSTwo_payment(String text) {

		String seven = WebUI.getText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/payment_7-11"))
		String familyMart = WebUI.getText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/payment_family"))
		String atm = WebUI.getText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/payment_Atm"))
		String creditCard1 = WebUI.getText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/payment_creditCard1"))
		String creditCard2 = WebUI.getText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/payment_creditCard2"))
		String street = WebUI.getText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/payment_street"))
		String linePay = WebUI.getText(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/payment_linePay"))
		creditCard2 = creditCard2.substring(0,5)

		if (text == seven) {

			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/payment_7-11"))
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/確認結帳'))

		}else if (text == familyMart) {

			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/payment_family"))
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/確認結帳'))

		}else if(text == atm) {

			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/payment_Atm"))
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/確認結帳'))

		}else if(text == creditCard1 ) {

			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/payment_creditCard1"))
			WebUI.setText(findTestObject('FunctionTest/信用卡一次付清/持卡人_信用卡號_有效期限_背面末三碼',[('y'):'step2-credit-card-name']),'hello')
			WebUI.switchToFrame(findTestObject('Object Repository/FunctionTest/信用卡一次付清/持卡人_信用卡號_有效期限_背面末三碼 - Copy'), 30)
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/iframe'))
			WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/iframe'), "4242424242424242")
			WebUI.switchToDefaultContent()
			WebUI.switchToFrame(findTestObject('Object Repository/FunctionTest/信用卡一次付清/持卡人_信用卡號_有效期限_背面末三碼 - Copy (1)'), 30)
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/iframe2'))
			WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/iframe2'),'0123')
			WebUI.switchToDefaultContent()
			WebUI.switchToFrame(findTestObject('Object Repository/FunctionTest/信用卡一次付清/持卡人_信用卡號_有效期限_背面末三碼 - Copy (2)'), 30)
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/iframe3'))
			WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/iframe3'),'123')
			WebUI.switchToDefaultContent()
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/確認結帳'))
			WebUI.waitForPageLoad(5)
			WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/tappay_card_num'),'1234567')
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/tappy_send_button'))
			WebUI.waitForPageLoad(10)


		}else if (text == creditCard2) {

			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/payment_creditCard2"))
			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/信用卡分期/3period"))
			WebUI.setText(findTestObject('FunctionTest/信用卡一次付清/持卡人_信用卡號_有效期限_背面末三碼',[('y'):'step2-credit-card-name']),'hello')
			WebUI.switchToFrame(findTestObject('Object Repository/FunctionTest/信用卡一次付清/持卡人_信用卡號_有效期限_背面末三碼 - Copy'), 30)
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/iframe'))
			WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/iframe'), "4242424242424242")
			WebUI.switchToDefaultContent()
			WebUI.switchToFrame(findTestObject('Object Repository/FunctionTest/信用卡一次付清/持卡人_信用卡號_有效期限_背面末三碼 - Copy (1)'), 30)
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/iframe2'))
			WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/iframe2'),'0123')
			WebUI.switchToDefaultContent()
			WebUI.switchToFrame(findTestObject('Object Repository/FunctionTest/信用卡一次付清/持卡人_信用卡號_有效期限_背面末三碼 - Copy (2)'), 30)
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/iframe3'))
			WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/iframe3'),'123')
			WebUI.switchToDefaultContent()
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/確認結帳'))
			WebUI.waitForPageLoad(5)
			WebUI.setText(findTestObject('Object Repository/FunctionTest/信用卡一次付清/tappay_card_num'),'1234567')
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/tappy_send_button'))
			WebUI.waitForPageLoad(10)

		}else if(text == street) {

			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/payment_street"))
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/確認結帳'))

		}else if(text == linePay) {

			WebUI.click(findTestObject("Object Repository/FunctionTest/信用卡一次付清/付款方式1/payment_linePay"))
			WebUI.click(findTestObject('Object Repository/FunctionTest/信用卡一次付清/確認結帳'))
		}

	}



}

