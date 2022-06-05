package fr.noah.proxy.Account;

import java.util.UUID;

public class Account {

        private int id;
        private UUID uuid;
        private String team;
        private Float coins;
        private int level;
        private String rank;
        private int kill;

        public Account(int id, UUID uuid, String team, Float coins, int level, String rank, int kill) {
            this.id = id;
            this.uuid = uuid;
            this.team = team;
            this.coins = coins;
            this.level = level;
            this.rank = rank;
            this.kill = kill;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public UUID getUuid() {
            return uuid;
        }

        public void setUuid(UUID uuid) {
            this.uuid = uuid;
        }

        public String getTeam() {
            return team;
        }

        public void setTeam(String guild) {
            this.team = guild;
        }

        public Float getCoins() {
            return coins;
        }

        public void setCoins(Float coins) {
            this.coins = coins;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public int getKill() {
            return kill;
        }

        public void setKill(int kill) {
            this.kill = kill;
        }
    }


