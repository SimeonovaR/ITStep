package introductionTasks;

import java.util.Scanner;

public class Video {
	
	public static int estimateDuration(String video) {
		String[] duration = video.split(":");
		String hours = duration[0];
		String minutes = duration[duration.length-1];
		return (Integer.parseInt(hours)*60 + Integer.parseInt(minutes));
	}

	public static void main(String[] args) {
		String end = "end";
		int duration = 0;
		Scanner sc = new Scanner(System.in);
		String video = "";
		do {
			System.out.println("Print a video duration in format hours:minutes ");
			video = sc.nextLine();
			duration += estimateDuration(video);
		} while(!video.equalsIgnoreCase(end) && video != null && video != "");
		
		int hours = duration / 60;
		int minutes = duration % 60;
		
		String allVideos = (String.valueOf(hours) + ":" + String.valueOf(minutes));
		System.out.println(allVideos);
		sc.close();	
	}

}
