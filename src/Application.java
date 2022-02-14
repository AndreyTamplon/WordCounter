public class Application
{
    public static void main(String[] args)
    {
        WordCounter a = new WordCounter();
        a.CountWords(new StringBuilder("C:\\Users\\andre\\IdeaProjects\\WordCounter\\src\\in.txt"),
                new StringBuilder("C:\\Users\\andre\\IdeaProjects\\WordCounter\\src\\out.txt"));
    }
}
