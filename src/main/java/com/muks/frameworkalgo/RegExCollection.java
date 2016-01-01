package com.muks.frameworkalgo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegExCollection {

	public static String getCustomMatch(String inputString, String regEx) {

		String mPattern = null;
		Pattern regex = Pattern.compile(regEx);
		Matcher regexMatcher = regex.matcher(inputString);

		while (regexMatcher.find()) {
			//System.out.println("PATTERN MATCHED: " + regexMatcher.group());
			mPattern = regexMatcher.group();
		}

		return mPattern;

	}	//


	public String matchImgSrcPatterntInXHTML(String inputString) {
		System.out.println("\n+ String to search: \n" + inputString);
		String mPattern = null;

		// to compile the regex => src="http:adoutput.inmobi.com/banner/inmobi/gifs/bang.png
		Pattern regexImageSrc = Pattern.compile("(src=\")+(http[s]?)?:(\\/\\/)?(\\w+)?(\\.)?(\\w+)+([-])?(\\w+)?(\\.)(\\w+)(/\\w+)+(.png)\"");

		Matcher regexMatcherImageSrc = regexImageSrc.matcher(inputString);

		if (regexMatcherImageSrc.find()) {
			System.out.println("PATTERN MATCHED: " + regexMatcherImageSrc.group());
			mPattern = regexMatcherImageSrc.group();
		}


		return mPattern;

	}	//
	
	public String matchImgSrcPattern(String inputString) {
		System.out.println("\n+ String to search: \n" + inputString);
		String mPattern = null;

		// to compile the regex => src="http:adoutput.inmobi.com/banner/inmobi/gifs/bang.png
		Pattern regexImageSrc = Pattern.compile("(src=\")+(http[s]?)?:(\\/\\/)?(\\w+)?(\\.)?(\\w+)+([-])?(\\w+)?(\\.)(\\w+)(/\\w+)+(.png)\"");

		Matcher regexMatcherImageSrc = regexImageSrc.matcher(inputString);

		if (regexMatcherImageSrc.find()) {
			System.out.println("PATTERN MATCHED: " + regexMatcherImageSrc.group());
			mPattern = regexMatcherImageSrc.group();
		}


		return mPattern;

	}	//


	public String matchImgSrcByIpPattern(String inputString) {
		System.out.println("\n+ String to search: \n" + inputString);
		String mPattern = null;

		// to compile the regex => src="http:adoutput.inmobi.com/banner/inmobi/gifs/bang.png
		Pattern regexImageSrcByIp = Pattern.compile("(src=\")+(http[s]?)?:(\\/\\/)?(\\d{1,2})+\\.(\\d{1,2})+\\.(\\d{1,2})+\\.(\\d{1,2})+(:\\d{1,4})?\\/(\\w+)+\\/(\\w+)?(/\\d{1,5})x(\\d{1,5})([_-])?(\\w+)?(\\.)(png|gif)+");
		Matcher regexMatcherImageSrcByIp = regexImageSrcByIp.matcher(inputString);

		if (regexMatcherImageSrcByIp.find()) {
			System.out.println("PATTERN MATCHED: " + regexMatcherImageSrcByIp.group());
			mPattern = regexMatcherImageSrcByIp.group();
		}

		return mPattern;

	}	//


	public String matchMRaidJsPattern(String inputString) {
		System.out.println("\n+ String to search: \n" + inputString);
		String mPattern = null;

		/* NOTE: 
		 * Matches below type of URLs
		 * String src="http:adoutput.inmobi.com/banner/inmobi/gifs/bang.png"
		 * String s = " var clickUrl = NULL";	
		 * */

		Pattern mriadJs = Pattern.compile("(<script src=\"(http[s]?)?):(\\/\\/)?(\\w+[-_]?)?(\\w+[-_]?)(.)(\\w+[-_]?)(.)(\\w+[-_]?)(.)?(\\w+)?(\\/)?(\\w+)?(\\/)+(.)+(js)+\">\\s<\\/script>");
		Matcher regexMraidJs = mriadJs.matcher(inputString);

		if (regexMraidJs.find()) {
			System.out.println("PATTERN MATCHED: " + regexMraidJs.group());
			mPattern = regexMraidJs.group();
		}

		return mPattern;

	}	//

	
	public String getPropKey(String inputString) {

		String mPattern = null;
		
		//Pattern regex = Pattern.compile("([a-zA-Z0-9]+[-|_]+[a-zA-Z0-9]+)|[a-zA-Z0-9]+|([A-Za-z]+[-][A-Za-z]+)");
		Pattern regex = Pattern.compile("([\\w\\d]*[-_]+[\\w]*[-_]*[\\w]*)|([a-zA-Z0-9]+)");
		Matcher regexMatcher = regex.matcher(inputString);

		while (regexMatcher.find()) {
			//System.out.println("PATTERN MATCHED: " + regexMatcher.group());
			mPattern = regexMatcher.group();
		}

		return mPattern;

	}	//
	
	
	public String matchLandingPage(String inputString) {
		System.out.println("\n+ LandingURL to search: \n" + inputString);
		String mPattern = null;

		/* NOTE: 
		 * Matches below type of URLs
		 * String s = " var clickUrl = 'http:\\/\\/adoutput.inmobi.com\\/clickUrl?at=2&am=1'";
		 * String s = " var clickUrl = NULL or null";	
		 * */
		
		Pattern landingUrl = Pattern.compile("(var landingUrl = )(\\'http[s]?)?:(\\\\\\/\\\\\\/)?(\\w+[-_]?)(.)(\\w+[-_]?)(.)(\\w+[-_]?)(\\\\\\/)(\\w+)(\\?)(\\w+)(=)?(\\d|\\w+[-_]?)?((\\&)?(\\w+)=(\\w+|\\d+))?\\'");
		Matcher regexLandingPage = landingUrl.matcher(inputString);

		if (regexLandingPage.find()) {
			System.out.println("PATTERN MATCHED: " + regexLandingPage.group());
			mPattern = regexLandingPage.group();
		}

		return mPattern;

	}	//
	
	
	public String matchNullClickURL(String inputString) {
		System.out.println("\n+ Null Click URL to search: \n" + inputString);
		String mPattern = null;

		/* NOTE: 
		 * Matches below type of URLs
		 * String s = " var clickUrl = 'http:\\/\\/adoutput.inmobi.com\\/clickUrl?at=2&am=1'";
		 * http://adoutput.inmobi.com/clickUrl
		 * */
		Pattern nullClickUrl = Pattern.compile("(\\s)+(var clickUrl = )((\\w+)+|muks|" +
				"((\\'http[s]?)?:(\\\\\\/\\\\\\/)?(\\w+[-_]?)(.)(\\w+[-_]?)(.)(\\w+[-_]?)(\\\\\\/)(\\w+)(\\?)(\\w+)(=)?(\\d|\\w+[-_]?)?((\\&)?(\\w+)=(\\w+|\\d+))?\\')?)" +
				"|((http[s]?):(\\/\\/)?(\\w+[-_]?)(.)(\\w+[-_]?)(.)(\\w+[-_]?)\\/clickUrl)?");
		
		Matcher regexNullClickUrl = nullClickUrl.matcher(inputString);

		if (regexNullClickUrl.find()) {
			System.out.println("PATTERN MATCHED: " + regexNullClickUrl.group());
			mPattern = regexNullClickUrl.group();
		}

		return mPattern;

	}	//

	
	public String matchClickURLInXHTML(String inputString) {
		System.out.println("\n+ Null Click URL to search: \n" + inputString);
		String mPattern = null;

		/* NOTE: 
		 * http://adoutput.inmobi.com/clickUrl
		 * <a href="http://adoutput.inmobi.com/clickUrl"
		 * */
		Pattern nullClickUrl = Pattern.compile("(<a href=\"http[s]?):(\\/\\/)?(\\w+[-_]?)(.)?(\\w+[-_]?)(.)?(\\w+[-_]?)/clickUrl\""); //(\\w+[-_]?)\\/clickUrl)?");
		
		Matcher regexNullClickUrl = nullClickUrl.matcher(inputString);

		if (regexNullClickUrl.find()) {
			System.out.println("PATTERN MATCHED: " + regexNullClickUrl.group());
			mPattern = regexNullClickUrl.group();
		}

		return mPattern;

	}	//
	

	public String matchBeaconURL(String inputString) {
		System.out.println("\n+ Null Click URL to search: \n" + inputString);
		String mPattern = null;

		/* NOTE: 
		 * Matches below type of URLs
		 * String s = "	img src="http://adoutput.inmbi.com/beaconUrl?m=18" "
		 * */

		Pattern beasconUrl = Pattern.compile("(img src=\")+(http[s]?)?:(\\/\\/)?(\\w+)+([-])?(\\.)?(\\w+)+([-])?(\\w+)?(\\.)(\\w+)/(beaconUrl)(\\?)?(m=18)\"");
		Matcher regexBeaconUrl = beasconUrl.matcher(inputString);

		if (regexBeaconUrl.find()) {
			System.out.println("PATTERN MATCHED: " + regexBeaconUrl.group());
			mPattern = regexBeaconUrl.group();
		}

		return mPattern;

	}	//
	
	public String matchBeaconURLInXHTML(String inputString) {
		System.out.println("\n+ Null Beacon URL to search: \n" + inputString);
		String mPattern = null;

		/* NOTE: 
		 * Matches below type of URLs
		 * String s = "	img src="http://adoutput.inmbi.com/beaconUrl?m=18" "
		 * */

		Pattern beasconUrl = Pattern.compile("(img src=\")+(http[s]?)?:(\\/\\/)?(\\w+)+([-])?(\\.)?(\\w+)+([-])?(\\w+)?(\\.)(\\w+)/(beaconUrl)(\\?)?(m=18)\"");
		Matcher regexBeaconUrl = beasconUrl.matcher(inputString);

		if (regexBeaconUrl.find()) {
			System.out.println("PATTERN MATCHED: " + regexBeaconUrl.group());
			mPattern = regexBeaconUrl.group();
		}

		return mPattern;

	}	//
	
	
	public String matchClickASyncURLInXHTML(String inputString) {
		System.out.println("\n+ match Click ASync URL In XHTML URL to search: \n" + inputString);
		String mPattern = null;

		/* NOTE: 
		 * Matches below type of URLs
		 * String s = "newIframe(\'http:\\/\\/adoutput.inmobi.com\\/clickUrl?at=1&am=0\');";
		 * */
		
		Pattern beasconUrl = Pattern.compile("(newIframe\\('(http[s]?)?:(\\\\/\\\\/)?(\\w+)+([-])?(\\.)?(\\w+)+([-])?(\\.)?(\\w+)+([-])?(\\.)?(\\\\/)?)(\\w+)+([-])?(\\?)(\\w+[-_]?)+(=)(\\d{1,5})?(\\&)(\\w+[-_]?)+(=)(\\d{1,5})?'\\);");
		Matcher regexBeaconUrl = beasconUrl.matcher(inputString);

		if (regexBeaconUrl.find()) {
			System.out.println("PATTERN MATCHED: " + regexBeaconUrl.group());
			mPattern = regexBeaconUrl.group();
		}

		return mPattern;

	}	//
	
	public String matchPlainBeacon(String inputString) {
		System.out.println("\n+ match Click ASync URL In XHTML URL to search: \n" + inputString);
		String mPattern = null;

		/* NOTE: 
		 * Matches below type of URLs
		 * http://adoutput.inmbi.com/cscBeaconUrl
		 * */
		
		Pattern beasconUrl = Pattern.compile("(img src=\")+(http[s]?)(:)+(\\/\\/)?(\\w+[-_]?)?(.)(\\w+[-_]?)?(.)(\\w+[-_]?)?(\\/)+(cscBeaconUrl)+\"");
		Matcher regexBeaconUrl = beasconUrl.matcher(inputString);

		if (regexBeaconUrl.find()) {
			System.out.println("PATTERN MATCHED: " + regexBeaconUrl.group());
			mPattern = regexBeaconUrl.group();
		}

		return mPattern;

	}	//
	
	public boolean iSHtmlbody(String inputString) {
		System.out.println("\n+ RegEx Testing: \n" + inputString);
		String mPattern = null;

		Pattern beasconUrl = Pattern.compile("^(<body>|</body>|<script.*/>$|<script.*</script>$|<AdResponse>.*)|(.*</AdResponse>$)");
		Matcher regexBeaconUrl = beasconUrl.matcher(inputString);

		if (regexBeaconUrl.find()) {
			
			System.out.println("PATTERN MATCHED: " + regexBeaconUrl.group());
			mPattern = regexBeaconUrl.group();
			System.out.println("+ Matched pattern is: [" + mPattern + "]" );
			
			return true;
			
		}

		return false;

	}	//
	
	public static void main(String[] args) {
		//String s = "[Path-PA]";
		//String s = "[REQ_EXTRACTOR_SCHEMA]";
		//String s = "[EXTRACTOR123]";

		//String s = "	<script src=\"http://cdn-a.inmobi.com/android/mraid.js\"> </script>			";
		//String s = "<script src=\"http://inmobisdk-a.akamaihd.net/sdk/android/mraid.js\"> </script>";
		//String s = "src=\"http://10.14.124.230:8080/psowebapp/images/320x50_banner.png";

		//String s = "/><img border='0' src=\"http://adoutput.inmobi.com/banner.png\" /><img border='0' ";
		//String s = "src=\"http://adoutput.inmobi.com/banner.png\"";
		//String s = "src=\"http://10.14.124.230:8080/psowebapp/images/320x50_banner.png";
		
		//String s = "img src=\"http://adoutput.inmbi.com/beaconUrl?m=18\"";
		//String s = " var clickUrl = NULL";
		//String s = "img src=\"http://adoutput.inmbi.com/beaconUrl?m=18\"";
		//String s = "]]></Ad></Ads></AdResponse>";
		//String s = "<a href=\"http://adoutput.inmobi.com/clickUrl\"";
		
		//String s = "newIframe(\'http:\\/\\/adoutput.inmobi.com\\/clickUrl?at=1&am=0\');";
		String s = "img src=\"http://adoutput.inmbi.com/cscBeaconUrl\"";
		RegExCollection test = new RegExCollection();
		
		String regexMap = test.matchPlainBeacon(s);
		System.out.println("\n Match: " + regexMap);
		
		//System.out.println("+++ FOUND: " + test.iSHtmlbody(s) );

	}	



}	// end RegExFactory
