package Domain;

import Domain.Items.ItemStack;
import Domain.Items.StackLocation;

import java.util.ArrayList;

public class Storage {
    private ArrayList<ItemStack> inventory;

    // Constructor for empty inventory
    public Storage() {
        this.inventory = new ArrayList<ItemStack>();
    }

    // Constructor from item stack
    public Storage(ItemStack itemStack) {
        this.inventory = new ArrayList<ItemStack>();
        this.addItemStack(itemStack);
    }

    public void addItemStack(ItemStack itemStack) {
        this.inventory.add(itemStack);
        itemStack.setLocation(new StackLocation(this.inventory.size() -1));
    }

    public ArrayList<ItemStack> getInventory() {
        return (ArrayList<ItemStack>) inventory.clone();
    }
}
