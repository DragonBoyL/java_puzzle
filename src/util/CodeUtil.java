package util;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {
    public static String getCode(){
        //创建集合包含所有字母
        ArrayList<Character> list=new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        //随机生成四个字母
        String result="";
        Random r=new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            char c=list.get(index);
            result+=c;
        }
        //拼接一个数字
        int num=r.nextInt(10);
        result+=num;
        //字符串转换成字符数组，
        char[] chars=result.toCharArray();
        //随机索引，与数字交换
        int randomIndex = r.nextInt(5);
        char temp=chars[randomIndex];
        chars[randomIndex]=chars[4];
        chars[4]=temp;
        String code=new String(chars);

        return code;
    }
}
