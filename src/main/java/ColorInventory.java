import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Set;

public class ColorInventory {

    private HashMap<Color, Integer> inventoryMap;

    public ColorInventory(){
        this.inventoryMap = new HashMap<>();
    }

    protected ColorInventory(HashMap<Color, Integer> givenMap){
        this.inventoryMap = givenMap;
    }

    public void addEntry(Color currentColor){
        if(inventoryMap.containsKey(currentColor)){
            int previousCount = inventoryMap.get(currentColor);
            inventoryMap.put(currentColor, (previousCount + 1));
        }
        else {
            inventoryMap.put(currentColor, 1);
        }
    }

    public int getCountOfColors(){
        return this.inventoryMap.size();
    }

    public Set<Color> getColorList(){
        return this.inventoryMap.keySet();
    }

    public int getQuantityOfColor(Color currentColor){
        return this.inventoryMap.get(currentColor);
    }

}
