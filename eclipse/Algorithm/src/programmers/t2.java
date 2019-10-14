import java.util.Arrays;

class Solution {
   public String solution(int n, String[] plates, int[] odo, int k, int[] drives) {
      String answer = ""; 
      int c = 0;
      while (c < k) {
         String[] re = find(n, plates, odo);
         odo[Integer.parseInt(re[1])] += drives[c];
         c++;
      }
      
      answer = find(n, plates, odo)[0];
      
      return answer;
   }

   public String[] find(int n, String[] plates, int[] odo) {
      int m_value = Integer.MAX_VALUE;
      int cnt = 0;

      for (int i = 0; i < n; i++) {
         m_value = Math.min(m_value, odo[i]);
      }

      for (int i = 0; i < n; i++) {
         if (m_value == odo[i]) {
            cnt++;
         }
      }
      String[] cs = new String[cnt];
      int a = 0;
      for (int i = 0; i < n; i++) {
         if (m_value == odo[i]) {
            cs[a] = plates[i];
            a++;
         }
      }

      Arrays.sort(cs);
      String[] result = new String[2];
      result[0] = cs[0];
      for (int i = 0; i < n; i++) {
         if(cs[0].equals(plates[i])) {
            result[1] = i+"";
         }
      }
      return result;
   }
}