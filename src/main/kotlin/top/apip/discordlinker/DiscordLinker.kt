package top.apip.discordlinker

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import org.bukkit.plugin.java.JavaPlugin
import top.apip.discordlinker.config.PluginConfig
import java.time.Duration

class DiscordLinker: JavaPlugin() {

    lateinit var jda: JDA
    lateinit var plConfig: PluginConfig

    override fun onEnable() {
        logger.info("Loading Config...")
        plConfig = PluginConfig(config)

        logger.info("Starting discord bot...")
        startBot(plConfig.token)
    }

    override fun onDisable() {
        jda.shutdown()
        jda.awaitShutdown(Duration.ofSeconds(10))
    }

    fun startBot(token: String) {
        jda = JDABuilder
            .createDefault(token, GatewayIntent.DIRECT_MESSAGES)
            .setActivity(Activity.customStatus("DM me to link your account!"))
            .build()
    }



}