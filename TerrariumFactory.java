public class TerrariumFactory 
{
    public Terrarium createTerrarium(String type)
    {
        if (type == null) 
        {
            return null;
        }
        if(type.equalsIgnoreCase("desert"))
        {
            return new DesertTerrarium();
        }
        else if (type.equalsIgnoreCase("tropical")) 
        {
            return new TropicalTerrarium();
        }
        
        throw new IllegalArgumentException("Неизвестный тип террариума: " + type);
    }
}
