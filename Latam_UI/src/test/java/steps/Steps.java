package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.MainPage;

public class Steps {

	private WebDriver driver;
	private MainPage mainpage;

	@Dado("que esteja na tela inicial do site")
	public void que_esteja_na_tela_inicial_do_site() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.latam.com/pt_br/");
	}
	
	@Quando("informar uma {string} válida")
	public void informar_uma_válida(String origem) {
		
		mainpage = new MainPage(driver);
		
		WebDriverWait wait = new WebDriverWait(this.driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("compra-select-origin")));
		
		mainpage.escreverOrigem(origem);

	}

	@E("inserir um {string} válido")
	public void inserir_um__destino_válido(String destino) {

		mainpage.escreverDestino(destino);

	}

	@E("uma data de ida válida")
	public void uma_data_de_ida_válida() {
		
		mainpage.clickDataInicial();

	}

	@E("uma data de volta válida")
	public void uma_data_de_volta_válida() {
		
		mainpage.clickDataFinal();

	}

	@E("o número de passageiros válido")
	public void o_número_de_passageiros_válido() {
		
        mainpage.clickPassageiro();

	}

	@E("clicar em Procure seu voo")
	public void clicar_em_Procure_seu_voo() {

		mainpage.clickProcure();

	}

	@Então("a tela com as opções de passagens será exibida")
	public void a_tela_com_as_opções_de_passagens_será_exibida() {
		
		String searchTitle = driver.findElement(By.cssSelector(".trip-dates")).getText();
		Assert.assertEquals(searchTitle, "27 de julho a 10 de agosto de 2020");

	}

	@After(order = 1)
	public void screenshot(Scenario cenario) {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/" + cenario.getId() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@After(order = 0)
	public void fecharBrowser() {

		driver.quit();

	}
}
