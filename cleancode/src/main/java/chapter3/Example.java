package chapter3;

/**
 * Created by kamil on 2017-09-05.
 */
public class Example {

    //maksymalnie dwa poziomy wcięć w funkcji
    //funkcje powinny wykonywać tylko jedną operację i powinny robić to dobrze!
    public static String renderPageWithSetupsAndTearDowns(PageData pageData, boolean isSuite) throws Exception{
        if(isTestPage(isSuite)){
            includeSetupAndTeardownPages(pageData, isSuite);
        }
        return pageData.getHtml();
    }
    /*
    mimo że funkcja pozornie wykonuje 3 operacje:
    1. sprawdzenie czy strona nie jest testowa
    2. jeżeli tak to dołączenie stron konfiguracyjnych i rozbioru
    3. wygenerowanie strony w html

    to te trzy kroki znajdują się o jeden poziom abstrakcji niżej niż zadeklarowano w nazwie funkcji
    można ją zdefiniować za pomocą dokumentacyjnego słowa kluczowego OTO:

    Oto funkcja renderPageWithSetupsAndTearDowns, sprawdzamy w niej czy strona jest testową i jeżeli
    tak to dołączamy konfigurację i rozbiór. W każdym przypadku generujemy kod html

     */

    private static void includeSetupAndTeardownPages(PageData pageData, boolean isSuite) {

    }

    private static boolean isTestPage(boolean isSuite) {
        return false;
    }
}
