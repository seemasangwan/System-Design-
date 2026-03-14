public class CloudProvider {
    public static CloudFactory getCloudFactory(String type)
    {
        if(type==null)
        {
            throw new IllegalArgumentException("type cannot be null");
        }
       else if(type.equalsIgnoreCase("gcp"))
        {
            return new GcpCloudFactory();
        }
        else if(type.equalsIgnoreCase("Azure"))
        {
            return new AzureCloudFactory();
        }
        else if(type.equalsIgnoreCase("Aws"))
        {
            return new AwsCloudFactory();
        }
        else
        {
            throw new IllegalArgumentException("not valid type");
        }
    }
}
