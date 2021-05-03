import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class blocks
{
    private int idx;
    private String data;
    private String hash;
    private String prevHash;
    private long timeStamp;

    //create constructor

    blocks(int idx, String data, String prevHash)
    {
        this.idx=idx;
        this.data=data;
        this.prevHash=prevHash;
        
        this.timeStamp=System.currentTimeMillis();
        this.hash=calculateHashValue();
    }

    //implement above methods to set and fetch their values

    public void setIndex(int idx)
    {
        this.idx=idx;
    }

    public void setData(String data)
    {
        this.data=data;
    }

    public void setHash(String hash)
    {
        this.hash=hash;
    }

    public void setPrevHash(String prevHash)
    {
        this.prevHash=prevHash;
    }

    public void setTimeStamp(long timeStamp)
    {
        this.timeStamp=timeStamp;
    }

    public int getIndex()
    {
        return idx;
    }

    public String getData()
    {
        return data;
    }

    public String getHash()
    {
        return hash;
    }

    public String getPrevHash()
    {
        return prevHash;
    }

    public long getTimeStamp()
    {
        return timeStamp;
    }

    public String calculateHashValue()
    {
        String ts=String.valueOf(getTimeStamp());
        String hashedValue=String.valueOf(idx+prevHash+ts+data);
        MessageDigest msgDigest=null;

        try
        {
            msgDigest = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        final byte bytes[]=msgDigest.digest(hashedValue.getBytes());
        final StringBuilder hexString=new StringBuilder();

        for(final byte b: bytes)
        {
            String hex=Integer.toHexString(0xff&b);

            if(hex.length()==1)
            {
                hexString.append('0');
            }

            hexString.append(hex);
        }

        String stringInHex=hexString.toString();

        return stringInHex;
    }

}