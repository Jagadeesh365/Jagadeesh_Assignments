
abstract class Persistence {
    abstract public String persist();
}
class FilePersistence extends Persistence{
    @Override
    public String persist() 
    {
    	return "File Persistance";
    }
}
class DatabasePersistence extends Persistence{
    @Override
    public String persist() 
    {
    	return "Database Persistance";
    }
}
public class Assignment2Q6 {

	public static void main(String[] args) {
		Persistence Client1 = new FilePersistence();
		Persistence Client2 = new DatabasePersistence();
		System.out.println(Client1.persist());
		System.out.println(Client2.persist());

	}
}