package top.apip.discordlinker.config

import org.bukkit.configuration.file.FileConfiguration

class PluginConfig(val config: FileConfiguration) {

    val token: String

    init {
        config.options().copyDefaults(true)

        token = config.getString("discord.token").toString()
    }

}