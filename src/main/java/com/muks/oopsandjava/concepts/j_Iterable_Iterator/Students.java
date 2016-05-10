package com.muks.oopsandjava.concepts.j_Iterable_Iterator;

/**
 * Created by mukthar.ahmed on 5/10/16.
 */
import java.util.Iterator;

/**
 * Example of an Iterable implementation
 */
class Students implements Iterable<String> {

    private String[] list;

    /**
     * Initialize the array of student with a custom capacity
     * @param capacity Size of the array of students
     */
    public Students(int capacity) {
        list = new String[capacity];
    }

    /**
     * Add a new student name to the list
     * @param pos Position into the array
     * @param name Name of the student
     */
    public void add(int pos, String name) {

        if (pos >= list.length || pos < 0)
            throw new ArrayIndexOutOfBoundsException();

        list[pos] = name;
    }

    /**
     * Implementation of the iterator to be returned in order to
     * iterate on the student list
     */
    private static final class MyIterator implements Iterator<String>{

        private Students students;
        private int count;

        /**
         * Initialize the iterator with the outer class, in order
         * to be able to move though the list of students
         * @param students Outer class reference
         */
        public MyIterator(Students students) {
            this.students = students;
        }

        /**
         * Check if there are other items in the list
         * @return true if other students are present, else false
         */
        @Override
        public boolean hasNext() {
            if (count < students.list.length)
                return true;

            return false;
        }

        /**
         * Retrieve next student from the list
         * @return Next student
         */
        @Override
        public String next() {
            return students.list[count++];
        }

        /**
         * remove a student (at the moment unsupported)
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Create a new iterator for the client
     * @return Iterator
     */
    @Override
    public Iterator<String> iterator() {
        return new MyIterator(this);
    }
}


