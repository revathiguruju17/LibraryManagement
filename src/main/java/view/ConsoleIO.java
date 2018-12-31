package view;

import java.util.Scanner;

public abstract class ConsoleIO implements IO{

    @Override
    public String readInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    @Override
    public String display(String message){
        System.out.println(message);
        return message;
    }
}
