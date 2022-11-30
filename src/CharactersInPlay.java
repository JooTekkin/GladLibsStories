import edu.duke.FileResource;

import java.util.ArrayList;
//test files in RandomStoryData folder
public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> counts;
    private FileResource file;

    public CharactersInPlay(){
        names = new ArrayList<>();
        counts = new ArrayList<>();
        file = new FileResource();
    }


    public void update(String person){
        int index = names.indexOf(person);
        if(index == -1){
            names.add(person);
            counts.add(1);
        } else {
            int value = counts.get(index);
            counts.set(index,value+1);
        }
    }

    public void findAllCharacters(){
        String name = null;
        for(String line : file.lines()){
            line = line.toLowerCase();
            int index = line.indexOf('.');
            if(index != -1){
                name = line.substring(0,index);
                update(name);
            }
        }
    }

    public void charactersWithNumParts(int num1, int num2){
        for (int i = 0; i < counts.size(); i++) {
            if(counts.get(i) >= num1 && counts.get(i) < num2){
                System.out.println("greater than : " + num1 +" smaller than : " + num2 + names.get(i));
            }
        }
    }


    public void tester(){
        findAllCharacters();
        for (int i = 0; i < names.size(); i++) {
            if(counts.get(i) > 1){
                System.out.println(names.get(i) + " " + counts.get(i));
            }
        }

        charactersWithNumParts(10,15);
    }


}

class CharactersInPlayMain{
    public static void main(String[] args) {
        CharactersInPlay ci = new CharactersInPlay();
        ci.tester();
    }
}
