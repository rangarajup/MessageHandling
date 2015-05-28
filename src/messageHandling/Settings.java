package messageHandling;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Settings {
	@Persistent
	public Long number;
	
	@Persistent
	public String color;
	
	@Persistent
	public boolean isDeleteOldMsgs;
	
	@Persistent
	public int textMsglimt;
	
	@Persistent
	public int multimediaMsglimt;
	
	@Persistent
	public int isTextMessageBackUP;
	
	@Persistent
	public int isSmsDeliveryConfermation;
	
	@Persistent
	public int isMmsDeliveryConfermation;
	
	@Persistent
	public long smsCenterNumber;
	
	public Settings(Long number,String color)
	{
		this.color=color;
		this.number=number;
	}

	public boolean isDeleteOldMsgs() {
		return isDeleteOldMsgs;
	}

	public void setDeleteOldMsgs(boolean isDeleteOldMsgs) {
		this.isDeleteOldMsgs = isDeleteOldMsgs;
	}

	public int getTextMsglimt() {
		return textMsglimt;
	}

	public void setTextMsglimt(int textMsglimt) {
		this.textMsglimt = textMsglimt;
	}

	public int getMultimediaMsglimt() {
		return multimediaMsglimt;
	}

	public void setMultimediaMsglimt(int multimediaMsglimt) {
		this.multimediaMsglimt = multimediaMsglimt;
	}

	public int getIsTextMessageBackUP() {
		return isTextMessageBackUP;
	}

	public void setIsTextMessageBackUP(int isTextMessageBackUP) {
		this.isTextMessageBackUP = isTextMessageBackUP;
	}

	public int getIsSmsDeliveryConfermation() {
		return isSmsDeliveryConfermation;
	}

	public void setIsSmsDeliveryConfermation(int isSmsDeliveryConfermation) {
		this.isSmsDeliveryConfermation = isSmsDeliveryConfermation;
	}

	public int getIsMmsDeliveryConfermation() {
		return isMmsDeliveryConfermation;
	}

	public void setIsMmsDeliveryConfermation(int isMmsDeliveryConfermation) {
		this.isMmsDeliveryConfermation = isMmsDeliveryConfermation;
	}

	public long getSmsCenterNumber() {
		return smsCenterNumber;
	}

	public void setSmsCenterNumber(long smsCenterNumber) {
		this.smsCenterNumber = smsCenterNumber;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
