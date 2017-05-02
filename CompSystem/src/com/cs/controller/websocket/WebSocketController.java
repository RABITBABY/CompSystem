package com.cs.controller.websocket;



import javax.servlet.http.HttpSession;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cs.pojo.Administer;
import com.cs.pojo.Message;
import com.cs.pojo.Student;
import com.cs.pojo.Teacher;
import com.sun.org.apache.regexp.internal.recompile;

@Controller
public class WebSocketController {
	/** 
     * 表示服务端可以接收客户端通过主题“/app/hello”发送过来的消息，客户端需要在主题"/topic/greetings"上监听并接收服务端发回的消息 
     * @param topic 
     * @param headers 
     */  
    @MessageMapping("/hello")
    @SendTo("/topic/student")
    public Message student(Message message,HttpSession session) throws Exception {
       // Thread.sleep(3000); // simulated delay
    	Student student=(Student) session.getAttribute("student");
    	if (message.getNo()==student.getStudentno()) {
    		return message;
		}
        return null;
    }
    
    @MessageMapping("/hello")
    @SendTo("/topic/teacher")
    public Message teacher(Message message,HttpSession session) throws Exception {
       // Thread.sleep(3000); // simulated delay
    	Teacher teacher=(Teacher) session.getAttribute("teacher");
    	if (message.getNo()==teacher.getTeacherno()) {
    		return message;
		}
        return null;
    }
    
    @MessageMapping("/hello")
    @SendTo("/topic/admin")
    public Message admin(Message message,HttpSession session) throws Exception {
       // Thread.sleep(3000); // simulated delay
    	Administer admin=(Administer) session.getAttribute("admin");
    	if (message.getNo().toString().equals(admin.getAdminno())) {
    		return message;
		}
        return null;
    }


    
}
