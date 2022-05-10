import java.io.*;
import java.util.ArrayList;

public class FileWork {
    private int maxRequests=1;
    private ArrayList<Integer> dataList;
    private String inFile;
    private String outFile;

    public int getMaxRequests() {
        return maxRequests;
    }

    public FileWork(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;

        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getDataList() {
        return dataList;
    }

    public void writingFile(int count) throws IOException {
        FileWriter fw = new FileWriter(outFile, false);
        fw.write(String.valueOf(count));
        fw.close();
    }

    private void readFile() throws IOException {
        int i = 0;
        String line;

        File file = new File(inFile);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while ((line = br.readLine()) != null) {
            if (i == 0) {
                i++;
                String[] s2_array = line.split("\\D+");

                maxRequests = Integer.parseInt(s2_array[0]);
                int numberRequest = Integer.parseInt(s2_array[1]);

                if (0 >= maxRequests && maxRequests > Math.pow(10, 5) || 0 >= maxRequests && numberRequest > Math.pow(10, 5)) {
                    throw new IOException("String can not be empty!");
                }

                dataList = new ArrayList<>(numberRequest);

                continue;
            }

            Integer key = Integer.parseInt(line);
            dataList.add(key);
        }

        br.close();
        fr.close();
    }
}
