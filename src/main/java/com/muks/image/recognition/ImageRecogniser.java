//package com.muks.image.recognition;
//
///*
// * Created by mukthar.ahmed on 09/06/15.
// */
//
//import net.sourceforge.tess4j.Tesseract;
//import net.sourceforge.tess4j.TesseractException;
//
//import java.io.File;
//
//public class ImageRecogniser {
//
//    /*
//        Commad to install tesseract on mac:
//        brew install tesseract --all-languages
//     */
//    public static void lib(String[] args) {
//        //File imageFile = new File("/Users/mukthar.ahmed/Downloads/UseFull/longHair.jpg");
//        File imageFile = new File("/Users/mukthar.ahmed/Downloads/images.jpg");
//
//        Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
//        // Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping
//
//        try {
//            String result = instance.doOCR(imageFile);
//
//            System.out.println(result);
//        } catch (TesseractException e) {
//            System.err.println(e.getMessage());
//        }
//    }
//}
