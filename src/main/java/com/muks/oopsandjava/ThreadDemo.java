package oops;

/**
 * Created by mukthar.ahmed on 14/10/14.
 */
public class ThreadDemo
{
    public static void main(String args[])
    {
        //Creating an object of the first thread
        FirstRunnableThread firstThread = new FirstRunnableThread();

        //Creating an object of the Second thread
        SecondRunnableThread secondThread = new SecondRunnableThread();

        //Starting the first thread
        Thread thread1 = new Thread(firstThread);
        thread1.start();

        //Starting the second thread
        Thread thread2 = new Thread(secondThread);
        thread2.start();
    }
}
