public class AwsCloudFactory implements  CloudFactory{
    public StorageProvider getStorageProvider()
    {
        return new AwsStorageProvider();
    }
    public VMProvider getVMProvider()
    {
        return new AwsVMProvider();
    }}
