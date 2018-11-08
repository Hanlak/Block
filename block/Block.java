package block;

import java.util.Date;

public class Block {
	public String hash;
	public String previoushash;
	private String data;
	private long timestamp;
	private int nonce;
	public Block(String data ,String previoushash) {
		this.data = data;
		this.previoushash = previoushash;
		this.timestamp = new Date().getTime();
		this.hash = calculateHash();
		
	}
	public String calculateHash(){
		String calculatedhash = StringUtil.apply256(
				previoushash+
				Long.toString(timestamp)+
				Integer.toString(nonce)
				+data
				);
		return calculatedhash;
	} 
	public void mineBlock(int difficulty){
		String target = new String(new char[difficulty]).replace('\0', '0');
		
		while(!hash.substring(0,difficulty).equals(target)){
			nonce++;
			hash = calculateHash();
			
		}
			System.out.println("Block Mined" +hash);
}
}
