import java.util.*;

public class Sherlock
{
    public static boolean isValid(String s)
    {
        if(s == null || s.length() < 1 || s.length() > 100000 ) {
            return false;
        }

        Map<Character, Integer> results = new HashMap<>();
        for(int i = 0; i< s.length(); i++) {
            if(!results.containsKey(s.charAt(i))) {
                results.put(s.charAt(i), 1);
            }else {
                results.put(s.charAt(i), results.get(s.charAt(i)) + 1);
            }
        }

        List<Integer> frequencies = new ArrayList<>(results.values());
        Collections.sort(frequencies);

        if(frequencies.size() == 1) {
            return true;
        }

        int firstElement = frequencies.get(0);
        int secondElement = frequencies.get(1);
        int beforeLastElement = frequencies.get(frequencies.size() - 2);
        int lastElement = frequencies.get(frequencies.size() - 1);

        if((firstElement == lastElement) || (firstElement == 1 && secondElement == lastElement)) {
            return true;
        }

        return firstElement == secondElement && secondElement == beforeLastElement && lastElement == beforeLastElement + 1;
    }
}
