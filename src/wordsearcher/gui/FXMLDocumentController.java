/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearcher.gui;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import wordsearcher.bll.WordManager;

/**
 *
 * @author Rasmus
 */
public class FXMLDocumentController implements Initializable
{
    
    @FXML
    private ListView lstWords;
    
    private WordManager wordManager;
    
    public FXMLDocumentController()
    {
        wordManager = new WordManager();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            List<String> allWords = wordManager.getAllWords();
            for(int i = 0; i < allWords.size(); i++)
            {
                System.out.println(allWords.get(i) + "\n");
            }
        } 
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }        
    }   
}
