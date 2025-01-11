package NazwanyPakiet;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static ArrayList<Products> object = new ArrayList<Products>();
    static Scanner scanner = new Scanner(System.in);

    public static void showMenu(){
        System.out.println("--------------------------------------------\n");
        System.out.println(">Stan konta: " + Products.getIncome() + " PLN<\n");
        System.out.println("Wybierz opcję którą chcesz wykonać");
        System.out.println("1. Dodawanie nowego obiektu (zestaw pól do wypełnienia zależny od wybranego podtypu).");
        System.out.println("2. Usuwanie obiektu o podanym identyfikatorze.");
        System.out.println("3. Wyświetlanie wszystkich zapamiętanych obiektów (komplet informacji o każdym z nich)");
        System.out.println("4. Wyświetlanie obiektów danego podtypu.");
        System.out.println("5. Wyświetlanie obiektów, których nazwa zawiera podany ciąg znaków.");
        System.out.println("6. Sprzedaj produkt");
        System.out.println("7. Sprawdź które produkty przeterminują się za zadaną liczbę dni");
        System.out.println("8. Wyjście z aplikacji");

    }//

    public static void showShortMenu(){
        System.out.println("--------------------------------------------\n");
        System.out.println(">Stan konta: " + Products.getIncome() + " PLN<\n");
        System.out.println("Wybierz opcję którą chcesz wykonać");
        System.out.println("1. Dodawanie nowego obiektu (zestaw pól do wypełnienia zależny od wybranego podtypu).");
        System.out.println("8. Wyjście z aplikacji");

    }//

    public static int insertInt(String mainText, String somethingIsNotOk ){

        System.out.println(mainText);
        while (true) {
            try {
                int number =  Integer.parseInt(scanner.nextLine());
                if ( number >= 0){
                    return number;
                }
                System.out.println(somethingIsNotOk);

            } catch (NumberFormatException e) {
                System.out.println(somethingIsNotOk);
            }
        }
    }//

    public static int insertIntWithMinus(String mainText, String somethingIsNotOk ){

        System.out.println(mainText);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(somethingIsNotOk);
            }
        }
    }//

    public static float insertFloat(String mainText, String somethingIsNotOk ){//
        System.out.println(mainText);
        while (true) {
            try {
                float number = Float.parseFloat(scanner.nextLine());
                if ( number > 0){
                    return number;
                }
                System.out.println(somethingIsNotOk);
            } catch (NumberFormatException e) {
                System.out.println(somethingIsNotOk);
            }
        }
    }//

    public static boolean insertboolean(String mainText, String somethingIsNotOk ){
        System.out.println(mainText);
        while (true) {
            try {
                String option = scanner.nextLine().toLowerCase();
                if(option.equals("true")||option.equals("1")){
                    return true;
                } else if (option.equals("false")||option.equals("0")) {
                    return false;
                }
                System.out.println(somethingIsNotOk);

            } catch (NumberFormatException e) {
                System.out.println(somethingIsNotOk);
            }
        }
    }//

    public static String insertString(String mainText){
        String name = "";
        while (name.isEmpty()) {
            System.out.println(mainText);
            name = scanner.nextLine();
            if(name.isEmpty()){
                System.out.println("nazwa nie może być pusta.");
            }

        }

        return name;
    }

    public static void addObject(){

        System.out.println("jaki typ obiektu dodajesz?");
        Products.possibleProducts();

        while (true) {
            String option = scanner.nextLine();
            switch(option){
                case "1": addDiary(); return;
                case "2": addVegetable(); return;
                case "3": addGardenTool(); return;
                case "4": addSeed(); return;
                default:
                    System.out.println("To nie jest poprawna opcja. Wybierz któryś z poniższych typów:");
                    Products.possibleProducts();
                    break;

            }
        }
    }//

    public static void addDiary(){

        String name = insertString("Podaj nazwę produktu mlecznego");
        float value = insertFloat("Podaj cenę sprzedaży produktu","Błędne dane, wpisz poprawnie cenę sprzedaży");
        int daysToExpiration = insertInt("Podaj liczbę dni, jaką ten produkt będzie jeszcze ważny do spożycia","Błędne dane, wpisz poprawnie liczbę dni");
        int requiredTempOfStorage = insertIntWithMinus("Podaj maksymalną wymaganą temperaturę w której produkt może być przechowywany","To nie jest poprawna temperatura, wpisz ponownie");

        object.add(new DiaryFood(name,value,daysToExpiration,requiredTempOfStorage));

    }//

    public static void addVegetable(){
        String name = insertString("Podaj nazwę warzywa");
        float value = insertFloat("Podaj cenę sprzedaży warzywa za kilogram", "Niepoprawna wartość, podaj cenę za kg poprawnie");
        int daysToExpiration = insertInt("Podaj liczbę dni, jaką ten produkt będzie jeszcze ważny do spożycia","Niepoprawna wartość. Podaj poprawną liczbę dni");
        float weight = insertFloat("Podaj wagę produktu w kilogramach","Niepoprawna wartość. Podaj poprawną wagę w kg");

        object.add(new Vegetable(name,value,daysToExpiration,weight));
    }//

    public static void addGardenTool(){

        String name = insertString("Podaj nazwę narzędzia");
        float value = insertFloat("Podaj cenę sprzedaży narzędzia","Niepoprawna cena. Wpisz ponownie");
        boolean isFromPoland = insertboolean("Podaj czy narzędzie wyprodukowano w polsce (true lub false)","błędna wartość. wpisz \"true\" lub \"false\"");
        float length = insertFloat("Podaj długość w cm","Błędne dane. Wpisz poprawną liczbę");
        float wide = insertFloat("Podaj szerokość w cm","Błędne dane. Wpisz poprawną liczbę");
        float height = insertFloat("Podaj wysokość w cm","Błędne dane. Wpisz poprawną liczbę");

        object.add(new GardenTool(name,value,isFromPoland,length,wide,height));
    }//

    public static void addSeed(){

        String name = insertString("Podaj nazwę nasion");
        float value = insertFloat("Podaj cenę sprzedaży nasion za paczkę","Błędna cena. Wpisz poprawną wartość");
        boolean isFromPoland = insertboolean("Podaj czy nasiona wyprodukowano w polsce (true lub false)","Błędny typ. Wpisz \"true\" lub \"false\"");
        float weightInPackage = insertFloat("Podaj wagę produktu w paczce w kg","Błędna waga, wpisz poprawnie dane");

        object.add(new Seed(name,value,isFromPoland,weightInPackage));

    }//

    public static void removeObject(){

        System.out.println("Lista dostępnych produktów:");
        displayAllObject();

        int option = insertInt(" Wpisz Id produktu który chcesz usunąć z listy. Wpisz 0 aby anulować usuwanie","Błędna dana liczbowa. Wpisz poprawnie");

        for(Products x: object) {
            if(x.getId() == option) {
                object.remove(x);
                System.out.println("Usunięto obiekt " + option);
                return;
            }
        }

        if (option == 0){
            System.out.println("Powrót do menu głównego");
            return;
        }
        System.out.println("Obiekt nie został usunięty, nie ma obiektu o podanym numerze Id");
        removeObject();
    }

    public static void displayAllObject(){

        for(Products x: object) {
            System.out.println(x);
        }
    }

    public static void displayObject(){

        System.out.println("Jaki typ obiektu chcesz wyświetlić?");
        System.out.println("1. Spożywczy Mleczny");
        System.out.println("2. Warzywo");
        System.out.println("3. Narzędzie ogrodnicze");
        System.out.println("4. Nasiona");
        System.out.println("5. Jadalne produkty");
        System.out.println("6. Niejadalne produkty");
        System.out.println("7. Wszystkie produkty");

        boolean isThisOptionInShop = false;

        boolean isOptionOk = true;
        String option = scanner.nextLine();

        for (Products x : object) {
            switch (option) {
                case "1":
                    if (x instanceof DiaryFood) {
                        System.out.println(x);
                        isThisOptionInShop = true;
                    }
                    break;

                case "2":
                    if (x instanceof Vegetable) {
                        System.out.println(x);
                        isThisOptionInShop = true;
                    }
                    break;

                case "3":
                    if (x instanceof GardenTool) {
                        System.out.println(x);
                        isThisOptionInShop = true;
                    }
                    break;

                case "4":
                    if (x instanceof Seed) {
                        System.out.println(x);
                        isThisOptionInShop = true;
                    }
                    break;

                case "5":
                    if (x instanceof Eatable) {
                        System.out.println(x);
                        isThisOptionInShop = true;
                    }
                    break;

                case "6":
                    if (x instanceof NonEatable) {
                        System.out.println(x);
                        isThisOptionInShop = true;
                    }
                    break;

                case "7":
                    displayAllObject();
                    return;

                default:
                    isOptionOk = false;
                    isThisOptionInShop = true;
                    break;
            }
        }

        if(!isOptionOk){
            System.out.println("Wybrano niewłaściwą wartość. Spróbuj ponownie");
            displayObject();
        }

        if(!isThisOptionInShop){
            System.out.println("Nie ma tej opcji w sklepie");
        }

    }

    public static void displayObjectWithText(){
        System.out.println("Podaj wzorzec tekstu do odnalezienia w nazwach produktów");
        String searchedText = scanner.nextLine();
        Pattern pattern = Pattern.compile(searchedText);
        boolean isFound = false;

        for (Products x : object) {
            Matcher matcher = pattern.matcher(x.getName());
            boolean matchFound = matcher.find();
            if (matchFound) {
                System.out.println(x);
                isFound = true;
            }
        }
        if (!isFound){
            System.out.println("Wzorca nie odnaleziono");
        }
    }

    public static void sellProduct(){
        System.out.println("Dostępne produkty:");
        displayAllObject();
        int option = insertInt("Produkt o którym numerze ID chcesz sprzedać?", "Błędna liczba. Wpisz ponownie");

        boolean isOk = false;

        for(Products x: object) {
            if(x.getId() == option) {
                x.sell();
                object.remove(x);
                System.out.println("Sprzedano produkt");
                isOk = true;
                break;
            }
        }

        if(!isOk) {
            System.out.println("Produktu o Id " + option + " nie ma w sklepie. Wybierz ponownie produkt z poniższej listy");
            sellProduct();
        }
    }

    public static void whichProductWillBeNotOk(){

        int days = insertInt("Podaj liczbę dni, aby sprawdzić, które produkty przeterminują się za X dni","Wpisano niewłaściwe dane. Wpisz ponownie liczbę");
        boolean isProduct = false;

        for(Products x: object) {

            if(x instanceof DiaryFood || x instanceof Vegetable){
                if(((Eatable) x).willItBeNonEatableAfterXdays(days)){
                    if(!isProduct){
                        System.out.println("Te produkty przeterminują się po " + days + " dniach:");
                    }
                    System.out.println(x);
                    isProduct = true;
                }
            }
        }
        if(!isProduct){
            System.out.println("Nie na takich produktów, które przeterminowałyby się za "+ days + " dni");
        }

    }

    public static boolean menuOption2(){

        showMenu();
        String option = scanner.nextLine();

        System.out.println("-------------------------");
        switch(option) {
            case "1": addObject();break;
            case "2": removeObject();break;
            case "3": displayAllObject();break;
            case "4": displayObject();break;
            case "5": displayObjectWithText();break;
            case "6": sellProduct();break;
            case "7": whichProductWillBeNotOk();break;
            case "8": return false;
            default:
                System.out.println("Zła opcja");
                return true;
        }
        return true;
    }

    public static boolean menuOption1() {
        showShortMenu();
        String option = scanner.nextLine();
        System.out.println("-------------------------");
        switch (option) {
            case "1":
                addObject();
                break;
            case "8":
                return false;
            default:
                System.out.println("Zła opcja");
        }
    return true;
    }


    public static void main(String[] args) {
        boolean isRunning = true;
        while(isRunning) {
            if (object.isEmpty()) {
                isRunning = menuOption1();
            } else {
                isRunning = menuOption2();
            }
        }
    }

}