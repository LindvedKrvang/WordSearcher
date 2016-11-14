/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearcher.gui.model;

import java.io.FileNotFoundException;
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
}
