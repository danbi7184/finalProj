package com.fin.proj.member.model.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	 
	@Autowired
	private JavaMailSender emailSender;
	
	private int authNumber;
	 
//	public void sendSimpleMessage(Email mailDto) {
//		SimpleMailMessage message = new SimpleMailMessage();
//	    message.setFrom("finemeaning.kh@gmail.com");
//	    message.setTo(mailDto.getAddress());
//	    message.setSubject(mailDto.getTitle());
//	    message.setText(mailDto.getContent());
//	    emailSender.send(message);
//	}
	
	public void makeRandomNumber() {
		// 난수의 범위 111111 ~ 999999 (6자리 난수)
		Random r = new Random();
		int checkNum = r.nextInt(888888) + 111111;
		System.out.println("인증번호 : " + checkNum);
		authNumber = checkNum;
	}

	public int checkEmail(String emailAddress) {		
		makeRandomNumber();
//		SimpleMailMessage message = new SimpleMailMessage();
//		
//	    message.setFrom("finemeaning.kh@gmail.com");
//	    message.setTo(emailAddress);
//	    message.setSubject("선뜻입니다");
//	    message.setText("인증번호는 " + authNumber + " 입니다");
//	    
//	    emailSender.send(message);
//	    System.out.println("메세지 : " + message);
//	    
//	    return authNumber;
		
		String setFrom = "finemeaning.kh@gmail.com"; // email-config에 설정한 자신의 이메일 주소를 입력 
		String toMail = emailAddress;
		String title = "회원 가입 인증 이메일 입니다."; // 이메일 제목 
		String content = 
				"홈페이지를 방문해주셔서 감사합니다." + 	//html 형식으로 작성 ! 
                "<br><br>" + 
			    "인증 번호는 " + authNumber + "입니다." + 
			    "<br>" + 
			    "해당 인증번호를 인증번호 확인란에 기입하여 주세요."; //이메일 내용 삽입
		mailSend(setFrom, toMail, title, content);
		return authNumber;
	}
	
	//이메일 전송 메소드
	public void mailSend(String setFrom, String toMail, String title, String content) { 
		MimeMessage message = emailSender.createMimeMessage();
		// true 매개값을 전달하면 multipart 형식의 메세지 전달이 가능.문자 인코딩 설정도 가능하다.
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			// true 전달 > html 형식으로 전송 , 작성하지 않으면 단순 텍스트로 전달.
			helper.setText(content,true);
			emailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}	
}

