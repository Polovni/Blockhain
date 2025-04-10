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

}
