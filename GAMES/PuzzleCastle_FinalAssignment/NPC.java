public class NPC extends Character implements Interactable {

    public NPC(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(name + " speaks.");
    }

    @Override
    public void interact() {
        System.out.println(name + " interacts.");
    }
}
