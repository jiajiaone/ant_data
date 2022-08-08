package com.model.ant_data.api.okex;

import com.model.ant_data.api.okex.consts.RequestArgs;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * 测试及熟悉WebSocket
 * 1.公共频道：包括行情频道，K线频道，交易数据频道，资金费率频道，限价范围频道，深度数据频道，标记价格频道等。
 * 2.私有频道：包括用户账户频道，用户交易频道，用户持仓频道等。
 *
 *
 */
public class ApiOKWebSocket {

	// 欧易官网
	private static final String APU_URL = "https://www.okx.com";
	// 公告频道
	private static final String API_WS_URL = "wss://ws.okx.com:8443/ws/v5/public";

	private static OkHttpClient client;

	private static RequestArgs requestArgs;

	/**
	 * stock初始化及业务处理
	 * @return
	 */
	public static WebSocket init() {
		client = new OkHttpClient();
		Request request = new Request.Builder().url(API_WS_URL).build();
		//开始连接
		WebSocket websocket = client.newWebSocket(request, new WebSocketListener() {
			@Override
			public void onOpen(WebSocket webSocket, Response response) {
				super.onOpen(webSocket, response);
				//连接成功...
				System.out.println("open:" + request.body());
			}

			@Override
			public void onMessage(WebSocket webSocket, String text) {
				super.onMessage(webSocket, text);
				//收到消息...（一般是这里处理json）
				System.out.println("message:" + text);
			}

			@Override
			public void onMessage(WebSocket webSocket, ByteString bytes) {
				super.onMessage(webSocket, bytes);
				//收到消息...（一般很少这种消息）
			}

			@Override
			public void onClosed(WebSocket webSocket, int code, String reason) {
				super.onClosed(webSocket, code, reason);
				//连接关闭...
			}

			@Override
			public void onFailure(WebSocket webSocket, Throwable throwable, Response response) {
				super.onFailure(webSocket, throwable, response);
				//连接失败...
			}
		});
		return websocket;
	}

	/**
	 * 测试提交
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		WebSocket websocket = init();
		boolean send = websocket.send(RequestArgs.instruments);
		System.out.println("订阅结果：" + send);
	}
}
