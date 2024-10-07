import java.util.HashMap;
import java.util.Map;

public class d
{
    public static int getCycleLength(int n){
        Map<Integer,Integer> stateToIter = new HashMap<Integer,Integer>();
        int state = 1;
        int iter = 0;
        while (!stateToIter.containsKey(state))
        {
            System.out.println(state + " " + iter);
            stateToIter.put(state, iter);
            state = state * 10 % n;
            iter++;
        }
        System.out.println(iter + " - " + stateToIter.get(state));
        return iter - stateToIter.get(state);
    }
    public static void main(String[] args) {
        System.out.println(getCycleLength(7));
    }
}