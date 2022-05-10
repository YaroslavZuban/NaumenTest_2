import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NumberRequests {
    private int maxRequests;
    private int cacheAmount = 0;
    private int count=0;

    private static Map<Integer,Integer> cache;

    public NumberRequests(int maxRequests) {
        this.maxRequests = maxRequests;
        cache=new HashMap<>();
    }

    private void elementValidation(ArrayList<Integer> arrayList) {
        Iterator<Map.Entry<Integer, Integer>> entries = cache.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            Integer key = entry.getKey();

            if (!arrayList.contains(key)) {
                cache.remove(key);
                break;
            }
        }
    }

    public void requests(Integer key, ArrayList<Integer> arrayList) {
        if (cacheAmount == maxRequests) {
            elementValidation(arrayList);
        }

        if (cache.get(key) != null) {
            arrayList.remove(key);
        } else {
            cache.put(key, 0);
            count++;
            arrayList.remove(key);
            cacheAmount++;
            elementValidation(arrayList);
        }
    }

    public int getCount() {
        return count;
    }
}
