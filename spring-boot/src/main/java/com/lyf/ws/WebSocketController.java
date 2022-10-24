/*
 *    Copyright 1999-2022  lyf712
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.lyf.ws;

import com.lyf.domain.UserBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @authorliyunfei
 * @date2022/10/24
 **/

@Component
@ServerEndpoint("/bulletinPush/{token}")
public class WebSocketController {

    private static ConcurrentHashMap<String, WebSocketController> webSocketMap = new ConcurrentHashMap<>(8);
    private static ConcurrentHashMap<String, UserBean> userMap = new ConcurrentHashMap<>(8);

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private String token = "";
   private UserBean userBean = new UserBean();
    private static ApplicationContext applicationContext;
    Logger logger  = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static void setApplicationContext(ApplicationContext applicationContext) {
        WebSocketController.applicationContext = applicationContext;
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) throws Exception {//@PathVariable

        System.out.println("User-"+token+" opened");
        this.session = session;
        this.token = token;
      //  RedisUtil redisUtil = (RedisUtil) applicationContext.getBean(RedisUtil.class);

//        String userSessionId = (String) redisUtil.get("token:"+token);
//        DoctorBean doctor = (DoctorBean) redisUtil.get("user:" + userSessionId);

       // CusUserBean userBean = (CusUserBean) redisUtil.get("token:"+token);

        if(userBean==null){
            logger.error("Token失效用户连接WS");
            throw new Exception("Token失效用户连接WS");
        }

        if (webSocketMap.containsKey(token)) {
            userMap.remove(token);
            webSocketMap.remove(token);
        }
        userMap.put(token,userBean);
        webSocketMap.put(token, this);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if (webSocketMap.containsKey(token)) {
            webSocketMap.remove(token);
            userMap.remove(token);
        }
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 发送自定义消息
     */
    public static void sendInfo(String message, String token) throws IOException {
        webSocketMap.get(token).sendMessage(message);
    }

    public static ConcurrentHashMap<String, WebSocketController> getWebSocketMap(){
        return webSocketMap;
    }
    public static ConcurrentHashMap<String, UserBean> getUserMap(){
        return userMap;
    }
}
