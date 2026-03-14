public class DatabaseFactoryProvider {
    public DatabaseFactory getDatabaseFactory(String type)
    {
        if(type==null){
            throw  new IllegalArgumentException("type can not be null");
        }
        else if(type.equalsIgnoreCase("mysql"))
            return new mysqlDatabaseFactory();
        else if(type.equalsIgnoreCase("mongo"))
            return new MongoDatabaseFactory();
        throw new IllegalArgumentException("invalid database type");
    }

}
