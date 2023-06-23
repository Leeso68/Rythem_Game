package dynamic_beat_15;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {

	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getTime() { // 실행되고있는 음악이 어떤 위치에 실행되고 있는지
		if (player == null)
			return 0;
		return player.getPosition(); // 노트를 떨어트릴 때, get time이라는 함수를 이용해 시간 분석 가능
	}

	public void close() { // 음악이 언제 실행되어있던 간에 언제든지 종료 가능
		isLoop = false;
		player.close();
		this.interrupt(); // ex,플레이하다가 지루해서 뒤로갈때, 곡을 중지시키고 다른 노래를 사용할 수 있게 해주는 것
	} // 곡을 종료해주는 것 > interrupt

	@Override
	public void run() { // 스레드 함수를 썼으면 무조건 사용해야하는 함수
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop); // 해당 곡 무한 반복
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 오류발생시 오류메세지
		}

	}
}