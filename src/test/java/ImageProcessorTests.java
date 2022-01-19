import javafx.scene.paint.Color;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

public class ImageProcessorTests {

    @Test()
    public void testAddEmptyEntryWithNoEntry(){
        ImageProcessor processor = new ImageProcessor();
        String[] values = new String[1];
        values[0] = "";
        try {
            processor.interpretArray(values, 0, 0);
            assert(false);
        }
        catch (IllegalArgumentException e){
            assert(true);
        }
    }

    @Test
    public void testAddEmptyEntryWithOneEntry(){
        ColorInventory inventory = new ColorInventory();
        Color green = new Color(0, 1, 0, 1);
        inventory.addEntry(green);
        assert(inventory.getCountOfColors() == 1);
        assert(inventory.getColorList().contains(green));
    }
}
