package messageHandling;


import java.util.ArrayList;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;


public class JdoOperations 
{
		public String sendMessage(Long fromNumber,Long toNumber,String messageText)
		{
		 String status="send";
		 PersistenceManager pm = PMF.get().getPersistenceManager();
	     Messages msg=new Messages(fromNumber,toNumber,messageText,getId());
	     try {
	           pm.makePersistent(msg);
	         } 
	     catch(Exception e){
	    	 status="fail";
	     }
	     finally {
	            pm.close();}
	      return status;
		}
		public List<Messages> displayMessages(long myNumber) 
		{
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q= pm.newQuery(Messages.class);
			q.setOrdering("id desc");
			List<Messages> results = (List<Messages>) q.execute();
			List<Messages> msgs =new ArrayList<Messages>();
			ArrayList<Long> listedNumbers=new ArrayList<Long>();
		    boolean isContain;
		    ArrayList<Long> bn= BlockedNumbers(myNumber);
		    for (Messages p : results) 
			{
				
				 Long fromNumber=p.getFromNumber();
				 Long toNumber=p.getToNumber();
			     if(((fromNumber.equals(myNumber) || toNumber.equals(myNumber))) && (!bn.contains(fromNumber)))
			     {
			    	 isContain=false;
			    	 for(int i=0;i<listedNumbers.size();i++)
			    	 {
			    		 if(toNumber.equals(listedNumbers.get(i)) || fromNumber.equals(listedNumbers.get(i)))
			    		 isContain=true;
			    	 }
			    	 if(!(isContain))
			    	 {
			    		 if(fromNumber.equals(myNumber))
			    			 listedNumbers.add(toNumber);
			    		 else
			    			 listedNumbers.add(fromNumber);
			    		 msgs.add(p);
			    	 }
			     }
			}
		     pm.close();
		     q.closeAll();
	        return msgs;
		}
		public List<Messages> displayChatMessages(long chatNumber,long myNumber) 
		{
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q= pm.newQuery(Messages.class);
			q.setOrdering("id asc");
			List<Messages> results = (List<Messages>) q.execute();
			List<Messages> msgs =new ArrayList<Messages>();
		
		     for (Messages p : results) 
			 {
				 Long fromNumber=p.getFromNumber();
				 Long toNumber=p.getToNumber();
				 if((fromNumber.equals(myNumber) && toNumber.equals(chatNumber)) ||(fromNumber.equals(chatNumber) && toNumber.equals(myNumber)))
			     {
					 msgs.add(p);
					
			     }
			 }
		     pm.close();
		     q.closeAll();
	         return msgs;  
		}
		public int displayChatCount(long chatNumber,long myNumber) 
		{
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q= pm.newQuery(Messages.class);
			List<Messages> results = (List<Messages>) q.execute();
			int count=0;
		
		     for (Messages p : results) 
			 {
				 Long fromNumber=p.getFromNumber();
				 Long toNumber=p.getToNumber();
				 if((fromNumber.equals(myNumber) && toNumber.equals(chatNumber)) ||(fromNumber.equals(chatNumber) && toNumber.equals(myNumber)))
			     {
					count+=1;
			     }
			 }
		     pm.close();
		     q.closeAll();
	         return count;  
		}
		public List<Messages> displaySearchMessage(long Number,long myNumber)
		{
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q= pm.newQuery(Messages.class);
			q.setOrdering("id desc");
			List<Messages> results = (List<Messages>) q.execute();
			List<Messages> msgs =new ArrayList<Messages>();
			
		
		     for (Messages p : results) 
			{
		    	 Long fromNumber=p.getFromNumber();
				 Long toNumber=p.getToNumber();
				 if((fromNumber.equals(myNumber) && toNumber.equals(Number)) ||(fromNumber.equals(Number) && toNumber.equals(myNumber)))
				 {
					 msgs.add(p);
					 break;
				 }
			}
		    pm.close();
		    q.closeAll();
	        return msgs;
			
		}

		public long getId()
		{
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q= pm.newQuery(Messages.class);
			q.setOrdering("id asc");
			List<Messages> results = (List<Messages>) q.execute();
			long id=0;
			 for (Messages p : results) 
			 {
				 id=p.id;
			 }
			 System.out.println(id);
			return id+1;
			
		}
		
	    public void blockNumber(Long myNumber,Long Number)
		{
			PersistenceManager pm = PMF.get().getPersistenceManager();
			BlockedNumbers msg=new BlockedNumbers(myNumber,Number);
			 try {
		           pm.makePersistent(msg);
		         }
			 finally {
		            pm.close();}
			 
		}
	    
		public List<BlockedNumbers> getBlockNumber(Long myNumber)
		{
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q= pm.newQuery(BlockedNumbers.class);
			q.setFilter("number=="+myNumber);
			List<BlockedNumbers> results = (List<BlockedNumbers>) q.execute();
			return results;	
		}
		
		public ArrayList<Long> BlockedNumbers(Long myNumber)
		{
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q= pm.newQuery(BlockedNumbers.class);
			q.setFilter("number=="+myNumber);
			List<BlockedNumbers> results = (List<BlockedNumbers>) q.execute();
			ArrayList<Long> bn=new ArrayList<Long>();
			  for (BlockedNumbers b : results) 
				{
				  	bn.add(b.blockedNumber);
				}
			return bn;	
		}
		
		public void unBlockNumber(Long myNumber,Long Number)
		{
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q= pm.newQuery(BlockedNumbers.class);
			q.setFilter("number=="+myNumber+" && blockedNumber=="+Number);
			q.deletePersistentAll();
			pm.close();
		}

        public void setSettings(Long myNumber,String color)
        {
         PersistenceManager pm = PMF.get().getPersistenceManager();
   	     Settings s=new  Settings(myNumber,color);
   	     pm.makePersistent(s);
   	  	 pm.close();
        }

}

