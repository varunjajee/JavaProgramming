package com.muks.IntrvAlgorithms.UnixCommands;

import java.io.File;

/**
 * Created by mukthar.ahmed on 3/4/16.
 */
public class Cmds {
    public static void main(String[] args) {

        String currentWorkingDir = "user.dir";
        System.out.println(System.getProperty(currentWorkingDir));

        File dir = new File(System.getProperty(currentWorkingDir));
        String childs[] = dir.list();
        for(String child: childs){
            System.out.println(child);
        }
    }
}
