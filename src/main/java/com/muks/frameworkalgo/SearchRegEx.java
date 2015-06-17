package frameworkalgo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sun.tools.doclets.internal.toolkit.util.DirectoryManager;

public class SearchRegEx {

	/**
	 * @param args
	 * @throws IOException 
	 */

	String mriadURL = "<script src=\"http://inmobisdk-a.akamaihd.net/sdk/android/mraid.js\"> </script>";
	String clickURL = "var clickUrl = 'http://10.14.100.249/:8080/psowebapp/Click?test=2&release=sdk360&responsetype=xhtml&platform=android'";
	String clickUrlXHTML = "http://10.14.100.249:8080/psowebapp/Click?test=2&release=sdk360&responsetype=xhtml_sync&platform=android";
	String clickRedirect = "\"http://10.14.100.249:8080/psowebapp/clickredirect\"";
	String clickRedirectXhtml = "<a href=\"http://10.14.100.249:8080/psowebapp/clickredirect\"";
	String landingURL = "var landingUrl = 'http://www.inmobi.com'";	//  var landingUrl =
	//String landingURL = "var landingUrl = 'http://10.14.100.249:8080/psowebapp/clickredirect'";
	String imageSrcURL = "src=\"http://10.14.100.249:8080/psowebapp/images/banner_320x48.png\"";
	String beaconURL = "img src=\"http://10.14.100.249:8080/psowebapp/Beacon?test=3&release=imai_sync&responsetype=imai_sync&platform=android&m=18\"";
	//String clickASyncXhtmlUrl = "newIframe('http:\\/\\/adoutput.inmobi.com\\/clickUrl?at=1&am=0');";
	String clickASyncXhtmlUrl = "newIframe('http:\\/\\/10.14.100.249:8080\\/psowebapp\\/Click?test=2&release=sdk360&responsetype=xhtml&platform=android&at=1&am=0');";
	//	<a href="http://adoutput.inmobi.com/clickUrl"
	String clickSyncXhtmlUrl = "<a href=\"http://10.14.100.249:8080/psowebapp/Click?test=2&release=sdk360&responsetype=xhtml_sync&platform=android\"";
	String beaconXhtmlURL = "img src=\"http://10.14.100.249:8080/psowebapp/Beacon?test=3&release=sdk360&responsetype=xhtml_sync&platform=android&m=18\"";
	String beaconM101 = "img src=\"http://10.14.100.249:8080/psowebapp/Beacon?test=testAndroidTemplate1&release=imai_async&platform=android&m=101\"";
	
