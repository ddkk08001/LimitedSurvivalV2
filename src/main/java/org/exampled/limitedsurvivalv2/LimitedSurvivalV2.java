package org.exampled.limitedsurvivalv2;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class LimitedSurvivalV2 extends JavaPlugin implements Listener, CommandExecutor {

    public boolean ItemBrake;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        ItemBrake = false;
        System.out.println("LimitedSurvivalV2 Plugin On!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("LimitedSurvivalV2 Plugin Off!");
    }

    //플레이어 웰컴 메시지 투 서버
    @EventHandler
    public void PlayerJoinAnnounce(PlayerJoinEvent a){
        Player p = a.getPlayer();
        p.sendMessage("현재 이 플러그인은 '베타'버전입니다. 따라서 설정 저장기능이 지원되지 않으니, 서버장이신 경우, 서버종료후 다시 시작하실때는 서버 시작후 /limitedsurvival start 꼭 쳐주시길 바랍니다!");
        p.sendMessage("일반 유저이시면, /limitedsurvival help 를 입력하시면 안내사항을 확인하실 수 있습니다.");
    }

    @EventHandler
    public void ItemBreakEvent(PlayerItemBreakEvent a){
        Player p = a.getPlayer();
        System.out.println("Item Break Detection!");
        p.sendMessage("숨겨진 도전과제 클리어! 달리기가 풀렸습니다! 서버가 종료된 후 다시 시작할 경우, 이 도전과제를 다시 깨셔야하니 잘 기억하시길 바랄게요!");
        ItemBrake = true;
    }

    // 이 두개(Sprint, Sneak)는 특정 숨겨진 도전과제를 깨면 무한 사용 가능하게 할거임
    @EventHandler
    public void ControlRun(PlayerToggleSprintEvent a){
        if(!ItemBrake){
            Player p = a.getPlayer();
            p.sendMessage("No Sneaking!");
            p.damage(1000);
        }
    }

    @EventHandler
    public void ControlSneak(PlayerToggleSneakEvent a){
        Player p = a.getPlayer();
        p.sendMessage("No Sneaking!");
        p.damage(1000);
    }
}
