import edu.duke.FileResource;

import java.util.ArrayList;

//test files in RandomStoryData folder
public class WordFrequencies {

    private ArrayList<String> myWord;
    private ArrayList<Integer> myFreqs;
    private FileResource fileResource;

    public WordFrequencies(){
        myWord = new ArrayList<>();
        myFreqs = new ArrayList<>();
        fileResource = new FileResource();
    }


    public void findUnique(){
        for(String words : fileResource.words()){
            words = words.toLowerCase();
            int index = myWord.indexOf(words);
            if(index == -1){
                myWord.add(words);
                myFreqs.add(1);
            } else {
                int value = myFreqs.get(index);
                myFreqs.set(index,value+1);
            }
        }
    }


    public int findIndexOfMax() {
        findUnique();
        int value = 0;
        int index = 0;
        for (int i = 0; i < myFreqs.size(); i++) {
            if (myFreqs.get(i) > value) {
                value = myFreqs.get(i);
                index = i;
            }
        }
        return index;
    }


    public void tester(){
        int index = findIndexOfMax();
        System.out.println("Number of uniqe words " + myWord.size());
        for (int i = 0; i < myWord.size(); i++) {
            System.out.println(myFreqs.get(i) +"\t" + myWord.get(i));
        }
        System.out.println("The word that occurs most often and its count are: " + myFreqs.get(index) + " " + myWord.get(index));
    }

}

class WordFrequenciesMain{
    public static void main(String[] args) {
        WordFrequencies wf = new WordFrequencies();
        wf.tester();
    }
}