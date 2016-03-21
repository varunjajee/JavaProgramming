package com.muks.IntrvAlgorithms.ReverseLargeFiles;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * - Created by mukthar.ahmed on 3/16/16.
 *
 * Link: ???
 *
 * Alternatively, Radix sort algorithm works with O(n) space
 * Link: http://www.codeproject.com/Articles/490755/Sorting-Variable-Length-Strings-in-O-N-Time
 *
 */

class ReverseLineReaderCore {
    private static final int BUFFER_SIZE = 8192;
    private final FileChannel fileChannel;
    private final String encoding;
    private long filePosition;
    private ByteBuffer byteBuffer;
    private int bufferPosition;         /** default value for int = -1, buffPosition starts at -1 */
    private byte lastLineBreak = '\n';
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


    public ReverseLineReaderCore(File file, String encoding) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        fileChannel = raf.getChannel();
        filePosition = raf.length();
        System.out.println("+ File Length=" + filePosition);
        this.encoding = encoding;

        System.out.println("\n Calling contructor() initialises: [ FilePosition = " + filePosition
        +", BufferPosition=" + bufferPosition + " ]");
    }


    public String readLine() throws IOException {
        System.out.println("\n+ readLine()...");

        System.out.println("Start: [FilePosition=" + filePosition + ", BufferPosition=" + bufferPosition + "]");

        while (true) {

            if (bufferPosition < 0) {
                System.out.println("+ To start with, buffer position = " + bufferPosition);
                if (filePosition == 0) {
                    if (byteArrayOutputStream == null) {
                        return null;
                    }
                    String line = bufferToString();
                    byteArrayOutputStream = null;
                    return line;
                }

                long start = Math.max(filePosition - BUFFER_SIZE, 0);
                long end = filePosition;
                long len = end - start;

                System.out.println("+ Start=" + start + ", End=" + end);

                byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, start, len);
                bufferPosition = (int) len;
                filePosition = start;
            }

            while (bufferPosition-- > 0) {
                byte c = byteBuffer.get(bufferPosition);
                if (c == '\r' || c == '\n') {
                    if (c != lastLineBreak) {
                        lastLineBreak = c;
                        continue;
                    }
                    lastLineBreak = c;
                    return bufferToString();
                }

                byteArrayOutputStream.write(c);
            }
        }
    }

    private String bufferToString() throws UnsupportedEncodingException {
        if (byteArrayOutputStream.size() == 0) {
            return "";
        }

        byte[] bytes = byteArrayOutputStream.toByteArray();


        /** Todo (note): Need to reverse as we are reading the line from backward */
        for (int i = 0; i < bytes.length / 2; i++) {
            byte t = bytes[i];
            bytes[i] = bytes[bytes.length - i - 1];
            bytes[bytes.length - i - 1] = t;
        }

        byteArrayOutputStream.reset();

        return new String(bytes, encoding);
    }


    public static void swapBytes(byte[] bytes, int st, int end) {
        byte tmp = bytes[st];
        bytes[st] = bytes[end];
        bytes[end] = tmp;
    }
}
