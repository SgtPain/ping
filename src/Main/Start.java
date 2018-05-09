/*
 *     Copyright 2018 Laurin Schmidt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
