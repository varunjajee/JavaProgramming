package com.muks.oopsandjava.concepts._aa_deepcopy_shallow_copy;

/**
 * Created by mukthar.ahmed on 5/5/16.
 */
public class ShallowCopyPupil implements Cloneable {

    private Subject subj;
    private String name;

    public Subject getSubj() { return subj; }

    public void setSubj(Subject subj) {
        this.subj = subj;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public ShallowCopyPupil(String name, String sub) {
        this.name = name;
        this.subj = new Subject(sub);
    }
    public Object clone() {
        // shallow copy
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // Original Object
        ShallowCopyPupil stud = new ShallowCopyPupil("Johnathan", "Algebra");
        System.out.println("Original Object: " + stud.getName()
            + " - " + stud.getSubj().getName() );

        // Clone Object
         ShallowCopyPupil clonedStud = (ShallowCopyPupil) stud.clone(); System
         .out.println("Cloned Object: " + clonedStud.getName() + " - " + clonedStud.getSubj().getName());
        stud.setName("Daniel"); stud.getSubj().setName("Physics");
        System.out.println("Original Object after it is updated: " + stud.getName() + " - " + stud.getSubj().getName());
        System.out.println("Cloned Object after updating original object: " + clonedStud.getName() + " - " + clonedStud.getSubj().getName());

    }
}
