package com.interfaces.advanced;

public class App {

	public static void main(String[] args) {
		// 음악을 재생해야 되기 때문에. Audio 인스턴스 lpRecod 생성
		Audio lpRecode = new Audio();
		//Joy 앨범 구매
		Joy joyAlbum = new Joy();
		
		//박동규 앨범 구매
		Park parkAlbum = new Park();
	
		// lpRecode가 musicPlay(재생할 앨범)를 호출하면 넣은 앨범의 음악이 재생됨.
		lpRecode.musicPlay(joyAlbum);
		System.out.println("다른음악 재생");
		lpRecode.musicPlay(parkAlbum);
	
	}

}
