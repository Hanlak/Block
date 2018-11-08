package block;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class NoobChain {

	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 3;
	public static void main(String args[]){
		blockchain.add(new Block("hi is the firstblock","0"));
		System.out.println("Trying to Mine block 1... ");
		blockchain.get(0).mineBlock(difficulty);
		
		
		blockchain.add(new Block("hi this is second block",blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 2... ");
		blockchain.get(1).mineBlock(difficulty);
		
		
		blockchain.add(new Block("hi this is third block",blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 3... ");
		blockchain.get(2).mineBlock(difficulty);
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		String BlockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");

		System.out.println(BlockChainJson);
		
	}
	public static Boolean isChainValid(){
		Block currentblock;
		Block previousblock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		for (int i=1;i<blockchain.size();i++){
			currentblock = blockchain.get(i);
			previousblock = blockchain.get(i-1);
			if(!currentblock.hash.equals(currentblock.calculateHash())){
				
				System.out.println("Current Hashesh are not equal");
				return false;
			}
			if(!previousblock.hash.equals(currentblock.previoushash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			if(!currentblock.hash.substring(0,difficulty).equals(hashTarget)){
				System.out.println("this block hasnt been mined ");
				return false;
			}
			
		}
		return true;
	}
	

	}

