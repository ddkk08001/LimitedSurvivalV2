package org.exampled.limitedsurvivalv2;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.http.WebSocket;

public final class LimitedSurvivalV2 extends JavaPlugin implements Listener, CommandExecutor {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        System.out.println("LimitedSurvivalV2 Plugin On!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("LimitedSurvivalV2 Plugin Off!");
    }

    @EventHandler
    public void PlayerJoinAnnouce(PlayerJoinEvent a){
        Player p = a.getPlayer();
        p.sendMessage("현재 이 플러그인은 '베타'버전입니다. 따라서 설정 저장기능이 지원되지 않으니, 서버장이신 경우, 서버종료후 다시 시작하실때는 서버 시작후 /limitedsurvival start 꼭 쳐주시길 바랍니다!");
        p.sendMessage("일반 유저이시면, /limitedsurvival help 를 입력하시면 안내사항을 확인하실 수 있습니다.");
    }

    // 이 두개(Sprint, Sneak)는 특정 아이템이 있으면 5초~10초 동안 가능하게 수정 예정
    @EventHandler
    public void ControlRun(PlayerToggleSprintEvent a){
        Player p = a.getPlayer();
        p.sendMessage("No Running!");
        p.damage(1000);
    }

    @EventHandler
    public void ControlSneak(PlayerToggleSneakEvent a){
        Player p = a.getPlayer();
        p.sendMessage("No Sneaking!");
        p.damage(1000);
    }
}
