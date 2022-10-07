public class Split1
{
    public static void main(String[] args)
    {
        String line = "http:/eas.asu/edu";

        String[] words = new String[3];

        //extract sub-strings using "/" as a delimiter, then the split methods returns an array of string.
        words = line.split("/");

        System.out.println("size " + words.length);
        for (int i=0; i<words.length; i++)
            System.out.println(words[i] + " with length " + words[i].length());



        //Here use are using the sting "http:/eas.asu/", thus there is no string to extract after the last "/"
       //An array containing two strings will be returned.
        line = "http:/eas.asu/";

        words = line.split("/");

        System.out.println("\nsize " + words.length);
        for (int i=0; i<words.length; i++)
            System.out.println(words[i] + " with length " + words[i].length());


        //Here by using the string "http//edu", thus there is no string to extract between two "/"s
       //An array containing three strings will be returned. The second string contains "" with length 0.
        line = "http://edu";

        words = line.split("/");

        System.out.println("\nsize " + words.length);
        for (int i=0; i<words.length; i++)
            System.out.println(words[i] + " with length " + words[i].length());
    }
}

