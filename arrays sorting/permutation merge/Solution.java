import java.util.*;

public class Solution {

    public String[][] stringDistribution(String[] strs) {
        if (strs == null) {
            return null;
        }

        var resultMap = new HashMap<String, List<String>>(strs.length);

        for (String str : strs) {
            var sortedStr = sortString(str);

            if (resultMap.containsKey(sortedStr)) {
                resultMap.get(sortedStr).add(str);
            } else {
                var newValue = new ArrayList<String>();
                newValue.add(str);
                resultMap.put(sortedStr, newValue);
            }
        }

        return resultMap.values().stream()
                .map(it -> it.toArray(String[]::new))
                .toArray(String[][]::new);
    }

    public String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}