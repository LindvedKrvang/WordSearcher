/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearcher.bll;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import wordsearcher.dal.WordDAO;

/**
 *
 * @author Rasmus
 */
public class WordManager
{
    private WordDAO wordDAO;
    
    public WordManager()
    {
        wordDAO = new WordDAO();
    }
    
    /**
     * Gets a List from dal and returns the List.
     * @return allWords
     * @throws FileNotFoundException 
     */
    public List<String> getAllWords() throws FileNotFoundException
    {
        List<String> allWords = wordDAO.getAllWords();        
        return allWords;
    }
    
    /**
     * Searches all items to see if any contains the search query.
     * @param query The String being searched for.
     * @return A List containg all words that macthed.
     * @throws FileNotFoundException 
     */
    public List<String> beginSearch(String query) throws FileNotFoundException
    {
        List<String> macthingWords = new ArrayList<>();
        List<String> allWords = wordDAO.getAllWords();
        
        for(int i = 0; i < allWords.size(); i++)
        {
            if(allWords.get(i).contains(query))
            {
                macthingWords.add(allWords.get(i));
            }
        }
        
        return macthingWords;
    }
    
}
