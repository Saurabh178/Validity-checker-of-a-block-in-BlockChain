import java.util.ArrayList;

public class blockOperations {
    private ArrayList<blocks> blockChain=new ArrayList<blocks>();

    private blocks getLatestBlock()
    {

        if(blockChain.isEmpty()==true)
        {
            generateGenesisBlock();
        }

        int lastIdx=blockChain.size()-1;

        return blockChain.get(lastIdx);
    }

    public ArrayList<blocks> getBlockChain()
    {
        return blockChain;
    }

    //create first block of blockchain
    private void generateGenesisBlock()
    {
        blockChain.add(new blocks(0, "Genisis Block", "hashingToken"));
    }

    public void appendBlock(String data)
    {
        blocks prevBlock=getLatestBlock();
        blocks newBlock=new blocks(prevBlock.getIndex()+1, data, prevBlock.getHash());
        blockChain.add(newBlock);
    }

    //validity check for blockchain

    public boolean checkValidity()
    {
        for(int i=1;i<blockChain.size();i++)
        {
            blocks currBlock=blockChain.get(i);
            blocks prevBlock=blockChain.get(i-1);

            //check done so that no tampering in blockchain can be done

            if(currBlock.getHash().equals(currBlock.calculateHashValue())==false)
            {
                return false;
            }

            if(currBlock.getPrevHash().equals(prevBlock.getHash())==false)
            {
                return false;
            }
        }

        return true;

    }
}
