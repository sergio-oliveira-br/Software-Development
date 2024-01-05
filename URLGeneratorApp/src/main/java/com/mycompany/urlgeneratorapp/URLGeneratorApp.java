/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.urlgeneratorapp;

import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Sergio Oliveira
 * TABA 2023/2024
 * e-mail: x23170981
 * Student ID: x23170981@student.ncirl.ie
 * 
 **/

public class URLGeneratorApp 
{

    public static void main(String[] args) 
    {
        //DECLARE VARIABLES
        String companyName;    //input
        String url;              //output

        int urlQty;              //Part (b), my last digite is 1. Approach ID: MCNA1

        String newCompanyName[];

        //declare and create the object
        URLGenerator myU = new URLGenerator();
        Scanner sc = new Scanner(System.in);

        //INPUT
            //Welcome Msg
            System.out.println("\nThis is TABA 2023 by Sergio Oliveira" +
                                "\nWelcome to the Url Generator!");
            
            //Approach ID: MCNA1 -> Ask the user how many URLs they would like to generate 
            
            do
            {
                System.out.println("How many URLs would you like to generate?");
                urlQty = sc.nextInt();       //User inputs a number, program stores it

                sc.nextLine();

                if(urlQty < 0)
                {
                    System.out.println("Opps! Invalid Input.");
                    System.out.println("Please enter a positive number.\n");
                }
                else if (urlQty > 3) //I need to change to a another number
                {
                    System.out.println("Are you sure about this number?");

                    System.out.print("Type 'y' or 'Y' for Yes or anything else for No."); //I ne
                    char c = sc.next().charAt(0);  
                    if(c == 'y' || c== 'Y')
                    {
                        sc.nextLine();
                        break;  
                    }
                }
            }
            while(urlQty < 0 );
            
            //My Array
            newCompanyName = new String[urlQty];
        
            //User enters the Company Name
            for(int i = 0; i < urlQty; i++)
            {
                System.out.println("\nPlease enter your Company Name:" + (i + 1));
                newCompanyName[i] = sc.nextLine();
            }

        //process???    

        //OUTPUT
        for(int i = 0; i < urlQty; i++)
        {
            myU.setCompanyName(newCompanyName[i]);
            myU.urlProtocol();
            myU.urlHostName();
            myU.newUrlHostname();
            
            //OUTPUT
            System.out.println("\nURL #" + (i + 1) + ": ");
            System.out.println("The Company Name: ");
            System.out.println(myU.getNewCompanyName());
        }
    }
}
