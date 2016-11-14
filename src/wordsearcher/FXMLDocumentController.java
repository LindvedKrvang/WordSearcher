/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearcher;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
        List<String> allWords = wordManager.getAllWords();
        for(String str : allWords)
        {
            System.out.println(str);
        }
    }    
    
}
