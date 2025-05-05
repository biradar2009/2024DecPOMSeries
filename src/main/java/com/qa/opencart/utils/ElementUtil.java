package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
//import java.util.concurrent.TimeoutException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;

	}

	public void doSendKey(By locator, String value) {
		getElement(locator).sendKeys(value);

	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	public void doClick(By locator) {
		getElement(locator).click();

	}

	public String doGetText(By locator) {
		String header = getElement(locator).getText();
		System.out.println(header);
		
		return header;

	}
	
	
	public  String getElementDomPropertyValue(By locator ,String propName) {
		return	getElement(locator).getDomAttribute(propName);
		}
	
	
	public  String getElementDomAttributeValue(By locator ,String attrName) {
	return	getElement(locator).getDomAttribute(attrName);
	}
	
	
//+++++++++++++++++++++++++++++++++ FindElements+++++++++++++++
	
	public  List<String> getElementTestList(By locator) {
		List<WebElement> eleList=getElements(locator);
		List<String> eleTextList= new ArrayList<String>();
		for(WebElement e:eleList) {
	String text=		e.getText();
	if(text.length()!=0) {
		
		eleTextList.add(text);
		
	}
		}
		return eleTextList;
		
	}
	
	public int getElementsCount(By locator) {
int eleCount=		getElements(locator).size();
System.out.println("Element count======" +eleCount);
return eleCount;
	}
	
	public  List<WebElement> getElements(By locator) {
	return	driver.findElements(locator);

	}
	
	
	
//	__________________---------------------------Dropdwon -select util
	public boolean doSelectDropDownByIndex(By locator,int index){
		Select select = new Select(getElement(locator));
		try {
		select.selectByIndex(index);
		return true;
		}
		catch(NoSuchElementException e) {
	
		System.out.println(index+ "is not present");
	return false;
	 }
	}
	 public  boolean doSelectDropDownByVisibleText(By locator,String visibleText){
			Select select = new Select(getElement(locator));
			try {
			select.selectByVisibleText(visibleText);
			return true;
			}
			catch(NoSuchElementException e) {
				System.out.println(visibleText+ "is not preset in the dropdown");
				return false;
			}
			}
	
	 public  boolean doSelectDropDownByValue(By locator,String value){
			Select select = new Select(getElement(locator));
			try {
				
			select.selectByValue(value);
			return true;
		}
		catch(NoSuchElementException e) {
	
		System.out.println( value+ "is not present");
	return false;
	 }
	 }
	
	
	 
	// ___+++++++++++ ActionClsss utils-----------
	 public void doMoveToElement(By locator) {
		 Actions act= new Actions(driver);
		 act.moveToElement(getElement(locator)).build().perform();
		 
	 }
	
	 
	 
	 public  void handleParentSubMenu(By parentMenu,By subMenu) throws InterruptedException {
			Actions act= new Actions(driver);
			doMoveToElement(parentMenu);
			Thread .sleep(2000);
			doClick(subMenu);
			
			//public static void handleparentSubMenu(By parentMenu,By subMenu) throws InterruptedException {
//			Actions act= new Actions(driver);
//			act.moveToElement(getElement(parentMenu)).build().perform();
//	Thread.sleep(2000);
//
//	getElement(subMenu).click();
		}
		
		//------------------Action Multilevel----
	 public void handle4LevelMenuHandle(By levelMenu1, By levelMenu2,By levelMenu3 ,By levelMenu4) throws InterruptedException {
			doClick(levelMenu1);
		 
			Thread.sleep(2000);

			//act.moveToElement(getElement(levelMenu2)).build().perform();
			doMoveToElement(levelMenu2);
			Thread.sleep(2000);
			//act.moveToElement(getElement(levelMenu3)).build().perform();
			doMoveToElement(levelMenu3);
			Thread.sleep(2000);
			//getElement(levelMenu4).click();
			doClick(levelMenu4);
	 }	
			
			
		//	------------ wait util---------
			/**
			 * An expectation for checking that an element is present on the DOM of a page.
			 *  This does notnecessarily mean that the element is visible
			 * @param locator
			 * @param timeout
			 * @return
			 */
			
			
			public WebElement waitForElementPresence(By locator, int timeout) {
				
				WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
				
				return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
						
			}
			
			
		
	
			// Wait Utils**************//
			
			
			/**
			 * An expectation for checking that there is at least one element present on a web page.
			 * @param locator
			 * @param timeOut
			 * @return
			 */
			public List<WebElement> waitForAllElementsPresence(By locator, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			}
			
			
			/**
			 * An expectation for checking that all elements present on the web page that match the locator are visible. 
			 * Visibility means that the elements are not only displayed but also have a height and width that is greater than 0.
			 * @param locator
			 * @param timeOut
			 * @return
			 */
			public List<WebElement> waitForAllElementsVisible(By locator, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			}
			

			/**
			 * An expectation for checking that an element is present on the DOM of a page.
			 * This does not necessarily mean that the element is visible.
			 * 
			 * @param locator
			 * @param timeOut
			 * @return
			 */
//			public WebElement waitForElementPresence(By locator, int timeOut) {
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
//				return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//			}

			/**
			 * An expectation for checking that an element is present on the DOM of a page
			 * and visible. Visibility means that the element is not only displayed but also
			 * has a height and width that is greater than 0.
			 * 
			 * @param locator
			 * @param timeOut
			 * @return
			 */
			public WebElement waitForElementVisible(By locator, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			}
			
			/**
			 * An expectation for checking an element is visible and enabled such that you can click it.
			 * @param locator
			 * @param timeOut
			 */
			public void clickWhenReady(By locator, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
			}
			

			public void clickWithWait(By locator, int timeOut) {
				waitForElementVisible(locator, timeOut).click();
			}

			public void sendKeysWithWait(By locator, int timeOut, CharSequence... value) {
				waitForElementVisible(locator, timeOut).sendKeys(value);
			}

			// *****wait for alert(JS POP)*****//
			public Alert waitForAlert(int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				wait.pollingEvery(Duration.ofSeconds(1))
					.ignoring(NoAlertPresentException.class)
					.withMessage("===js alert not present");
				return wait.until(ExpectedConditions.alertIsPresent());
			}

			public void acceptAlert(int timeOut) {
				waitForAlert(timeOut).accept();
			}

			public void dismissAlert(int timeOut) {
				waitForAlert(timeOut).dismiss();
			}

			public String getTextAlert(int timeOut) {
				return waitForAlert(timeOut).getText();
			}

			public void sendKeysAlert(int timeOut, String value) {
				waitForAlert(timeOut).sendKeys(value);
			}

			// wait for title:
			public String waitFotTitleContains(String fractionTitle, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				try {
					wait.until(ExpectedConditions.titleContains(fractionTitle));
					return driver.getTitle();

				} catch (TimeoutException e) {
					return null;
				}

			}

			public String waitFotTitleIs(String title, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				try {
					wait.until(ExpectedConditions.titleIs(title));
					return driver.getTitle();

				} catch (TimeoutException e) {
					return null;
				}

			}

			// wait for url:
			public String waitForURLContains(String fractionURL, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				try {
					wait.until(ExpectedConditions.urlContains(fractionURL));
					return driver.getCurrentUrl();

				} catch (TimeoutException e) {
					return null;
				}

			}

//			public String waitForURLIs(String url, int timeOut) {
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
//				try {
//					wait.until(ExpectedConditions.urlToBe(url));
//					return driver.getCurrentUrl();
//
//				} catch (TimeoutException e) {
//					return null;
//				}
				
	//	========		
				
				public String waitForURLIs(String url, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			try {
				wait.until(ExpectedConditions.urlToBe(url));
				return driver.getCurrentUrl();

			} 
			catch (TimeoutException e) {
				return null;
			}

		}
			
				


				
				
				
				

			

			// wait for frame:
			public void waitForFrameAndSwitchToIt(By frameLocator, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
			}

			public void waitForFrameAndSwitchToIt(String frameNameOrID, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrID));
			}

			public void waitForFrameAndSwitchToIt(int frameIndex, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
			}

			public void waitForFrameAndSwitchToIt(WebElement frameElement, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
			}

			// wait for windows:

			public boolean waitForWindow(int expectedNumberOfWindows, int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

				try {
					return wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
				} catch (Exception e) {
					System.out.println("expectedNumberOfWindows are not correct");
					return false;
				}

			}
			
			
			public WebElement waitForElementVisibleWithFluentWait(By locator, int timeOut, int pollingTime) {
				Wait<WebDriver> wait =  new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(timeOut))
						.pollingEvery(Duration.ofSeconds(pollingTime))
						.ignoring(NoSuchElementException.class)
						.ignoring(StaleElementReferenceException.class)
						.withMessage("===Element is not found====");

				return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			}
			
			
			public WebElement waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
				Wait<WebDriver> wait =  new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(timeOut))
						.pollingEvery(Duration.ofSeconds(pollingTime))
						.ignoring(NoSuchElementException.class)
						.ignoring(StaleElementReferenceException.class)
						.withMessage("===Element is not found====");

				return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			}
			
			
			public boolean isPageLoaded(int timeOut) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
				String flag = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'")).toString();
				return Boolean.parseBoolean(flag);//true
			}
			
			
			
						

		}