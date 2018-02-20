package me.sn00pbom.massivesort;

import java.io.File;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    //A program that shuffles a long list of strings in a text file, sorts them, and prints the
    //time taken for each
    public static void main(String[] args) {

        try{
            long starttime = System.currentTimeMillis();
            System.out.println("Scrambling... " + starttime);
            ArrayList<String> scrambled = scramble();
            for(int i = 0; i<100;i++){
                System.out.println(scrambled.get(i));
            }
            long scrtime = System.currentTimeMillis();
            System.out.println("Scrambled!... Sorting... " + (scrtime-starttime));
            Collections.sort(scrambled);
            for(int i = 0; i<100;i++){
                System.out.println(scrambled.get(i));
            }
            long sorttime = System.currentTimeMillis();
            System.out.println("Finished sorting!... closing..." + (sorttime-scrtime));

        }catch (Exception e){
            System.out.println("Err: Doesn't exist or something went wrong");
            e.printStackTrace();
        }

    }
    static ArrayList<String> scramble() throws Exception{

        File file = new File("lotsawords.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<String> scrambled = new ArrayList<>();


        while(scanner.hasNextLine()){
            int randomNum = ThreadLocalRandom.current().nextInt(0, scrambled.size()+1);
            scrambled.add(randomNum,scanner.nextLine());
        }
        return scrambled;
    }
}
