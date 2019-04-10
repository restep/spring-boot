package com.restep;

import com.restep.util.WebSocketUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;


/**
 * @author restep
 * @date 2019/4/10
 */
@RestController
@ServerEndpoint("/chat-room/{username}")
public class ChatRoomServerEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(ChatRoomServerEndpoint.class);

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        WebSocketUtil.ONLINE_USER_SESSIONS.put(username, session);
        String message = "欢迎用户[" + username + "] 来到聊天室！";
        logger.info("用户登录：" + message);
        WebSocketUtil.sendMessageAll(message);
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        logger.info("发送消息：" + message);
        WebSocketUtil.sendMessageAll("用户[" + username + "] : " + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        //当前的Session 移除
        WebSocketUtil.ONLINE_USER_SESSIONS.remove(username);
        //并且通知其他人当前用户已经离开聊天室了
        WebSocketUtil.sendMessageAll("用户[" + username + "] 已经离开聊天室了！");

        try {
            session.close();
        } catch (IOException e) {
            logger.error("onClose error", e);
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            logger.error("onError excepiton", e);
        }

        logger.info("Throwable msg " + throwable.getMessage());
    }
}
