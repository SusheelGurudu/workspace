/**
 * 
 */
package com.test.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * The Class ChatBot.
 *
 * @author suprith.gurudu
 */
public class ChatBot
{

    /** The counter. */
    // Class variables
    static int    counter        = 0;

    /** The attributes. */
    static String attributes[][] = null;

    /**
     * Multicheck.
     *
     * @param input
     *            the input
     * @param inputs
     *            the inputs
     * @return the string
     */
    // Checking if the user has given same inputs multiple times
    public static String multicheck(String input, List<String> inputs)
    {
        String output = "";
        if (inputs.contains(input) && (!input.equals("") || input != null))
            output = "as i said,";
        return (output);
    }

    /**
     * Question generator.
     *
     * @param input
     *            the input
     * @param outputs
     *            the outputs
     * @return the string
     */
    // Question generator for the theme Michael Jackson
    public static String question_generator(String input, List<String> outputs)
    {
        String question = "";

        // Checking for the base question for theme introduction
        if (counter == 0)
        {
            String sample = "how is your day";
            String strSample[] = sample.split(" ");
            int p = 0;
            for (int i = 0; i < strSample.length; i++)
            {
                if (input.matches(".*\\b" + strSample[i] + "\\b.*"))
                {
                    p++;
                }
            }

            if (p > 2)
            {
                question = "what are your hobbies?";
                counter++;
            }
            else
            {
                if (outputs.size() > 0)
                {
                    String strPreviousOut = outputs.get(outputs.size() - 1);
                    p = 0;
                    for (int i = 0; i < strSample.length; i++)
                    {
                        if (strPreviousOut.matches(".*\\b" + strSample[i] + "\\b.*"))
                        {
                            p++;
                        }
                    }

                    if (p > 2)
                    {
                        question = "what are your hobbies ?";
                        counter++;
                    }

                }
            }
        }
        // Starting off with the questions
        else
        {
            String inpArr[] = null;
            String reqArr[] = input.split(" ");
            String last = null;
            Random ran = new Random();
            boolean check = false;
            for (int j = 0; j < reqArr.length; j++)
            {
                for (int i = 0; i < attributes.length; i = i + 2)
                {
                    if (Arrays.asList(attributes[i]).contains(reqArr[j]))
                    {
                        check = true;
                        inpArr = reqArr;
                    }
                }
            }
            if (!check)
            {
                if (outputs.size() > 0)
                {
                    String strPreviousOut = outputs.get(outputs.size() - 1);
                    String outArr[] = strPreviousOut.split(" ");
                    for (int j = 0; j < outArr.length; j++)
                    {
                        for (int i = 0; i < attributes.length; i = i + 2)
                        {
                            if (Arrays.asList(attributes[i]).contains(outArr[j]))
                            {
                                check = true;
                                inpArr = outArr;

                            }
                        }
                    }
                }
            }

            // Creating questions from knowledge base and user inputs
            if (check)
            {

                for (int j = 0; j < inpArr.length; j++)
                {

                    for (int i = 0; i < attributes.length; i = i + 2)
                    {
                        if (Arrays.asList(attributes[i]).contains(inpArr[j]))
                        {

                            last = attributes[i + 1][ran.nextInt(attributes[i + 1].length)];
                            if (inpArr[j].equals("singing") || inpArr[j].equals("hobbies")
                                    || inpArr[j].equals("football") || inpArr[j].equals("swimming")
                                    || inpArr[j].equals("tennis") || inpArr[j].equals("playing")
                                    || inpArr[j].equals("painting") || inpArr[j].equals("reading")
                                    || inpArr[j].equals("dancing") || inpArr[j].equals("games"))
                            {
                                question = "i love " + last + ".dont you " + last + " ?";
                            }
                            if (inpArr[j].equals("moves") || inpArr[j].equals("dance"))
                            {
                                question = "i like " + last + " move.which kind of albums do you like?";
                            }
                            if (inpArr[j].equals("albums"))
                            {
                                question = "my favourite album is " + last + ".what is your favourite songs ?";
                            }
                            if (inpArr[j].equals("songs"))
                            {
                                question = "i like " + last + ".do you know mj is popular ?";
                            }
                            if (inpArr[j].equals("popular") || inpArr[j].equals("fame"))
                            {
                                question = "mj is famous " + last + " and received many awards ";
                            }
                            if (inpArr[j].equals("awards") || inpArr[j].equals("achievements"))
                            {
                                question = "mj has got " + last + ". and do you know he has surgeries ?";
                            }
                            if (inpArr[j].equals("surgeries") || inpArr[j].equals("surgery"))
                            {
                                question = "mj has undergone " + last
                                        + " surgery and do you know he has a huge family ?";
                            }
                            if (inpArr[j].equals("family"))
                            {
                                question = "mj became successful even from a family of " + last
                                        + " members.. his death was tragedy";
                            }
                            if (inpArr[j].equals("death") || inpArr[j].equals("died"))
                            {
                                question = "mj died due to " + last;
                            }

                            if (inpArr[j].equals("websitecrash"))
                            {
                                question = "after his death websites like " + last + " crashed due to sever load";
                            }

                        }
                    }
                }
            }

        }

        return (question);
    }

