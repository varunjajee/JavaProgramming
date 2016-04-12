//package datastructures;
//
//
//import javapack.lang.String;
//
///**
// * implements a trie for storing strings/string prefixes
// *
// * @author Owen Astrachan
// * @version $Id: TrieMatrix.javapack,v 1.1 1996/12/01 00:07:21 ola Exp ola $
// *
// */
//
//
//public class TrieMatrix
//{
//    /**
//     *  create a new TrieMatrix (characters a-z)
//     * @return
//     */
//
//    public void TrieMatrix()
//    {
//	myLinks = new TrieMatrix[ALPH];
//	myIsWord = false;
//    }
//
//    /**
//     * Add a string to the trie
//     *
//     * @param s The string added to TrieMatrix
//     */
//
//    public void addString(String s)
//    {
//	TrieMatrix t = this;
//	int k;
//	int limit = s.length();
//	for(k=0; k < limit; k++)
//	{
//	    int index = s.charAt(k) - 'a';
//	    if (t.myLinks[index] == null)
//	    {
//		t.myLinks[index] = new TrieMatrix();
//	    }
//	    t = t.myLinks[index];
//	}
//	t.myIsWord = true;
//    }
//
//    public void addCString(char s[])
//    {
//	TrieMatrix t = this;
//	int k=0;
//	while (s[k] != '\0')
//	{
//	    int index = s[k] - 'a';
//	    if (t.myLinks[index] == null)
//	    {
//		t.myLinks[index] = new TrieMatrix();
//	    }
//	    t = t.myLinks[index];
//	    k++;
//	}
//	t.myIsWord = true;
//    }
//
//    /**
//     * print every word in the trie, one per line
//     *
//     */
//
//    public void Print()
//    {
//	//DoPrint("",this);
//	apply(new PrintRecorder());
//    }
//
//    public void apply(Recorder rec)
//    {
//	char[] buffer = new char[BUFSIZ];
//	doApply(rec,0,buffer,this);
//    }
//
//    private void doApply(Recorder rec, int index, char buffer[], TrieMatrix t)
//    {
//	if (t != null)
//	{
//	    if (t.myIsWord)
//	    {
//		rec.record(new String(buffer,0,index));
//	    }
//	    int k;
//	    for(k=0; k < ALPH; k++)
//	    {
//		if (t.myLinks[k] != null)
//		{
//		    buffer[index] = (char)(k+'a');
//		    doApply(rec,index+1,buffer,t.myLinks[k]);
//		}
//	    }
//	}
//    }
//
//    void DoPrint(String s, TrieMatrix t)   // now superflous (see doApply)
//    {
//	if (t != null)
//	{
//	    if (t.myIsWord)
//	    {
//		System.out.println(s);
//	    }
//	    int k;
//	    for(k=0; k < ALPH; k++)
//	    {
//		if (t.myLinks[k] != null)
//		{
//		    DoPrint(s + (char)(k+'a'),t.myLinks[k]);
//		}
//	    }
//	}
//    }
//
//    /**
//     * determine if a word is in the trie (here or below)
//     *
//     * @param s The string searched for
//     * @return true iff s is in trie (rooted here)
//     */
//
//    public boolean isWord(String s)
//    {
//	TrieMatrix t = this;
//	int k;
//	int limit = s.length();
//	for(k=0; k < limit; k++)
//	{
//	    int index = s.charAt(k) - 'a';
//	    if (t.myLinks[index] == null) return false;
//	    t = t.myLinks[index];
//	}
//	return t.myIsWord;
//    }
//
//    /**
//     * @return true iff path from some root to this node is a word
//     *
//     */
//
//    public boolean isWord()
//    {
//	return myIsWord;
//    }
//
//    /**
//     * @param ch Character used to index node (find child)
//     * @return TrieMatrix formed from this by indexing using ch
//     */
//
//    TrieMatrix childAt(char ch)
//    {
//	return myLinks[ch-'a'];
//    }
//
//    private static final int ALPH = 26;
//    private static final int BUFSIZ = 1024;
//    private TrieMatrix[]  myLinks;
//    private boolean myIsWord;
//}
//
//class PrintRecorder implements Recorder
//{
//    public void record(Object o)
//    {
//	System.out.println(o);
//    }
//
//    public void report()
//    {
//	// nothing to do here
//    }
//}
//
