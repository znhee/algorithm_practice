package implementation;

public class Main_JadenCase {

	public String solution(String s) {
        String answer = "";
        String[] word = s.split(" ");
        
        for(int i=0; i<word.length; i++) {
            String str = word[i];
            if(str.length() == 0) {
                answer += " ";
            } else {
                answer += str.substring(0, 1).toUpperCase();
                answer += str.substring(1, str.length()).toLowerCase();
                answer += " ";
            }
        }
        if(s.substring(s.length()-1, s.length()).equals(" ")) {
            return answer;
        }
        return answer.substring(0, answer.length()-1);
    }

}
