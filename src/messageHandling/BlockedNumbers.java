package messageHandling;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class BlockedNumbers {
	
	@Persistent
	public long number;
	
	@Persistent
	public long blockedNumber;
	
	public BlockedNumbers(long number,long blockedNumber)
	{
		this.blockedNumber=blockedNumber;
		this.number=number;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public long getBlockedNumber() {
		return blockedNumber;
	}

	public void setBlockedNumber(long blockedNumber) {
		this.blockedNumber = blockedNumber;
	}
	

}
