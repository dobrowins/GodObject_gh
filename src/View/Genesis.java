package View;

import Model.GodIdea;
import Model.GodObject;
import Model.Priest;

import java.util.ArrayList;
import java.util.Random;

class Genesis {

    private boolean turnToTalk, agreed;
    private Priest priestOne;
    private Priest priestTwo;
    private GodObject godObject;
    private GodIdea godIdea;

    public static void main(String[] args) {
        Genesis genesis = new Genesis();
        genesis.godIdea = new GodIdea();
        genesis.godIdea.generateIdeas();

        System.out.println("Two priests once met and decided to found a religion.");
        genesis.NameThePriests();
        genesis.PriestsTalk();
    }

    // picking names for our priests
    private void NameThePriests() {
        ArrayList<String> priestNames = new ArrayList<>();
        priestNames.add("Moha Med");
        priestNames.add("Jeshua");
        priestNames.add("Gan D.");
        priestNames.add("Davai Llama");
        priestNames.add("Average Joe");
        priestNames.add("Confu Cius");
        priestNames.add("Zorro Aster");
        priestNames.add("Krishnahh");
        priestNames.add("Gautama B.");

        Random r = new Random();
        int item = r.nextInt(priestNames.size());
        priestOne = new Priest(priestNames.get(item));
        priestNames.remove(item);
        item = r.nextInt(priestNames.size());
        priestTwo = new Priest(priestNames.get(item));
        priestNames.remove(item);

        System.out.println("\nFirst priest name was " + priestOne.getName() + ".");
        System.out.println("Second priest name was " + priestTwo.getName() + ".");

        priestNames = null;
        r = null;
    }

    /* priests coming to an decision; it would loop till all the ideas are not
        picked.
     */
    private void PriestsTalk() {
        turnToTalk = true;
        Thread0 thread0 = new Thread0();
        thread0.run();
    }

    class Thread0 implements Runnable {
        @Override
        public void run() {
            String proposition = godIdea.getIdea();
            System.out.println("\n" + priestOne.getName() + " said: Shall our God have " + proposition + "?");

            turnToTalk = false;

            Thread1 thread1 = new Thread1();
            thread1.run();

            while (!turnToTalk) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // after thread woke up
            if (agreed) {
                if (godObject == null) {
                    godObject = new GodObject();
                }
                System.out.println(priestOne.getName() + " said: Great! Now our God have " + proposition + ".");
                godObject.addProperty(proposition);
                godIdea.removeIdea(proposition);
                if (godIdea.getSize() != 0) {
                    PriestsTalk();
                } else {
                    System.out.println("\nOur God has been created!\n");
                    for (int i = 0; i < godObject.getGodProperties().size(); i++) {
                        System.out.println("Our God have " + godObject.getProperty(i));
                    }

                    proposition = null;
                    godIdea = null;
                    godObject = null;
                }
            } else {
                System.out.println(priestOne.getName() + " said: Rude. But let's continue...");
                PriestsTalk();
            }
        }
    }

    class Thread1 implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                while (turnToTalk) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Random r = new Random();
                int i = r.nextInt(2);
                String answer =
                        i != 0 ? "Yes" : "No";

                if (answer.equals("Yes")) {
                    System.out.println(priestTwo.getName() + " said: Yes!");
                    agreed = true;
                    turnToTalk = true;
                    r = null;
                    answer = null;
                    notify();
                } else {
                    System.out.println(priestTwo.getName() + " said: Blasphemy!");
                    agreed = false;
                    turnToTalk = true;
                    r = null;
                    answer = null;
                    notify();
                }
            }
        }
    }
}
