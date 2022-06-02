import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class WebTest {
    //Test case:
    //1. Open page http://www.99-bottles-of-beer.net
    //2. Click menu button Browse languages;
    //3. Click menu button Start
    //4. Confirm that user can see heading "Welcome to 99 Bottles of Beer"
    //5. Close browser

    @Test
    public void testMenuStartTitle() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        //Thread.sleep(2000);

        WebElement menuBrowserLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li[@class='sel']/a")
        );
        menuBrowserLanguages.click();
        //Thread.sleep(2000);

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );
        menuStart.click();

        WebElement h2 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h2")
        );
        String actualResult = h2.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
        ;
    }

    //TC_11_01
    //Confirm that user can see heading "99 Bottles of Beer" on the top right corner of the base page
    //Steps
    //1. Open the base page of the website http://www.99-bottles-of-beer.net
    //2. Read the heading on the top right corner
    //3. Confirm that the text of the heading matches the expected text
    //4. Close browser

    @Test
    public void testHeadingOnTopRight() {

        String chromeDriver = "webdriver.chrome.driver";
        String pathDriver = "C:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver, pathDriver);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement h2Top = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='header']/h1")
        );
        String actualResult = h2Top.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //TC_11_02
    // Подтвердите, что на странице по базовой ссылке последний пункт меню называется Submit new Language
    //Шаги:
    //1. Открыть вебсайт на базовой странице
    //2. Считать название последнего пункта меню
    //3. Подтвердить, что название последнего пункта меню соответствует ожидаемому
    //4. Закрыть браузер

    @Test
    public void testMenuSubmit() {

        String chromeDriver = "webdriver.chrome.driver";
        String pathDriver = "C:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net";
        String expectedResult = "Submit new Language";

        System.setProperty(chromeDriver, pathDriver);

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuSubmit = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );
        String actualResult = menuSubmit.getText();

        Assert.assertEquals(actualResult, expectedResult.toUpperCase());

        driver.quit();
    }

    /*TC_11_03 Подтвердите, что на странице по базовой ссылке последний пункт меню имеет подзаголовок Submit new Language
    Шаги:
    1. Открыть вебсайт на базовой странице
    2. Нажать на пункт меню Submit New Language
    3. Считать название подзаголовка последнего пункта меню
    4. Подтвердить, что название подзаголовка последнего пункта меню соответствует ожидаемому
    5. Закрыть браузер
    */
    @Test
    public void testSubHeadingSubmitNewLanguage() {

        String chromedriver = "webdriver.chrome.driver";
        String pathdriver = "C:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net";
        String expectedResult = "Submit New Language";

        System.setProperty(chromedriver, pathdriver);

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuSubmit = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/" +
                        "ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );
        menuSubmit.click();

        WebElement subHead = driver.findElement(
                By.xpath("//*[@id='submenu']/li/a")
        );

        String actualResult = subHead.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

        /*TC_11_04 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/abc.html , первый пункт
         подменю называется 0-9

        Шаги:
        1. Открыть вебсайт на странице
        2. Считать название первого подзаголовка
        3. Подтвердить, что название подменю соответствует ожидаемому
        4. Закрыть браузер*/

    @Test
    public void testFirstSubmenu() {

        String chromeDriver = "webdriver.chrome.driver";
        String pathDriver = "C:/chromedriver.exe";
        String urlABC = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResult = "0-9";

        System.setProperty(chromeDriver, pathDriver);

        WebDriver driver = new ChromeDriver();

        driver.get(urlABC);

        WebElement firstSubmenu = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='0.html']")
        );
        String actualResult = firstSubmenu.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }
    /*TC_11_06 Подтвердите, что имена создателей сайта:
    Oliver Schade
    Gregor Scheithauer
    Stefan Scheler*/

    @Test
    public void testNamesOfAuthers() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/chromedriver.exe";
        String urlTeam = "http://www.99-bottles-of-beer.net/team.html";
        String[] expectedResult = {"Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"};

        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(urlTeam);

        //String[] actualresult = new String[3];

        WebElement oliver = driver.findElement(By.xpath("//*[@id='main']/h3[1]"));
        String actualnameOne = oliver.getText();

        WebElement gregor = driver.findElement(By.xpath("//*[@id='main']/h3[2]"));
        String actualNameTwo = gregor.getText();

        WebElement stefan = driver.findElement(By.xpath("//*[@id='main']/h3[3]"));
        String actualNameThree = stefan.getText();

        String[] actualresult = {actualnameOne, actualNameTwo, actualNameThree};

        Assert.assertEquals(actualresult, expectedResult);

        driver.quit();

    }
    /*TC_11_11 Подтвердите, что если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
     пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях, будет показана ошибка

    Error: Precondition failed - Incomplete Input.

    Шаги:
    1. Открыть вебсайт на странице
    2. Нажать на кнопку Submit Language
    3. Подтвердить, что на странице показана ошибка
    4. Подтвердить, что текст ошибки соответствует ожидаемому
    5. Закрыть браузер
*/
    @Test
    public void testButtonSubmitLanguageWhenEmptyInput(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/chromedriver.exe";
        String urlsnl = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(urlsnl);

        WebElement submitButton = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type='submit']")
        );
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='main']/p"));
        String actualResult = errorMessage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

