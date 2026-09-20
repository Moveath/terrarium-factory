public class Main 
{
    public static void main(String[] args) 
    {
        TerrariumFactory myTerrarium = new TerrariumFactory();
        Terrarium desertTerrarium = myTerrarium.createTerrarium("desert");
        desertTerrarium.describe();

        Terrarium tropicalTerrarium = myTerrarium.createTerrarium("tropical");
        tropicalTerrarium.describe();

    }
}