	public static void main(String[] args) throws IOException {
		SearchRegEx reg = new SearchRegEx();
		//String myDir = "/Users/muktharahmed/Data2/toDelete/banner_320X48_300X50.new";
		String myDir = "/Users/muktharahmed/Data2/git/QA/muks-org-psotest/test-automation/psowebapp/src/main/resources/responses/xhtml_sync/android";
		//String myDir = "/Users/muktharahmed/Data2/git/QA/muks-org-psotest/test-automation/psowebapp/src/main/resources/responses/imai_async/android";

		List<File> files = getFilesList(myDir, "files");
		System.out.println("+ total number of files: " + files.size());

		for (File f : files) {
			System.out.println("+ Files: " + f.toString());
			//reg.searchAndReplaceInIMAI(f);
			//reg.searchAndReplaceInXHTML(f);
			//reg.searchAndReplaceInASyncXHTML(f);
			//reg.searchAndReplaceInSyncXHTML(f);
			reg.searchAndReplacePlainBeaconURL(f);
		}

		String infile = "/Users/muktharahmed/Downloads/banner_320X48_300X50.new";
		//reg.searchAndReplaceInIMAI(new File(infile));
		//reg.searchAndReplaceInSyncXHTML(new File(infile));
		//reg.searchAndReplaceInASyncXHTML(new File(infile));
		reg.searchAndReplacePlainBeaconURL(new File(infile));

	}	// main()

	
	// searchAndReplace:  to search for a string within a file and replace
		public void searchAndReplacePlainBeaconURL (File inFile) throws IOException {

			System.out.println("\n+++ Search and replace block +++");
			System.out.println("\n+ File: " + inFile);

			File backedFile = fileCopy(inFile);		// back up the file

			//boolean wasReplaced = false;
			String line = null;
			RegExCollection regEx = new RegExCollection();		// reg-ex collector class
			BufferedReader reader = new BufferedReader(new FileReader(backedFile));
			PrintWriter writer = new PrintWriter(new FileWriter(inFile));


			while ((line = reader.readLine()) != null) {

				line.trim();	// trimming trailing characters
				if (!line.matches("^\\s*$") ) {			// skip blank lines
					//System.out.println("+ Line: "+ line);


					String planBeaconURLMatch = regEx.matchPlainBeacon(line);
					if (planBeaconURLMatch != null) {
						System.out.println("\n+ Plan Beacon URL: " + planBeaconURLMatch);
						line = line.replace(planBeaconURLMatch, beaconM101);
					}

					writer.println(line);	// write the buffered line with searched & replaced pattern.

				}

			}

			// close the file handlers
			reader.close();
			writer.close();

		}	// end searchAndReplace()

	
	// ####################################################################################################
	// searchAndReplace:  to search for a string within a file and replace
	public void searchAndReplaceInASyncXHTML (File inFile) throws IOException {

		System.out.println("\n+++ Search and replace block +++");
		System.out.println("\n+ File: " + inFile);

		File backedFile = fileCopy(inFile);		// back up the file

		//boolean wasReplaced = false;
		String line = null;
		RegExCollection regEx = new RegExCollection();		// reg-ex collector class
		BufferedReader reader = new BufferedReader(new FileReader(backedFile));
		PrintWriter writer = new PrintWriter(new FileWriter(inFile));


		while ((line = reader.readLine()) != null) {

			line.trim();	// trimming trailing characters
			if (!line.matches("^\\s*$") ) {			// skip blank lines
				//System.out.println("+ Line: "+ line);


				String imageUrlMatchInxHTML = regEx.matchImgSrcPatterntInXHTML(line);
				if (imageUrlMatchInxHTML != null) {
					System.out.println("\n+ Image URL at xhtml file: " + imageUrlMatchInxHTML);
					line = line.replace(imageUrlMatchInxHTML, imageSrcURL);
				}

				String beaconUrlMatchInxHTML = regEx.matchBeaconURLInXHTML(line);
				if (beaconUrlMatchInxHTML != null) {
					System.out.println("\n+ Beacon URL at xhtml file: " + beaconUrlMatchInxHTML);
					line = line.replace(beaconUrlMatchInxHTML, beaconURL);
				}
				
				String clickUrlMatch = regEx.matchClickASyncURLInXHTML(line);
				if (clickUrlMatch != null) {
					System.out.println("\n+ Click URL at xhtml file: " + clickUrlMatch);
					line = line.replace(clickUrlMatch, clickASyncXhtmlUrl);
				}
				
				if (regEx.iSHtmlbody(line)) {
					writer.println(line);	// write the buffered line with searched & replaced pattern.
				}


			}

		}

		// close the file handlers
		reader.close();
		writer.close();

	}	// end searchAndReplace()

	
	// ####################################################################################################
	// searchAndReplace:  to search for a string within a file and replace
	public void searchAndReplaceInSyncXHTML (File inFile) throws IOException {

		System.out.println("\n+++ Search and replace block +++");
		System.out.println("\n+ File: " + inFile);

		File backedFile = fileCopy(inFile);		// back up the file

		//boolean wasReplaced = false;
		String line = null;
		RegExCollection regEx = new RegExCollection();		// reg-ex collector class
		BufferedReader reader = new BufferedReader(new FileReader(backedFile));
		PrintWriter writer = new PrintWriter(new FileWriter(inFile));


		while ((line = reader.readLine()) != null) {

			line.trim();	// trimming trailing characters
			if (!line.matches("^\\s*$") ) {			// skip blank lines
				//System.out.println("+ Line: "+ line);


				String imageUrlMatchInxHTML = regEx.matchImgSrcPatterntInXHTML(line);
				if (imageUrlMatchInxHTML != null) {
					System.out.println("\n+ Image URL at xhtml file: " + imageUrlMatchInxHTML);
					line = line.replace(imageUrlMatchInxHTML, imageSrcURL);
				}

				String beaconUrlMatchInxHTML = regEx.matchBeaconURLInXHTML(line);
				if (beaconUrlMatchInxHTML != null) {
					System.out.println("\n+ Beacon URL at xhtml file: " + beaconUrlMatchInxHTML);
					line = line.replace(beaconUrlMatchInxHTML, beaconXhtmlURL);
				}
				
				String clickUrlMatch = regEx.matchClickURLInXHTML(line);
				if (clickUrlMatch != null) {
					System.out.println("\n+ Click URL at xhtml file: " + clickUrlMatch);
					line = line.replace(clickUrlMatch, clickRedirectXhtml);
				}
				
				if (regEx.iSHtmlbody(line)) {
					writer.println(line);	// write the buffered line with searched & replaced pattern.
				}


			}

		}

		// close the file handlers
		reader.close();
		writer.close();

	}	// end searchAndReplace()


