import java.io.IOException;
import java.util.ArrayList;

public class Server {
    private NumberRequests numberRequests;
    private FileWork fileWork;
    private ArrayList<Integer> dataList;

    public Server(String inFile, String outFile) {
        fileWork=new FileWork(inFile,outFile);
        dataList=fileWork.getDataList();
        numberRequests=new NumberRequests(fileWork.getMaxRequests());
    }

    public void dataWork() {
        ArrayList<Integer> arrayList = new ArrayList<>(dataList);

        for (int i = 0; i < dataList.size(); i++) {
            Integer key = dataList.get(i);
            numberRequests.requests(key,arrayList);
        }

        try {
            fileWork.writingFile(numberRequests.getCount());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
