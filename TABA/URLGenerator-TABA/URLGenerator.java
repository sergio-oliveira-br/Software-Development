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

/*
 * @author Sergio Oliveira
 * TABA 2023/2024
 * e-mail: x23170981
 * Student ID: x23170981@student.ncirl.ie
*/


public class URLGenerator
{
    //DECLARE VARIABLES
        private String companyName;     //input
        private String url;             //output

    //Using in Rule (a), (e) and (f)
        private String newCompanyName;

    //Using in Rule (c)
        private StringBuffer strBuff;

    //Using in Rule (e)
        private int numConsonants;
        char vowel;

    //Using in Rule (f)
        int numPairsVowel = 0;
        char currentChar;               //using to identify the pairs   (i)
        char nextChar;                  //close to each other         (i + 1)
        //int length;

    //CONSTRUCTOR
    public URLGenerator()
    {}

    //COMPUTE METHOD

        //Rule (a) URL Protocol:
        //Replace "Meta" to "coap", otherwise "ftp"
        public void urlProtocol()
        {
            if(companyName.toLowerCase().contains("meta"))
            {
               url = "coap://" + companyName;
            }
            else
            {
                url = "ftp://" + companyName;
            }
        }

        //Rule (b) Hostsname:
        //Replace incorporated, limited or limited liability company to
        //"Inc", "Ltd" or "LCC"
        public void urlHostName()
        {
            String lowerCaseURL = url.toLowerCase(); //converting everyting to lower case

            if (lowerCaseURL.contains("incorporated"))
            {
                url = url.replaceFirst("(?i)incorporated", "Inc");
            }

            else if (lowerCaseURL.contains("limited liability company"))
            {
                url = url.replaceFirst("(?i)limited liability company", "LCC");
            }

            else if (lowerCaseURL.contains("limited"))
            {
                url = url.replaceFirst("(?i)limited", "Ltd");
            }

        }

        //Rule (c) Hostsname:
        //Replace space to underscore "_"

        public void newUrlHostname()
        {
            strBuff = new StringBuffer();
            for(int i = 0; i < url.length(); i++)
            {
                if (url.charAt(i) == ' ')
                {
                    strBuff.append('_');
                }

                else
                {
                    strBuff.append(url.charAt(i));
                }
            }
            newCompanyName = strBuff.toString();
        }

        //Rule (d) Hostsname:
        //Don't change the name


