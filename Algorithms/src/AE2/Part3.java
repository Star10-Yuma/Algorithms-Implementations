package AE2;

public class Part3 {

    public int hashCode(String s) {
        int hash = 0;
        int skip = Math.max(1, s.length() / 3);
        for (int i = 0; i < s.length(); i += skip)
            hash = (hash * 37) + s.charAt(i);
        return hash;
    }


    public static void main(String[] args){
        Part3 part3 = new Part3();
        System.out.println(part3.hashCode("dd"));

    }


}
