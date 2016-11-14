/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearcher.gui.controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import wordsearcher.gui.model.WordModel;

/**
 *
 * @author Rasmus
 */
public class FXMLDocumentController implements Initializable
{
    private WordModel wordModel;
    
    @FXML
    private ListView lstWords;     
    @FXML
    private TextField txtQuery;
    @FXML
    private Label lblCount;
    
    public FXMLDocumentController()
    {
        wordModel = new WordModel();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            lstWords.setItems(wordModel.getWords());
            wordModel.reset();  
            updateCount();
        } 
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
    }   
    
    /**
     * Starts the search when the button is pressed by parsing the search query.
     * @param event 
     */
    @FXML
    private void handleSearch(ActionEvent event)
    {
        try
        {
            String query = txtQuery.getText();
            wordModel.doSearch(query);
            updateCount();
        } 
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Clears the txtQuery input field and shows all items.
     * @param event 
     */
    @FXML
    private void handleClear(ActionEvent event)
    {
        try
        {
            txtQuery.setText("");
            wordModel.reset();            
            updateCount();
        } 
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Updates the Count label with the amount of words displayed.
     */
    @FXML
    private void updateCount()
    {
        List<String> wordsList = wordModel.getWords();
        int amountOfWords = 0;
        for(String str : wordsList)
        {
            amountOfWords++;
        }
        lblCount.setText("Count: " + amountOfWords);
    }
}