        //Rule (e) Hostsname:
        //Company's names has a total of consonants:
        public void Consonants()
        {
            for (int i = 0; i < companyName.length(); i++)
            {
                char vowel = companyName.charAt(i);
                if(vowel == 'a' || vowel == 'e' ||
                   vowel == 'i' || vowel == 'o' || vowel == 'u')
                {
                    //System.out.println(companyName);
                    //System.out.println("check the method and number");
                }
                else if(vowel != ' ')
                {
                    numConsonants++;
                }
            }
            //odd number of consonants, add ".org" at the end
            if(numConsonants % 2 != 0)
            {
                //System.out.println("* Since the number of consonants is odd, " +
                //                   "\nit was included: '.org' at the end of your hostname.");
                newCompanyName += ".org";
            }
            //even number of consonants, add ".edu" at the end
            else
            {
                //System.out.println("* Since the number of consonants is even, " +
                //                   "\nit was included: '.edu' at the end of your hostname." );
                newCompanyName += ".edu";
            }
        }
        //Rule (f) Pairs of Vowels:
        //Count the number of pairs of vowels next to each other:
        public void PairsOfVowels()
        {
            numPairsVowel = 0;

            for(int i = 0; i < companyName.length() - 1; i++)
            {
                currentChar = Character.toLowerCase(newCompanyName.charAt(i));
                nextChar = Character.toLowerCase(newCompanyName.charAt(i + 1));

                if ("aeiouAEIOU".indexOf(currentChar) != -1 && "aeiouAEIOU".indexOf(nextChar) != -1)
                {
                    numPairsVowel++;
                }
            }

            // for 0 add "/bio"
            if (numPairsVowel == 0)
            {
                newCompanyName = newCompanyName + "/bio";
                //System.out.println("\nThe number of pairs of vowels is: " + numPairsVowel);
                //System.out.println("For this reason, I added '/bio' at the end.");
            }

            // from 1 to 3 add "/FAQ"
            else if (numPairsVowel <= 3)
            {
                newCompanyName = newCompanyName + "/FAQ";
                //System.out.println("\nThe number of pairs of vowels is: " + numPairsVowel);
                //System.out.println("In this case, I added '/FAQ' at the end.");

            }

            //from 3 up add "/Glossary"
            else if (numPairsVowel > 3 )
            {
                //System.out.println("\nThe number of pairs of vowels is: " + numPairsVowel);
                //System.out.println("Uau, it's 'Glossary' added at the end.");
                newCompanyName = newCompanyName + "/Glossary";
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

     /*
     *  ***********************************************************************
     *
     *    !IMPORTANT! I don't remember seeing Boolean in the classroom, so I won't use it.
     *
     *  ***********************************************************************
     */



    public void Validation()
    {

        //it must contain “amazon” or “aws” in the URL hostname.
        System.out.println("-> Your URL contain 'Amazon' or 'aws': ");

        String lowerCaseNewCompany = newCompanyName.toLowerCase();

        if(lowerCaseNewCompany.contains("amazon"))
        {
            System.out.println(newCompanyName);
            System.out.println("   True");
        }
        else if(lowerCaseNewCompany.contains("aws"))
        {
            System.out.println(newCompanyName);
            System.out.println("   True");
        }
        else
        {
            System.out.println(lowerCaseNewCompany);
            System.out.println("   False, does not contain 'Amazon' either 'aws'!");
        }

        // *****  *****  *****  *****  *****  *****  *****
        //SHOUDL I NEED TO ELIMINATE THE "FTP://" & "COAP://" ?
        //NO, IT WAS SAID THAT --> "URL containing a Protocol, Hostname, and Path." <--
        // *****  *****  *****  *****  *****  *****  *****

        //It cannot be shorter than 5 characters & It cannot be longer than 16 characters.
        System.out.println("\n-> Is there a range of 5 to 16 characters?");
        for(int i = 0; i < newCompanyName.length(); i++)
        {}

        //System.out.println("   Has: " + newCompanyName.length() + " characters" );

        if(newCompanyName.length() > 4 && newCompanyName.length() < 17)
        {
            System.out.println("   True");
        }
        else
        {
            System.out.println("   False, it has: " + newCompanyName.length() + " characters");
        }

        // *****  *****  *****  *****  *****  *****  *****
        //SHOUDL I NEED TO ELIMINATE THE "FTP://" & "COAP://" ?
        //NO, IT WAS SAID THAT --> "URL containing a Protocol, Hostname, and Path."
        // *****  *****  *****  *****  *****  *****  *****

        //It can only contain letters (i.e. a – z inclusive, A – Z inclusive),
        //  digits (i.e. 0 – 9 inclusive), and underscores (i.e. ‘_’),
        //      forward slashes (i.e. ‘/’), and periods (i.e. ‘.’)

        //!IMPORTANT
        /* To ensure the code worked, I took the liberty of adding ':' */

        System.out.println("\n-> Can contain: 'a to z', 'A to Z', '0 to 9', '/' and '.'");

        int pass = 0; //if match with score of newCompanyName pass.

        for(int i = 0; i < newCompanyName.length(); i++)
        {
            currentChar = newCompanyName.charAt(i);

            if ((currentChar >= 'a' && currentChar <= 'z') ||
                (currentChar >= 'A' && currentChar <= 'Z') ||
                (currentChar >= '0' && currentChar <= '9') ||
                 currentChar == '/' || currentChar == '.'||
                currentChar == ':' || currentChar == '_')
                /* To ensure the code worked, I took the liberty of adding ':' and '_' */

            {
                pass++;

                //TEST
                //System.out.println(currentChar);
                //System.out.println("True");
            }
            else
            {
                //TEST
                System.out.println("   This characters is not allowed: " + currentChar);
                //System.out.println("   False, that's not allowed.");
            }

        }
        if (pass == newCompanyName.length()) //if match, pass.
        {
            //TEST
            //System.out.println("Pass: " + pass + "newCompanyName: " + newCompanyName.length());
            System.out.println("   True");
            System.out.println("- - - - - - - - - -\n");
        }
        else
        {
            //TEST
            //System.out.println("Pass: " + pass + "newCompanyName: " + newCompanyName.length());
            System.out.println("   False");
            System.out.println("- - - - - - - - - -\n");
        }
    }

    //SETTERS
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public void setNewCompanyName(String newCompanyName)
    {
        this.newCompanyName = newCompanyName;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public void setVowel(char vowel)
    {
        this.vowel = vowel;
    }

    public void setNumConsonants(int numConsonants)
    {
        this.numConsonants = numConsonants;
    }

    public void setNumPairsVowel(int numPairsVowel)
    {
        this.numPairsVowel = numPairsVowel;
    }

    //GETTERS
    public String getCompanyName()
    {
        return companyName;
    }

    public String getNewCompanyName()
    {
        return newCompanyName;
    }

    public String getUrl()
    {
        return url;
    }

    public char getVowel()
    {
        return vowel;
    }

    public int getNumConsonants()
    {
        return numConsonants;
    }

    public int getNumPairsVowel()
    {
        return numPairsVowel;
    }
}
