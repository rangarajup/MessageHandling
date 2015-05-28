
package messageHandling;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController 
  {
	 long myNumber;
	  
	//Starting Page <<ok>>
	@RequestMapping(value="/messages.html")
	protected ModelAndView getHomePage()
	{
		ModelAndView modelandview=new ModelAndView("Home");	
		return modelandview;
	}
	
	//Gets Header Page  <<ok>>
	@RequestMapping(value="/head")
	protected ModelAndView getHeaderPage()
	{
			ModelAndView modelandview=new ModelAndView("Header");	
			return modelandview;
	}
	
	//Gets Header Page  <<ok>>
	@RequestMapping(value="/bgimage")
	protected ModelAndView getBgImage()
	{
			ModelAndView modelandview=new ModelAndView("Bgimage");	
			return modelandview;
	}
		
	//Get Settings <<ok>>
	@RequestMapping(value="/settings")
	protected ModelAndView getSettings(@RequestParam("mobileId")String mobileId)
	{
			ModelAndView modelandview=new ModelAndView("Settings");	
			modelandview.addObject("myNumber",mobileId);
			return modelandview;
	}
	
	//Search <<ok>>
	@RequestMapping(value="/search")
	protected ModelAndView searchPage(@RequestParam("mobileId")String mobileId)
	{
			    ModelAndView modelandview=new ModelAndView("Search");	
			    modelandview.addObject("myNumber",mobileId);
				return modelandview;
	}
	
	//get block page <ok>
	@RequestMapping(value="/block")
	protected ModelAndView getblockPage(@RequestParam("mobileId")String mobileId)
	{
				long myNumber=Long.parseLong(mobileId);
			    JdoOperations jdo=new JdoOperations();
			    ModelAndView modelandview=new ModelAndView("Block");	
			    modelandview.addObject("list",jdo.getBlockNumber(myNumber));
			    modelandview.addObject("myNumber",mobileId);
				return modelandview;
	}
	
	
	//changeSettings 
	@RequestMapping(value="/changeSettings")
	protected ModelAndView changeSettings(@RequestParam("mobileId")String mobileId,@RequestParam("selectColor")String color)
	{ 
			long myNumber=Long.parseLong(mobileId);
			JdoOperations jdo=new JdoOperations();
			jdo.setSettings(myNumber, color);
			ModelAndView modelandview=new ModelAndView("Messages");
			modelandview.addObject("myNumber",myNumber);
			modelandview.addObject("msgs",jdo.displayMessages(myNumber));
			return modelandview;	
	}
	
	//Search Results <ok>
	@RequestMapping(value="/searchMessage")
	protected ModelAndView searchMessage(@RequestParam("mobileId")String mobileId,@RequestParam("mobileNumber")String num)
	{
		    long myNumber=Long.parseLong(mobileId);
		    ModelAndView modelandview=new ModelAndView("Search");	
			if(num!="")
			{
		    JdoOperations jdo=new JdoOperations();
			modelandview.addObject("myNumber",myNumber);
			modelandview.addObject("msgs",jdo.displaySearchMessage(Long.parseLong(num),myNumber));
			return modelandview;	
			}
			else
			return modelandview;
	}

	//blockThisNumber
	@RequestMapping(value="/blockThisNumber")
	protected ModelAndView blockNumber(@RequestParam("mobileId")String mobileId,@RequestParam("Number")String num)
	{  
		
		long myNumber=Long.parseLong(mobileId);
		ModelAndView modelandview=new ModelAndView("Block");
		if(num!="")
		{
			JdoOperations jdo=new JdoOperations();
			jdo.blockNumber(myNumber, Long.parseLong(num));
			modelandview.addObject("list",jdo.getBlockNumber(myNumber));
			modelandview.addObject("myNumber",myNumber);
			return modelandview;	
		}
		else
		{
			return modelandview;
		}
	}
	
	//unBlockThis Number
	@RequestMapping(value="/unBlockThisNumber")
	protected ModelAndView unBlockNumber(@RequestParam("selectedNumber")String num)
	{
		 JdoOperations jdo=new JdoOperations();
		 jdo.unBlockNumber(myNumber, Long.parseLong(num));
		 ModelAndView modelandview=new ModelAndView("Block");	
		 modelandview.addObject("list",jdo.getBlockNumber(myNumber));
		 return modelandview;
	}
	
	//Load All Messages for the given Number
	@RequestMapping(value="/submitMobileNumber")
	protected ModelAndView getmobilenum(@RequestParam("mobileNumber")String num)
	{
		ModelAndView modelandview=new ModelAndView("Messages");
		if(num!="")
		{
		myNumber=Long.parseLong(num);
		JdoOperations jdo=new JdoOperations();
		modelandview.addObject("myNumber",num);
		modelandview.addObject("msgs",jdo.displayMessages(Long.parseLong(num)));
		return modelandview;		
		}
		else
		{
			return modelandview;
		}
	}
	
	//Creating Message <ok>
	@RequestMapping(value="/createMessage")
	protected ModelAndView createMessage(@RequestParam("mobileId")String mobileId) 
	{
			ModelAndView modelandview=new ModelAndView("CreateMessage");
			modelandview.addObject("myNumber",mobileId);
			return modelandview;		
	}
		
	
	//When Back Button clicked <ok>
	@RequestMapping(value="/backHome")
	protected ModelAndView back1(@RequestParam("mobileId")String mobileId) 
	{
		long myNumber=Long.parseLong(mobileId);
		JdoOperations jdo=new JdoOperations();
		ModelAndView modelandview=new ModelAndView("Messages");
		modelandview.addObject("myNumber",myNumber);
		modelandview.addObject("msgs",jdo.displayMessages(myNumber));
		return modelandview;			
	}
	
	//Sending Message <ok>
	@RequestMapping(value="/sendMessage")
	protected ModelAndView sendMessage(@RequestParam("mobileId")String mobileId,@RequestParam("msgNumber")String num,@RequestParam("msgText")String msgText) 
	{
		long myNumber=Long.parseLong(mobileId);
		if(num.equals(null)){
			ModelAndView modelandview=new ModelAndView("CreateMessage");
			modelandview.addObject("myNumber",myNumber);
			return modelandview;}
		try{
		Long msgNum=Long.parseLong(num);
		JdoOperations jdo=new JdoOperations();
		String status=jdo.sendMessage(myNumber,msgNum,msgText);
		ModelAndView modelandview=new ModelAndView("Messages");
		modelandview.addObject("myNumber",myNumber);
		modelandview.addObject("msgs",jdo.displayMessages(myNumber));
		return modelandview;
		}
		catch(Exception e){ModelAndView modelandview=new ModelAndView("CreateMessage");
		modelandview.addObject("myNumber",myNumber);
		return modelandview;}
	}
	
	//open Chat Page <ok>
	@RequestMapping(value="/chat") 
	protected ModelAndView chat(@RequestParam("mobileId")String mobileId,@RequestParam("selectedNumber")String num) 
	{
		JdoOperations jdo=new JdoOperations();
		ModelAndView modelandview=new ModelAndView("chat1");
		modelandview.addObject("myNumber",mobileId);
		modelandview.addObject("chatNumber",num);
		modelandview.addObject("chatMsgs",jdo.displayChatMessages(Long.parseLong(num),Long.parseLong(mobileId)));
		return modelandview;			
	}
	
	//chatting <ok>
	@RequestMapping(value="/sendChatMessages") 
	protected ModelAndView chat2(@RequestParam("mobileId")String mobileId,@RequestParam("msgNumber")String num,@RequestParam("msgText")String msgText) 
	{
		
		ModelAndView modelandview=new ModelAndView("chat1");
		JdoOperations jdo=new JdoOperations();
		if(msgText != ""){
		  String status=jdo.sendMessage(Long.parseLong(mobileId),Long.parseLong(num),msgText);		
		}
		modelandview.addObject("myNumber",mobileId);
		modelandview.addObject("chatNumber",num);
		modelandview.addObject("chatMsgs",jdo.displayChatMessages(Long.parseLong(num),Long.parseLong(mobileId)));
		return modelandview;
	}
	
	//refreshChatPage
}
