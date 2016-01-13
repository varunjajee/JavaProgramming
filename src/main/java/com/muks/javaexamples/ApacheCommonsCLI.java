package com.muks.javaexamples;


import org.apache.commons.cli.*;

/*
 * Created by mukthar.ahmed on 23/09/15.
 *
 * Usage:
 * javapack -cp mtap-lens-1.0-SNAPSHOT.jar com.inmobi.pso.mtap.lens.ApacheCommonsCLI -configFile /usr/bin
 */
public class ApacheCommonsCLI {

    public static void main(String[] args) throws ParseException {
        new CLI(args).parse();
    }


    public static class CLI {
        private String[] args = null;
        private Options options = new Options();

        public CLI(String[] args) throws ParseException {
            this.args = args;
            //Options options = new Options();
            options.addOption("help", false, "Help!");
            options.addOption("version", false, "1.0");
            options.addOption("configFile", true, "Input config file");

        }

        public void parse() throws ParseException {
            // add t option

            // create the parser
            CommandLineParser parser = new DefaultParser();
            try {
                // parse the command line arguments
                CommandLine line = parser.parse(options, args);

                // has the buildfile argument been passed?
                if (line.hasOption("configFile")) {
                    System.out.println(line.getOptionValue("configFile"));
                }

                if (line.getOptions().length == 0 || line.hasOption("help")) {
                    helpFormatter();
                }

            } catch (ParseException exp) {
                helpFormatter();
                // oops, something went wrong
                System.err.println("Parsing failed.  Reason: " + exp.getMessage());
            }


        }

        public void helpFormatter() {
            String helpWithUsageText =
                "java -cp com.muks.javaexamples.ApacheCommonsCLI -configFile <config-file>";

            // automatically generate the help statement
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(helpWithUsageText, options);
        }
    }
}
