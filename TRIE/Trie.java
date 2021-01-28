package TRIE;
// search,insert,delete - o(keylength)
//build - o(numberOfWords * avgLengthOfWords)
//space complexity - o(alphabetSize * numberOfKeys * keyLength)
public class Trie {

    static TrieNode root;
    static final int ALPHABET_SIZE = 26;

    static class TrieNode{

        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for(int i=0;i<ALPHABET_SIZE;i++)
                children[i] = null;
        }
    }

    static void insert(String key){
        TrieNode current = root;
        for(int i=0;i<key.length();i++){
            int index = key.charAt(i)-'a';
            if(current.children[index] == null)
                    current.children[index] = new TrieNode();
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    static boolean search(String key){
        TrieNode current = root;
        for(int i=0;i<key.length();i++){
            int index = key.charAt(i)-'a';
            if(current.children[index] == null)
                return false;
            current = current.children[index];
        }

        return current!=null && current.isEndOfWord;
    }


    static boolean isEmpty(TrieNode root) 
    { // Returns true if root has no children, else false 
        for (int i = 0; i < ALPHABET_SIZE; i++) 
            if (root.children[i]!=null) 
                return false; 
        return true; 
    } 
    static TrieNode remove(TrieNode root, String key, int depth) // Recursive function to delete a key from given Trie 
    {   
        if (root == null)  // If tree is empty 
            return null; 
        if (depth == key.length()) {  // If last character of key is being processed 
            if (root.isEndOfWord)  // This node is no more end of word after // removal of given key 
                root.isEndOfWord = false; 
            if (isEmpty(root)) // If given is not prefix of any other word 
                root = null; 
            return root; 
        } 
        int index = key.charAt(depth) - 'a';  // If not last character, recur for the child 
        root.children[index] =  remove(root.children[index], key, depth + 1); // obtained using ASCII value 
        if (isEmpty(root) && root.isEndOfWord == false) // If root does not have any child (its only child got  deleted), 
            root = null;                                //and it is not end of another word.
    return root; 
    } 

    public static void main(String[] args) {
        
        // Input keys (use only 'a' through 'z' and lower case) 
        String keys[] = {"the", "a", "there", "answer", "any", 
                         "by", "bye", "their"}; 
       
        String output[] = {"Not present in trie", "Present in trie"}; 
       
        root = new TrieNode(); 
        // Construct trie 
        for (int i = 0; i < keys.length ; i++) 
            insert(keys[i]); 
       
        // Search for different keys 
        if(search("the") == true) 
            System.out.println("the --- " + output[1]); 
        else System.out.println("the --- " + output[0]); 
          
        if(search("these") == true) 
            System.out.println("these --- " + output[1]); 
        else System.out.println("these --- " + output[0]); 
          
        if(search("their") == true) 
            System.out.println("their --- " + output[1]); 
        else System.out.println("their --- " + output[0]); 
          
        if(search("thaw") == true) 
            System.out.println("thaw --- " + output[1]); 
        else System.out.println("thaw --- " + output[0]); 

        remove(root, keys[0], 0);
        if(search("the") == true) 
            System.out.println("the --- " + output[1]); 
        else System.out.println("the --- " + output[0]); 
         
    } 
}


