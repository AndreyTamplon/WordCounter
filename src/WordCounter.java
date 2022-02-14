import java.io.*;
import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class WordCounter
{

    private final SortedSet<WordCountPair> dictionary;
    private int number_of_words;

    public WordCounter()
    {
        Comparator<WordCountPair> comparator = (left, right) -> {
            if (left.getAmount_of_repeats() == right.getAmount_of_repeats() && left.getWord() != right.getWord())
            {
                return 1;
            }
            return left.getAmount_of_repeats() - right.getAmount_of_repeats();
        };
        dictionary = new TreeSet<>(comparator);
        number_of_words = 0;
    }

    public void CountWords(StringBuilder inputFile, StringBuilder outputFile)
    {
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(String.valueOf(inputFile))));
            String line;

            while ((line = reader.readLine()) != null)
            {
                parseLine(new StringBuilder(line));
            }
        } catch (IOException e)
        {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        } finally
        {
            if (null != reader)
            {
                try
                {
                    reader.close();
                } catch (IOException e)
                {
                    e.printStackTrace(System.err);
                }
            }
        }

        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(String.valueOf(outputFile))));
            for(WordCountPair pair : dictionary)
            {
                writer.write(pair.getWord()
                        + " " + pair.getAmount_of_repeats()
                        + " " + String.format("%.3f", (double) pair.getAmount_of_repeats() * 100 / number_of_words) + "%\n");
            }
        } catch (IOException e)
        {
            System.err.println("Error while writing in file: " + e.getLocalizedMessage());
        } finally
        {
            if (null != writer)
            {
                try
                {
                    writer.close();
                } catch (IOException e)
                {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    private void parseLine(StringBuilder line)
    {
        int beginning_of_word = -1;
        for(int i = 0; i <= line.length(); ++i)
        {
            if ((i == line.length() || !Character.isLetterOrDigit(line.charAt(i))) && beginning_of_word != -1)
            {
                StringBuilder word = new StringBuilder(line.substring(beginning_of_word, i));
                boolean word_exists = false;
                for(WordCountPair pair : dictionary)
                {
                    if(Objects.equals(pair.getWord().toString(), word.toString()))
                    {
                        pair.increaseAmount_of_repeats();
                        word_exists = true;
                    }
                }
                if (!word_exists)
                {
                    dictionary.add(new WordCountPair(word));
                }
                beginning_of_word = -1;
                number_of_words += 1;
            }
            else if(beginning_of_word == -1 && i != line.length() && Character.isLetterOrDigit(line.charAt(i)))
            {
                beginning_of_word = i;
            }
        }
    }
}

