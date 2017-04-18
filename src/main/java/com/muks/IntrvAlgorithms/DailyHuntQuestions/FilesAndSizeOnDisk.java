package com.muks.IntrvAlgorithms.DailyHuntQuestions;

import java.util.*;
import java.util.List;

/**
 * Created by 300000511 on 11/04/17.
 *  -
 */

public class FilesAndSizeOnDisk {

    public static void main(String[] args) {
        String input = "\"my.song.mp3 11b\n" +
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov!e.mkv 10000b\"";

        String input2 = "'my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b'";

        System.out.println(new FilesAndSizeOnDisk().solution(input2));
    }



    private MusicFiles MusicFileListing;
    private MovieFiles MovieFileListing;
    private ImageFiles ImageFileListing;
    private OtherFiles OtherFileListing;

    private HashMap<String, Integer> ImageFiles = new HashMap<>();
    private HashMap<String, Integer> VideoFiles = new HashMap<>();
    private HashMap<String, Integer> OtherFiles = new HashMap<>();

    private List<String> MusicFileExtensions;
    private List<String> ImgFileExtensions;
    private List<String> MovieFileExtensions;


    {
        this.MusicFileListing = new MusicFiles();
        this.MovieFileListing = new MovieFiles();
        this.ImageFileListing = new ImageFiles();
        this.OtherFileListing = new OtherFiles();

        // extension details
        this.MusicFileExtensions = new ArrayList<>(Arrays.asList("mp3", "aac", "flac"));
        this.ImgFileExtensions = new ArrayList<>(Arrays.asList("jpg", "bmp", "gif"));
        this.MovieFileExtensions = new ArrayList<>(Arrays.asList("mp4", "avi", "mkv"));
    }

    public String solution(String input) {
        String trimmedInput = input.replace("\"", "");
        trimmedInput = trimmedInput.replace("\'", "");

        System.out.println(trimmedInput + "\n\n");


        String[] lines = trimmedInput.split("\\n");
        for (int i = 0; i < lines.length; i++) {
            String[] fileDetails = lines[i].split(" ");

            String fileName = fileDetails[0];
            // convert size element by comping off the 'b' from the string
            int sizeInBytes =  Integer.parseInt(
                    fileDetails[1].substring(0, fileDetails[1].length()-1)
            );


            String[] fileNameSplit = fileName.split("\\.");
            String fileExtension = fileNameSplit[fileNameSplit.length-1];

            if ( MusicFileExtensions.contains( fileExtension ) ) {
                this.MusicFileListing.addFile(fileName, sizeInBytes);
            }
            else if ( ImgFileExtensions.contains( fileExtension ) ) {
                this.ImageFileListing.addFile(fileName, sizeInBytes);
            }
            else if ( MovieFileExtensions.contains( fileExtension ) ) {
                this.MovieFileListing.addFile( fileName, sizeInBytes );
            }
            else {
                this.OtherFileListing.addFile(fileName, sizeInBytes);
            }
        }


        StringBuilder soln = new StringBuilder("");
        soln.append(MusicFileListing.toString() + "\n");
        soln.append(ImageFileListing.toString() + "\n");
        soln.append(MovieFileListing.toString() + "\n");
        soln.append(OtherFileListing.toString());
        soln.append("");

        return soln.toString();
    }



    private class MusicFiles {
        private HashMap<String, Integer> MusicFiles = new HashMap<>();

        MusicFiles() {
            this.MusicFiles = new HashMap<>();
        }

        void addFile(String fileName, int sizeOnDisk) {
            this.MusicFiles.put(fileName, sizeOnDisk);
        }

        public String toString() {
            int sizeOnDisk = 0;
            Set<String> keys = this.MusicFiles.keySet();
            for (String key : keys) {
                sizeOnDisk += MusicFiles.get(key);
            }
            return "music " + sizeOnDisk + "b";
        }
    }


    private class MovieFiles {
        private HashMap<String, Integer> MovieFiles = new HashMap<>();

        MovieFiles() {
            this.MovieFiles = new HashMap<>();
        }

        void addFile(String fileName, int sizeOnDisk) {
            this.MovieFiles.put(fileName, sizeOnDisk);
        }

        public String toString() {
            int sizeOnDisk = 0;
            Set<String> keys = this.MovieFiles.keySet();
            for (String key : keys) {
                sizeOnDisk += MovieFiles.get(key);
            }
            return "movies " + sizeOnDisk + "b";
        }
    }


    private class ImageFiles {
        private HashMap<String, Integer> ImageFiles = new HashMap<>();

        ImageFiles() {
            this.ImageFiles = new HashMap<>();
        }

        void addFile(String fileName, int sizeOnDisk) {
            this.ImageFiles.put(fileName, sizeOnDisk);
        }

        public String toString() {
            int sizeOnDisk = 0;
            Set<String> keys = this.ImageFiles.keySet();
            for (String key : keys) {
                sizeOnDisk += ImageFiles.get(key);
            }
            return "images " + sizeOnDisk + "b";
        }
    }


    private class OtherFiles {
        private HashMap<String, Integer> OtherFiles = new HashMap<>();

        OtherFiles() {
            this.OtherFiles = new HashMap<>();
        }

        void addFile(String fileName, int sizeOnDisk) {
            this.OtherFiles.put(fileName, sizeOnDisk);
        }

        public String toString() {
            int sizeOnDisk = 0;
            Set<String> keys = this.OtherFiles.keySet();
            for (String key : keys) {
                sizeOnDisk += OtherFiles.get(key);
            }
            return "other " + sizeOnDisk + "b";
        }
    }

}
