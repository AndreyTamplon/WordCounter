public class Application
{
    public static void main(String[] args)
    {
        WordCounter wordCounter = new WordCounter();
        wordCounter.countWords(
                ReadFile.readFile (new StringBuilder("C:\\Users\\andre\\IdeaProjects\\WordCounter\\src\\in.txt")));
        DataFormatter dataFormatter = new DataFormatter(wordCounter.getWords(), wordCounter.getNumberOfWords());
        WriteInFile.writeInFile(
                new StringBuilder("C:\\Users\\andre\\IdeaProjects\\WordCounter\\src\\out.txt"), dataFormatter.formatWords());
    }
}
