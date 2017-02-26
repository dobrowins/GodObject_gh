package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class dedicated to list of ideas about God and getters and setters to them.
 */

public class GodIdea {

    private ArrayList<String> ideas = null;

    // populating ideas list
    public void generateIdeas() {
        ideas = new ArrayList<>();
        ideas.add("Aseity");
        ideas.add("Eternity");
        ideas.add("Goodness");
        ideas.add("Graciousness");
        ideas.add("Holiness");
        ideas.add("Immanence");
        ideas.add("Immutability");
        ideas.add("Impassibility");
        ideas.add("Impeccability");
        ideas.add("Incomprehensibility");
        ideas.add("Incorporeality");
        ideas.add("Love");
        ideas.add("Mission");
        ideas.add("Beer belly");
        ideas.add("Mystery");
        ideas.add("Infinity");
        ideas.add("Jealousy");
        ideas.add("Omnipotence");
        ideas.add("Omnipresence");
        ideas.add("Omniscience");
        ideas.add("Oneness");
        ideas.add("Providence");
        ideas.add("Righteousness");
        ideas.add("Simplicity");
        ideas.add("Sovereignty");
        ideas.add("Transcendence");
        ideas.add("Trinity");
        ideas.add("Veracity");
        ideas.add("Wrath");
    }

    // pulling ideas out of the list
    public String getIdea () {
        Random random = new Random();
        return ideas.get(random.nextInt(ideas.size()));
    }

    public void removeIdea(String idea) {
        ideas.remove(idea);
    }

    public int getSize() {
        return ideas.size();
    }
}

