package selenium.automated.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class DevToTests {

    WebDriver driver; //inicjalizacja drivera - pustej przeglądarki

    @Before
    public void SetUp(){ //pre-requirements - warunki początkowe
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe"); //ścieżka do chromedriver
        driver = new ChromeDriver(); // nadpisanie drivera, jako przeglądarkę chrome
    }

    @Test
    public void OpenDevTo(){
        String url = "https://dev.to/";  //zapisujemy w zmiennej url, wartość linku, który ma zostać otworzony w przeglądarce
        driver.get(url); //otworzenie linku w przeglądarce

        //na ten moment, mamy otworzną stronę dev.to - żeby sprawdzić, czy faktycznie na niej jesteśmy,
        // chcemy porównać url ze zmiennej wcześniejszej do obecnego url z przeglądarki

        String currentUrl = driver.getCurrentUrl(); //wyciągamy obecny url z przeglądarki i przypisujemy go do zmiennej currentUrl

        //assertTrue - sprawdza poprawność warunku url.equals(currentUrl) - czy url ze zmiennej url jest taki sam jak w zmiennej currentUrl
        //jeśli nie - wypisuje message "The current url isn't dev.to", i ustawia test na fail

        assertTrue("The current url isn't dev.to",url.equals(currentUrl));

    }
}
