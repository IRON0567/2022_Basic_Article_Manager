package com.koreaIT.java.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);
		
		int lastArticleId = 0;
		
		List<Article> articles = new ArrayList<>();
		//어레이리스트= 저장하기(DB역할 대체).
		while(true) {
			
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();
		
			if(cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			
			if(cmd.equals("exit")) {
				break;
				}
			
			if(cmd.equals("article write")) {
				int id = lastArticleId +1;
				lastArticleId = id;
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				
				
				//id title body를 밑에 인자로 넘겼고
				Article article = new Article(id, title, body);
				
				articles.add(article);
				
//				lastArticleId++;
				
				System.out.printf("%d번 글이 생성되었습니다\n", lastArticleId);
				
				
				
//				System.out.printf("%s, %s\n", title, body);
			}
			else if (cmd.equals("article list")) {
				
				if (articles.size() == 0){
				System.out.println("게시물이 없습니다");
				continue;
				}
				
				System.out.println("번호	|	제목");
				
				for(int i = articles.size() -1; i >=0;  i--) {
					Article article = articles.get(i);
					System.out.printf("%d	|	 %s\n", article.id, article.title);
				}
				
			}else if (cmd.startsWith("article detail ")) {
				
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);
				
				boolean found = false;
				Article foundArticle = null;
				for(int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					
					if(article.id == id) {
						found = true;
						foundArticle = article;
						System.out.printf("%d번 게시물은 존재합니다\n", id);
						break;
					}
				}
				
				
				if(found == false) {
				System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
				continue;
				}else {
					System.out.printf("번호 : %d\n", foundArticle.id);
					System.out.printf("날짜 : %d\n", "2022-12-12 12:12:12");
					System.out.printf("제목 : %d\n", foundArticle.title);
					System.out.printf("내용 : %d\n", foundArticle.body);
				}
				
			}else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
			
	
			
		}
		
		System.out.println("== 프로그램 종료 ==");
	
		sc.close();
	}
}
class Article {
	int id; //id title body를 파라미터로 받아왔고
	String title;
	String body;
	//id title body를 밑에서 활용을 한다.
	Article(int id, String title, String body){
		this.id = id;
		this.title = title;
		this.body = body;
	}
}