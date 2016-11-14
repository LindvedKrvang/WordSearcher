/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearcher.dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rasmus
 */
public class WordDAO
{
    private static final String WORD_FILE_NAME = "brit-a-z.txt";
    
    /**
     * Reads the file with all the words and saves them in an ArrayList.
     * @return ArrayList with all the words within.
     * @throws FileNotFoundException 
     */
    public List<String> getAllWords() throws FileNotFoundException
    {
        ArrayList<String> allWords = new ArrayList<>();
        
        File inputFile = new File(WORD_FILE_NAME);
        Scanner in = new Scanner(inputFile);
        while(in.hasNextLine())
        {
            allWords.add(in.nextLine());
        }
        
        return allWords;
    }
    
}
