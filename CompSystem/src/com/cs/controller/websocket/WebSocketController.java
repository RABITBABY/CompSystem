package com.cs.controller.websocket;



import javax.servlet.http.HttpSession;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cs.pojo.Greeting;
import com.cs.pojo.HelloMessage;
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

    @MessageMapping("/admin")
    @SendTo("/topic/admin")
    public Greeting admin(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @MessageMapping("/sb")
    @SendTo("/topic/sb")
    public Greeting sb(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @MessageMapping("/themanager")
    @SendTo("/topic/themanager")
    public String AllMessage(String message) throws Exception {
        return  "系统公告："+message;
    }


    @MessageMapping("/waiter")
    @SendTo("/topic/waiter")
    public String waiter(String message) throws Exception {
        return "厨师提醒您：" + message+ "!";
    }

    @MessageMapping("/cooker")
    @SendTo("/topic/cooker")
    public String cooker(String message) throws Exception {
        return "点餐员提醒您：" + message+ "!";
    }

    @MessageMapping("/cashier")
    @SendTo("/topic/cashier")
    public String cashier(String message) throws Exception {
        return "点餐员提醒您：" + message+ "!";
    }

    @MessageMapping("/fresh")
    @SendTo("/topic/fresh")
    public String fresh() throws Exception {
        return "刷新!";
    }

}
