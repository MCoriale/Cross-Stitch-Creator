import javafx.scene.paint.Color;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ColorInventoryTests {

    @Test
    public void testAddEntryEmptyInventory(){
        ColorInventory inventory = new ColorInventory();
        assert(inventory.getCountOfColors() == 0);
        Color black = new Color(0,0,0,1);
        inventory.addEntry(black);
        assert(inventory.getCountOfColors() == 1);
    }

    @Test
    public void testAddEntryWithOneEntry(){
        ColorInventory inventory = new ColorInventory();
        Color green = new Color(0, 1, 0, 1);
        inventory.addEntry(green);
        assert(inventory.getCountOfColors() == 1);
        assert(inventory.getColorList().contains(green));
    }

    @Test
    public void testAddNewEntryWithMultiples(){
        HashMap<Color, Integer> mapToStart = new HashMap();
        Color first = new Color(0, 0.2, 0.2, 1);
        Color second = new Color(0.2, 0, 0.2, 1);
        Color third = new Color(0, 0.1, 0.8, 1);
        mapToStart.put(first, 1);
        mapToStart.put(second, 2);
        mapToStart.put(third, 3);

        ColorInventory inventory = new ColorInventory(mapToStart);

        assert(inventory.getCountOfColors() == 3);
        assert(inventory.getColorList().contains(first));
        assert(inventory.getColorList().contains(second));
        assert(inventory.getColorList().contains(third));

        Color fourth = new Color(0.5, 0.5, 0.1, 1);
        inventory.addEntry(fourth);

        assert(inventory.getCountOfColors() == 4);
        assert(inventory.getColorList().contains(first));
        assert(inventory.getColorList().contains(second));
        assert(inventory.getColorList().contains(third));
        assert(inventory.getColorList().contains(fourth));

        assert(inventory.getQuantityOfColor(fourth) == 1);
        assert(inventory.getQuantityOfColor(first) == 1);
        assert(inventory.getQuantityOfColor(second) == 2);
        assert(inventory.getQuantityOfColor(third) == 3);


    }

    @Test
    public void testIncrementEntryWithMultiples(){
        HashMap<Color, Integer> mapToStart = new HashMap();
        Color first = new Color(0, 0.2, 0.2, 1);
        Color second = new Color(0.2, 0, 0.2, 1);
        Color third = new Color(0, 0.1, 0.8, 1);
        mapToStart.put(first, 1);
        mapToStart.put(second, 2);
        mapToStart.put(third, 3);

        ColorInventory inventory = new ColorInventory(mapToStart);

        assert(inventory.getCountOfColors() == 3);
        assert(inventory.getColorList().contains(first));
        assert(inventory.getColorList().contains(second));
        assert(inventory.getColorList().contains(third));

        inventory.addEntry(third);

        assert(inventory.getCountOfColors() == 3);
        assert(inventory.getColorList().contains(first));
        assert(inventory.getColorList().contains(second));
        assert(inventory.getColorList().contains(third));

        assert(inventory.getQuantityOfColor(first) == 1);
        assert(inventory.getQuantityOfColor(second) == 2);
        assert(inventory.getQuantityOfColor(third) == 4);
    }


}
