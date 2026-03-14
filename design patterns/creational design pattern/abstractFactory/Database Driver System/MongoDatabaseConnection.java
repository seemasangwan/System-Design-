public class MongoDatabaseConnection implements DatabaseConnection {

    public void createConnection()
    {
        System.out.println("creating mongo db  connection");
    }
    public void closeConnection()
    {
        System.out.println("closing mongo db connection");
    }
    public boolean isConnected()
    {
        System.out.println("are we connected to mongo database");
        return true;
    }
}
