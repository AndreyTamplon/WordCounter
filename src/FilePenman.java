import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class FilePenman
{
    private FilePenman()
    {

    }
    public static void writeInFile(String outputFilePath, List<String> formattedOutput)
    {
        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath)));
            for(String elem : formattedOutput)
            {
                writer.write(String.valueOf(elem));
            }
        } catch (IOException e)
        {
            System.err.println("Error while writing in file: " + e.getLocalizedMessage());
        }
        finally
        {
            if (null != writer)
            {
                try
                {
                    writer.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}
