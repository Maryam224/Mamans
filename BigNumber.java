
/**
 * This Class represents a BigNumber using IntNode
 * which stores the digits of a specific big number for each object
 * 
 * the digits are stored in a list from left to right
 * 
 *
 * @author (Maryam)
 * @version (Maman15 : 23/1/2021)
 * Time complexity :O(1)
 * Space complexity :O(1)
 */
public class BigNumber
{
    private IntNode _head;
    
    public BigNumber(){
        _head=new IntNode(0);
    }
    
    /**
     * Constructor of objects of class BigNumber
     * this constructor takes a long number and make a BigNumber object representing the number
     * @param num - The number which BigNumber represents
     * 
     * Time complexity :O(n) , n is the num length
     * Space complexity :O(n)
     */
    public BigNumber(long num){
    	
            _head=new IntNode((int)(num%10));
            num=num/10;
            IntNode p=_head;
            while(num!=0)
            {
                p.setNext(new IntNode((int)(num%10)));
                num=num/10;
                p=p.getNext();
            }
        
    }
    
/**
 * Constructor of objects of class BigNumber
 * Copy constructor, construct a BigNumber using another BigNumber 
 * @param other - The copied BigNumber object
 * Time complexity :O(n) , n is the BigNumber _head length
 * Space complexity :O(n)
 */
	public BigNumber(BigNumber other){
        IntNode tmp=other._head;
        if(tmp==null || other==null)//other==null ?if not initialized?
        this._head=null;
        else{
            _head=new IntNode(tmp.getValue());
            IntNode ptr=_head;
            tmp=tmp.getNext();
            while(tmp!=null)
            {
                ptr.setNext(new IntNode(tmp.getValue()));
                ptr=ptr.getNext();
                tmp=tmp.getNext();
            }
            
            
        }
        
    }
    //
    //
	/**
	 * this private method adds new node to the end.
	 * @param node - the head of the given BigNumber
	 * @param num - the value we want to add inside an end node
	 * @return the _head
	 * Time complexity :O(n) , n is the BigNumber _head length
     * Space complexity :O(n)
	 */
    private IntNode add(IntNode node,int num){
        if(node==null)
        return new IntNode(num);
        else{
        node.setNext(add(node.getNext(),num));
        return node;
    }
    }
    /**
     * Returns a string representation of BigNumber.
     * @overrides toString in class java.lang.Object
	 * @return A String representation of the BigNumber
	 * Time complexity :O(n) , n is the BigNumber length
     * Space complexity :O(n)
	 */
    public String toString(){
        return toString(_head);
    }
    private String toString(IntNode node){
        if(node==null)
        return "";
        
        return toString(node.getNext())+""+node.getValue();
    }
    /**
     * this method compares between two given BigNumbers
     * @param other - BigNumber object we want to copmpare to the referenced one
     * @return 1 if the referenced is bigger ,-1 if the referenced is smaller
     * 0 if the referenced is equal to the other.
     *  Time complexity :O(n) , n is the BigNumber length (when both have the same length)
     * Space complexity :O(1)
	 
     * 
     */
    public int compareTo(BigNumber other)
    {
        int myLength=this.length();
        int otherLength=other.length();
        if(myLength>otherLength){
            return 1;
        }
        if(myLength<otherLength){
            return -1;
        }
        else//both have the same length
        {
            IntNode tmp1=this._head;
            IntNode tmp2=other._head;
            int lastVal=0;
            while(tmp1!=null){
                int val1=tmp1.getValue();
                int val2=tmp2.getValue();
                if(val1>val2)
                {
                    lastVal=1;
                    
                }
                else if(val1<val2)
                {
                    lastVal=-1;
                    
                }
                tmp1=tmp1.getNext();
                tmp2=tmp2.getNext();
               
            }
            return lastVal;
        }
    }
    /**
     * this methods returns BigNumber representing the sum of the two BigNumbers given.
     * @param other - the given number which we want to add to the referenced one
     * @return BigNumber representing the sum of the two BigNumbers given.
     *  Time complexity :O(n) , n is the BigNumber length of the longest of both objects
     * Space complexity :O(n)
     */
    public BigNumber addBigNumber (BigNumber other){
        
        IntNode tmp1=this._head;
        IntNode tmp2=other._head;
        int val1;
        int val2;
        int carry=0;
        BigNumber sum=new BigNumber();
        sum._head=null;
        while(!(tmp1==null && tmp2==null))
        {
            if(tmp1==null)
            val1=0;
            else {
                val1=tmp1.getValue();
                tmp1=tmp1.getNext();
            }
            if(tmp2==null)
            val2=0;
            else {
                val2=tmp2.getValue();
                tmp2=tmp2.getNext();
            }
            
            int digit=carry+val1+val2;
            sum._head=sum.add(sum._head,(digit%10));
            if(digit>9){
                carry=1;
            }
            else {
                carry=0;
            }
            
        }
        if(carry==1)
        sum._head=sum.add(sum._head,1);
        
        return sum;
    }
    /**
     * this method adds a given Long number to the referenced  BigNumber.
     * @param num - a given long number we want to add to the referenced
     * @return BigNumber object represents the sum
     *  Time complexity :O(n) , n is the BigNumber length of the longest of both numbers 
     * Space complexity :O(n)
     *
     * 
     */
    public BigNumber addLong (long num){
        BigNumber Bnum=new BigNumber(num);
        return addBigNumber(Bnum);
    }
    /**
     * this method subtracts the biggest number from the smallest one 
     * @param other - the other number we want to use subtract on
     * @return the absolute value of the subtraction between the referenced and other
     *  Time complexity :O(n) , n is the BigNumber length of the longest of both objects
     * Space complexity :O(n)
     *
     */
    public BigNumber subtractBigNumber (BigNumber other){
       IntNode tmp1,tmp2;
       
    	if(this.compareTo(other)==1)
        {
            tmp1=this._head;
            tmp2=other._head;
        }
    	else if (this.compareTo(other)==-1)
    	{
    		tmp1=other._head;
    		tmp2=this._head;
    	}
    	else {//if they are equal
    		return new BigNumber();
    	}
    	int val1,val2;
        int carry=0;
        BigNumber subB=new BigNumber();
        subB._head=null;
        int curr=-1;
    	while(!(tmp1==null &&tmp2==null)) {
    		
    		if(tmp1==null)
            val1=0;
            else {
                    val1=tmp1.getValue();
                    tmp1=tmp1.getNext();
                }
            if(tmp2==null)
            val2=0;
            else {
                    val2=tmp2.getValue();
                    tmp2=tmp2.getNext();
                }
            curr=val1-carry-val2;
            if(curr<0) {
            	carry=1;
            }
            else {
            	carry=0;
            }
            curr=(curr+10)%10;
            subB._head=add(subB._head,curr);//??
    	}
    	if(curr==0) 
    	{
    		IntNode ptr=subB._head;
    		IntNode lastDig=ptr;
    		while(ptr!=null) {
    			if(ptr.getValue()!=0)
    				lastDig=ptr;
    			ptr=ptr.getNext();
    		}
    		lastDig.setNext(null);
    	}
        return subB;
    }
    /**
     * this method calculate the multiplication of two BigNumbers
     * @param other - the one we want to multiply to the referenced BigNumber object
     * @return BigNumber object represents the result value of the multiplication
     *  Time complexity :O(n*m) ,m and n are the lengths of the two numbers the objects represent
     * Space complexity :O(n)
     * 
     */
    public BigNumber multBigNumber (BigNumber other) {
    	IntNode tmp2,ptr;
    	
    	if(this.length()>other.length())
    	{
    		ptr=this._head;
    		tmp2=other._head;
    		
    	}
    	else {
    		tmp2=this._head;
    		ptr=other._head;
    	}
    	
    	int carry=0;
    	BigNumber multB=new BigNumber();
    	BigNumber currB=new BigNumber();
    	for(int i=0;tmp2!=null;i++) {
    		
    		int val2=tmp2.getValue();
    		currB._head=null;
    		int j=i;
    		
    		while(j>0) {
    			currB._head=add(currB._head,0);
    			j--;
    			
    		}
    		IntNode tmp1=ptr;///////////////////////
    		
    		while(tmp1!=null) {
    			int val1=tmp1.getValue();
    			int currDig=(val1*val2)+carry;
    			carry=currDig/10;
    			currDig=currDig%10;
    			currB._head=add(currB._head,currDig);
    			tmp1=tmp1.getNext();
    		}
    		//chech carry!=0
    		if(carry>0)
    			currB._head=add(currB._head,carry);
    		carry=0;
    		multB=multB.addBigNumber(currB);
    		tmp2=tmp2.getNext();
    	}
    	
    	return multB;
    }



    /**
     * this is a private method to help get the number digits of a long number
     * represented in a BigNumber object
     * @return the length of the long number
     *  Time complexity :O(n) , n is the BigNumber length
     * Space complexity :O(1)
     *
     */
    private int length()
    {   IntNode temp = _head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    
    }
   
    
    
    
    
   
    
    
        
    
}

