/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearcher.bll;

/**
 *
 * @author Rasmus
 */
public class ExactSearch extends QuerySearchTemplate
{
    public ExactSearch(String query, boolean caseSensitive)
    {
        super(query, caseSensitive);
    }    
    
    @Override
    public boolean compare(String word)
    {
        if (caseSensitive) 
        {
            return word.equals(query);
        } else 
        {
            return word.toLowerCase().contains(query.toLowerCase());
        }
    } 
}
