import java.util.*;

public class WordCounter
{
    private TreeSet<AbstractMap.SimpleEntry<String, Integer>> wordFrequencyCollection;
    private int numberOfWords = 0;
    public WordCounter()
    {
        Comparator<AbstractMap.SimpleEntry<String, Integer>> comparator = Comparator.comparing(AbstractMap.SimpleEntry::getKey);
        wordFrequencyCollection = new TreeSet<>(comparator);
    }

    private List<String> parseText(List<String> data)
    {
        List<String> wordList = new LinkedList<>();
        for(String line : data)
        {
            int wordBeginningIndex = -1;
            for(int i = 0; i <= line.length(); ++i)
            {
                if ((i == line.length() || !Character.isLetterOrDigit(line.charAt(i))) && wordBeginningIndex != -1)
                {
                    String newWord = line.substring(wordBeginningIndex, i);
                    wordList.add(newWord);
                    wordBeginningIndex = -1;
                }
                else if(wordBeginningIndex == -1 && i != line.length() && Character.isLetterOrDigit(line.charAt(i)))
                {
                    wordBeginningIndex = i;
                }
            }
        }
        return wordList;
    }

    private void addWord(String word)
    {
        AbstractMap.SimpleEntry<String, Integer> newPair = new AbstractMap.SimpleEntry<>(word, 1);
        AbstractMap.SimpleEntry<String, Integer> foundedPair = wordFrequencyCollection.ceiling(newPair);
        if (foundedPair != null && Objects.equals(foundedPair.getKey(), newPair.getKey()))
        {
            foundedPair.setValue(foundedPair.getValue() + 1);
        }
        else
        {
            wordFrequencyCollection.add(newPair);
        }

        numberOfWords += 1;

    }

    public void countWords(List<String> data)
    {
        List<String> wordList = parseText(data);
        for (String word : wordList)
        {
            addWord(word);
        }
    }

    public SortedSet<AbstractMap.SimpleEntry<String, Integer>> getWordFrequencyCollection()
    {
        return wordFrequencyCollection;
    }

    public int getNumberOfWords()
    {
        return numberOfWords;
    }

}
