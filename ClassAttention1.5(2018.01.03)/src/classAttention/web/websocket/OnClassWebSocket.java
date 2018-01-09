package classAttention.web.websocket;

import classAttention.domain.Chatter;
import classAttention.domain.OnClassWebSocketUser;
import com.google.gson.Gson;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/webSocket/onClass/{classId}")
public class OnClassWebSocket {

    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    //private static CopyOnWriteArraySet<Map<String,OnClassWebSocket>> onClassWebSockets = new CopyOnWriteArraySet<>();
    private static ConcurrentHashMap<OnClassWebSocket,Integer> onClassWebSockets = new ConcurrentHashMap<>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    @OnOpen
    public void onOpen(Session session,@PathParam("classId") int classId) {
        this.session = session;/*
        OnClassWebSocketUser onClassWebSocketUser=new OnClassWebSocketUser();
        onClassWebSocketUser.setClassId(5);*/
        onClassWebSockets.put(this,classId);  //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    @OnClose
    public void onClose() {
        onClassWebSockets.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }


    @OnMessage
    public void onMessage(String getChatter, Session session) {
        System.out.println("来自客户端的消息:" + getChatter);
        Gson gson = new Gson();
        Chatter chatter = gson.fromJson(getChatter,Chatter.class);
        //群发消息
        for (ConcurrentHashMap.Entry<OnClassWebSocket,Integer> item : onClassWebSockets.entrySet()) {
            try {
                if (item.getValue().equals(chatter.getClassId()))
                    item.getKey().sendMessage(getChatter);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }


    public void sendMessage(String message) throws IOException {
        //this.session.getBasicRemote().sendText(message);
        this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        OnClassWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        OnClassWebSocket.onlineCount--;
    }
}

