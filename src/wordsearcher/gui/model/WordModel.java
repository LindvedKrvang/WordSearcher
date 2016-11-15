/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearcher.gui.model;

import java.io.FileNotFoundException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import wordsearcher.bll.WordManager;

/**
 *
 * @author Rasmus
 */
public class WordModel
{
    private final ObservableList<String> ITEMS;
    
    private WordManager wordManager;
    
    public WordModel()
    {
        ITEMS = FXCollections.observableArrayList();
        wordManager = new WordManager();
    }
    
    /**
     * Return a List containing ITEMS.
     * @return ITEMS.
     */
    public ObservableList<String> getWords()
    {
        return ITEMS;
    }
    
    /**
     * Resets the ITEMS list by clearing it and adding all words.
     * @throws FileNotFoundException 
     */
    public void reset() throws FileNotFoundException
    {
        ITEMS.clear();
        ITEMS.addAll(wordManager.getAllWords());
    }
    
    /**
     * Searches the wordbase for words beginning with the given query.
     * @param query The String to search for.
     * @param selectedRadioButton The radioButton seleceted as an int.
     * @throws java.io.FileNotFoundException
     */
    public void doSearch(String query, int selectedRadioButton) throws FileNotFoundException
    {
        switch(selectedRadioButton)
        {
            case 1:
            {
                List<String> searchResult = wordManager.beginSearch(query);
                ITEMS.clear();
                ITEMS.addAll(searchResult);
                break;
            }
            case 2:
            {
                List<String> searchResult = wordManager.containSearch(query);
                ITEMS.clear();
                ITEMS.addAll(searchResult);
                break;
            }
            case 3:
            {
                List<String> searchResult = wordManager.endsSearch(query);
                ITEMS.clear();
                ITEMS.addAll(searchResult);
                break;
            }
            case 4:
            {
                List<String> searchResult = wordManager.exactSearch(query);
                ITEMS.clear();
                ITEMS.addAll(searchResult);
                break;
            }
        }        
    }
}
