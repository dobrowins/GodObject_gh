package Model;

import java.util.ArrayList;

/**
 * Actually the GodObject himself. Would be populated by priest's ideas.
 */

public class GodObject {

    private ArrayList<String> godProperties = null;

    public void addProperty(String property) {
        if (godProperties == null) {
            godProperties = new ArrayList<>();
        }
        godProperties.add(property);
    }

    public String getProperty(int index) {
        return godProperties.get(index);
    }

    public ArrayList<String> getGodProperties() {
        return godProperties;
    }
}