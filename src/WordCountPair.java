public class WordCountPair
{
    private StringBuilder word;
    private int amount_of_repeats;

    public WordCountPair(StringBuilder word)
    {
        this.word = word;
        amount_of_repeats = 1;
    }

    public StringBuilder getWord()
    {
        return word;
    }

    public int getAmount_of_repeats()
    {
        return amount_of_repeats;
    }

    public void setWord(StringBuilder word)
    {
        this.word = word;
    }

    public void setAmount_of_repeats(int amount_of_repeats)
    {
        this.amount_of_repeats = amount_of_repeats;
    }

    public void increaseAmount_of_repeats()
    {
        this.amount_of_repeats++;
    }
}
