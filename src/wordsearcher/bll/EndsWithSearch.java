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
public class EndsWithSearch implements IWordComparer
{
    private final String query;

    public EndsWithSearch(String query)
    {
        this.query = query;
    }

    @Override
    public boolean compare(String word)
    {
        return word.endsWith(query);
    }
    
}
