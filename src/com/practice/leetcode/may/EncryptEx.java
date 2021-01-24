package com.practice.leetcode.may;

public class EncryptEx {

    // Complete the encryption function below.
    static String encryption(String s) {
        String str = s.trim().replace(" ", "");
        float l = str.length();
        int r = (int)Math.floor(Math.sqrt(l));
        int c = (int)Math.ceil(Math.sqrt(l));

        StringBuilder sb = new StringBuilder();

        if((r*c)<l){
            r=c;
        }

        for(int i=0; i<c; i++){
            int idx = i;
            while (idx<l){
                sb.append(str.charAt(idx));
                idx += c;
            }
            sb.append(" ");
        }

        String res = sb.toString();
        System.out.println(res.trim());
        return res;
    }

    public static void main(String[] args) {
        //String s = "if man was meant to stay on the ground god would have given us roots";
        String s = "chillout";
        String str = encryption(s);
    }

    /*private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }*/
}
