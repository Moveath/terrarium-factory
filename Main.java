public class Main 
{
    public static void main(String[] args) 
    {
        TerrariumFactory myTerrarium = new TerrariumFactory();
        Terrarium desertTerrarium = myTerrarium.createTerrarium("desert");
        desertTerrarium.describe();

        Terrarium tropicalTerrarium = myTerrarium.createTerrarium("tropical");
        tropicalTerrarium.describe();

        TerrariumKitFactory desertKit = new DesertKitFactory();
        Plant desertPlant = desertKit.createPlant();
        Substrate desertSubstrate = desertKit.createSubstrate();
        desertPlant.grow();
        desertSubstrate.describe();
        TerrariumKitFactory tropicalKit = new TropicalKitFactory();
        Plant tropicalPlant = tropicalKit.createPlant();
        Substrate tropicalSubstrate = tropicalKit.createSubstrate();
        tropicalPlant.grow();
        tropicalSubstrate.describe();
    }
}