/*
    TC_11_12 Precondition: Если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
     пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях, будет показана ошибка
     с текстом

    Error: Precondition failed - Incomplete Input.

    Подтвертите, что в тексте ошибки слова Error, Precondition, Incomplete и Input написаны с большой буквы, а слово
    failed  написано  с маленькой буквы.
    Так же подтвердите, что в тексте ошибки содержатся знаки :, -  и .

    Шаги:
    1. Открыть вебсайт на странице
    2. Нажать на кнопку Submit Language
    3. Считать текст ошибки
    4. Подтвердить requirenments
    5. Закрыть браузер
*/
    @Test
    public void testCharactersInErrorMessageVersionOne(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/chromedriver.exe";
        String urlsnl = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult1 = "Error";
        String expectedResult2 = "Precondition";
        String expectedResult3 = "failed";
        String expectedResult4 = "Incomplete";
        String expectedResult5 = "Input.";
        String expectedResult6 = ":";
        String expectedResult7 = "-";
        String expectedResult8 = ".";


        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(urlsnl);

        WebElement submitButton = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type='submit']")
        );
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='main']/p"));
        String message = errorMessage.getText().trim();

        Assert.assertTrue(message.contains(expectedResult1));
        Assert.assertTrue(message.contains(expectedResult2));
        Assert.assertTrue(message.contains(expectedResult3));
        Assert.assertTrue(message.contains(expectedResult4));
        Assert.assertTrue(message.contains(expectedResult5));
        Assert.assertTrue(message.contains(expectedResult6));
        Assert.assertTrue(message.contains(expectedResult7));
        Assert.assertTrue(message.contains(expectedResult8));

        driver.quit();
    }
    @Test
    public void testCharactersInErrorMessageVersionTwo(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/chromedriver.exe";
        String urlsnl = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(urlsnl);

        WebElement submitButton = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type='submit']")
        );
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='main']/p"));
        String mess = errorMessage.getText();
        String message = mess.trim().replace(" , ", " ");
        String[] array = message.split(" ");


        for(int i = 0; i < array.length; i++ ){
            if(array[i].charAt(0) == 'f' || array[i].charAt(0) == 'F' ) {
                Assert.assertEquals(array[i].charAt(0), Character.toLowerCase(array[i].charAt(0)));
            } else {
                Assert.assertEquals(array[i].charAt(0),Character.toUpperCase(array[i].charAt(0)));
            }

        }
        Assert.assertTrue(mess.contains(":"));
        Assert.assertTrue(mess.contains("-"));
        Assert.assertTrue(mess.contains("."));

        driver.quit();
    }

    @Test
    public void testCharactersInErrorMessageVersionThree(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/chromedriver.exe";
        String urlsnl = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        char expectedResult1 = "Error".charAt(0);
        char expectedResult2 = "Precondition".charAt(0);
        char expectedResult3 = "failed".charAt(0);
        char expectedResult4 = "Incomplete".charAt(0);
        char expectedResult5 = "Input".charAt(0);
        char expectedResult6 = ':';
        char expectedResult7 = '-';
        char expectedResult8 = '.';


        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(urlsnl);

        WebElement submitButton = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type='submit']")
        );
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='main']/p"));
        String message = errorMessage.getText().trim();

        String[] array = message.split(" ");

        Assert.assertEquals(array[0].charAt(0),expectedResult1);
        Assert.assertEquals(array[1].charAt(0),expectedResult2);
        Assert.assertEquals(array[2].charAt(0),expectedResult3);
        Assert.assertEquals(array[3].charAt(0),expectedResult7);
        Assert.assertEquals(array[4].charAt(0),expectedResult4);
        Assert.assertEquals(array[5].charAt(0),expectedResult5);
        Assert.assertEquals(array[0].charAt(array[0].length()-1),expectedResult6);
        Assert.assertEquals(array[5].charAt(array[5].length()-1),expectedResult8);

        driver.quit();
    }

   /* TC_11_14 Подтвердите, что нажав на пункт меню Browse Languages, пользователь увидит таблицу со следующими
    названиями для первого и второго столбцов:
    Language
    Author

    Шаги:
    1. Открыть вебсайт на базовой странице
    2. Нажать на пункт меню Browse Languages
    3. Считать названия первого и второго столбцов таблицы
    3. Подтвердить, что названия соответствует ожидаемым
    4. Закрыть браузер*/

    @Test
    public void testTableColumns(){

        String chromeDriver = "webdriver.chrome.driver";
        String pathDriver = "C:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResult1 = "Language";
        String expectedResult2 = "Author";

        System.setProperty(chromeDriver, pathDriver);

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLang = driver.findElement(
                By.xpath("//*[@id='menu']/li/a[@href='/abc.html']")
        );
        menuBrowseLang.click();

        WebElement tableFirstRowFirstColumn = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/table[@id='category']/tbody/tr[1]/th[1]")
        );
        String actualResult1 = tableFirstRowFirstColumn.getText();

        WebElement tableFirstRowSecondColumn = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/table[@id='category']/tbody/tr[1]/th[2]")
        );
        String actualResult2 = tableFirstRowSecondColumn.getText();

        Assert.assertEquals(actualResult1,expectedResult1);
        Assert.assertEquals(actualResult2,expectedResult2);

        driver.quit();
    }

    /*TC_11_15 Подтвердите, что на странице по базовой ссылке  пользователь НЕ увидит новые комментарии,
     если нажмет на пункты меню Top List → New Comments*/

    @Test
    public void testNewCommentstext(){

        String chromeDriver = "webdriver.chrome.driver";
        String pathDriver = "C:/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResult = "";

        System.setProperty(chromeDriver, pathDriver);

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuTopList = driver.findElement(
                By.xpath("//*[@id='menu']/li[4]/a")
        );
        menuTopList.click();

        WebElement menuNewComments = driver.findElement(
                By.xpath("//*[@id='submenu']/li[7]/a[@href='./newcomments.html']")
        );
        menuNewComments.click();

        WebElement textNewComment = driver.findElement(
                By.xpath("//*[@id='main']/p")
        );
        String actualResult = textNewComment.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }
    /*TC_11_21 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html
    пользователь видит предупреждение IMPORTANT:, написанное белыми буквами bold шрифтом на красном фоне, и что
    все буквы - capital

    Шаги:
    1. Открыть вебсайт на странице
    2. Считать слово IMPORTANT: из списка
    3. Подтвердить requirements
    4. Закрыть браузер*/

    @Test
    public void testImportantWord(){

        String chromeDriver = "webdriver.chrome.driver";
        String pathDriver = "C:/chromedriver.exe";
        String urlSNL = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResultText = "IMPORTANT:";
        String expectedResultStyle = "background-color: red; color: white;";
        String expectedResultTag = "b";


        System.setProperty(chromeDriver, pathDriver);

        WebDriver driver = new ChromeDriver();

        driver.get(urlSNL);

        WebElement wordImportantStyle = driver.findElement(By.xpath("//*[@id='main']/ul/li[1]/span"));
        String actualResultStyle = wordImportantStyle.getAttribute("style");

        WebElement wordImportant = driver.findElement(By.xpath("//*[@id='main']/ul/li[1]/span/b"));
        String actualResultText = wordImportant.getText();

        String actualResultTag = wordImportant.getTagName();

        Assert.assertEquals(actualResultText, expectedResultText);
        Assert.assertEquals(actualResultStyle, expectedResultStyle);
        Assert.assertEquals(actualResultTag,expectedResultTag);

        driver.quit();
    }

    @Test
    public void testLyricText() throws InterruptedException {
        //TC
        //1.Open base url http://www.99-bottles-of-beer.net/
        //2.Click on menu Song Lyrics
        //3.Read the text of the song
        //4.Verify that the text matches the expected text

        String chromeDriver = "webdriver.chrome.driver";
        String pathDriver = "C:/chromedriver.exe";



        String expectedResult = "99 bottles of beer on the wall, 99 bottles of beer.\n" +
                "Take one down and pass it around, 98 bottles of beer on the wall.98 bottles of beer on the wall, 98 bottles of beer.\n" +
                "Take one down and pass it around, 97 bottles of beer on the wall.97 bottles of beer on the wall, 97 bottles of beer.\n" +
                "Take one down and pass it around, 96 bottles of beer on the wall.96 bottles of beer on the wall, 96 bottles of beer.\n" +
                "Take one down and pass it around, 95 bottles of beer on the wall.95 bottles of beer on the wall, 95 bottles of beer.\n" +
                "Take one down and pass it around, 94 bottles of beer on the wall.94 bottles of beer on the wall, 94 bottles of beer.\n" +
                "Take one down and pass it around, 93 bottles of beer on the wall.93 bottles of beer on the wall, 93 bottles of beer.\n" +
                "Take one down and pass it around, 92 bottles of beer on the wall.92 bottles of beer on the wall, 92 bottles of beer.\n" +
                "Take one down and pass it around, 91 bottles of beer on the wall.91 bottles of beer on the wall, 91 bottles of beer.\n" +
                "Take one down and pass it around, 90 bottles of beer on the wall.90 bottles of beer on the wall, 90 bottles of beer.\n" +
                "Take one down and pass it around, 89 bottles of beer on the wall.89 bottles of beer on the wall, 89 bottles of beer.\n" +
                "Take one down and pass it around, 88 bottles of beer on the wall.88 bottles of beer on the wall, 88 bottles of beer.\n" +
                "Take one down and pass it around, 87 bottles of beer on the wall.87 bottles of beer on the wall, 87 bottles of beer.\n" +
                "Take one down and pass it around, 86 bottles of beer on the wall.86 bottles of beer on the wall, 86 bottles of beer.\n" +
                "Take one down and pass it around, 85 bottles of beer on the wall.85 bottles of beer on the wall, 85 bottles of beer.\n" +
                "Take one down and pass it around, 84 bottles of beer on the wall.84 bottles of beer on the wall, 84 bottles of beer.\n" +
                "Take one down and pass it around, 83 bottles of beer on the wall.83 bottles of beer on the wall, 83 bottles of beer.\n" +
                "Take one down and pass it around, 82 bottles of beer on the wall.82 bottles of beer on the wall, 82 bottles of beer.\n" +
                "Take one down and pass it around, 81 bottles of beer on the wall.81 bottles of beer on the wall, 81 bottles of beer.\n" +
                "Take one down and pass it around, 80 bottles of beer on the wall.80 bottles of beer on the wall, 80 bottles of beer.\n" +
                "Take one down and pass it around, 79 bottles of beer on the wall.79 bottles of beer on the wall, 79 bottles of beer.\n" +
                "Take one down and pass it around, 78 bottles of beer on the wall.78 bottles of beer on the wall, 78 bottles of beer.\n" +
                "Take one down and pass it around, 77 bottles of beer on the wall.77 bottles of beer on the wall, 77 bottles of beer.\n" +
                "Take one down and pass it around, 76 bottles of beer on the wall.76 bottles of beer on the wall, 76 bottles of beer.\n" +
                "Take one down and pass it around, 75 bottles of beer on the wall.75 bottles of beer on the wall, 75 bottles of beer.\n" +
                "Take one down and pass it around, 74 bottles of beer on the wall.74 bottles of beer on the wall, 74 bottles of beer.\n" +
                "Take one down and pass it around, 73 bottles of beer on the wall.73 bottles of beer on the wall, 73 bottles of beer.\n" +
                "Take one down and pass it around, 72 bottles of beer on the wall.72 bottles of beer on the wall, 72 bottles of beer.\n" +
                "Take one down and pass it around, 71 bottles of beer on the wall.71 bottles of beer on the wall, 71 bottles of beer.\n" +
                "Take one down and pass it around, 70 bottles of beer on the wall.70 bottles of beer on the wall, 70 bottles of beer.\n" +
                "Take one down and pass it around, 69 bottles of beer on the wall.69 bottles of beer on the wall, 69 bottles of beer.\n" +
                "Take one down and pass it around, 68 bottles of beer on the wall.68 bottles of beer on the wall, 68 bottles of beer.\n" +
                "Take one down and pass it around, 67 bottles of beer on the wall.67 bottles of beer on the wall, 67 bottles of beer.\n" +
                "Take one down and pass it around, 66 bottles of beer on the wall.66 bottles of beer on the wall, 66 bottles of beer.\n" +
                "Take one down and pass it around, 65 bottles of beer on the wall.65 bottles of beer on the wall, 65 bottles of beer.\n" +
                "Take one down and pass it around, 64 bottles of beer on the wall.64 bottles of beer on the wall, 64 bottles of beer.\n" +
                "Take one down and pass it around, 63 bottles of beer on the wall.63 bottles of beer on the wall, 63 bottles of beer.\n" +
                "Take one down and pass it around, 62 bottles of beer on the wall.62 bottles of beer on the wall, 62 bottles of beer.\n" +
                "Take one down and pass it around, 61 bottles of beer on the wall.61 bottles of beer on the wall, 61 bottles of beer.\n" +
                "Take one down and pass it around, 60 bottles of beer on the wall.60 bottles of beer on the wall, 60 bottles of beer.\n" +
                "Take one down and pass it around, 59 bottles of beer on the wall.59 bottles of beer on the wall, 59 bottles of beer.\n" +
                "Take one down and pass it around, 58 bottles of beer on the wall.58 bottles of beer on the wall, 58 bottles of beer.\n" +
                "Take one down and pass it around, 57 bottles of beer on the wall.57 bottles of beer on the wall, 57 bottles of beer.\n" +
                "Take one down and pass it around, 56 bottles of beer on the wall.56 bottles of beer on the wall, 56 bottles of beer.\n" +
                "Take one down and pass it around, 55 bottles of beer on the wall.55 bottles of beer on the wall, 55 bottles of beer.\n" +
                "Take one down and pass it around, 54 bottles of beer on the wall.54 bottles of beer on the wall, 54 bottles of beer.\n" +
                "Take one down and pass it around, 53 bottles of beer on the wall.53 bottles of beer on the wall, 53 bottles of beer.\n" +
                "Take one down and pass it around, 52 bottles of beer on the wall.52 bottles of beer on the wall, 52 bottles of beer.\n" +
                "Take one down and pass it around, 51 bottles of beer on the wall.51 bottles of beer on the wall, 51 bottles of beer.\n" +
                "Take one down and pass it around, 50 bottles of beer on the wall.50 bottles of beer on the wall, 50 bottles of beer.\n" +
                "Take one down and pass it around, 49 bottles of beer on the wall.49 bottles of beer on the wall, 49 bottles of beer.\n" +
                "Take one down and pass it around, 48 bottles of beer on the wall.48 bottles of beer on the wall, 48 bottles of beer.\n" +
                "Take one down and pass it around, 47 bottles of beer on the wall.47 bottles of beer on the wall, 47 bottles of beer.\n" +
                "Take one down and pass it around, 46 bottles of beer on the wall.46 bottles of beer on the wall, 46 bottles of beer.\n" +
                "Take one down and pass it around, 45 bottles of beer on the wall.45 bottles of beer on the wall, 45 bottles of beer.\n" +
                "Take one down and pass it around, 44 bottles of beer on the wall.44 bottles of beer on the wall, 44 bottles of beer.\n" +
                "Take one down and pass it around, 43 bottles of beer on the wall.43 bottles of beer on the wall, 43 bottles of beer.\n" +
                "Take one down and pass it around, 42 bottles of beer on the wall.42 bottles of beer on the wall, 42 bottles of beer.\n" +
                "Take one down and pass it around, 41 bottles of beer on the wall.41 bottles of beer on the wall, 41 bottles of beer.\n" +
                "Take one down and pass it around, 40 bottles of beer on the wall.40 bottles of beer on the wall, 40 bottles of beer.\n" +
                "Take one down and pass it around, 39 bottles of beer on the wall.39 bottles of beer on the wall, 39 bottles of beer.\n" +
                "Take one down and pass it around, 38 bottles of beer on the wall.38 bottles of beer on the wall, 38 bottles of beer.\n" +
                "Take one down and pass it around, 37 bottles of beer on the wall.37 bottles of beer on the wall, 37 bottles of beer.\n" +
                "Take one down and pass it around, 36 bottles of beer on the wall.36 bottles of beer on the wall, 36 bottles of beer.\n" +
                "Take one down and pass it around, 35 bottles of beer on the wall.35 bottles of beer on the wall, 35 bottles of beer.\n" +
                "Take one down and pass it around, 34 bottles of beer on the wall.34 bottles of beer on the wall, 34 bottles of beer.\n" +
                "Take one down and pass it around, 33 bottles of beer on the wall.33 bottles of beer on the wall, 33 bottles of beer.\n" +
                "Take one down and pass it around, 32 bottles of beer on the wall.32 bottles of beer on the wall, 32 bottles of beer.\n" +
                "Take one down and pass it around, 31 bottles of beer on the wall.31 bottles of beer on the wall, 31 bottles of beer.\n" +
                "Take one down and pass it around, 30 bottles of beer on the wall.30 bottles of beer on the wall, 30 bottles of beer.\n" +
                "Take one down and pass it around, 29 bottles of beer on the wall.29 bottles of beer on the wall, 29 bottles of beer.\n" +
                "Take one down and pass it around, 28 bottles of beer on the wall.28 bottles of beer on the wall, 28 bottles of beer.\n" +
                "Take one down and pass it around, 27 bottles of beer on the wall.27 bottles of beer on the wall, 27 bottles of beer.\n" +
                "Take one down and pass it around, 26 bottles of beer on the wall.26 bottles of beer on the wall, 26 bottles of beer.\n" +
                "Take one down and pass it around, 25 bottles of beer on the wall.25 bottles of beer on the wall, 25 bottles of beer.\n" +
                "Take one down and pass it around, 24 bottles of beer on the wall.24 bottles of beer on the wall, 24 bottles of beer.\n" +
                "Take one down and pass it around, 23 bottles of beer on the wall.23 bottles of beer on the wall, 23 bottles of beer.\n" +
                "Take one down and pass it around, 22 bottles of beer on the wall.22 bottles of beer on the wall, 22 bottles of beer.\n" +
                "Take one down and pass it around, 21 bottles of beer on the wall.21 bottles of beer on the wall, 21 bottles of beer.\n" +
                "Take one down and pass it around, 20 bottles of beer on the wall.20 bottles of beer on the wall, 20 bottles of beer.\n" +
                "Take one down and pass it around, 19 bottles of beer on the wall.19 bottles of beer on the wall, 19 bottles of beer.\n" +
                "Take one down and pass it around, 18 bottles of beer on the wall.18 bottles of beer on the wall, 18 bottles of beer.\n" +
                "Take one down and pass it around, 17 bottles of beer on the wall.17 bottles of beer on the wall, 17 bottles of beer.\n" +
                "Take one down and pass it around, 16 bottles of beer on the wall.16 bottles of beer on the wall, 16 bottles of beer.\n" +
                "Take one down and pass it around, 15 bottles of beer on the wall.15 bottles of beer on the wall, 15 bottles of beer.\n" +
                "Take one down and pass it around, 14 bottles of beer on the wall.14 bottles of beer on the wall, 14 bottles of beer.\n" +
                "Take one down and pass it around, 13 bottles of beer on the wall.13 bottles of beer on the wall, 13 bottles of beer.\n" +
                "Take one down and pass it around, 12 bottles of beer on the wall.12 bottles of beer on the wall, 12 bottles of beer.\n" +
                "Take one down and pass it around, 11 bottles of beer on the wall.11 bottles of beer on the wall, 11 bottles of beer.\n" +
                "Take one down and pass it around, 10 bottles of beer on the wall.10 bottles of beer on the wall, 10 bottles of beer.\n" +
                "Take one down and pass it around, 9 bottles of beer on the wall.9 bottles of beer on the wall, 9 bottles of beer.\n" +
                "Take one down and pass it around, 8 bottles of beer on the wall.8 bottles of beer on the wall, 8 bottles of beer.\n" +
                "Take one down and pass it around, 7 bottles of beer on the wall.7 bottles of beer on the wall, 7 bottles of beer.\n" +
                "Take one down and pass it around, 6 bottles of beer on the wall.6 bottles of beer on the wall, 6 bottles of beer.\n" +
                "Take one down and pass it around, 5 bottles of beer on the wall.5 bottles of beer on the wall, 5 bottles of beer.\n" +
                "Take one down and pass it around, 4 bottles of beer on the wall.4 bottles of beer on the wall, 4 bottles of beer.\n" +
                "Take one down and pass it around, 3 bottles of beer on the wall.3 bottles of beer on the wall, 3 bottles of beer.\n" +
                "Take one down and pass it around, 2 bottles of beer on the wall.2 bottles of beer on the wall, 2 bottles of beer.\n" +
                "Take one down and pass it around, 1 bottle of beer on the wall.1 bottle of beer on the wall, 1 bottle of beer.\n" +
                "Take one down and pass it around, no more bottles of beer on the wall.No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.";

        System.setProperty(chromeDriver, pathDriver);

        WebDriver driver = new ChromeDriver();


        driver.get("http://www.99-bottles-of-beer.net/");

        driver.findElement(
                        By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='lyrics.html']"))
                .click();

        /*WebElement[] elementArray = new WebElement[100];//
        for(int i =0; i < elementArray.length; i++){
            int index = i + 1;
            elementArray[i] = getDriver().findElement(
                    By.xpath("//body/div[@id='wrap']/div[@id='main']/p[" + index + "]"));
        }*/


        String[] pText = new String[100];
        for(int i =0; i < pText.length; i++){
            int index = i + 1;
            pText[i] = driver.findElement(
                    By.xpath("//body/div[@id='wrap']/div[@id='main']/p[" + index + "]")).getText();
        }


        String actualResult = "";
        for(int i = 0; i < pText.length; i++){
            actualResult += pText[i];
        }
        //System.out.println(actualResult);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }



        @Test
        public void testLastLanguage() {
            /**
             * Подтвердите, что в меню BROWSE LANGUAGES, подменю  M, последний программный язык в таблице -  MySQL
             * */
            String chromeDriver = "webdriver.chrome.driver";
            String pathDriver = "C:/chromedriver.exe";
            String expectedResult = "MySQL";

            System.setProperty(chromeDriver, pathDriver);
            WebDriver driver = new ChromeDriver();

            driver.get("http://www.99-bottles-of-beer.net");

            driver.findElement(By.xpath("//li/a[@href='/abc.html']")).click();
            driver.findElement(By.xpath("//a[@href='m.html']")).click();
            WebElement text = driver.findElement(By.xpath("//tr[last()]/td/a"));
            String actualResult = text.getText();

            Assert.assertEquals(actualResult, expectedResult);

            driver.quit();
        }

    /*    TC_12_03 Подтвердите, что в меню BROWSE LANGUAGES существует таблица с заголовками Language, Author, Date,
       Comments, Rate
*/
    @Test
    public void testTableTreadInBrowselanguge(){

        String chromeDriver = "webdriver.chrome.driver";
        String pathDriver = "C:/chromedriver.exe";
        String[] expectedResult = {"Language", "Author", "Date", "Comments", "Rate"};

        System.setProperty(chromeDriver, pathDriver);
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.99-bottles-of-beer.net");

        driver.findElement(By.xpath("//li/a[@href='/abc.html']")).click();

        String[] actualResult = new String[5];
        for(int i = 0; i < actualResult.length; i++){
            int index = i+1;
            actualResult[i] = driver.findElement(By.xpath("//table[@id='category']/tbody/tr/th[" + index + "]")).getText();
        }
        //System.out.println(Arrays.toString(actualResult));

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }
   /* TC_12_04 Подтвердите, что создатель решения на языке Mathematica - Brenton Bostick, дата обновления решения на
    этом языке - 03/16/06, и что это решение имеет 1 комментарий
*/

    @Test
    public void testLanguageMathematicaInfo() {

        String chromeDriver = "webdriver.chrome.driver";
        String pathDriver = "C:/chromedriver.exe";
        String[] expectedResult = {"Mathematica", "Brenton Bostick", "03/16/06", "1"};

        System.setProperty(chromeDriver, pathDriver);
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.99-bottles-of-beer.net");

        driver.findElement(By.xpath("//li/a[@href='/abc.html']")).click();

        driver.findElement(By.xpath("//a[@href='m.html']")).click();

        String[] actualResult = new String[4];
        actualResult[0] = driver.findElement(By.xpath("//a[@href='language-mathematica-1090.html']")).getText();
        for (int i = 1; i < actualResult.length; i++) {
            actualResult[i] = driver.findElement(By.xpath("//a[@href='language-mathematica-1090.html']" +
                    "/ancestor::td/following-sibling::td[" + i + "]")).getText();
        }

        System.out.println(Arrays.toString(actualResult));

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
        @Test
        //TC_12_05 Подтвердите, что на сайте существует 10 языков, названия которых начинаются с цифр.
        public void testLanguagesWithDigitCount(){
            String chromeDriver = "webdriver.chrome.driver";
            String pathDriver = "C:/chromedriver.exe";
            int expectedResult = 10;

            System.setProperty(chromeDriver, pathDriver);
            WebDriver driver = new ChromeDriver();

            driver.get("http://www.99-bottles-of-beer.net");

            driver.findElement(By.xpath("//li/a[@href='/abc.html']")).click();

            driver.findElement(By.xpath("//a[@href='0.html']")).click();

            //count sibling elements
            List<WebElement> rows = driver.findElements(By.xpath("//th[text()='Language']/ancestor::tr/following-sibling::tr"));
            int actualResult = rows.size();

            Assert.assertEquals(actualResult, expectedResult);

            driver.quit();
        }

    /*TC_12_06 Подтвердите, что если на странице Sign Guestbook http://www.99-bottles-of-beer.net/signv2.html вы
    заполните все поля формы, но введете случайно сгенерированное трехзначное число в поле  Security Code: ,
    то вы получите сообщение об ошибке  Error: Error: Invalid security code.
*/
    @Test
    public void testErrorMessageOnSignGuestbook() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String pathDriver = "C:/chromedriver.exe";
        String expectedResult = "Error: Error: Invalid security code.";

        System.setProperty(chromeDriver, pathDriver);

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.99-bottles-of-beer.net/signv2.html");

        driver.findElement(By.xpath("//p/input[@name='name']")).sendKeys("peter");
        driver.findElement(By.xpath("//p/input[@name='location']")).sendKeys("Anywhere");
        driver.findElement(By.xpath("//p/input[@name='email']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//p/input[@name='homepage']")).sendKeys("https//test.com");

        int random = (int) (100 + Math.random() *(1000-100));
        //System.out.println(random);

        driver.findElement(By.xpath("//p/input[@name='captcha']")).sendKeys(String.valueOf(random));
        driver.findElement(By.xpath("//p/textarea[@name='comment']")).sendKeys("message");
        driver.findElement(By.xpath("//p/input[@type='submit']")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='main']/p[contains(., 'Error')]"));
        String actualResult = errorMessage.getText();

        Assert.assertEquals(actualResult,expectedResult);
        driver.quit();
    }



    }




