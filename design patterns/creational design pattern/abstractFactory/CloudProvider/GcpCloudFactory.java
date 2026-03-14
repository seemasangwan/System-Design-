public class GcpCloudFactory implements  CloudFactory {
    public StorageProvider getStorageProvider()
    {
        return new GcpStorageProvider();
    }
    public VMProvider getVMProvider()
    {
        return new GcpVMProvider();
    }
}
