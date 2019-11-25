package IO;

import com.github.javafaker.Faker;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class IO {

    private Faker faker = new Faker();

    private void exists(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void writeCSV(String nameFile) throws IOException {
        exists(nameFile);
        try (PrintWriter writer = new PrintWriter(new File(nameFile))) {
            for (int i = 0; i <= 10; i++) {
                StringBuilder names = new StringBuilder()
                        .append(faker.name().fullName())
                        .append(',');
                writer.write(names.toString());
            }
        }
    }

    public List<String> readFileToList(String fileName) throws IOException {
        File file = new File(fileName);
        List<String> dataList = new ArrayList<>();
        exists(fileName);
        try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                while (true) {
                    String line = in.readLine();
                    if (line == null) break;
                    String[] split = line.split(",");
                    dataList.addAll(Arrays.asList(split));
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }

    public void delete(String nameFile) throws IOException {
        exists(nameFile);
        new File(nameFile).delete();
    }

    public void writeExcelFile(List<String> inputDataList,String fileName) throws IOException {
        exists(fileName);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("XLSFile");
        int bound = inputDataList.size();
        IntStream.range(0, bound).forEach(i -> {
            HSSFRow hssfSheetRow = hssfSheet.createRow(i);
            HSSFCell hssfCell = hssfSheetRow.createCell(i);
            hssfCell.setCellValue(inputDataList.get(i));
        });
        try{
            FileOutputStream output = new FileOutputStream(fileName);
            hssfWorkbook.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
