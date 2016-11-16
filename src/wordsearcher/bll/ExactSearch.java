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
public class ExactSearch implements IWordComparer
{
    private final String query;

    public ExactSearch(String query)
    {
        this.query = query;
    }

    @Override
    public boolean compare(String word)
    {
        return word.equals(query);
    }
    
}
