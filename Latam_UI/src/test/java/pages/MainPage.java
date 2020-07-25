package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	
	WebDriver driver;
	
	By txt_origem = By.id("compra-select-origin");
	
	By sel_origem = By.xpath("//a[contains(.,'São Paulo (SAO), Brasil')]");
	
	By txt_destino = By.id("compra-select-destination");
	
	By sel_destino = By.xpath("//div[2]/div/div/div[2]/ul/li/a/span");
	
	By data_inicial = By.xpath("//div[2]/div/div/div/div/div/div/input");
	
	By data_in = By.xpath("//a[contains(.,'27')]");
	
	By data_final = By.xpath("//div[2]/div/div[3]/div/div/div/div/input");
	
	By data_fi = By.xpath("//a[contains(text(),'10')]");
	
	By num_passag = By.cssSelector("#tab-compra > div > div > div > div > div > div > form > div > div.row > div > div.collapsible-panel > div:nth-child(1) > div:nth-child(3) > div.custom-col-sm.custom-col-sm-passengers.col-sm-5.col-xs-12 > div > div > div > div.box-input.col-xs-12.col-sm-push-0.col-sm-12 > span");
	
	By num_adulto = By.xpath("//*[@id=\"tab-compra\"]/div/div/div/div/div/div/form/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div/div/div/div[4]/div[2]/div/div[2]/div/div/div/span[2]/button");
	
	By btn_procure_voo = By.cssSelector(".compra__ok-button-region > .button");	
	
	//Constructor
	public MainPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void escreverOrigem(String origem) {
		
		driver.findElement(txt_origem).sendKeys(origem);
		
		WebDriverWait wait = new WebDriverWait(this.driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(sel_origem));
		
		driver.findElement(sel_origem).click();
				
	}
	
	public void escreverDestino(String destino) {
		
		driver.findElement(txt_destino).sendKeys(destino);
		
		WebDriverWait wait = new WebDriverWait(this.driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(sel_destino));
		
		driver.findElement(sel_destino).click();
		
	}
	
	public void clickDataInicial() {
		
		driver.findElement(data_inicial).click();
		
		WebDriverWait wait = new WebDriverWait(this.driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(data_in));
		
		driver.findElement(data_in).click();
		
	}
	
	public void clickDataFinal() {
		
		driver.findElement(data_final).click();
		
		WebDriverWait wait = new WebDriverWait(this.driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(data_fi));
		
		driver.findElement(data_fi).click();
		
	}
	
	public void clickPassageiro() {
			
		driver.findElement(num_passag).click();
		
		driver.findElement(num_adulto).click();
		
	}
	
	public void clickProcure() {
		
		driver.findElement(btn_procure_voo).click();
		
	}

}