import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ReadFile
{
    public static List<StringBuilder> readFile(StringBuilder inputFilePath)
    {
        List<StringBuilder> data = new LinkedList<>();
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(String.valueOf(inputFilePath))));
            String line;
            while ((line = reader.readLine()) != null)
            {
                data.add(new StringBuilder(line));
            }
            return data;
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
        return null;
    }
}
