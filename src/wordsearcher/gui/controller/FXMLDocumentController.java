/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearcher.gui.controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import wordsearcher.gui.model.WordModel;

/**
 *
 * @author Rasmus
 */
public class FXMLDocumentController implements Initializable
{
    
    @FXML
    private ListView lstWords;
    
    private WordModel wordModel;
    
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
        } 
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
    }   
}
