package com.cs.controller.websocket;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cs.dao.message.MessageMapper;
import com.cs.pojo.Administer;
import com.cs.pojo.Message;
import com.cs.pojo.Student;
import com.cs.pojo.Teacher;
import com.sun.org.apache.regexp.internal.recompile;

@Controller
public class WebSocketController {
	@Autowired
	private MessageMapper mapper;
	/** 
     * 表示服务端可以接收客户端通过主题“/app/hello”发送过来的消息，客户端需要在主题"/topic/greetings"上监听并接收服务端发回的消息 
     * @param topic 
     * @param headers 
     */  
    @MessageMapping("/student")
    @SendTo("/topic/student")
    public Message student(Message message,HttpSession session) throws Exception {
       // Thread.sleep(3000); // simulated delay
    	Student student=(Student) session.getAttribute("student");
    	mapper.insertMessage(message);
    	if (message.getNo()==student.getStudentno()) {
    		return message;
		}
        return null;
    }
    
    @MessageMapping("/teacher")
    @SendTo("/topic/teacher")
    public Message teacher(Message message,HttpSession session) throws Exception {
       // Thread.sleep(3000); // simulated delay
    	Teacher teacher=(Teacher) session.getAttribute("teacher");
    	mapper.insertMessage(message);
    	if (message.getNo()==teacher.getTeacherno()) {
    		return message;
		}
        return null;
    }
    
    @MessageMapping("/admin")
    @SendTo("/topic/admin")
    public Message admin(Message message,HttpSession session) throws Exception {
       // Thread.sleep(3000); // simulated delay
    	Administer admin=(Administer) session.getAttribute("admin");
    	mapper.insertMessage(message);
    	if (message.getNo().toString().equals(admin.getAdminno())) {
    		return message;
		}
        return null;
    }


    
}
