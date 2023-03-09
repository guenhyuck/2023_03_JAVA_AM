package com.KoreaIT.java.AM;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		List<Article> articles = new ArrayList<>();
		while (true) {

			System.out.print("명령어 > ");
		
			String command = sc.nextLine().trim();

			if (command.length() == 0) {
				System.out.println("명령어를 입력해주세요");

				System.out.printf("%d번글이 생성되었습니다\n", id);
				lastArticleId++;

			} else if (command.startsWith("article detail ")) {

				String[] cmdDiv = command.split(" "); // article detail 1

//				System.out.println(cmdDiv[0]);
//				System.out.println(cmdDiv[1]);
//				System.out.println(cmdDiv[2]);

				int id = Integer.parseInt(cmdDiv[2]);

				// article detail 1 => "1" => 1

				System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);

			} else {
				System.out.println("존재하지 않는 명령어입니다");
			}
		}
		System.out.println("==프로그램 끝==");
		sc.close();
	}
}
class Article {
	int id;
	String title;
	String body;
	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}