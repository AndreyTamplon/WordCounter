import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FileReciter
{
    private FileReciter()
    {

    }
    public static List<String> readFile(String inputFilePath)
    {
        List<String> text = new LinkedList<>();
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath)));
            String line;
            while ((line = reader.readLine()) != null)
            {
                text.add(line);
            }
            return text;
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
        return Collections.emptyList();
    }
}
