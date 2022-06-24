package com.interfaces.advanced;

public class Audio {
	void musicPlay(Joy joyAlbum) {
		joyAlbum.play();
	}
	
	//박동규 앨범 재생
	 void musicPlay(Park parkAlbum) {
			parkAlbum.play();
	}
	 
	 void musicPlay(Playable lp) {
	// 매개 변수에서의 다형성 +인터페이스와 다형성
	//Playable lp = new park();
	//상위타입                      하위타입
		 lp.play();
}
}