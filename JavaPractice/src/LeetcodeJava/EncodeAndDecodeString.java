package LeetcodeJava;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {
    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str: strs){
            stringBuilder.append(str.length()).append("#").append(str);
        }
        return stringBuilder.toString();
    }

    public List<String> decode(String s) {
        int i=0;
        List<String> output = new ArrayList<>();
        while (i < s.length()){
            int j = s.indexOf('#', i);
            int count = Integer.parseInt(s.substring(i, j));
            output.add(s.substring(j+1, j+count+1));
            i = j+count+1;
        }
        return output;
    }

    public static void main(String[] args) {
        EncodeAndDecodeString encodeAndDecodeString = new EncodeAndDecodeString();
        List<String> strs = new ArrayList<>();
        strs.add("Hello");
        strs.add("World");
        strs.add("");
        strs.add("Encode#Decode");
        System.out.println(strs);
        String encoded = encodeAndDecodeString.encode(strs);
        System.out.println(encoded);
        System.out.println(encodeAndDecodeString.decode(encoded));
    }
}
