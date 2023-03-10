package com.KoreaIT.java.AM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작=="); //시스템 시작 코드
		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		List<Article> articles = new ArrayList<>();
		while (true) {
			System.out.printf("명령어 ) ");
			String command = sc.nextLine().trim();
			if (command.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			if (command.equals("system exit")) { // 시스템 종료 코드
				break;
			}
			if (command.equals("article write")) {  //게시글 작성
				int id = lastArticleId + 1;
				lastArticleId = id;
				String regDate = Util.getNowDateTimeStr();
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				Article article = new Article(id, regDate, title, body);
				articles.add(article);
				System.out.printf("%d번글이 생성되었습니다\n", id);
			} else if (command.equals("article list")) { //게시글 조회
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다");
					continue;
				}
				System.out.println("번호    / 제목    /   조회");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d  	 /  %s   /  0\n", article.id, article.title);
				}
			} else if (command.startsWith("article detail ")) { //게시글 까보기
				String[] commandBits = command.split(" ");
				int id = Integer.parseInt(commandBits[2]);
				Article foundArticle = null;
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}else
				System.out.printf("%d번 게시물은 존재합니다.\n", id);
				System.out.printf("번호 : %d\n", foundArticle.id);
				System.out.printf("날짜 : %s\n", foundArticle.regDate);
				System.out.printf("제목 : %s\n", foundArticle.title);
				System.out.printf("내용 : %s\n", foundArticle.body);

			} else if (command.startsWith("article modify ")) { //게시글 수정

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]);

				Article foundArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);

					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}else
				
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				foundArticle.title = title;
				foundArticle.body = body;

				System.out.printf("%d번 게시물을 수정했습니다.\n", id);

			} else if (command.startsWith("article delete ")) {  //게시글 삭제

				String[] commandBits = command.split(" ");
				int id = Integer.parseInt(commandBits[2]);
				int foundIndex = -1;
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id == id) {
						foundIndex = i;
						break;
					}
				}
				if (foundIndex == -1) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				articles.remove(foundIndex);
				System.out.printf("%d번 게시물을 삭제했습니다.\n", id);
			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}
		sc.close();
		System.out.println("==프로그램 끝==");
	}
}

class Article {
	int id;
	String regDate;
	String title;
	String body;
	

	public Article(int id, String regDate, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
		
	}
}