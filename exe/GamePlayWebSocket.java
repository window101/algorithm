package exe;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import javax.websocket.Session;

//웹소켓 종단점
//roomId를 동적으로 받아 방마다 웹소켓 생성
@ServerEndpoint("/GamePlay/{roomId}")
public class GamePlayWebSocket {
    //private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());
    
    private static Map<String, Set<Session>> clients = new ConcurrentHashMap<>(); // 멀티 스레드 환경에서 사용
    private static Map<Session, String> sessionRoomMap = new ConcurrentHashMap<>(); // 방을 나가고 다른 방에 입장할경우 세션 중복 문제 해결

    //소켓 접속 시 1회 실행
    @OnOpen
    public void onOpen(Session session, @PathParam("roomId") String roomId) {
        clients.computeIfAbsent(roomId, k -> Collections.synchronizedSet(new HashSet<>())); // 이 방(roomId)에 해당하는 세션 set이 없다면 새로 생성
        //clients에 접속 session 저장
        clients.get(roomId).add(session); // 해당 방의 set에 현재 접속한 session 추가
        System.out.println("클라이언트 연결됨 (room: " + roomId + ", session: " + session.getId() + ")");

    }

    //클라이언트에서 send 발생 시 실행
    @OnMessage
    public void onMessage(String message, Session sender) throws IOException {
        String roomId = sessionRoomMap.get(sender);
        if(roomId == null) {
            System.out.println("방 정보가 없음" + sender.getId());
            return;
        }
        System.out.println("[" + roomId + "] 메시지 수신 : " + message);
        // 메시지 브로드캐스트: 같은 방에 있는 다른 사용자에게만 전송
        for (Session client : clients.get(roomId)) {
            if (client.isOpen() && !client.equals(sender)) {
                client.getBasicRemote().sendText(message);
            }
        }

        // 게임 시작: 방에 2명 접속돼 있으면 start 메시지 전송
        if (roomClients.get(roomId).size() == 2) {
            for (Session client : clients.get(roomId)) {
                if (client.isOpen()) {
                    client.getBasicRemote().sendText("start");
                }
            }
        }
    }
    

    /* 
    public void handleMessage(String message, Session sender) throws IOException {
        System.out.println(message);
        //상대방에게만 메세지 전송
        for (Session client : clients) {
            if (client.isOpen() && !client.equals(sender)) {
                client.getBasicRemote().sendText(message);
            }
        }
        System.out.println(clients.size());
        //2명 접속 확인 후 게임 시작 전달
        if (clients.size() > 1){
            for (Session client : clients) {
                if (client.isOpen()) {
                    client.getBasicRemote().sendText("start");
                }
            }
        }
        
    }*/

    //클라이언트가 웹소켓 퇴장시 실행
    @OnClose
    public void onClose(Session session) {
        clients.remove(session);  // Set<Session> clients 에서 제거
        System.out.println("클라이언트 연결 종료됨: " + session.getId());
    }
    

}