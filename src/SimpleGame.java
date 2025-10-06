import java.util.Random;
import java.util.Scanner;

public class SimpleGame{


    static String heroName;
    static int heroHP;
    static int heroPower;
    static int heroMoney ;
    static String monsterName;
    static int monsterHP;
    static int monsterPower;
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static String answer;
    static boolean playAgain = true;

    public static void main(String[] args) {

        while (playAgain){
        init();

        System.out.println("Game Started");
        System.out.println("Hero " + heroName + " entered the forest and see behind him  monster " + monsterName);
        System.out.println("fight started");

        while (true) {
            heroTurn();
            if (isGameOver()) {
                break;
            }
            printStatistic();
            monsterTurn();
            if (isGameOver()) {
                break;
            }
            printStatistic();

        }

        System.out.println("game ended would you try again ? yes or no ");
        answer = sc.next();
        switch(answer){
            case "yes":
                playAgain = true;
                break;
            case "no":
                playAgain = false;
                System.out.println("Okay,game over have a good day");
                break;
            default:
                System.out.println("wrong answer, program ended restart to play again");
                break;

        }
        }

    }

        public static boolean isGameOver(){
        if(heroHP <= 0){
            System.out.println("Monster win");
            return true;
        }
        if(monsterHP <= 0){
            System.out.println("Hero win");
            return true;
        }
        return false;
        }

        public static void heroTurn(){

            System.out.println(" Your turn. Choose the option: 1 Fight, 2 Protection");
            int chose = sc.nextInt();
            if (chose == 1) {
                System.out.println("Hero attack Monster " + monsterName + " take " + heroPower + " points of damage");
                monsterHP -= heroPower;
                if (rand.nextInt(100) < 20) {
                    System.out.println("Hero gave additional damage " + heroPower + " points of damage");
                    monsterHP -= heroPower;
                }
            } else if (chose == 2) {
                System.out.println("Hero " + heroName + " decide to defend himself and heald 1 point of hp");
                heroHP++;
            } else {
                System.out.println("You entered an incorrect option you skip a turn");
            }
        }
        public static void monsterTurn(){
            System.out.println("Monster turn");
            int monsterComand = rand.nextInt(3);
            if(monsterComand == 0) {
            System.out.println("Monster attack. Hero " + heroName + " take " + monsterPower + " points of damage");
            heroHP -= monsterPower;
            } else if (monsterComand == 1) {
                System.out.println("monster decide to defend himself and heald 5 point of HP");
                monsterHP += 5;
            }

        }

        public static void printStatistic() {
            System.out.println();
            System.out.println("State of the game");
            System.out.println(" Hero " + heroName + " HP: " + heroHP);
            System.out.println("Monster " + monsterName + " HP: " + monsterHP);
            System.out.println();
        }

        public static void init(){
            sc = new Scanner(System.in);
            rand = new Random();
            System.out.println("Eneter hero name");
            heroName = sc.next();
            heroHP = 10;
            heroPower = 3;
            heroMoney = 100;
            monsterHP = 10;
            monsterPower = 4;
            System.out.println("Enster monster name ");
            monsterName = sc.next();
        }


}


