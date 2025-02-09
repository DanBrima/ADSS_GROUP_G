package Presentation.Inventory;

import Domain.ItemStack;
import Domain.Storage;
import External.InventoryConstants;
import Presentation.Screen;

import java.io.PrintStream;
import java.util.Scanner;

public class DefectiveItemsScreen extends Screen {

    private Storage storageRef;

    public DefectiveItemsScreen(PrintStream out, Scanner in, Storage storageRef) {
        super(out, in);
        this.storageRef = storageRef;
    }

    @Override
    public int handleMsg() {
        String LEFT_ALIGN_FORMAT = "| %-6s | %-8s |%n";

        this.out.println();
        this.out.format("+--------+----------+%n");
        this.out.format("| Item   | Amount   |%n");
        this.out.format("+--------+----------+%n");
        for (int itemStackIndex = 0; itemStackIndex < this.storageRef.getDefectiveItems().size(); itemStackIndex++) {
            ItemStack itemStack = this.storageRef.getDefectiveItems().get(itemStackIndex);
            this.out.format(LEFT_ALIGN_FORMAT, itemStack.getItemType().getName(), itemStack.getItemCount());
        }
        this.out.format("+--------+----------+%n");
        this.out.println();

        return InventoryConstants.USER_NO_INPUT;
    }
}