	public static List<File> getFilesList (String dirPath, String lookingFor) {
		File workingDir = new File(dirPath);

		List<File> fileList = new ArrayList<File>();
		List<File> dirList = new ArrayList<File>();

		for (File file : workingDir.listFiles()) {
			if (file.isDirectory()) {
				dirList.add(file);

			} else {
				fileList.add(file);

			}
		}

		if (lookingFor.equals("files")) {
			return fileList;
		} else {
			return dirList;
		}

	}

	// ####################################################################################################
	// searchAndReplace:  to search for a string within a file and replace
	public void searchAndReplaceInIMAI (File inFile) throws IOException {

		System.out.println("\n+++ Search and replace block +++");
		System.out.println("\n+ File: " + inFile);

		File backedFile = fileCopy(inFile);		// back up the file

		//boolean wasReplaced = false;
		String line = null;
		RegExCollection regEx = new RegExCollection();		// reg-ex collector class
		BufferedReader reader = new BufferedReader(new FileReader(backedFile));
		PrintWriter writer = new PrintWriter(new FileWriter(inFile));


		while ((line = reader.readLine()) != null) {

			line.trim();	// trimming trailing characters
			if (!line.matches("^\\s*$") ) {			// skip blank lines
				//System.out.println("+ Line: "+ line);

				String landingUrlMatch = regEx.matchLandingPage(line);
				if (landingUrlMatch != null) {
					System.out.println("\n landingUrlMatch: " + landingUrlMatch);
					line = line.replace(landingUrlMatch, landingURL);
					//line = line.replace(landingUrlMatch, " var landingUrl = \'LANDING-PAGE\'" );		// for special cases like back slash should be replace rather replaceAll()
				}

				String clickUrlMatch = regEx.matchNullClickURL(line);
				if (clickUrlMatch != null) {
					System.out.println("\n+ clickUrlMatch: " + clickUrlMatch);
					line = line.replace( clickUrlMatch, clickURL);
					//line = line.replace( clickUrlMatch, " var clickUrl = CLICK-URL" );
				}

				String imgSrcMatch = regEx.matchImgSrcPatterntInXHTML(line);
				if (imgSrcMatch != null) {
					System.out.println("\n+ Image search match: " + imgSrcMatch);
					line = line.replace(imgSrcMatch, imageSrcURL);
					//line = line.replace(imgSrcMatch, "src=IMAGE-SOURCE");
				}

				String imgSrcByIpMatch = regEx.matchImgSrcByIpPattern(line);
				if (imgSrcByIpMatch != null) {
					System.out.println("\n+ Image search by Ip: " + imgSrcByIpMatch);
					line = line.replace(imgSrcByIpMatch, imageSrcURL);
					//line = line.replace(imgSrcByIpMatch, "src=IMAGE-SOURCE");
				}

				String mraidJsUrlMatch = regEx.matchMRaidJsPattern(line);
				if (mraidJsUrlMatch != null) {
					System.out.println("\n+ MRaid URL: " + mraidJsUrlMatch);
					//line = line.replace(mraidJsUrlMatch, "<script src='MRAID-URL'");
					line = line.replace(mraidJsUrlMatch, mriadURL);
				}

				String beaconUrlMatch = regEx.matchBeaconURL(line);
				if (beaconUrlMatch != null) {
					System.out.println("\n+ MRaid URL: " + beaconUrlMatch);
					line = line.replace(beaconUrlMatch, beaconURL);
					//line = line.replace(beaconUrlMatch, "img src=BEACON-URL");
				}

				if (regEx.iSHtmlbody(line)) {
					writer.println(line);	// write the buffered line with searched & replaced pattern.
				}


			}

		}

		// close the file handlers
		reader.close();
		writer.close();

	}	// end searchAndReplace()


	// ####################################################################################################
	// fileCopy:  if 2nd arg not specified, copies to .bak file
	public File fileCopy (File sourceFile) throws IOException {

		File destFile = new File(sourceFile + ".bak");

		if(!destFile.exists()) {
			destFile.createNewFile();
		}

		FileChannel source = null;
		FileChannel destination = null;

		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		}
		finally {
			if(source != null) {
				source.close();
			}

			if(destination != null) {
				destination.close();
			}
		}

		return destFile;
	}


	// ####################################################################################################
	// fileCopy:  Copies to the given dest file name. If 2nd arg not specified, copies to .bak file
	public File fileCopy (File sourceFile, File destFile) throws IOException {

		if(!destFile.exists()) {
			destFile.createNewFile();
		}

		FileChannel source = null;
		FileChannel destination = null;

		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		}

		finally {
			if(source != null) {
				source.close();
			}
			if(destination != null) {
				destination.close();
			}
		}

		return destFile;
	}


}	// end class()
