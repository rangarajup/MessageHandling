package messageHandling;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Messages {


	@Persistent
	protected Long id;
	
	@Persistent
	protected Long fromNumber;
	
	@Persistent
	protected Long toNumber;
	
	@Persistent
	protected String messageText;
	
	@Persistent
	protected String time;
	
	@Persistent
	private boolean isStatus;// to get delivery status
	
	@Persistent
	private boolean isSeen;
	
	@Persistent
	private boolean isFromNumberAccess; //by default the access will be true if the user deletes the message the access will be false.
	
	@Persistent
	private boolean isTONumberAccess;
	
	public Messages()
	{}
	
	public Messages(Long fromNumber,Long toNumber,String messageText,Long id)
	{
		this.fromNumber=fromNumber;
		this.toNumber=toNumber;
		this.messageText=messageText;
		this.time=getTime1();
		this.id=id;
		isStatus=true;
		isSeen=false;
		isFromNumberAccess=true;
		isTONumberAccess=true;
	}
	
	public String getTime1()
    {
      DateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm");
 	   Calendar cal = Calendar.getInstance();
 	   String time=dateFormat.format(cal.getTime());
	   return time; 
    }
	
	 public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFromNumber() {
		return fromNumber;
	}

	public void setFromNumber(Long fromNumber) {
		this.fromNumber = fromNumber;
	}

	public Long getToNumber() {
		return toNumber;
	}

	public void setToNumber(Long toNumber) {
		this.toNumber = toNumber;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public boolean isStatus() {
		return isStatus;
	}

	public void setStatus(boolean isStatus) {
		this.isStatus = isStatus;
	}

	public boolean isSeen() {
		return isSeen;
	}

	public void setSeen(boolean isSeen) {
		this.isSeen = isSeen;
	}

	public boolean isFromNumberAccess() {
		return isFromNumberAccess;
	}

	public void setFromNumberAccess(boolean isFromNumberAccess) {
		this.isFromNumberAccess = isFromNumberAccess;
	}

	public boolean isTONumberAccess() {
		return isTONumberAccess;
	}

	public void setTONumberAccess(boolean isTONumberAccess) {
		this.isTONumberAccess = isTONumberAccess;
	}
	
	
}
