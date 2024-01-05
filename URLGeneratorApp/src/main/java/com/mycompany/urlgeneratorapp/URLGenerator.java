/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.urlgeneratorapp;

/**
 *
 * @author Sergio Oliveira
 * TABA 2023/2024
 * e-mail: x23170981
 * Student ID: x23170981@student.ncirl.ie
 * 
 **/

/**
 *
 * Protocol -> https:               
 * Hostname -> moodle2023.ncirl.ie  
 * Path -> course/view.php?id=768  
 * 
 * Examples:
 * ftp://Google_LLC.org/FAQ
 * ftp://Deloite_Touche_Tohmatsu_Ltd.edu/FAQ
 * ftp://Monsters_Inc.edu/bio
 * coap://Meta_Ltd.edu/bio
 */


public class URLGenerator 
{
    //DECLARE VARIABLES  
    private String companyName;     //input 
    private String url;             //output

    private String newCompanyName;  
    private StringBuffer strBuff;
    private String newUrl;

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
               url = "coap://" + companyName ;
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
            strBuff = new StringBuffer();
            for(int i = 0; i < url.length(); i ++)
            {
                if (url.toLowerCase().contains("incorporated"))
                {
                    strBuff.append(".Inc");
                }
                /* 
                else if (url.toLowerCase().contains("limited"))
                {
                    strBuff.append(".Ltd");
                }
                else if (url.toLowerCase().contains("limited liability company")) 
                {
                    strBuff.append(".LCC");
                }*/
                else
                {
                    strBuff.append(url);
                }
                
            newUrl = strBuff.toString();
            }
        }

        //Rule (c) Hostsname:
        //Replace space to underscore "_"
        public void newUrlHostname()
        {
            strBuff = new StringBuffer();
            for(int i = 0; i < url.length(); i++)
            {
                if(newUrl.charAt(i) == ' ')
                {
                    strBuff.append('_');
                }
                else
                {
                    strBuff.append(newUrl.charAt(i));
                }
            }
            newCompanyName = strBuff.toString();
        }
        
        //Rule (d) Hostsname:
        //Don't change the name

        //Rule (e) Hostsname:
        //Name contains:
            //odd number of consonants, add ".org" at the end
                
        
            //even number of consonants, add ".edu" at the end
                
        //Rule (f) Phath
        //Count the number of pairs:
            //for 0         -> add "bio"
            //from 1 to 3   -> "FAQ"
            //for 3+        -> "Glossary"
    
    //SETTERS
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public void setNewCompanyName(String newCompanyName)
    {
        this.newCompanyName = newCompanyName;
    }

    public void setNewUrl(String newUrl)
    {
        this.newUrl = newUrl;
    }

    public void setUrl(String url) 
    {
        this.url = url;
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

    public String getNewUrl()
    {
        return newUrl;
    }
}
