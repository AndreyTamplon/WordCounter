import java.util.*;

public class DataFormatter
{
    private SortedSet<AbstractMap.SimpleEntry<String, Integer>> wordFrequencyCollection;
    private final int numberOfWords;
    public DataFormatter(SortedSet<AbstractMap.SimpleEntry<String, Integer>> wordFrequencyCollection, int numberOfWords)
    {
        this.wordFrequencyCollection = wordFrequencyCollection;
        this.numberOfWords = numberOfWords;
    }
    private void sortSet()
    {
        Comparator<AbstractMap.SimpleEntry<String, Integer>> comparator = (left, right) ->
        {
            if (Objects.equals(left.getValue(), right.getValue()) && !Objects.equals(left.getKey(), right.getKey()))
            {
                return 1;
            }
            return right.getValue() - left.getValue();
        };
        TreeSet<AbstractMap.SimpleEntry<String, Integer>> sortedWords = new TreeSet<>(comparator);
        sortedWords.addAll(wordFrequencyCollection);
        wordFrequencyCollection = sortedWords;
    }

    private List<String> convertToCSV()
    {
        List<String> wordFrequencyCollectionInCSV = new LinkedList<>();
        for(AbstractMap.SimpleEntry<String, Integer> pair : wordFrequencyCollection)
        {
            wordFrequencyCollectionInCSV.add(pair.getKey()
                    + " " + pair.getValue()
                    + " " + String.format("%.3f", (double) pair.getValue() * 100 / numberOfWords) + "%\n");
        }
        return wordFrequencyCollectionInCSV;
    }

    public List<String> formatWordFrequencyCollection()
    {
        sortSet();
        return convertToCSV();
    }
}
