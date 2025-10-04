import java.util.Random;
import java.util.Scanner;

public class SimpleGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Enter the Name of Hero");
         String heroName = sc.next();
         int heroHP = 10;
         int heroPower = 3;
         int heroMoney = 100;

        System.out.println("monster name");
         String monsterName  = sc.next();
         int monsterHP = 10;
         int monsterPower = 4;

        System.out.println("Game Started");
        System.out.println("Hero " + heroName + " entered the forest and see behind him  monster " + monsterName );


        // logic of hero turn
        System.out.println("fight started");

        while(true) {
            System.out.println(" Your turn. Choose the option: 1 Fight, 2 Protection");
            int chose = sc.nextInt();
            if (chose == 1) {
                System.out.println("Hero attack Monster " + monsterName + " take " + heroPower + " points of damage");
                monsterHP -= heroPower;
                if(rand.nextInt(100) < 10){
                    System.out.println("Hero gave additional damage " + heroPower + "points of damage");
                    monsterHP -= heroPower;
                }

                if( monsterHP <= 0 ){
                    System.out.println("hero win and took money price");
                    heroMoney += 1000;
                    System.out.println("Hero bank is: " + heroMoney);
                    break;
                }
            } else if (chose == 2) {
                System.out.println("Hero " + heroName + " decide to defend himself and heald 1 point of hp");
                heroHP++;
            } else {
                System.out.println("You entered an incorrect option you skip a turn");
            }
            System.out.println("State of the game. Hero " + heroName + " has " + heroHP + "HP " + ", monster " + monsterName + " has " + monsterHP + "HP");

            // logic of monster turn
            System.out.println("Monster turn");
            int monsterComand = rand.nextInt(2);
            System.out.println("Monster attack. Hero " + heroName + " take " + monsterPower + " points of damage");
            heroHP -= monsterPower;
            if(heroHP <= 0){
                System.out.println("Monster win");
                break;
            } else if(monsterComand == 0){
                System.out.println("monster decide to defend himself and heald 5 point of HP");
                monsterHP += 5;
            }
            System.out.println("State of the game. Hero " + heroName + " has " + heroHP + "HP " + ", monster " + monsterName + " has " + monsterHP + "HP");

        }

        System.out.println("Game ended");


    }
}
