import java.util.*;

public class DataFormatter
{
    private TreeSet<AbstractMap.SimpleEntry<StringBuilder, Integer>> words;
    private final int numberOfWords;
    public DataFormatter(TreeSet<AbstractMap.SimpleEntry<StringBuilder, Integer>> words, int numberOfWords)
    {
        this.words = words;
        this.numberOfWords = numberOfWords;
    }
    private void sortSet()
    {
        Comparator<AbstractMap.SimpleEntry<StringBuilder, Integer>> comparator = (left, right) ->
        {
            if (Objects.equals(left.getValue(), right.getValue()) && left.getKey() != right.getKey())
            {
                return 1;
            }
            return right.getValue() - left.getValue();
        };
        TreeSet<AbstractMap.SimpleEntry<StringBuilder, Integer>> sortedWords = new TreeSet<>(comparator);
        sortedWords.addAll(words);
        words = sortedWords;
    }

    private List<StringBuilder> convertToCSV()
    {
        List<StringBuilder> wordsInCSV = new LinkedList<>();
        for(AbstractMap.SimpleEntry<StringBuilder, Integer> pair : words)
        {
            wordsInCSV.add(new StringBuilder (pair.getKey()
                    + " " + pair.getValue()
                    + " " + String.format("%.3f", (double) pair.getValue() * 100 / numberOfWords) + "%\n"));
        }
        return wordsInCSV;
    }

    public List<StringBuilder> formatWords()
    {
        sortSet();
        return convertToCSV();
    }
}
