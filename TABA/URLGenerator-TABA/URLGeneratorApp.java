/*
** The application prompts the user to provide one single line
** of text with the name of the company, for example:
** Meta Platforms Inc, Google LLC, Amazon Inc., Deloitte Touche Tohmatsu Ltd.
** (Please note that you are not required to validate the input,
** we assume that the input is well formed.)
** Next, the application uses the given company name to generate/create
** the corresponding URL containing a Protocol, Hostname, and Path.
** The URL is created using several rules.
*/

/*
** Protocol -> https:
** Hostname -> moodle2023.ncirl.ie
** Path -> course/view.php?id=768
*/

/*
** Examples:
**
** ftp://Google_LLC.org/FAQ
** ftp://Deloite_Touche_Tohmatsu_Ltd.edu/FAQ
** ftp://Monsters_Inc.edu/bio
** coap://Meta_Ltd.edu/bio
*/

/**
 * @author Sergio Oliveira
 * TABA 2023/2024
 * e-mail: x23170981
 * Student ID: x23170981@student.ncirl.ie
*/


import java.util.Scanner;

public class URLGeneratorApp
{

    public static void main(String[] args)
    {
        //DECLARE VARIABLES
        String companyName;      //input
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
                System.out.println("\nPlease enter your Company Name #" + (i + 1) + ":");
                newCompanyName[i] = sc.nextLine();
            }

        System.out.println("\nHere is a summary and the URLs that were generated:\n");

        //OUTPUT
        for(int i = 0; i < urlQty; i++)
        {
            myU.setCompanyName(newCompanyName[i]);
            myU.urlProtocol();
            myU.urlHostName();
            myU.newUrlHostname();
            myU.Consonants();
            myU.PairsOfVowels();


            //Introduction
            System.out.println("\n--------");
            System.out.println("#" + (i + 1));
            System.out.println("The Company Name: " + myU.getCompanyName());
            System.out.println("URL-> " + myU.getNewCompanyName() + "\n");

            //Rule (all) here is the final answer
            //System.out.println(myU.getNewCompanyName() + "\n");

            //Introduction to explanation
            System.out.print("This URL was created using these rules:\n");

            //Explaing the rule (e)
            //myU.Consonants();
            if (myU.getNumConsonants() % 2 != 0)
            {
                System.out.println("* Since the number of consonants is odd, " +
                                  "\nit was included: '.org' at the end of your hostname.");
            }

            else
            {
                System.out.println("* Since the number of consonants is even, " +
                                   "\nit was included: '.edu' at the end of your hostname." );

            }

            //Explaing the rule (f)
            myU.PairsOfVowels();
            System.out.println("\n* The number of pair of vowel is: " + myU.getNumPairsVowel());
            if (myU.getNumPairsVowel() == 0)
            {
                System.out.println("  For this reason, I added '/bio' at the end.");
            }

            else if (myU.getNumPairsVowel() <= 3)
            {
                System.out.println("  In this case, I added '/FAQ' at the end.");
            }

            else if (myU.getNumPairsVowel() > 3)
            {
                System.out.println("   Wow, 'Glossary' was added at the end.");
            }
        }
    /*
     *  ***********************************************************************
     *
     *    PART 2 - The method should compute whether the given URLs are valid
     *
     *  ***********************************************************************
     *
     *      Penultimate (i.e. second to last) digit of your student ID
     *      ID: 23170981 - Sergio Oliveira
     *      Assigned URL - Amazon URLs
     *
     *  Functionality: Check the validity of an Amazon URL
     *  A valid Amazon URL satisfies all the following rules:
	 *  ->  it must contain “amazon” or “aws” in the URL hostname.
	 *  ->  It cannot be shorter than 5 characters.
	 *  ->  It cannot be longer than 16 characters.
	 *  ->  It can only contain letters (i.e. a – z inclusive, A – Z inclusive), digits (i.e. 0 – 9 inclusive), and underscores (i.e. ‘_’), forward slashes (i.e. ‘/’), and periods (i.e. ‘.’)
	 *  ->  If it contains more than one dot ("."), there can only be exactly two dots
     *
     */

    //Declare Variables
        char answer;

    //INPUT

        System.out.println("\n##############");
        System.out.println("\nWould you like to validat you URL? ");
        System.out.println("Press 'y' or 'Y' for Yes, or anything for No.");
        answer = sc.next().charAt(0);
        if(answer == 'y' || answer == 'Y')
        {
            sc.nextLine();
            System.out.println("\nLet's start! ");

            for(int i = 0; i < urlQty; i++)
            {
                myU.setCompanyName(newCompanyName[i]);
                myU.urlProtocol();
                myU.urlHostName();
                myU.newUrlHostname();
                myU.Consonants();
                myU.PairsOfVowels();

                System.out.println("#" + (i + 1));
                myU.Validation();
            }

        }
        else
        {
            System.out.println("Okay, bye bye!" +
                                "\nThis was TABA Software Development" +
                                "\n By Sergio Oliveira");
        }
            System.out.println("\nTks" +
                            "\nThis was TABA Software Development" +
                            "\nBy Sergio Oliveira");
    }
}
