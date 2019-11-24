import java.io.FileNotFoundException;
import java.io.IOException;

public class  Start{
    public static void main(String[] args) throws FileNotFoundException, IOException {

        TxtFile txt = new TxtFile();
        txt.createTxtFile();

        XlsxFile exel = new XlsxFile();
        exel.createXlsxFile(  );


    }
}  