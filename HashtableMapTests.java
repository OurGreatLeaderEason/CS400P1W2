// --== CS400 Project One File Header ==--
// Name: Eason Xiao
// CSL Username: eason
// Email: xiao227@wisc.edu
// Lecture #: Heimrl 4
// Notes to Grader: GLHF

import java.util.NoSuchElementException;

/**
 * Class to test the implementation of HashtableMap
 */
public class HashtableMapTests {
    
    /**
     * Tests put() and collision handling
     * @return true if implemented correctly, false it otherwise
     */
    public static boolean test1(){
        HashtableMap<Integer, String> map=new HashtableMap<Integer, String>(4);
        //we put 2 keys that would collide
        map.put(0, "John");
        map.put(4, "Cena");
        if(!map.get(4).equals("Cena") || !map.get(0).equals("John")){
            return false;
        }
        if(map.getSize()!=2){
            return false;
        }
        return true;
    }

    /**
     * test containsKey() method
     * @return true if implemented correctly, false it otherwise
     */
    public static boolean test2(){
        HashtableMap<Integer, String> map=new HashtableMap<Integer, String>(4);
        boolean a=map.containsKey(69);
        if(a==true){
            return false;
        }
        return true;
    }

    /**
     * Tests get() method
     * @return true if implemented correctly, false it otherwise
     */
    public static boolean test3(){
        HashtableMap<Integer, String> map=new HashtableMap<Integer, String>(4);
        map.put(0, "Bing Chilling");
        if(!map.get(0).equals("Bing Chilling")){
            return false;
        }
        try{
            String s=(String) map.get(69);
        }
        catch(NoSuchElementException e){
            return true;
        }
        catch(Exception e){
            return false;
        }
        return false;
    }

    /**
     * Tests remove() method
     * @return true if implemented correctly, false it otherwise
     */
    public static boolean test4(){
        HashtableMap<Integer, String> map=new HashtableMap<Integer, String>(4);
        map.put(69, "Bing Chilling");
        map.put(24, "John Cena");
        map.remove(69);
        if(map.getSize()!=1 || map.containsKey(69)==true){
            return false;
        }
        try{
            map.remove(69);
        }
        catch(NoSuchElementException e){
            return true;
        }
        catch(Exception e){
            return false;
        }
        return false;
    }

    /**
     * Tests auto expansion of hasharray
     * @return true if implemented correctly, false it otherwise
     */
    public static boolean test5(){
        HashtableMap<Integer, String> map=new HashtableMap<Integer, String>(3);
        map.put(69, "Bing Chilling");
        map.put(24, "John Cena");
        map.put(33, "Super Max");
        if(map.getCapacity()!=6 || map.getSize()!=3){
            return false;
        }
        if(!map.containsKey(69) || !map.containsKey(24) || !map.containsKey(33)){
            return false;
        }
    
        return true;
    }

    public static void main(String[] args){
        System.out.println("test1: "+test1());
        System.out.println("test2: "+test2());
        System.out.println("test3: "+test3());
        System.out.println("test4: "+test4());
        System.out.println("test5: "+test5());
    }
}
