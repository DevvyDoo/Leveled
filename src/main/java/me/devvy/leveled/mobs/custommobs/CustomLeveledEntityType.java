package me.devvy.leveled.mobs.custommobs;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;

public enum CustomLeveledEntityType {

    CORRUPTED_SKELETON(CustomLeveledEntityCorruptedSkeleton.class, EntityType.STRAY, "Corrupted Skeleton",          70, .2f),
    FIREFOX(           CustomLeveledEntityFireFox.class,           EntityType.FOX,    ChatColor.RED + "Firefox",    50, .25f),
    LOST_MINER(        CustomLeveledEntityZombieMiner.class,       EntityType.ZOMBIE, ChatColor.RED + "Lost Miner", 15, .2f);

    public final Class<? extends CustomLeveledEntity> CLAZZ;
    public final EntityType ENTITY_TYPE;
    public final String NAME;
    public final int DEFAULT_LEVEL;
    public final float FREQUENCY;  // percentage chance that this mob has to spawn with a 'relative'

    CustomLeveledEntityType(Class<? extends CustomLeveledEntity> clazz, EntityType entityType, String name, int defaultLevel, float frequency){
        this.CLAZZ = clazz;
        this.ENTITY_TYPE = entityType;
        this.NAME = name;
        this.DEFAULT_LEVEL = defaultLevel;
        this.FREQUENCY = frequency;
    }

}
