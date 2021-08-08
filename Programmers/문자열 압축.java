public class Solution {
    public int solution(String s) {
      int min = s.length();

      for (int i = 1; i <= s.length() / 2; i++) {
        int compLeng = compression(s, i).length();
        min = Math.min(min, compLeng);
      }

      return min;
    }

  
    private String compression(String str, int i) {

      int count = 1;
      String compression = "";
      String pattern = "";

      for (int j = 0; j <= str.length() + i; j += i) {

        String nowStr;

        if (j >= str.length()) { // 현재 문자열이 없을 때
          nowStr = "";
        } else if (str.length() < j + i) { // 마지막 현재 문자열일 때
          nowStr = str.substring(j);
        } else {
          nowStr = str.substring(j, j + i); // 그 외
        }

        
        if (j != 0) {
          if (nowStr.equals(pattern)) { // 똑같으면
            count++;
          } else if (count >= 2) { // 다르고 count가 2회 이상이면 압축 가능
            compression += count + pattern;
            count = 1;
          } else { // 압축 불가능하면 그냥 그대로 문자열 이어붙이기
            compression += pattern;
          }
        }
        
        pattern = nowStr;
      }

      return compression;
    }

    @Test
    public void 정답() {
      Assert.assertEquals(7, solution("aabbaccc"));
      Assert.assertEquals(9, solution("ababcdcdababcdcd"));
      Assert.assertEquals(8, solution("abcabcdede"));
      Assert.assertEquals(14, solution("abcabcabcabcdededededede"));
      Assert.assertEquals(17, solution("xababcdcdababcdcd"));
    }
}
