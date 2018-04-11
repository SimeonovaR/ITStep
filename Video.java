package tasks1104;

import java.util.Scanner;

public class Video {
	
	public static int estimateDuration(String video) {
		String[] duration = video.split(":");
		String hours = duration[0];
		String minutes = duration[1];
		return (Integer.parseInt(hours)*60 + Integer.parseInt(minutes));
	}

	
	public static void main(String[] args) {
		int duration = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("How many videos have you watched today? ");
		int n = sc.nextInt();
		do {
			System.out.println("Print a video duration in format hours:minutes ");
			String video = sc.nextLine();
			duration += estimateDuration(video);
			n--;
		} while(n > 0);
		int hours = duration / 60;
		int minutes = duration % 60;
		String allVideos = (String.valueOf(hours) + ":" + String.valueOf(minutes));
		System.out.println(allVideos);
		sc.close();
	}
}
