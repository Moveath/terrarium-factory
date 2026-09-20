public class DesertKitFactory implements TerrariumKitFactory
{
    @Override
    public Plant createPlant()
    {
        return new Cactus();
    }

    @Override
    public Substrate createSubstrate()
    {
        return new Sand();
    }
}