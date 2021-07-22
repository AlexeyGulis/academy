package by.academy.homework.hmwk2;

import java.util.Scanner;

// Сколько раздач должна имитировать программа???

public class Deal {
    static String cardname = "";
    static String cardtype = "";
    static Stack stck = new Stack();

    public static void main(String[] args) {
        int cardDeal = 5;
        createCard();
        System.out.println("Введите количество игроков ");
        Scanner scanner = new Scanner(System.in);
        int countPlayers = scanner.nextInt();
        scanner.nextLine();
        while(true){
            if (countPlayers > 0 && countPlayers*cardDeal < (52 - 5) ) {

                System.out.println("Раздача карт");
                System.out.println();
                for (int i = 0; i < countPlayers; i++) {
                    System.out.println("Игрок " + (i + 1));
                    System.out.println();
                    for (int j = 0; j < cardDeal; j++) {
                        System.out.println(stck.pop().toString());
                        System.out.println();
                    }
                }
                break;
            }else {
                System.out.println("Введите количество игроков ");
                countPlayers = scanner.nextInt();
                scanner.nextLine();
            }
        }
        scanner.close();
    }
    public static void createCard(){
        System.out.println("Создание колоды");
        for (int i = 0; i < 13; i++) {
            switch (i){
                case 0:
                    cardname = "Туз";
                    break;
                case 1:
                    cardname = "Двойка";
                    break;
                case 2:
                    cardname = "Тройка";
                    break;
                case 3:
                    cardname = "Четверка";
                    break;
                case 4:
                    cardname = "Пятерка";
                    break;
                case 5:
                    cardname = "Шестерка";
                    break;
                case 6:
                    cardname = "Семерка";
                    break;
                case 7:
                    cardname = "Восьмерка";
                    break;
                case 8:
                    cardname = "Девятка";
                    break;
                case 9:
                    cardname = "Десятка";
                    break;
                case 10:
                    cardname = "Валет";
                    break;
                case 11:
                    cardname = "Дама";
                    break;
                case 12:
                    cardname = "Король";
                    break;
                default :cardname = "";break;
            }
            for (int j = 0; j < 4; j++) {
                switch(j){
                    case 0:
                        cardtype="Буби";
                        break;
                    case 1:
                        cardtype="Черви";
                        break;
                    case 2:
                        cardtype="Пики";
                        break;
                    case 3:
                        cardtype="Крести";
                        break;
                    default:
                        cardtype="";
                        break;
                }
                Card temp = new Card(cardname,cardtype);
                stck.push(temp);
            }
        }
        System.out.println("Перетасовка карт");
        stck.shuffle();

    }
}
