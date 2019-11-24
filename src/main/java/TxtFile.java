import com.github.javafaker.Faker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.Channel;

public class TxtFile {
    void createTxtFile() throws IOException {
        try {
            FileWriter nFile = new FileWriter("src/main/resources/data.txt");

            nFile.write( getValuesForFile( 10 )  );
            nFile.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error");
        }

    }
    String getValuesForFile(int size){
        Faker faker = new Faker(  );
        String data ="";
        for (int i = 0; i < size ; i++) {
        data +=String.format(faker.name().firstName()+"%s",",");
        }

        return data;
    }
}
