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
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import wordsearcher.bll.BeginsWithSearch;
import wordsearcher.bll.ContainsSearch;
import wordsearcher.bll.EndsWithSearch;
import wordsearcher.bll.ExactSearch;
import wordsearcher.bll.WordManager;
import wordsearcher.gui.model.WordModel;

/**
 *
 * @author Rasmus
 */
public class MainController implements Initializable
{
    private WordModel wordModel;
    private WordManager wordManager;
    
    @FXML
    private ListView lstWords;     
    @FXML
    private TextField txtQuery;
    @FXML
    private Label lblCount;
    @FXML
    private RadioButton rbtnBeginsWith;
    @FXML
    private RadioButton rbtnContains;
    @FXML
    private RadioButton rbtnEndsWith;
    @FXML
    private RadioButton rbtnExact;
    @FXML
    private CheckBox checkCase;
    @FXML
    private ComboBox<String> comboLimit;
    
    public MainController()
    {
        wordModel = new WordModel();
        wordManager = new WordManager();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        comboLimit.setItems(FXCollections.observableArrayList("None", "10", "20", "50", "100"));
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
            wordManager.doSearch(query, getSelectedSearch(), checkLimit(), wordModel.getWords(), checkCase.isSelected());
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
    
//    /**
//     * Searches the wordbase for words beginning with the given query.
//     * @param query The String to search for.
//     * @param selectedOption The radioButton seleceted as an int.
//     * @param limitation The limit that is allowed to be shown.
//     * @param ITEMS The observableList the model is updated after.
//     * @throws java.io.FileNotFoundException
//     */
//    public void doSearch(String query, int selectedOption, int limitation, List<String> ITEMS) throws FileNotFoundException
//    {
//        List<String> searchResult;
//        boolean isCaseSensitive = checkCase.isSelected();
//        switch(selectedOption)
//        {
//            case 1: //Search for all that begins with.
//            {
//                searchResult = wordManager.search(new BeginsWithSearch(query, isCaseSensitive));
//                updateITEMS(searchResult, limitation, ITEMS);              
//                break;
//            }
//            case 2: //Search for all the contains.
//            {
//                searchResult = wordManager.search(new ContainsSearch(query, isCaseSensitive));
//                updateITEMS(searchResult, limitation, ITEMS);
//                break;
//            }
//            case 3: //Search for all that ends with.
//            {
//                searchResult = wordManager.search(new EndsWithSearch(query, isCaseSensitive));
//                updateITEMS(searchResult, limitation, ITEMS);
//                break;
//            }
//            case 4: //Search for all exact.
//            {
//                searchResult = wordManager.search(new ExactSearch(query, isCaseSensitive));
//                updateITEMS(searchResult, limitation, ITEMS);
//                break;
//            }
//        }        
//    }
    
//    /**
//     * Update the ITEMS List for the model.
//     * @param searchResult
//     * @param limitation
//     * @param ITEMS 
//     */
//    private void updateITEMS(List<String> searchResult, int limitation, List<String> ITEMS)
//    {
//        ITEMS.clear();
//        if(limitation != 0 && !searchResult.isEmpty())
//        {
//            for(int i = 0; i < limitation; i++)
//            {
//                if(i < searchResult.size())
//                {
//                    ITEMS.add(searchResult.get(i)); 
//                }
//            }
//        }
//        else
//        {
//            ITEMS.addAll(searchResult);
//        }
//    }
    
    /**
     * Checks which radioButton that has been selected and parses it as an int.
     * @return The selected button as an int.
     */
    private int getSelectedSearch()
    {
        int selectedSearch = 0;
        if(rbtnBeginsWith.isSelected())
        {
            selectedSearch = 1;
        }
        if(rbtnContains.isSelected())
        {
            selectedSearch = 2;
        }
        if(rbtnEndsWith.isSelected())
        {
            selectedSearch = 3;
        }
        if(rbtnExact.isSelected())
        {
            selectedSearch = 4;
        }
        return selectedSearch;
    }
    
    /**
     * Updates the Count label with the amount of words displayed.
     */
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

    /**
     * Checks if a limitation has been selected and returns the limit.
     * @return The limit to return as int.
     */
    private int checkLimit()
    {
        int amountToShow = 0; //If no limit is set, show all.
        int selectedIndex = comboLimit.getSelectionModel().getSelectedIndex();
        switch(selectedIndex)
        {
            case 0:
            {
                amountToShow = 0;
                break;
            }
            case 1:
            {
                amountToShow = 10;
                break;
            }
            case 2:
            {
                amountToShow = 20;
                break;
            }
            case 3:
            {
                amountToShow = 50;
                break;
            }
            case 4:
            {
                amountToShow = 100;
                break;
            }
        }
        return amountToShow;
    }
    
    /**
     * Terminates the program.
     * @param event 
     */
    @FXML
    private void handleCloseButton(ActionEvent event)
    {
        Platform.exit();
    }
}
