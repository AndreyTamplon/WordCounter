public class Application
{
    public static void main(String[] args)
    {
        WordCounter wordCounter = new WordCounter();
        wordCounter.countWords(
                FileReciter.readFile ("C:\\Users\\andre\\IdeaProjects\\WordCounter\\src\\in.txt"));
        DataFormatter dataFormatter = new DataFormatter(wordCounter.getWordFrequencyCollection(), wordCounter.getNumberOfWords());
        FilePenman.writeInFile(
                "C:\\Users\\andre\\IdeaProjects\\WordCounter\\src\\out.txt", dataFormatter.formatWordFrequencyCollection());
    }
}
