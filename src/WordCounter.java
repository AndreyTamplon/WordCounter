import java.util.*;

public class WordCounter
{
    private TreeSet<AbstractMap.SimpleEntry<StringBuilder, Integer>> words;
    private int numberOfWords = 0;
    public void countWords(List<StringBuilder> data)
    {
        Comparator<AbstractMap.SimpleEntry<StringBuilder, Integer>> comparator = Comparator.comparing(AbstractMap.SimpleEntry::getKey);
        words = new TreeSet<>(comparator);
        for(StringBuilder line : data)
        {
            int wordBeginningIndex = -1;
            for(int i = 0; i <= line.length(); ++i)
            {
                if ((i == line.length() || !Character.isLetterOrDigit(line.charAt(i))) && wordBeginningIndex != -1)
                {
                    StringBuilder newWord = new StringBuilder(line.substring(wordBeginningIndex, i));
                    AbstractMap.SimpleEntry<StringBuilder, Integer> newPair = new AbstractMap.SimpleEntry<>(newWord, 1);
                    AbstractMap.SimpleEntry<StringBuilder, Integer> foundedPair = words.ceiling(newPair);
                    if (foundedPair != null && Objects.equals(foundedPair.getKey().toString(), newPair.getKey().toString()))
                    {
                        foundedPair.setValue(foundedPair.getValue() + 1);
                    }
                    else
                    {
                        words.add(newPair);
                    }

                    wordBeginningIndex = -1;
                    numberOfWords += 1;
                }
                else if(wordBeginningIndex == -1 && i != line.length() && Character.isLetterOrDigit(line.charAt(i)))
                {
                    wordBeginningIndex = i;
                }
            }
        }
    }

    public SortedSet<AbstractMap.SimpleEntry<StringBuilder, Integer>> getWords()
    {
        return words;
    }

    public int getNumberOfWords()
    {
        return numberOfWords;
    }

}
