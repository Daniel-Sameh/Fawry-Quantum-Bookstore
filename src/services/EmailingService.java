package services;

import java.io.File;

public class EmailingService {
    public EmailingService(){}

    public void email(String email, File book, String message){
        System.out.println("=====================================");
        System.out.println("Sending email to "+email+"...");
        System.out.println(message);
        //Sending email
        System.out.println("Sent the email successfully...");
        System.out.println("=====================================");
    }

}
