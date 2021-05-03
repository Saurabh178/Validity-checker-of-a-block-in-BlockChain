import java.util.Scanner;

public class blockchainRunner {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        blockOperations op=new blockOperations();

        while(in.hasNext()==true)
        {
            String terminator=in.nextLine();

            if(terminator.equals("exit")==true)
            {
                break;
            }

            op.appendBlock(terminator);
        }

        //op.appendBlock("100");
        //op.appendBlock("200");
        //op.appendBlock("300");

        int size=op.getBlockChain().size();
        System.out.println();

        for(int i=0;i<size;i++)
        {
            int num=i+1;
            System.out.println("Block Number "+num+":");
            System.out.println("Index:" + op.getBlockChain().get(i).getIndex());
            System.out.println("Data:" + op.getBlockChain().get(i).getData());
            System.out.println("Hash Value:" + op.getBlockChain().get(i).getHash());
            System.out.println("Previous Hash Value:" + op.getBlockChain().get(i).getPrevHash());
            System.out.println("TimeStamp:" + op.getBlockChain().get(i).getTimeStamp());
            System.out.println();
        }

        if(op.checkValidity()==true)
        {
            System.out.println("Block has not been Tampered!");
        }
        else
        {
            System.out.println("Block has been Tampered and data is modified!");
        }

        op.getBlockChain().get(2).setData("500");
        System.out.println();

        if(op.checkValidity()==true)
        {
            System.out.println("Block has not been Tampered!");
        }
        else
        {
            System.out.println("Block has been Tampered and data is modified!");
        }

    }
    
}
