package apoio;


import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApoioProjetoMantis extends ScreenShots {
	
	private String usuario = "henrique.cervi";
	private String senha = "henrique1234"; 
	
	protected static WebDriver driver = acessoMantis();	
	
	public void acessarMantis () {			
		inserirDados();
		ScreenShots.printDaTela(driver);	
	}

	private void inserirDados() {
		driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[2]/td[2]/input")).sendKeys(usuario);
		driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[3]/td[2]/input")).sendKeys(senha);
		ScreenShots.printDaTela(driver);
		driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[6]/td/input")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static WebDriver acessoMantis() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mantis-prova.base2.com.br/login_page.php");
		driver.manage().window().maximize();
		return driver;
	}
	
	public void alteraProjeto() {
		
		Select select = new Select(driver.findElement(By.name("project_id")));
		select.selectByValue("134");
		ScreenShots.printDaTela(driver);
	}
	
	public void criaReportIssue() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Report Issue")).click();
		Thread.sleep(2000);
		Select category = new Select(driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[2]/td[2]/select")));
		category.selectByValue("1");
		
		Select repro = new Select(driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[3]/td[2]/select")));
		repro.selectByValue("30");
		
		Select profile = new Select(driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[6]/td[2]/select")));
		profile.selectByValue("74");
		
		driver.findElement(By.name("summary")).sendKeys("Criação de Problema Referente Windows 10");
		
		driver.findElement(By.name("description"))
			.sendKeys("Windows 10 instalado sem cortana.");
		
			ScreenShots.printDaTela(driver);		
			Thread.sleep(2000);		
		driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[15]/td[2]/input")).click();			
			ScreenShots.printDaTela(driver);		
	}
	
	public void adicionaFiltros() throws InterruptedException  {
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/a[2]")).click();
			Thread.sleep(2000);
		
		driver.findElement(By.id("reporter_id_filter")).click();
			Thread.sleep(2000);
		Select reporter = new Select(driver.findElement
				(By.xpath("/html/body/div[3]/form/table/tbody/tr[2]/td[1]/select")));
			Thread.sleep(2000);
		reporter.selectByValue("159");
		
			Thread.sleep(1000);
		
		driver.findElement(By.id("per_page_filter")).click();
			Thread.sleep(2000);
		driver.findElement(By.name("per_page")).clear();
		driver.findElement(By.name("per_page")).sendKeys("5");
		driver.findElement(By.name("filter")).click();		
		ScreenShots.printDaTela(driver);
	}
	
	public void incluiNotes() throws InterruptedException {
		
		driver.findElement(By.name("all_bugs")).click();
			Thread.sleep(2000);
		Select addNotes = new Select(driver.findElement
				(By.xpath("/html/body/form/table/tbody/tr[9]/td/span[1]/select")));
			Thread.sleep(2000);
		addNotes.selectByValue("EXT_ADD_NOTE");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[9]/td/span[1]/input[2]")).click();
		
		driver.findElement(By.name("bugnote_text")).sendKeys("Atividade, etapa 2.");
		Select status = new Select (driver.findElement(By.name("view_state")));
			Thread.sleep(1000);
		status.selectByValue("50");
		driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[4]/td/center/input")).click();		
			Thread.sleep(2000);		
			ScreenShots.printDaTela(driver);		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[5]/span/a")).click();		
		Thread.sleep(2000);		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)");	
		ScreenShots.printDaTela(driver);
		
	}
	
	@AfterClass
	public static void closeWindow() throws InterruptedException {
		
		Thread.sleep(1500);		
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/a[1]")).click();		
		Thread.sleep(1500);		
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/a[7]")).click();		
		Thread.sleep(2000);
		ScreenShots.printDaTela(driver);
		driver.close();
	}
	

}
