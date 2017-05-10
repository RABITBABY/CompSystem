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
     * 表示服务端可以接收客户端通过主题“/app/user”发送过来的消息，客户端需要在主题"/topic/user"上监听并接收服务端发回的消息 
     * @param topic 
     * @param headers 
     */  
    @MessageMapping("/user")
    @SendTo("/topic/user")
    public Message student(Message message,HttpSession session) throws Exception {
    	Student student=(Student) session.getAttribute("student");
    	Teacher teacher=(Teacher) session.getAttribute("teacher");
    	Administer admin=(Administer) session.getAttribute("admin");
    	mapper.insertMessage(message);
    	if (student!=null) {
    		if (message.getSendtoNo().equals(student.getStudentno().toString())) {
        		return message;
    		}
		}else if(teacher!=null){
			if (message.getSendtoNo().equals(teacher.getTeacherno().toString())) {
        		return message;
    		}
		}else if(admin!=null){
			if (message.getSendtoNo().equals(admin.getAdminno().toString())) {
        		return message;
    		}
		}
    	return null;
    }
    
    
}
