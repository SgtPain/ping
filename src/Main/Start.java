package Main;

import java.io.File;
import java.util.Scanner;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Start {

	public static void main(String[] args) {
		try {
			JDA jda;
			System.out.println(new File("args.txt").getAbsolutePath());
			File file = new File("args.txt");
			Scanner sc = new Scanner(file);
			String token = sc.next();
			String guild = sc.next();
			String channel = sc.next();
			sc.close();
			jda = new JDABuilder(AccountType.CLIENT).setToken(token).buildBlocking();
			jda.addEventListener(new UserAntiStealthPing(jda, guild, channel));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
