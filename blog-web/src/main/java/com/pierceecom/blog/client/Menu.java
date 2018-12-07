package com.pierceecom.blog.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Menu {

    public static void runApp() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Menu.class);
        Menu contextBean = applicationContext.getBean(Menu.class);

        runMenuMechanism();
    }

    public static Integer runMenuMechanism(){
        printMenu();
        Integer option = enterInteger();
        if (option == 0 ) {
            System.out.println("Bye!");
            return 0;
        } else if (option == 1 ) {

        } else if (option == 2 ) {

        } else if (option == 3 ) {

        } else if (option == 4 ) {

        }
        return 0;
    }

    public static void printMenu() {
        System.out.println("[0] Add post\n[1] Display selected post\n[2] Display all posts\n[3] Delete selected post" +
                "\n[4] Exit");
    }

    public static Integer enterInteger(){
        try {
            Scanner enterInteger = new Scanner(System.in);
            System.out.println("Enter integer: ");
            Integer value = enterInteger.nextInt();
            if (validateInput(value)) return value;
            else {
                System.out.println("There is no option under that number. Please type again:");
                return enterInteger();
            }
        } catch (Exception type) {
            System.out.println("That was not an integer. Please type again:\n");
            return enterInteger();
        }
    }

    public static Boolean validateInput(Integer value) {
        return value >= 0 && value <= 4;
    }
}
