public class TropicalKitFactory implements TerrariumKitFactory
{
    @Override
    public Plant createPlant()
    {
        return new Fern();
    }

    @Override
    public Substrate createSubstrate()
    {
        return new Soil();
    }
}
