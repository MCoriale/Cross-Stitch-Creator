import javafx.scene.paint.Color;

public class ImageProcessor {

    private ColorInventory colorInventory;

    public ImageProcessor(){
        this.colorInventory = new ColorInventory();
    }

    public ImageProcessor(ColorInventory inventory){
        this.colorInventory = inventory;
    }

    protected void interpretArray(String[] values, int width, int height){
        boolean throwException = false;
        for(int i = 0; i < values.length; i++){
            String currentValue = values[i];
            try{
                Color current = Color.web(currentValue);
                this.colorInventory.addEntry(current);
            }
            catch (IllegalArgumentException e){
                e.printStackTrace();
                throwException = true;
            }
            //need to add other stuff here too
            if(throwException){
                throw new IllegalArgumentException();
            }
        }
    }

}
