package com.cs.controller.websocket;



import javax.servlet.http.HttpSession;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cs.pojo.Message;
import com.sun.org.apache.regexp.internal.recompile;

@Controller
public class WebSocketController {
	/** 
     * 表示服务端可以接收客户端通过主题“/app/hello”发送过来的消息，客户端需要在主题"/topic/greetings"上监听并接收服务端发回的消息 
     * @param topic 
     * @param headers 
     */  
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) throws Exception {
       // Thread.sleep(3000); // simulated delay
    	if (message.getNo()==1) {
    		return message;
		}
        return null;
    }

    
}
