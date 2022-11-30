import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class WordsInFiles {

    private HashMap<String, ArrayList<String>> myMap;

    public WordsInFiles() {
        myMap = new HashMap<>();
    }


    public void addWordsFromFile(File file){
        FileResource fResource = new FileResource(file);
        ArrayList<String> list;
        for (String words : fResource.words()){
  //          words = words.toLowerCase();
  //          String checkedWords = checkWords(words);
            if (!myMap.containsKey(words)){
                list = new ArrayList<>();
                list.add(file.getName());
                myMap.put(words,list);
            } else {
                list = myMap.get(words);
                list.add(file.getName());
                myMap.put(words,list);
            }
        }
    }

    private String checkWords(String words) {
        char lIndex = words.charAt(words.length() - 1);
        if(!Character.isLetter(lIndex)){
            return words.substring(0,words.indexOf(lIndex));
        }
        return words;
    }


    public void buildWordFileMap(){
        myMap.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()){
            addWordsFromFile(file);
        }
    }



    public int maxNumber(){
        int max = 0;
        ArrayList<String> list;
        for (String map : myMap.keySet()){
            list = myMap.get(map);
            if (list.size() > max){
                max = list.size();
            }
        }
        return max;
    }


    public ArrayList<String> wordsInNumFiles(int number){
        System.out.println("the words that abears in the files = " + number);
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> list ;
        for(String map : myMap.keySet()){
            list = myMap.get(map);
            if (list.size() == number){
                words.add(map);
            }
        }
        return words;
    }


    public void printFilesIn(String word){
        System.out.println(word + " Abears in files ");
        for (String map : myMap.keySet()){
            if(map.equals(word)){
                System.out.println(myMap.get(map));
            }
        }
    }


    public void tester(){
        buildWordFileMap();
        System.out.println("Max Word = " + maxNumber());
        ArrayList<String> list = wordsInNumFiles(7);
        Collections.sort(list);
        for (String words : list){
            System.out.println(words);
        }
        System.out.println("how many words = " +list.size());
        printFilesIn("tree");

    }

}



class WordsInFilesMain{
    public static void main(String[] args) {
        WordsInFiles wr = new WordsInFiles();
        wr.tester();
    }
}