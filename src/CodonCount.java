import edu.duke.FileResource;

import java.util.HashMap;

public class CodonCount {

    private HashMap<String,Integer> myMap;

    public CodonCount(){
        myMap = new HashMap<>();
    }

    public void buildCodonMap(int start, String dna){
        myMap.clear();
        int stCodon = start;
        int endCodon = start +3;
        int times = (dna.length() - start) / 3;
        for (int i = 0; i < times; i++) {
            String codonOccur = dna.substring(stCodon,endCodon);
            if (!myMap.containsKey(codonOccur)){
                myMap.put(codonOccur,1);
            } else {
                myMap.put(codonOccur, myMap.get(codonOccur)+1);
            }
            stCodon += 3;
            endCodon += 3;
        }
        System.out.println("Reading frame starting with " + start + " results in " + myMap.size() + " unique codons");
    }

    public String getMostCommonCodon(){
        int max = 0;
        String commonCodon = null;
        for (String map : myMap.keySet()){
            if(myMap.get(map) > max){
                max = myMap.get(map);
                commonCodon = map;
            }
        }
        return commonCodon;
    }


    public void printCodonCounts(int start, int end){
        System.out.println("Counts of codons between " + start + " and " + end + " inclusive are:");
        for (String map : myMap.keySet()){
            if(myMap.get(map) >= start && myMap.get(map) <= end){
                System.out.println(map + "\t" + myMap.get(map));
            }
        }
    }
    public void tester(){
        FileResource file = new FileResource();
        String dna = file.asString();
        buildCodonMap(2,dna);
        for (String map : myMap.keySet()){
            System.out.println(map + "\t"+ myMap.get(map));
        }
        String mostCodon = getMostCommonCodon();
        System.out.println("and most common codon is " + mostCodon + "with count " + myMap.get(mostCodon));
        printCodonCounts(1,5);
    }

}

class CodonCountMain{
    public static void main(String[] args) {
        CodonCount cc = new CodonCount();
        cc.tester();
    }
}