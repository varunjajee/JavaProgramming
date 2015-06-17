package general;

import sun.misc.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Misc {

    public Misc() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String URL = "http://c.appsdt.com/click/phoenix/44546428-5dd6-4f7f-be44-0d3ed4017fe2?odin1={odin1}&udid={androidid_md5}&clickId={identifier}";
        String pattern = "\\{odin1\\}";
        Regexp regex = new Regexp(pattern);

//
//        if (URL.contains("{odin1}")) {
//            System.out.println("+++ FOUND... ");
//            replaced = URL.replace("\\{odin1\\}", "myodin1");
//
//
//        }

        String odin1Match = matchOdin1(URL);
        if (odin1Match != null) {
            System.out.println("\n+ ODIN1: " + odin1Match);
            URL = URL.replace( odin1Match, "MY-ODIN1" );
        }



        String androidIDMd5Match = matchAndroidIdMd5(URL);
        if (androidIDMd5Match != null) {
            System.out.println("\n+ AndroidId Md5: " + androidIDMd5Match);
            URL = URL.replace( androidIDMd5Match, "MY-ANDROIDID-MD5" );
        }

        System.out.println("Final: " + URL);
    }



    public static String matchOdin1(String inputString) {
        System.out.println("\n+ String to search in: \n" + inputString);
        String mPattern = null;
        Pattern regexOdin1FromUrl = Pattern.compile("(\\{odin1\\})");

        Matcher regexMatcherOdin1 = regexOdin1FromUrl.matcher(inputString);

        if (regexMatcherOdin1.find()) {
            System.out.println("PATTERN MATCHED: " + regexMatcherOdin1.group());
            mPattern = regexMatcherOdin1.group();
        }

        return mPattern;

    }	//


    public static String matchAndroidIdMd5(String inputString) {
        System.out.println("\n+ String to search in: \n" + inputString);
        String mPattern = null;
        Pattern regexAndoirdIdMd5 = Pattern.compile("(\\{androidid_md5\\})");

        Matcher regexMatcherOdin1 = regexAndoirdIdMd5.matcher(inputString);

        if (regexMatcherOdin1.find()) {
            System.out.println("PATTERN MATCHED: " + regexMatcherOdin1.group());
            mPattern = regexMatcherOdin1.group();
        }

        return mPattern;

    }	//


}




