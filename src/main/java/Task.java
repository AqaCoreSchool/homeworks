




public class Task {

    public static void main(String[] args) {


        String words = "Comparator Iterator";
        char[] values = words.toCharArray();

        for(int i=0; i<values.length; i++){
            int a = (int)(Math.random()*values.length);
            System.out.print(values[a]);
        }






    }
}
