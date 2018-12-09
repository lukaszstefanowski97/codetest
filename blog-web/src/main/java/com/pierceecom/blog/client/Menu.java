package com.pierceecom.blog.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Menu {

    public static ConnetionSettings connetionSettings = new ConnetionSettings();

    public static void runApp() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Menu.class);
        Menu contextBean = applicationContext.getBean(Menu.class);

        contextBean.runMenuMechanism();
    }

    public static Integer runMenuMechanism(){
        printMenu();
        Integer option = enterInteger();
        if (option == 0 ) {
            System.out.println("Bye!");
            return 0;
        } else if (option == 1 ) {
            System.out.println("Please type ID: ");
            String id = enterString();
            System.out.println("Please type title: ");
            String title = enterString();
            System.out.println("Please type content: ");
            String content = enterString();
            connetionSettings.savePost(id, title, content);
            runMenuMechanism();
        } else if (option == 2 ) {
            connetionSettings.getAllPosts();
            runMenuMechanism();
        } else if (option == 3 ) {
            System.out.println("Please type ID: ");
            String id = enterString();
            connetionSettings.getPost(id);
            runMenuMechanism();
        } else if (option == 4 ) {
            System.out.println("Please type ID: ");
            String id = enterString();
            connetionSettings.removePost(id);
            runMenuMechanism();
        }
        return 0;
    }

    public static void printMenu() {
        System.out.println("[0] Exit\n[1] Add post\n[2] Display all posts\n[3] Display selected post" +
                "\n[4] Delete selected post");
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

    public static String enterString() {
        try {
            Scanner enterInteger = new Scanner(System.in);
            String id = enterInteger.nextLine();
            if (id.length() < 1) {
                System.out.println("Your string was not valid. Please type again.");
                return enterString();
            } else return id;
        } catch (Exception e) {
            System.out.println("Your string was not valid. Please type again.");
            return enterString();
        }
    }

    public static Boolean validateInput(Integer value) {
        return value >= 0 && value <= 4;
    }
}
