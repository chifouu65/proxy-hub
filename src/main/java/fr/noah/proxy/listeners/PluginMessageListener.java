package fr.noah.proxy.listeners;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.noah.proxy.Account.Account;
import fr.noah.proxy.Proxy;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.ArrayList;
import java.util.UUID;

public class PluginMessageListener implements Listener {

    @EventHandler
    public void onPluginMessage(PluginMessageEvent event) {
        if (event.getTag().equals("Channel")) {
            final ByteArrayDataInput in = ByteStreams.newDataInput(event.getData());
            final String sub = in.readUTF();

            if (sub.equals("GetProfile")) {
               final String uuid_string = in.readUTF();
               final UUID uuid = UUID.fromString(uuid_string);
               final Proxy plugin = Proxy.INSTANCE;
               final ArrayList<Account> accounts = plugin.getAccounts();

                for (Account account : accounts) {
                    if (account.getUuid().equals(uuid)) {
                        //evoie un plMSG avec les infos de compte
                        final ByteArrayDataOutput out = ByteStreams.newDataOutput();

                        out.writeUTF("GetProfile");
                        out.writeInt(account.getId());
                        out.writeUTF(account.getUuid().toString());
                        out.writeUTF(account.getTeam());
                        out.writeFloat(account.getCoins());
                        out.writeInt(account.getLevel());
                        out.writeUTF(account.getRank());
                        out.writeInt(account.getKill());

                        final ProxiedPlayer player = plugin.getProxy().getPlayer(event.getReceiver().toString());
                        player.getServer().sendData("Channel", out.toByteArray());
                    }
                }

                //si le coompte n'a pas ete trouve

            }
        }
    }
}