package ee.bcs.java.tasks;


import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Väiksem");
        System.out.println("2 - Suurem");
        System.out.println("3 - Absoluutarv");
        System.out.println("4 - Paarisarv");
        System.out.println("5 - Väiksem kolmest arvust");
        System.out.println("6 - Suurim kolmest arvust");
        System.out.println("7 - Lause");
        int choise = scanner.nextInt();
        if (choise == 1) {
            System.out.println("Sisesta a");
            int a = scanner.nextInt();
            System.out.println("Sisesta b");
            int b = scanner.nextInt();
            System.out.println(min(a, b));
        } else if (choise == 2) {
            System.out.println("Sisesta a");
            int a = scanner.nextInt();
            System.out.println("Sisesta b");
            int b = scanner.nextInt();
            System.out.println(max(a, b));
        } else if (choise == 3) {
            System.out.println("Sisesta arv");
            int a = scanner.nextInt();
            System.out.println("Absoluutarv on: " + abs(-a));
        } else if (choise == 4) {
            System.out.println("Sisesta arv");
            int a = scanner.nextInt();
            System.out.println("Arv on: " + isEven(a % 2));
        } else if (choise == 5) {
            System.out.println("Sisesta a");
            int a = scanner.nextInt();
            System.out.println("Sisesta b");
            int b = scanner.nextInt();
            System.out.println("Sisesta c");
            int c = scanner.nextInt();
            System.out.println("Väiksem kolmest on:  " + min3(a, b, c));
        } else if (choise == 6) {
            System.out.println("Sisesta a");
            int a = scanner.nextInt();
            System.out.println("Sisesta b");
            int b = scanner.nextInt();
            System.out.println("Sisesta c");
            int c = scanner.nextInt();
            System.out.println("Suurim kolmest on:  " + max3(a, b, c));
        } else if (choise == 7) {
            System.out.println("Sisesta sõnad");
            System.out.println("Sisestasid sõnad -  " + someString());
            }
        }








    /*{
        excersie0();
        System.out.println("Miinimum 2, 4 on: " + min(2, 4));
        System.out.println("Miinimum 5, 3 on: " + min(5, 3));
        System.out.println("Maksimum 5, 3 on: " + max(5, 3));
        System.out.println("Absoluutarv -2 on: " + abs(-2));
        System.out.println("Maksimum 2, 2 ja 0 on: " + max3(2, 2, 0));
        System.out.println(someString());
    } */

        // TODO
        //  defineeri 3 muutujat a = 1, b = 1, c = 3
        //  Prindi välja a==b
        //  Prindi välja a==c
        //  Lisa rida a = c
        //  Prindi välja a==b
        //  Prindi välja a==c, mis muutus???
        public static void excersie0 () {
            int a = 1;
            int b = 2;
            int c = 3;
            System.out.println(a == b);
            System.out.println(a == c);
            a = c;  //a=3
            System.out.println(a == b);
            System.out.println(a == c);

        }

        // TODO tagasta a ja b väikseim väärtus
        public static int min ( int a, int b){
            if (a < b) {
                return a;
            } else {
                return b;
            }
        }


        // TODO tagasta a ja b suurim väärtus
        public static int max ( int a, int b){
            if (a > b) {
                return a;
            } else {
                return b;
            }
        }


        // TODO tagasta a absoluut arv
        public static int abs ( int a){
            if (a < 0) {
                return (a * -1);
            } else {
                return a;
            }
        }

        // TODO tagasta true, kui a on paaris arv
        // tagasta false kui a on paaritu arv
        public static boolean isEven ( int a){
            int arv = a % 2;
            if (arv == 0) {
                return true;
            } else {
                return false;
            }
        }

        // TODO tagasta kolmest arvust kõige väiksem
        public static int min3 ( int a, int b, int c){
            if (a <= b && a <= c) {
                return a;
            } else if (b <= a && b <= c) {
                return b;
            } else {
                return c;
            }
        }


        // TODO tagasta kolmest arvust kõige suurem
        public static int max3 ( int a, int b, int c){
            //return max(a, max(b, c));
            if (a >= b && a > c) {
                return a;
            } else if (b >= a && b > c) {
                return b;
            } else {
                return c;
            }
        }

        // TODO
        //  Tagasta string mille väärtus oleks "\"\\""
        //  Trüki muutuja sisu välja
        public static String someString () {
            String text = " siin on tekst \" lisa tekst \"";
            return text;
        }

    }
