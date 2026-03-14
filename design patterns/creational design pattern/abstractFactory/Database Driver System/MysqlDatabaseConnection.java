public class MysqlDatabaseConnection implements DatabaseConnection {
    public void createConnection()
    {
        System.out.println("creating mysql database connection");
    }
    public void closeConnection()
    {
        System.out.println("closing mysql connection");
    }
    public boolean isConnected()
    {
        System.out.println("are we connected to mysql database");
        return true;
    }
}
