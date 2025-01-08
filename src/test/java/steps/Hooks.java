package steps;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigExtentReport;
import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    @Before
    public void setUp() {
        System.out.println("Iniciando o WebDriver...");
        WebDriver driver = DriverManager.getDriver();
        driver.get(ConfigReader.getProperty("base.url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();

        if (scenario.isFailed()) {
            System.out.println("Capturando screenshot para o cenário: " + scenario.getName());
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String screenshotName = scenario.getName().replaceAll(" ", "_") + "_" + timestamp + ".png";
            String screenshotPath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + screenshotName;

            try {
                // Criar diretório se necessário
                File screenshotsDir = new File(System.getProperty("user.dir") + File.separator + "screenshots");
                if (!screenshotsDir.exists()) {
                    if (screenshotsDir.mkdirs()) {
                        System.out.println("Diretório 'screenshots' criado com sucesso.");
                    } else {
                        throw new RuntimeException("Não foi possível criar o diretório 'screenshots'.");
                    }
                }
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                File destinationFile = new File(screenshotPath);
                FileUtils.copyFile(screenshot, destinationFile);
                System.out.println("Screenshot salva em: " + screenshotPath);

                byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshotBytes, "image/png", screenshotName);

            } catch (IOException e) {
                System.err.println("Erro ao salvar a screenshot: " + e.getMessage());
            }
        }

        System.out.println("Encerrando o WebDriver...");
        ConfigExtentReport.generateReport(scenario);
        DriverManager.closeDriver();
    }

    @AfterAll
    public static void callGenerateExtentReport() {
        System.out.println("Finalizando e salvando o relatório de Testes...");
        ConfigExtentReport.flushReport();
    }

    public static WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}