    /**
     * Output multi check.
     *
     * @param output
     *            the output
     * @param outputs
     *            the outputs
     * @return the string
     */
    public static String output_multi_check(String output, List<String> outputs)
    {
        String mod_output = output;
        if (outputs.contains(output) && (!output.equals("") || output != null))
        {
            if (output.equals("good, how is your day?"))
            {
                mod_output = "good.";
            }
        }
        return (mod_output);
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args)
    {

        // Knowledge Base for direct matching
        String canned[][] = { { "hello", "hi", "hey" }, { "hello", "hi", "hey"},
                { "how are you", "how do you do", "how is it going" },
                { "good, Thank you!!  How are you today?", "good, how about you?", "going good, how is your day?" },
                { "what is your name" }, { "you can call me Jackson " }

        };

        // Knowledge Base for the theme Michael Jackson
        String attributes1[][] = {
                { "hobbies", "football", "swimming", "tennis", "playing", "games", "singing", "painting", "reading",
                        "dancing" }, { "dance" }, { "moves", "dance" }, { "moon walk", "robot" }, { "albums" },
                { "thriller", "dangerous", "this is it" }, { "songs" },
                { "beat it", "dangerous", "will you be there?" }, { "fame", "popular" },
                { "worldwide", "top earning dead celebrity", "top songs in billboard" }, { "awards", "achievements" },
                { "guiness world record", "grammy awards" }, { "surgeries", "surgery" }, { "facial" }, { "family" },
                { "13" }, { "death", "died" }, { "intoxication in 2009", "cardiac arrest in 2009" },
                { "websitecrash" }, { "google", "twitter", "wikipidea" } };

        // Knowledge Base for partial and probabilistic matching
        attributes = attributes1;
        Map<String, String> hm = new HashMap<String, String>();
        Map<String, Integer> hmRank = new HashMap<String, Integer>();
        hm.put("how are you", "good, how is your day?");
        hm.put("how do you do", "good, how is your day?");
        hm.put("how is it", "good, how is your day?");
        hm.put("what is your name", "you can call me bottie.");
        hm.put("how is your day", "good, how is your day?");

        // Variable Initializations
        DataInputStream ds = new DataInputStream(System.in);
        Random ran = new Random();
        List<String> inputs = new ArrayList<String>();
        List<String> outputs = new ArrayList<String>();
        boolean response = false;
        String input, output = "", question = "";

        // Chat loop
        while (true)
        {
            try
            {
                // Input taking
                response = false;
                input = ds.readLine().toLowerCase();

                // Check for special characters
                if (input.endsWith("?") || input.endsWith("!") || input.endsWith("."))
                {
                    input = input.substring(0, input.length() - 1);
                    input = input.trim();
                }

                // Same Input multi checking
                output = "";
                output = multicheck(input, inputs);

                inputs.add(input);

                // Get Response
                if (input != null && !input.equals(""))
                {
                    // Direct Matching
                    for (int i = 0; i < canned.length; i = i + 2)
                    {
                        if (Arrays.asList(canned[i]).contains(input))
                        {
                            output = output + canned[i + 1][ran.nextInt(canned[i + 1].length)];
                            response = true;
                            break;
                        }

                    }

                    // Partial & Probabilistic Matching
                    if (!response)
                    {
                        for (Map.Entry<String, String> entry : hm.entrySet())
                        {
                            String key = entry.getKey();
                            String strArr[] = key.split(" ");
                            int rank = 0;
                            for (int i = 0; i < strArr.length; i++)
                            {
                                if (input.matches(".*\\b" + strArr[i] + "\\b.*"))
                                {
                                    rank++;
                                }
                            }

                            if (rank == strArr.length)
                            {
                                output = output + hm.get(key);
                                response = true;
                                break;
                            }

                            else
                            {
                                hmRank.put(key, rank);
                            }
                        }

                        if (!response)
                        {
                            Map.Entry<String, Integer> maxEntry = null;
                            for (Map.Entry<String, Integer> entry : hmRank.entrySet())
                            {
                                if (maxEntry == null || entry.getValue() > maxEntry.getValue())
                                {
                                    maxEntry = entry;
                                }
                            }

                            if (maxEntry.getValue() != 0)
                            {
                                output = output + hm.get(maxEntry.getKey());
                                response = true;
                            }

                        }

                    }

                }
                output = output_multi_check(output, outputs);
                question = question_generator(input, outputs);
                if (output != null)
                {
                    output = output + question;
                }
                else
                    output = question;

                // Handling unusual cases
                if (input == null || input.equals("") || input.equals(" "))
                {
                    output = "are you der?";
                }
                if (output == null || output.equals("") || output.equals(" "))
                {
                    output = "oh, my keyboard hung again.";
                }

                outputs.add(output);
                output = "->" + output;
                System.out.println(output);

            }

            // Exception handling
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

}