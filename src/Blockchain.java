import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Blockchain {

        public static ArrayList<Block> blockchain = new ArrayList<>();

        public static void main(String[] args) {
            blockchain.add(new Block("Hi im the first block", "0"));
            blockchain.add(new Block("Hi im the second block", blockchain.getLast().hash));
            blockchain.add(new Block("Hi im the third block", blockchain.getLast().hash));

            String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
            System.out.println(blockchainJson);
        }
    public static Boolean isChainValid() {
            Block currentBlock;
            Block previousBlock;

            for(int i = 0; i < blockchain.size(); i++) {
                currentBlock = blockchain.get(i);
                previousBlock = blockchain.get(i - 1);

                if(!currentBlock.hash.equals(currentBlock.calculateHash())) {
                    System.out.println("Current Hashes not equal!");
                    return false;
                }
                if(!previousBlock.hash.equals(currentBlock.previousHash)) {
                    System.out.println("Previous Hashes not equal!");
                    return false;
                }
            }
            return true;
    }
}
