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
    
    public List<String> search(IWordComparer comparer) throws FileNotFoundException
    {
        List<String> macthingWords = new ArrayList<>();
        List<String> allWords = getAllWords();
        
        for(String word : allWords)
        {
            if(comparer.compare(word))
            {
                macthingWords.add(word);
            }
        }
        
        return macthingWords;
    }
    
    /**
     * Searches the wordbase for words beginning with the given query.
     * @param query The String to search for.
     * @param selectedOption The radioButton seleceted as an int.
     * @param limitation The limit that is allowed to be shown.
     * @param ITEMS The observableList the model is updated after.
     * @param isCaseSensitive
     * @throws java.io.FileNotFoundException
     */
    public void doSearch(String query, int selectedOption, int limitation, List<String> ITEMS, boolean isCaseSensitive) throws FileNotFoundException
    {
        List<String> searchResult;
        switch(selectedOption)
        {
            case 1: //Search for all that begins with.
            {
                searchResult = search(new BeginsWithSearch(query, isCaseSensitive));
                updateITEMS(searchResult, limitation, ITEMS);              
                break;
            }
            case 2: //Search for all the contains.
            {
                searchResult = search(new ContainsSearch(query, isCaseSensitive));
                updateITEMS(searchResult, limitation, ITEMS);
                break;
            }
            case 3: //Search for all that ends with.
            {
                searchResult = search(new EndsWithSearch(query, isCaseSensitive));
                updateITEMS(searchResult, limitation, ITEMS);
                break;
            }
            case 4: //Search for all exact.
            {
                searchResult = search(new ExactSearch(query, isCaseSensitive));
                updateITEMS(searchResult, limitation, ITEMS);
                break;
            }
        }        
    }
    
    /**
     * Update the ITEMS List for the model.
     * @param searchResult
     * @param limitation
     * @param ITEMS 
     */
    private void updateITEMS(List<String> searchResult, int limitation, List<String> ITEMS)
    {
        ITEMS.clear();
        if(limitation != 0 && !searchResult.isEmpty())
        {
            for(int i = 0; i < limitation; i++)
            {
                if(i < searchResult.size())
                {
                    ITEMS.add(searchResult.get(i)); 
                }
            }
        }
        else
        {
            ITEMS.addAll(searchResult);
        }
    }
}
