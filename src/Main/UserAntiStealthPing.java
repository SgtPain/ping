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

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageUpdateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class UserAntiStealthPing extends ListenerAdapter {
	JDA jda;
	String guildID;
	String channelID;
	public UserAntiStealthPing(JDA jda, String guildID, String channelID) {
		this.jda = jda;
		this.channelID = channelID;
		this.guildID = guildID;
	}

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if (event.getMessage().isMentioned(event.getGuild().getSelfMember())) {
			EmbedBuilder embed = new EmbedBuilder();
			embed.setAuthor(event.getAuthor().getName(), null, event.getAuthor().getAvatarUrl());
			embed.setThumbnail(event.getGuild().getIconUrl());
			embed.setTitle("Pinged you");
			embed.setDescription("in: " +  event.getGuild().getName() + "#" + event.getChannel().getName());
			embed.addField("Message:",event.getMessage().getContentDisplay(),false);
			jda.getGuildById(guildID).getTextChannelById(channelID).sendMessage(embed.build()).queue();;
		}

	}

	public void onGuildMessageUpdate(GuildMessageUpdateEvent event) {

		if (event.getMessage().isMentioned(event.getGuild().getSelfMember())) {
			EmbedBuilder embed = new EmbedBuilder();
			embed.setAuthor(event.getAuthor().getName(), null, event.getAuthor().getAvatarUrl());
			embed.setThumbnail(event.getGuild().getIconUrl());
			embed.setTitle("Pinged you");
			embed.setDescription("in: " +  event.getGuild().getName() + "#" + event.getChannel().getName());
			embed.addField("Message:",event.getMessage().getContentDisplay(),false);
			jda.getGuildById(guildID).getTextChannelById(channelID).sendMessage(embed.build()).queue();;
		}

	}
}
