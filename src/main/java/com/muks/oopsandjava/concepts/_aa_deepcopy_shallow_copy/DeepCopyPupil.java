package com.muks.oopsandjava.concepts._aa_deepcopy_shallow_copy;

/**
 * Created by mukthar.ahmed on 5/5/16.
 */
public class DeepCopyPupil implements Cloneable {
// Contained object
private Subject subj;
    private String name;
    /** * @return the subj */
    public Subject getSubj() {
        return subj;
    }

    /** * @param subj * the subj to set */
    public void setSubj(Subject subj) {
        this.subj = subj;
    }

    /** * @return the name */
    public String getName() {
        return name;
    }

    /** * @param name * the name to set */
    public void setName(String name) {
        this.name = name;
    }

    public DeepCopyPupil(String name, String sub) {
        this.name = name;
        this.subj = new Subject(sub);
    }

    public Object clone() {
        // deep copy
        DeepCopyPupil pupil = new DeepCopyPupil(name, subj.getName());
        return pupil;
    }
}