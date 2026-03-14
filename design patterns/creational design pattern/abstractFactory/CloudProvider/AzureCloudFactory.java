public class AzureCloudFactory implements CloudFactory {
    public StorageProvider getStorageProvider()
    {
        return new AzureStorageProvider();
    }
    public VMProvider getVMProvider()
    {
        return new AzureVMProvider();
    }
}
