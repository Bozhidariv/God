package fmi.god.enums;

import java.util.Random;

public enum EntityType {
    
    ENTITY("entity"),

    ANIMAL("animal"),

    HUMAN("human"),

    GOD("god"),

    UNKNOWN("unknown");
    
    
    private final String name;
    
    private static String[] entities = {"entity","animal","human","god","unknown"};
    
    EntityType(String name) {
        this.name = name;
    }

    public String value() {
        return this.name;
    }
    
    public EntityType value(String name) {
        for (EntityType entityType : EntityType.values()) {
            if (entityType.value().equalsIgnoreCase(name)) {
                return entityType;
            }
        }

        return null;
    }
    
    public static EntityType randomEntity() {
        int pick = new Random().nextInt(EntityType.values().length);
        return EntityType.values()[pick];
    }
    
   
    
    public static String[] getEntities() {
        return entities;
    }
    
    public static boolean isEntity(String name){
        for(int i = 0; i < entities.length; i++){
            if(name.equals(entities[i])){
                return true;
            }
        }
        return false;
        
    }
}
